/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package Tree.Prefix;

/**
 *
 * @author jlgut
 */
public class NodoTrie<T> {
    NodoTrie<T> hijos [];
    NodoTrie<T> papa;
    static char [] keys;
    int cont;
    T elem;
    
    public NodoTrie(char [] ord){
        hijos = new NodoTrie[ord.length];
        keys = ord;
        cont = 0;
        papa = null;
    }//builder
    
    public NodoTrie(){
        hijos = new NodoTrie[keys.length];
        cont = 0;
        papa = null;
    }//builder    
    
    public NodoTrie(String key){
        hijos = new NodoTrie[keys.length];
        if (key != null)           
            add(key);
        papa = null;
    }//builder
    
    public NodoTrie<T> getPapa(){
        return papa;
    }//method
    
    public NodoTrie(String key, NodoTrie pa){
        hijos = new NodoTrie[keys.length];
        if (key != null)           
            add(key);
        cont++;
        papa = pa;
    }//builder

    public void add(String key){
        if (key == null){
            System.out.println("el key se hizo null");
        }//if            
        if (key.length() == 1){
            if (hijos[pos(key.charAt(0))] == null){
                hijos[pos(key.charAt(0))] = new NodoTrie();
                hijos[pos(key.charAt(0))].cont++;
                hijos[pos(key.charAt(0))].papa = this;
            }//if
            else
                hijos[pos(key.charAt(0))].cont++;
        }//if
        else{
            if (hijos[pos(key.charAt(0))] == null){
                hijos[pos(key.charAt(0))] = new NodoTrie(key.substring(1));            
                hijos[pos(key.charAt(0))].papa = this;
            }
            else{
                hijos[pos(key.charAt(0))].add(key.substring(1));
            }//else
        }//else
    }//method
    
    public int pos(char c){
        int i = 0;
        while (i < keys.length && keys[i] != c)
            i++;
        if (i >= keys.length)
            return -1;
        else
            return i;
    }//method
    
    public NodoTrie getNodo(char c){
        return hijos[pos(c)];
    }//method
    
    public void setNodo(char c, NodoTrie n){
        hijos[pos(c)] = n;
    }//method
    
    public boolean emptyExcept(char c){
        boolean res = true;
        int i = 0, p = pos(c);
        while (res && i < hijos.length){
            if (i != p)
                res = hijos[i] == null;
            i++;
        }//while
        return res;
    }//method
    
    public boolean isEmpty(){
        boolean res = false;
        int i = 0;
        while (i < hijos.length && !res){            
            res = hijos[i] ==null ;
            i++;
        }//while
        return res;
    }//method
    
}//class
