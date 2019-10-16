
package DoubleLists;


public class DoublyLinkedOrderedList<T> extends DoublyLinkedList<T> 
         implements OrderedListADT<T> {
  
     // if (!(element instanceof Comparable))
    //  throw new NonComparableException("LinkedOrderedListR");
    // Comparable<T> comparableElement = (Comparable<T>) element;
    @Override
    public void add(T element) {
        // Orden ascentedte
      	DoubleNode<T> current = head.getNext();
      	while ( current != tail && 
                ( (Comparable<T>) element).compareTo(current.getElement())>=0 )
         	current = current.getNext();
        DoubleNode<T> newNode  = new DoubleNode<>(element);
        addNode(newNode, current.getPrevious(), current);
    }

}
