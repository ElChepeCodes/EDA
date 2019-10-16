/**  
 * SetADT defines the interface to a set collection.
 */

package Sets;
import java.util.Iterator;

public interface SetADT<T> {

  /** Adds one element to this set, ignoring duplicates. 
    */
  public void add(T element);

  /** Adds all the elements of the parameter to this set.
    */
  public void addAll(SetADT<T> oset);
  
  /** Removes and returns a random element from this set. 
    */
  public T removeRandom();
  
  /** Removes and returns the specified element from this set. 
    */
  public T remove(T element);
  
  /** Returns the union of this set and the parameter.
    */
  public SetADT<T> union(SetADT<T> oSet);
  
  /** Returns the intersection of this set and the parameter.
    */
  public SetADT<T> intersection(SetADT<T> oSet);

  /** Returns the difference of this set and the parameter.
    */
  public SetADT<T> difference(SetADT<T> oSet);

  /** Returns true if this set contains the element.
    */
  public boolean contains(T element);
  
  /** Returns true if this set and the parameter contain exactly
    * the same elements.
    */
  public boolean equals(SetADT<T> oSet);
  
  /** Returns true if this set contains no elements.
    */
  public boolean isEmpty();
  
  /** Returns the number of elements in this set.
    */
  public int size();
  
  /** Returns an iterator for the elements in this set.
    */
  public Iterator<T> iterator();
  
  /** Returns a string representation of this set.
    */
  public String toString();
}
