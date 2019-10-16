package LinkedStructures;

/**
 * Implemnts and represents a Node in a Linked List.
 */
public class LinearNode<T> {
    /** Attributes:
     * Reference to "next" Node in Linked List.
     * Object "element" stored (referenced) at this Node */
    private LinearNode<T> next;
    private T element;
 
    /** Creates an empty node */
    public LinearNode() {
        next = null;
        element = null;
    }
 
    /** Creates a node storing (referencing) the specified element */
    public LinearNode(T elem) {
        next = null;
        element = elem;
    }
 
    /** Returns the node that follows this one */
    public LinearNode<T> getNext() {
        return next;
    }
 
    /** Sets the node that follows this one */
    public void setNext(LinearNode<T> node) {
        next = node;
    }
 
    /** Returns the element stored (referenced)) in this node */
    public T getElement() {
        return element;
    }
 
    /** Sets the element stored (referenced) in this node */
    public void setElement(T elem) {
        element = elem;
    }
}
