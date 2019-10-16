/**
 * Problema 46.
 * A Linked Structure implementation of a stack.
 * @author EDg1
 */

package Stacks;
import LinkedStructures.*;
import Queues.LnkStrQueue;

public class LnkStrStack<T> implements StackADT<T> {

    // Linked Structure of generic elements to represent the stack.
    private LinkedStruct<T> stack;

    // Creates an empty stack using the default capacity.
    public LnkStrStack() {
        stack = new LinkedStruct();
    }

    // Pushes in or adds the specified element to the top of this stack.
    public void push (T element) {
        stack.add(element, 1);
    }

    // Pops out or removes the element at the top of this stack and returns a
    // reference to it.
    public T pop() throws ElementNotFoundException {
        return stack.remove(1);
    }

    // Peeks and returns a reference to the T element at the top of this stack.
    // The element is not removed from the stack.
    public T peek() throws ElementNotFoundException {
        return stack.get(1);
    }

    // isEmpty: returns true if this stack is empty and false otherwise.
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // size: returns the count (top) of elements in the stack.
    public int size() {
        return stack.size();
    }

    // Returns a string representation of this stack.
    @Override
    public String toString() {
        String result = "";
        if( isEmpty() ) {
            result = "LnkStrStack is <EMPTY>";
            // Could be thrown an EmptyCollectionException
        } else {
            String aux = stack.toString();
            int len = aux.length();
            aux = aux.substring(15, len-4);
            result = "LnkStrStack is {TOP: " + aux + " :BASE}";
        }

        return result;
    }

    public void volteaStack(){
      if (this.isEmpty())
        return;
      else
        volteaStack(new LnkStrQueue());
    }//method

    private void volteaStack(LnkStrQueue<T> cola){
      if (this.isEmpty()){
        regresaQueue(cola);
      }//if
      else{
        cola.enqueue(pop());
        volteaStack(cola);
      }//else

    }//method

    private void regresaQueue(LnkStrQueue<T> cola){
      if (cola.isEmpty()){
        return;
      }//if
      else{
        this.push(cola.dequeue());
        regresaQueue(cola);
      }//else
    }//method


}
