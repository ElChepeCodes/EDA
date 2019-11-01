/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package SkipLists;

/**
 *
 * @author jlgut
 */
public class SkipList<T extends Comparable <T>> {
    NodoSkip<T> top, tail;
    int cont, numListas;
    
    public SkipList(){
        top = new NodoSkip();
        tail = new NodoSkip();
        top.setDer(tail);
        tail.setIzq(top);
        cont = 0; numListas = 0;
    }//builder
    
    public boolean busca(T elem){
        if (isEmpty())
            return false;
        return busca(top.getDer(), elem).getElem().equals(elem);
    }//builder
    
    private NodoSkip<T> busca(NodoSkip<T> n, T elem){
        if (n.getElem() == null){
            if (n.getDer().getElem() == null)                
                return n;
            if (n.getDer().getElem().compareTo(elem) > 0){
                if (n.getAbajo() == null)
                    return n;
                else
                    return busca(n.getAbajo(), elem);
            }//if
            else
                return busca(n.getDer(), elem);
        }//if
        if (n.getElem().equals(elem)){
            while(n.getAbajo()!=null)
                n = n.getAbajo();
            return n;
        }//if
        if (n.getElem().compareTo(elem) > 0){
            return busca(n.getIzq(), elem);
        }//if
        else
            return busca(n.getDer(), elem);
    }//method
    
    public boolean delete(T elem){
        boolean res = true;
        
        
        return res;
    }//method
    
    
    public boolean isEmpty(){
        return top.getDer().equals(tail);
    }//method
    
    
    
    
}//class






