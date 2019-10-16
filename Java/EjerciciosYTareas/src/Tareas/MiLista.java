package Tareas;

import LinkedStructures.ElementNotFoundException;
import LinkedStructures.EmptyCollectionException;
import LinkedStructures.LinearNode;

public class MiLista<T> {
    int count;
    LinearNode<T> head, tail;
    
    public MiLista(){
        count = 0;
        head = tail = new LinearNode(null);
    }//builder

    public T removeFirst(){
        if (isEmpty())
            throw new EmptyCollectionException();
        LinearNode <T> res = head.getNext();
        head.setNext(res.getNext());
        count--;
        return res.getElement();
    }//method

    public T removeLast(){
        if (isEmpty())
            throw new EmptyCollectionException();
        LinearNode<T>previous = head, current = previous.getNext();
        while (current.getNext()!=null){
            previous=current;
            current=current.getNext();            
        }//while
        previous.setNext(null);
        count--;
        return current.getElement();
    }//method

    public void remove(int pos){
        LinearNode<T> previous = head, current = previous.getNext();
        int i = 0;
        while (current != null && current.getElement() != null && i<pos){
            previous = current; current = current.getNext();
            i++;
        }//while
        if (current == null || current.getElement() == null)
            throw new ElementNotFoundException();
        previous.setNext(current.getNext());
    }//method

    public void remove (T elem) throws EmptyCollectionException, ElementNotFoundException{
        if (isEmpty())
            throw new EmptyCollectionException();
        LinearNode<T> previous=null, current = head;
        while (current.getNext()!=null){
            previous = current; current = current.getNext();
            if (current .getElement().equals(elem)){
                previous.setNext(current.getNext());
                count--;
                return;
            }//if
        }//while
        throw new ElementNotFoundException();
    }//method

    public T first(){
        if (isEmpty())
            throw new EmptyCollectionException();
        return head.getElement();
    }//method

    public T last(){
        if (isEmpty())
            throw new EmptyCollectionException();
        return tail.getElement();
    }//method

    public boolean contains(T elem){
        if (isEmpty())
            throw new EmptyCollectionException();
        LinearNode<T> current = head;
        while (current.getNext()!=null){
            current=current.getNext();
            if (current.getElement().equals(elem))
                return true;
        }//while
        return false;
    }//method

    public int find(T elem){
        if (isEmpty())
            throw new EmptyCollectionException();
        int i=0;
        LinearNode<T> current=head;
        while (current.getNext()!=null){
            current = current.getNext();
            i++;
            if (current.getElement().equals(elem))
                return i;
        }//while
        return -1;
    }//method


    public boolean isEmpty(){
        return (count==0);
    }//method

    public void addToFront(T element){
        LinearNode<T> nodo = new LinearNode(element);
        if (isEmpty()){
            head.setNext(nodo);
            nodo.setNext(tail);
            count++;
            return;
        }//if
        nodo.setNext(head.getNext());
        head.setNext(nodo);
        count++;
    }//method

    public void addToRear(T element){
        LinearNode<T> nodo = new LinearNode(element);
        if (isEmpty()){
            head.setNext(nodo);
            nodo.setNext(tail);
            count++;
            return;
        }//if
        LinearNode<T> current=head.getNext();
        while(current.getNext()!=null && current.getNext().getElement() != null) {        	
        	current=current.getNext();

        }//while
        current.setNext(nodo);
        nodo.setNext(tail);
        count++;
    }//method

    public void addBefore(T target, T element) throws ElementNotFoundException, EmptyCollectionException{
        if (isEmpty())
            throw new EmptyCollectionException();
        LinearNode<T> previous = head, current = previous.getNext();
        while(current.getNext()!= null){
            if (current.getElement().equals(target)){
                previous.setNext(new LinearNode(element));
                previous.getNext().setNext(current);
                count++;
                return;
            }//if
            previous = current; current = current.getNext();
        }//while
        throw new ElementNotFoundException();
    }//method

    public char[] toArray(){
        if (head.getNext().getElement() instanceof Character){                
            LinearNode <T> current = head.getNext();
            char[] res = new char[count];
            int i = 0;
            while (current != null && current.getElement() != null){
                res[i] = (Character)current.getElement();
                current = current.getNext();
            }//while
            return res;
        }//if
        else
            throw new ElementNotFoundException();
    }//method

    public void addAfter(T target, T element){
        if (isEmpty())
            throw new EmptyCollectionException();
        LinearNode<T> current = head, next = current.getNext();
        while (next != null){
            if (current.getElement().equals(target)){
                current.setNext(new LinearNode(element));
                current.getNext().setNext(next);
                count++;
            }//if
            current = next; next = next.getNext();
        }//while
        throw new ElementNotFoundException();
    }//method


    
    public void volteaConex(){
        if(isEmpty() || count==1)
            return;
        T temp = removeFirst();
        addToRear(temp);
        volteaConex(0);
    }//method

    private void volteaConex(int i){    	
        if (i==count)
            return;
        T temp = removeFirst();
        addBeforeNum(temp, count-i);
        volteaConex(i+1);
        
    }//method

    public void addBeforeNum(T element, int pos)throws IndexOutOfBoundsException{
        if (pos>count)
            throw new IndexOutOfBoundsException();
        LinearNode<T> current = head;
        int i=0;
        while(i<pos-1){
            current = current.getNext();
            i++;
        }//while
        LinearNode<T> nodo = new LinearNode(element);
        nodo.setNext(current.getNext());
        current.setNext(nodo);
        count++;
    }//method

    public void volteaElem(){
        if (isEmpty() || count==1)
            return;
        volteaElem(head.getNext(), new MiLista());
    }//method

    private void volteaElem(LinearNode<T> nodo, MiLista<T> lista2){        
    	if (nodo == null || nodo.getElement()==null){
            volteaElem(lista2, head.getNext());
            return;
        }//if
        
    	lista2.addToFront(nodo.getElement());
        volteaElem(nodo.getNext(), lista2);
    }//method

    private void volteaElem(MiLista<T> lista2, LinearNode<T> nodo){
        if (lista2.isEmpty() || nodo==null || nodo.getElement()==null)
            return;
        nodo.setElement(lista2.removeFirst());
        volteaElem(lista2, nodo.getNext());
    }//method
    @Override
    public String toString(){
        if (isEmpty())
            return "La lista esta vacia";
        StringBuilder res = new StringBuilder();
        LinearNode<T> nodo = head.getNext();
        res.append("{").append(nodo.getElement().toString());
        while (nodo.getNext()!=null && nodo.getNext().getElement()!=null){
            nodo=nodo.getNext();
            res.append(", ").append(nodo.getElement().toString());
        }//while
        res.append("}");
        return res.toString();
    }//method

    public static void main(String args[]){
        MiLista l = new MiLista();
        l.addToFront(1); l.addToFront(2);
        l.addToFront(3); l.addToFront(4);
        l.addToFront(5); l.addToFront(6); 
        System.out.println("Original: \n");
        System.out.println(l.toString());
        System.out.println("Despues de voltear los enlaces recursivamente:");
        l.volteaConex();
        System.out.println(l.toString());
        System.out.println("Despues de voltear los elementos recursivamente");
        l.volteaElem();
        System.out.println(l.toString());
                
    }//main

}//class
