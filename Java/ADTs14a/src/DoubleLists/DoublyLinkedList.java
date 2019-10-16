
package DoubleLists;
import java.util.*;    // Iterator
import AllExceptions.*;

/*
Represents a doubly linked implementation of a list. 
The front of the list is kept by "head" and the rear by "tail". 
It uses two sentinel nodes and will be extended to create concrete lists.
*/
public abstract class DoublyLinkedList<T> implements ListADT<T>, Iterable<T>
{    
    protected DoubleNode<T> head,tail;
    protected int count;

    public DoublyLinkedList() {
        head = new DoubleNode<>();
        tail = new DoubleNode<>();
        tail.setPrevious(head);
        head.setNext(tail);
        count = 0;    }
 
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException ("list"); 
        DoubleNode<T> first = head.getNext();
        return first.getElement();
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException ("list"); 
        DoubleNode<T> last = tail.getPrevious();
        return last.getElement();
    }
   
    private void removeNode(DoubleNode<T> node) {
        DoubleNode<T> before, after;   
        before = node.getPrevious();       
        after = node.getNext();
        before.setNext(after); 
        after.setPrevious(before);
        node.setPrevious(null);
        node.setNext(null);
        count--;
    }
    
    @Override
    public T removeFirst() throws EmptyCollectionException {
        T result = first();
        removeNode(head.getNext());
        return result;
    }
    
    @Override
    public T removeLast () throws EmptyCollectionException {
        T result = last();
        removeNode(tail.getPrevious());
        return result;
    }

    @Override
    public T remove (T target) throws ElementNotFoundException {
        DoubleNode<T> current = findNode(target);
        if (current == null)
            throw new ElementNotFoundException ("Linked Dequeue");
        T result = current.getElement();  
        removeNode(current);
        return result; 
    }

    // Metodo iterativo
    private DoubleNode<T> findNode(T target) {
        DoubleNode<T> current = head.getNext();
        DoubleNode<T> result = null;
        while (result == null && current != tail)
            if (current.getElement().equals(target))
                result = current;
            else
                current = current.getNext();
        return result;
    }
    
    private DoubleNode<T> findNodeR(T target, DoubleNode<T> current) {
        if ( current == tail )
            return null;
   	else if ( target.equals(current.getElement()) )
            return current;
   	else
            return findNodeR(target, current.getNext());
    }
    
    private DoubleNode<T> findNodeI(T target) {
        DoubleNode<T> current = head.getNext();   
        DoubleNode<T> result = null;
        Iterator<T> it = this.iterator();
        while (result==null && it.hasNext()) {
            if (it.next().equals(target))
                result = current;
            else
                current = current.getNext();
        }
        return current;
    }

    
    @Override
    public boolean contains (T target) {
        return (findNode(target) != null);
    }
     
    @Override
    public Iterator<T> iterator() {
        return new DoubleIterator<> (head.getNext());
    }
    
    protected void addNode(DoubleNode<T> node, 
            DoubleNode<T> before, DoubleNode<T> after) {      
        node.setPrevious(before);
        node.setNext(after);
        before.setNext(node);
        after.setPrevious(node);    
        count++;
    }     

    @Override
    public final void clear() {
        head = new DoubleNode<>();
        tail = new DoubleNode<>();
        tail.setPrevious(head);
        head.setNext(tail);
        count = 0;
    }
    
    @Override
    public int size() {
        return count;
    }
   
    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public String toString() {
        String result = "  {LkdList";

        if( this.isEmpty() ) {
            result = result + ", is EMPTY";
        } 

        DoubleNode<T> current = head.getNext();

        while (current.getNext() != null)
        {
            result = result + ", " + current.getElement();
            current = current.getNext();
        }
        
        result = result + "}\n";
        return result;
    }   
   
}
