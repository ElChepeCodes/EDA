package LinkedStructures;

public class LinearNode<T> {
    private LinearNode<T> next;
    private T element;


    public LinearNode(){
        next=null;
        element=null;
    }//builder

    public LinearNode(T el){
        next=null;
        element=el;
    }//builder

    public LinearNode<T> getNext(){
        return next;
    }//method

    public void setNext(LinearNode<T> nodo){
        next=nodo;
    }//method

    public T getElement(){
        return element;
    }//method

    public void setElement(T el){
        element=el;
    }//method
}//class
