
package DoubleLists;
import java.util.*;

/**
 * 
 * @author EDg1
 */
public class DoubleIterator<T> implements Iterator<T> {
    private DoubleNode<T> current;  //the current position in the iteration
    
    public DoubleIterator(DoubleNode<T> actual){
        current=actual;
    }
    
    public boolean hasNext(){
        return current != null;
    }
    
    public T next(){
        if(current==null)
            throw new NoSuchElementException();
        else{
            T resultado = current.getElement();
            current = current.getPrevious();
            return resultado;
        }
    }
    
    public void remove(){
        throw new UnsupportedOperationException();
    }
}
