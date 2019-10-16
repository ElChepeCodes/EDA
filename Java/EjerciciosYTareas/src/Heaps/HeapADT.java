/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package Heaps;

/**
 *
 * @author jlgut
 */
public interface HeapADT <T extends Comparable <T>> {
    public void add(T elem);
    public T delete();
    public T find(T elem);
    public boolean isEmpty();
}//interface
