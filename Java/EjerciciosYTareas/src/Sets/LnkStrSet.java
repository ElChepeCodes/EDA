/**  
 * LnkStrSet represents an Linked Structure implementation of a set.
 */

package Sets;
import java.util.Iterator;
import java.util.Random;

public class LnkStrSet<T> implements SetADT<T>, Iterable<T> {
  private static Random rand = new Random();
  private final int DEFAULT_CAPACITY = 100;
  private final int NOT_FOUND = -1;
  private int count;  // the current number of elements in the set
  private T[] contSet; 
  
  /**
   * Creates an empty set using the default capacity.
   */
  public LnkStrSet() {
    count = 0;
    contSet = (T[])(new Object[DEFAULT_CAPACITY]);
  }
  
  /**
   * Creates an empty set using the specified capacity.
   */
  public LnkStrSet(int initialCapacity) {
    count = 0;
    contSet = (T[])(new Object[initialCapacity]);
  }
  
  public void addR(T element){
    if (count == contSet.length)
        expandCapacity();           //Si el arreglo está lleno, lo aumenta.
      
      //Agrega el elemento.
      contSet[count]= element;
      count++;
  }//method

  public void toSet(T [] arr){
    for (int i = 0; i < arr.length ; i++){
      addR(arr[i]);
    }//for
  }//method

  /**
   * Adds the specified element to the set if it is not already
   * present. Expands the capacity of the set array if necessary.
   */
  public void add(T element) {
    
    if (!contains(element)) {       //Verifica que no esté el elemento.
      if (count == contSet.length)
        expandCapacity();           //Si el arreglo está lleno, lo aumenta.
      
      //Agrega el elemento.
      contSet[count]= element;
      count++;
    }
  }
  
  /**
   * Adds the contents of otherSet to this set.
   */
  public void addAll(SetADT<T> oSet) {
    Iterator<T> iter= oSet.iterator();
    T element;
    
    while (iter.hasNext()) {
      element = iter.next();
      this.add(element);
    }
  }
  
  /**
   * Removes a random element from the set and returns it. Throws
   * an EmptyCollectionException if the set is empty.
   */
  public T removeRandom() throws EmptyCollectionException {
    T result = null;
    int index;
    
    if (isEmpty())
      throw new EmptyCollectionException("ArraySet");

    // Generates a random integer between [0,count-1].
    index = rand.nextInt(count);

    // Recovers the selected element.
    result= contSet[index];
    
    // Moves the last element to the place of the removed element.
    contSet[index]= contSet[count-1];
    contSet[count-1]= null;
    count--;
    
    return result;
  }
  
  /**
   * Removes the specified element from the set and returns it.
   * Throws an EmptyCollectionException if the set is empty and a
   * ElementNotFoundException if the element is not in the set.
   */
  public T remove (T element) throws EmptyCollectionException,
                                      ElementNotFoundException {
    boolean found = false;   // Not found
    int index;
    
    if (isEmpty())
      throw new EmptyCollectionException("ArraySet");
    
    // Look for the elemente inside this set.
    index = 0;
    while (index<count && !found) {
      found = contSet[index].equals(element);
      index++;      
    }
    
    // Was it found
    if (!found)
      throw new ElementNotFoundException("ArraySet");   //No.
    
    //If it was found, recovers the element and erases from this set.
    T result= contSet[index-1];
    contSet[index-1]= contSet[count-1];
    contSet[count-1]= null;
    count--;
    
    return result;
  }
  
  /**
   * Returns a new set that is the union of this set and
   * otherSet.
   */
  public SetADT<T> union (SetADT<T> oSet) {
    LnkStrSet<T> result= new LnkStrSet<T>();
    
    result.addAll(this);
    result.addAll(oSet);
/*
    // .addAll(this)
    Iterator<T> iter= this.iterator();
    T element;
    while (iter.hasNext()) {
      element = iter.next();
      result.add(element);
    }

    // .addAll(oSet)
    iter= oSet.iterator();
    while (iter.hasNext()) {
      element = iter.next();
      result.add(element);
    }
*/
    return result;
  }

    /**
     * Returns a new set that is the union, recursive, of this set and the
     * parameter.
     */
    public SetADT<T> unionRv(SetADT<T> oSet) {
        if(oSet==null)
            throw new ParamErrException("<nulo o fuera de rango>");
        SetADT<T> result = null;
    
        // Union of this with new ArraySet(), empty by now
        result= unionRv(this.iterator(), new LnkStrSet() );
        // Union of oSet with result
        result= unionRv( oSet.iterator(), result );

        return result;
    }
  
    //Metodo privado que hace efectivamente la union recursiva.
    private SetADT<T> unionRv(Iterator<T> iter, SetADT<T> unionSet) {
        if(iter==null || unionSet==null)
            throw new ParamErrException("<nulo o fuera de rango>");
    
        if (iter.hasNext()) {    // Caso Recursivo
            unionSet.add( iter.next() );
            unionSet = unionRv( iter, unionSet );
        }
    
        return unionSet;
    }  
  
  /** Returns the intersection of this set and the otherSet.
    */
  public SetADT<T> intersection(SetADT<T> oSet) {
    LnkStrSet<T> result= new LnkStrSet<T>();

    Iterator<T> iter= oSet.iterator();
    T element;
    
    while (iter.hasNext()) {
      element= iter.next();
      if ( this.contains(element) )
        result.add(element);
    }
    return result;
  }

