/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package Trees;

import java.util.Iterator;

/**
 *
 * @author jlgut 
 */

public interface BinBalancedTreeADT <T extends Comparable<T>>{
    public boolean isEmpty();
    public int size();
    public boolean contains(T elem);
    public <T extends Comparable<T>> NodoBT<T> find (T elem);
    public Iterator<T> inOrden();
    public Iterator<T> preOrden();
    public Iterator<T> postOrden();
    public int altura();
    public  void agrega(T elem);
    public  boolean delete(T elem);
}//class
