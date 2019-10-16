
package LinkedStructures;
import java.util.Iterator;

/**
 * Esta clase instancia un Iterador para una Estructura Enlazada
 * EDg2
 */
public class LinkedStructIter<T> implements Iterator<T> {
    /** Atributo para recorrer una Estructura Enlazada */  
    private LinearNode<T> current;
  
    /** Constructor del iterador */
    public LinkedStructIter(LinearNode<T> ls) {
        current= ls;
    }

    /** Regresa true si el iterador tiene al menos
     * un elemento mas */
    @Override
    public boolean hasNext() {
        return ( current != null );
    }

    /** Regresa el siguiente elemento en la iteracion.
     * Si no hay mas, lanza una excepcion */
    @Override
    public T next() {
        T result;

        if (!hasNext())
            throw new ElementNotFoundException("Linked Structure: no next");

        result= current.getElement();
        current= current.getNext();
        return result;
    }

    /** The remove operation is not supported in this collection */
    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

}
