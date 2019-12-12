/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package Hash;

/**
 *
 * @author jlgut
 */
public class HashNode <T> {
    int llave;
    T elem;
    HashNode<T> sig;
    
    public HashNode(T element, int key){
        elem = element;
        llave = key;
        sig = null;
    }//builder
    
    public HashNode(T element){
        elem = element;
        sig = null;
    }//builder
    
    public HashNode<T> getNext(){
        return sig;
    }//method
    
    public T getElem(){
        return elem;
    }//method
    
    public void setNext(HashNode<T> n){
        sig = n;
    }//method
    
    public boolean hasNext(){
        return sig != null;
    }//method
}//class
