package LinkedStructures;

import java.util.Iterator;

public class LinkedStructure<T> {
    private int count;
    private LinearNode<T> front;

    public LinkedStructure(){
        count=0;
        front=null;
    }//builder

    public void add(T element, int pos){
        LinearNode nuevo=new LinearNode(element), current;
        int i;
        if (isEmpty()){
            front=nuevo;
            return;
        }//if
        if (pos<=1){
            nuevo.setNext(front);
            front=nuevo;
            return;
        }//if
        i=1;
        current=front;
        while(i<(pos-1) && current.getNext()!=null){
            i++;
            current=current.getNext();
        }//while
        nuevo.setNext(current.getNext());
        current.setNext(nuevo);
        count++;
    }//method

    public T remove(int pos) throws ElementNotFoundException{
        LinearNode<T> current, previous=null;
        int i;
        T res;
        if (pos<1 || pos>size())
            throw new ElementNotFoundException();
        if (pos==1){
            res=front.getElement();
            front=front.getNext();
        }//if
        else{
            i=1; current=front;
            while(i<pos){
                previous=current;
                current=current.getNext();
                i++;
            }//while
        
        res=current.getElement();
        previous.setNext(current.getNext());
        }//else
        count--;
        return res;
    }//method

    public T get(int pos) throws ElementNotFoundException{
        if (pos<1 || pos>size())
            throw new ElementNotFoundException();
        LinearNode<T> current;
        current=front;
        for(int i=0; i<pos; i++)
            current=current.getNext();
        return current.getElement();
    }//method

    public void set(T el, int pos) throws ElementNotFoundException{
        if (pos<1 || pos>size())
            throw new ElementNotFoundException();
        LinearNode<T> current=front;
        for(int i=0; i<pos; i++)
            current=current.getNext();
        current.setElement(el);
    }//method

    public Iterator<T> iterator(){
        return (new LinkStrIter<T>(front));
    }//method

    @Override
    public String toString(){
        String res="{";
        LinearNode<T> current=front;
        if (front==null)
            return "<EMPTY>";
        while(current!=null){
            if (current.getNext()!=null)
                res+=", "+current.getElement();
            current=current.getNext();
        }//while
        return res+"}";
    }//method

    public boolean isEmpty(){
        return (count==0);
    }//method

    public int size(){
        return count;
    }//method
}//class