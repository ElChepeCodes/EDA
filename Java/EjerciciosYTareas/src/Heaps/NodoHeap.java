/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package Heaps;

/**
 *
 * @author jlgut
 */
public class NodoHeap<T>{
    private T elem;
    private int pr;
    
    public NodoHeap(T el, int p){
        elem = el;
        pr = p;
    }//method
    
    public NodoHeap(T el){
        elem = el;
        pr = 0;
    }//method
    
    public int getPrioridad(){
        return pr;
    }//method
    
    public T getElem(){
        return elem;
    }//method
}//class
