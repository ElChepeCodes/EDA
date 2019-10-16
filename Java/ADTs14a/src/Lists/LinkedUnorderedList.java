package Lists;
import java.util.Iterator;

import AllExceptions.*;

/**
 * LinkedUnorderedList represents a singly linked implementation of an 
 * unordered list.
 */
public class LinkedUnorderedList<T> extends LinkedList<T> 
         implements UnorderedListADT<T>
{
    /**
     * Creates an empty list.
     */
    public LinkedUnorderedList()
    {
        super();
    }

    /**
     * Adds the specified element to the front of this list.
     *
     * @param element the element to be added to the list
	 */
    public void addToFront(T element)
    {
        LinearNode<T> newNode  = new LinearNode<T>(element);
      
        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
		else 
		{
            newNode.setNext(head);
            head = newNode;
		}
      
        count++;
		modCount++;
    }
	
	/**
     * Adds the specified element to the rear of this list.
     *
     * @param element the element to be added to the list
	 */
    public void addToRear(T element)
    {
        LinearNode<T> newNode  = new LinearNode<T>(element);
		
        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
		else 
		{
            tail.setNext(newNode);
            tail = newNode;
		}
				
        count++;
		modCount++;
    }

    /** Adds the specified element before the specified target.
     * Assumption: if target does not exist, the element will be added
     *  at the end of the list.
     */
    public void addBefore (T target, T element) {
        
    }	
	
    /**
     * Adds the specified element to this list after the given target.
     *
     * @param  element the element to be added to this list
	 * @param  target the target element to be added after
	 * @throws ElementNotFoundException if the target is not found
	 */
    public void addAfter(T element, T target)
    {
        if (isEmpty())
			throw new ElementNotFoundException("LinkedUnorderedList");
		
		boolean found = false;
		LinearNode<T> current = head;
		LinearNode<T> newNode = new LinearNode<T>(element);
		
        while (current != null && !found) 
            if (target.equals(current.getElement()))
                found = true;
            else
                current = current.getNext();	
		
		if (!found)
			throw new ElementNotFoundException("LinkedUnorderedList");
		
		newNode.setNext(current.getNext());
		current.setNext(newNode);
		
        count++;
		modCount++;
    }
    

    public int cuentaElementos(){
        return cuentaElementos(head,0);
    }//method
    
    private int cuentaElementos(LinearNode<T> nodo, int num){
        if (nodo!=null)
            return cuentaElementos(nodo.getNext(),num+1);
        else
            return num;
    }//method

    public boolean eliminaElemento(T var){
        boolean res=false;
        if (var!=null){
            int pos=1;
            Iterator<T> it=this.iterator();
            return eliminaElemento(eliminaElemento(it, pos, var));
        }//if
        else
        return res;
    }//method

    private int eliminaElemento(Iterator<T> it, int pos, T var){
        if (it.hasNext()){
            T aux=it.next();
            pos++;
            if (aux.equals(var))
                return pos;
            else
                return eliminaElemento(it,pos,var);
        }//if
        else
        return -1;
    }//method

    private boolean eliminaElemento(int pos){
        if (pos<0)
            return false;
        else{
            eliminaElemento(pos,1, head);
            return true;
        }//else
    }//method

    private void eliminaElemento(int pos, int cuenta, LinearNode<T> nodo){
        if (nodo.getNext()!=null) {
    	if (pos-2>cuenta){
    		System.out.println("pos "+pos+"\ncuenta "+cuenta);
            eliminaElemento(pos, cuenta+1, nodo.getNext());
        }//if
        else{
        	System.out.println("else");
            nodo.setNext(nodo.getNext().getNext());
        }//else
        }//if
        else {
        	nodo=null;
        }//else
    }//method
    public void invierteElementos(){
        invierteElementos(head, new LinkedUnorderedList());
    }//method

    private void invierteElementos(LinearNode<T> nodo, LinkedUnorderedList<T> lista){
        if (nodo==null)
        return;
        if (nodo.getNext()!=null){
            LinearNode<T> aux=nodo;
            nodo=nodo.getNext();
            lista.addToFront(aux.getElement());
            this.eliminaElemento(aux.getElement());
            invierteElementos(nodo, lista);
        }//if
        else{
            regresaElementos(lista);
        }//else

    }//method

    private void regresaElementos(LinkedUnorderedList<T> lista){
        if (lista.isEmpty())
            return;
        this.addToFront()
    }//method
}//class
