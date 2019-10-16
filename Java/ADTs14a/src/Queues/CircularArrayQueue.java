
package Queues;
import java.util.ArrayList;

/** CircularArrayQueue represents an array implementation of a queue in 
  * which the indexes for the front and rear of the queue circle back to 0
  * when they reach the end of the array.
  */
public class CircularArrayQueue<T> implements QueueADT<T> {
    private final static int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue; 
  
    /** Creates an empty queue using the specified capacity.
     */
    public CircularArrayQueue(int initialCapacity) {
        front = rear = count = 0;
        queue = ( (T[])(new Object[initialCapacity]) );
    }
  
    /** Creates an empty queue using the default capacity.
     */
    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }
  
    /** Adds the specified element to the rear of this queue, expanding
     * the capacity of the queue array if necessary.
     */
    public void enqueue(T element) {
        if (size() == queue.length)
            expandCapacity();   //Cola llena.

        queue[rear]= element;
        rear= (rear+1)%queue.length;
        count++;
    }
  
    /** Removes the element at the front of this queue and returns a
     * reference to it. Throws an EmptyCollectionException if the
     * queue is empty.
     */
    public T dequeue() throws EmptyCollectionException {
        T result=null;

        if ( isEmpty() )
            throw new EmptyCollectionException("Q-VACIA-dequeue");

        result= queue[front];
        queue[front]= null;
        front= (front+1) % queue.length;
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

        return queue[front];
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
        String cade = "{" + front + ": ";
        int f, s;
        
        if( isEmpty() ) {
            cade = cade + "Q-VACIA-toString ";  // queue vacio
        } else {
            s = size();
            f = front;
            while( s > 0 ) {
                cade = cade + queue[f] + "  ";
                f = (f+1) % queue.length;
                s--;
            }
        }
        cade = cade + ":" + rear + "}\n";
    
        return cade;
    }

    /** Creates a new array to store the contents of this queue with
     * twice the capacity of the old one.
     */
    private void expandCapacity() {
        T[] larger = (T[])(new Object[queue.length *2]);
    
        for(int scan=0; scan < count; scan++) {
            larger[scan] = queue[front];
            front = (front+1) % queue.length;
        }
    
        front = 0;
        rear = count;
        queue = larger;
    }

    // Problema 36
    // 36.a) Regresa el total de elementos almacenados en la cola,
    //       sin usar "size()" ni "count"
    public int cuentaElementos() {
        int total;
        if( rear >= front ) {
            // ----front########rear----
            total = rear - front;
        } else {
            // front>rear, ####rear--------front####
            total = (rear - 0) + (queue.length - front);
        }    // Todavia se puede reducir a if-then
        
        return total;
    }

    // 36.b) Regresa el ultimo elemento almacenado en la cola, sin quitarlo
    public T consultaUltimo() {        
        T t = null;
        int ultimo;    // el predecesor de "rear", indica el ultimo elemento
        
        if( !this.isEmpty() ) {    // Con this.isEmpty(), t=null;
            ultimo = (rear - 1 + queue.length) % queue.length;
            t = queue[ultimo];
        }
        return t;
    }

    // 36.c) Rregresa un ArrayList almacenando los n elementos quitados de la cola
    public ArrayList multiQuita(int n) {
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






















