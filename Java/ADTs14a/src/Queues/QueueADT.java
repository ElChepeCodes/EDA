package Queues;
import java.util.ArrayList;

/**
 * QueueADT<T> defines the interface to a queue collection.
 */
public interface QueueADT<T> {

    /**  Adds one element to the rear of this queue.
     */
    public void enqueue (T element);

    /**  Removes and returns the element at the front of this queue.
     */
    public T dequeue();

    /**  Returns without removing the element at the front of this queue.
     */
    public T first();

    /**  Returns true if this queue contains no elements.
     */
    public boolean isEmpty();
   
    /**  Returns the number of elements in this queue.
     */
    public int size();

    /**  Returns a string representation of this queue.
     *   ONLY TO DO PRINT's, NO OTHER OPERATIONS.
     */
    public String toString();
    
    // Problema 36
    // 36.a) Regresa el total de elementos almacenados en la cola,
    //       sin usar "size()" ni "count"
    public int cuentaElementos();

    // 36.b) Regresa el último elemento almacenado en la cola, sin quitarlo
    public T consultaUltimo();

    // 36.c) Rregresa un ArrayList almacenando los n elementos quitados de la cola
    public ArrayList multiQuita(int n);
}
