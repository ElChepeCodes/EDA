/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package SkipLists;

/**
 *
 * @author jlgut
 */
public class NodoSkip<T extends Comparable <T>> {
    NodoSkip<T> izq, der, arriba, abajo;
    T elem;
    
    public NodoSkip(T el){
        elem = el;
        izq = null;
        der = null;
        arriba = null;
        abajo = null;
    }//builder
    
    public NodoSkip(){
        elem = null;
        izq = null;
        der = null;
        arriba = null;
        abajo = null;
    }//builder    

    public NodoSkip<T> getIzq() {
        return izq;
    }

    public NodoSkip<T> getDer() {
        return der;
    }

    public NodoSkip<T> getArriba() {
        return arriba;
    }

    public NodoSkip<T> getAbajo() {
        return abajo;
    }

    public T getElem() {
        return elem;
    }

    public void setIzq(NodoSkip<T> izq) {
        this.izq = izq;
    }

    public void setDer(NodoSkip<T> der) {
        this.der = der;
    }

    public void setArriba(NodoSkip<T> arriba) {
        this.arriba = arriba;
    }

    public void setAbajo(NodoSkip<T> abajo) {
        this.abajo = abajo;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }
    
    public int compareTo(NodoSkip<T> n){
        return elem.compareTo(n.getElem());
    }
    
}//class
