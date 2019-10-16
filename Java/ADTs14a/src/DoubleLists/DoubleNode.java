
package DoubleLists;

/**
 *
 * @author EDg1
 */
public class DoubleNode<T> {
    private T element;
    protected DoubleNode<T> next;    // siguiente, derecha
    protected DoubleNode<T> previous;    // anterior, izquierda
    
    public DoubleNode() {
        element= null;
        next= null;
        previous= null;
    }
    
    public DoubleNode(T elem) {
        element= elem;
        next= null;
        previous= null;
    }
    
    public DoubleNode<T> getNext() {
        return next;
    }
    
    public void setNext(DoubleNode<T> sig) {
        next=sig;
    }
    
    public T getElement() {
        return element;
    }
    
    public void setElement(T elem) {
        element = elem;
    }
    
    public DoubleNode<T> getPrevious() {
        return previous;
    }
    
    public void setPrevious(DoubleNode<T> ant) {
        previous=ant;
    }
    
    public String toString() {
        return element.toString();
    }
    
}
