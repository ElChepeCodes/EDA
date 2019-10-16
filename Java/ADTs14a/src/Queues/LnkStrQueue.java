
package Queues;
import LinkedStructures.*;
import java.util.ArrayList;

/** LnkStrQueue represents a LinkedStruct implementation of a queue instead
 *  of the array. 
  */
public class LnkStrQueue<T> implements QueueADT<T> {
    private int count;
    private LinkedStruct<T> queue; 
  
    /** Creates an empty queue using the specified capacity.
     */
    public LnkStrQueue() {
        count = 0;
        queue = new LinkedStruct();
    }
    
    /** Adds the specified element to the rear of this queue, expanding
     * the capacity of the queue array if necessary.
     */
    public void enqueue(T element) {
        count++;        
        queue.add(element, count);
    }
  
    /** Removes the element at the front of this queue and returns a
     * reference to it. Throws an EmptyCollectionException if the
     * queue is empty.
     */
    public T dequeue() throws EmptyCollectionException {
        if ( isEmpty() )
            throw new EmptyCollectionException("Q-VACIA-dequeue");
        T result=null;

        result= queue.remove(1);
        count--;

        return result;
    }
  
    /** Returns a reference to the element at the front of this queue.
     * The element is not removed from the queue.  Throws an
     * EmptyCollectionException if the queue is empty.
     */
    public T first() throws EmptyCollectionException {
        if ( this.isEmpty() )
            throw new EmptyCollectionException("Q-VACIA-first");

        return queue.get(1);
    }
  
    /** Returns true if this queue is empty and false otherwise.
     */
    public boolean isEmpty() {
        return (count == 0);
    }
   
    /**  Returns the number of elements in this queue.
     */
    public int size() {
        return count;
    }
  
    /**  Returns a string representation of this queue.
     *   ONLY TO DO PRINT's, NO OTHER OPERATIONS.
     */
    public String toString() {
        String cade = "{" + 1 + ": ";
        
        if( isEmpty() ) {
            cade = cade + "Q-VACIA-toString ";  // queue vacio
        } else {
            for( int i = 1; i<=count; i++) {
                cade = cade + queue.get(i) + ", ";
            }
        }
        cade = cade + ":" + count + "}\n";
    
        return cade;
    }

    // Problema 36
    // 36.a) Regresa el total de elementos almacenados en la cola,
    //       sin usar "size()" ni "count". No hay otra forma.
    public int cuentaElementos() {
        return count;
    }

    // 36.b) Regresa el ultimo elemento almacenado en la cola, sin quitarlo
    public T consultaUltimo() {        
        if ( this.isEmpty() )
            throw new EmptyCollectionException("Q-VACIA-consultaUltimo");
        
        T t = queue.get(count);
        
        return t;
    }

    // 36.c) Rregresa un ArrayList almacenando los n elementos quitados de la cola
    public ArrayList multiQuita(int n) {
        if ( n < 0 )
            throw new ParamErrException("multiqita- n<0");

        ArrayList<T> quitados = new ArrayList();
        T t;

        while ( !this.isEmpty() && (n>0) ) {
            // Quita los "n" elementos o la cola se vaciara si "<n"
            n--;
            t = this.dequeue();
            quitados.add(t);
        } 
        
        return quitados;
    }

}






