    /** Returns the intersection, recursive, of this set and the parameter.
     */  
    public SetADT<T> intersectionRv(SetADT<T> oSet) {
        if(oSet==null)
            throw new ParamErrException("<nulo o fuera de rango>");
        SetADT<T> result= null;
    
        result= intersectionRv(oSet.iterator(), new LnkStrSet());
        
        return result;
    }

    //Metodo privado que hace efectivamente la interseccion recursiva.
    private SetADT<T> intersectionRv(Iterator<T> oSetIter, SetADT<T> interSet) {
        if(oSetIter==null || interSet==null)
            throw new ParamErrException("<nulo o fuera de rango>");
        T temp;
    
        if (oSetIter.hasNext()) {    // Caso Recursivo
            temp= oSetIter.next();
            if (this.contains(temp))
                interSet.add(temp);
            interSet = intersectionRv(oSetIter, interSet);
        }

        return interSet;
    }
  
  /** Returns the difference of this set and the otherSet.
    */
  public SetADT<T> difference(SetADT<T> oSet) {
    LnkStrSet<T> result= new LnkStrSet<T>();

    Iterator<T> iter = this.iterator();
    T element;
    
    while (iter.hasNext()) {
      element = iter.next();
      if ( !oSet.contains(element) )
        result.add(element);
    }
        return result;    
  }


    /** Returns the difference, recursive, of this set and the otherSet.
     */  
    public SetADT<T> differenceRv(SetADT<T> oSet) {
        if(oSet==null)
            throw new ParamErrException("<nulo o fuera de rango>");
        SetADT<T> nuevo= null;
    
        nuevo= differenceRv(this.iterator(), oSet, new LnkStrSet());
        
        return nuevo;
    }

    //Metodo privado que hace efectivamente la diferencia recursiva.
    private SetADT<T> differenceRv(Iterator<T> iter, SetADT<T> oSet,
                                    SetADT<T> diffSet) {
        if(iter==null || oSet==null || diffSet==null)
            throw new ParamErrException("<nulo o fuera de rango>");
        T temp;
    
        if (iter.hasNext()) {    // Caso Recursivo
            temp= iter.next();
            if (!oSet.contains(temp))
                diffSet.add(temp);
            diffSet = differenceRv(iter, oSet, diffSet);
        }
        return diffSet;
  }  
  
  /**
   * Returns true if this set contains the specified element.
   */
  public boolean contains (T element) {
    boolean found = false;  //Not found
    int index;
    
    index = 0;
    while (index<count && !found) {
      found = contSet[index].equals(element);
      index++;
    }
    
    return found;
  }
  
    /**
    * Returns true if this set contains the specified element.
    */
    public boolean containsRv (T element) {
        if(element==null)
            throw new ParamErrException("<nulo o fuera de rango>");
        boolean found = false;  //Not found
        Iterator<T> iter = this.iterator();
        T aux;
        
        if (iter.hasNext()==true) {
            found = containsRv( iter, element );
        }

        return found;
    }

    //Metodo privado que hace efectivamente el contains recursiva.
    public boolean containsRv (Iterator<T> iter, T element) {
        if(iter==null || element==null)
            throw new ParamErrException("<nulo o fuera de rango>");
        boolean found = false;  //Not found
        T aux;
        
        if (iter.hasNext()==false) {
            found = false;    // caso base
        } else {
            aux = iter.next();    // caso base
            if( aux.equals(element) ) {
                found = true;
            } else {
                found = containsRv( iter, element );    // caso recursivo          
            }
        }

        return found;
    }

  
  /**
   * Returns true if this set contains exactly the same elements
   * as the otherSet.
   */
  public boolean equals (SetADT<T> oSet) {
    boolean identical = false;
    LnkStrSet<T> temp1 = new LnkStrSet<T>();
    LnkStrSet<T> temp2 = new LnkStrSet<T>();
    T obj2;
    
    if ( size() == oSet.size() )  {
      temp1.addAll(this);
      temp2.addAll(oSet);

      Iterator<T> iter2 = oSet.iterator();
      while ( iter2.hasNext() ) {
        obj2 = iter2.next();   
        if ( temp1.contains(obj2) ) {
          temp1.remove(obj2);
          temp2.remove(obj2);
        }
      }
      
      identical = ( temp1.isEmpty() && temp2.isEmpty() );
    }
    return identical;  
  }
  
  /**
   * Returns true if this set is empty and false otherwise.
   */
  public boolean isEmpty() {
    return (count == 0);
  }
  
  /**
   * Returns the number of elements currently in this set.
   */
  public int size() {
    return count;
  }
  
  /**
   * Returns an iterator for the elements currently in this set.
   */
  public Iterator<T> iterator() {
    return new ArrayIterator<T>(contSet,count);
  }
  
  /**
   * Returns a string representation of this set.
   */
  public String toString() {
    String result = "";
    if(isEmpty()) {
        result = "ArraySet is {EMPTY";
    } else {
        result = "Set{ ";
        for (int index=0; index < count; index++) {
            result = result + contSet[index].toString() + ", ";
        }
    }
    result = result + "}\n";
    return result;
  }
  
  /**
   * Creates a new array to store the contents of the set with
   * twice the capacity of the old one.
   */
  private void expandCapacity() {
    T[] larger = (T[])(new Object[contSet.length*2]);
    
    for (int index = 0; index < contSet.length; index++)
      larger[index] = contSet[index];
    
    contSet = larger;
  }
}

