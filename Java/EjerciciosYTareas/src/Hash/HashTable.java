/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package Hash;

import java.util.Random;

/**
 *
 * @author jlgut
 */
public class HashTable <T>{
    //insertar
    //buscar
    //eliminar
    //hashFunction
    //
    HashNode<T>[] nodos;
    int siz, cont, contList;
    public HashTable(){
        siz = 100;
        nodos = new HashNode[siz]; 
        cont = 0;
        contList = 0;
    }//builder
    public HashTable(int tam){
        nodos = new HashNode[tam];
        siz = tam;
        cont = 0;
        contList = 0;
    }//builder
    public <T> int Hash(T dato){
        if (dato.toString() != null){
            String toSt = dato.toString();
            int hash = toSt.charAt(0) - siz;
            for (int i = 0; i< toSt.length(); i++){
                hash += Math.pow(3, i + 1) * toSt.charAt(i) - i * i;
            }//for
            return Math.abs(hash) % siz;
        }//if
        else
        {
            return dato.hashCode() % siz;
        }//else
    }//method
    
    public <T> void add(T el){
        int pos = Hash(el);
        if (nodos[pos] == null)
            nodos[pos] = new HashNode(el);
        else{
            HashNode node = new HashNode(el), next = nodos[pos];
            node.setNext(next);
            nodos[pos] = node;
            contList++;
        }//else
        cont++;
        if (cont * 100 / siz > 65)
            expand();
    }//method
    
    private void expand(){
        HashNode[] old = nodos, nuevo = new HashNode[siz * 2];
        HashNode temp;
        nodos = nuevo;
        siz *= 2;
        cont = 0;
        contList = 0;
        for (int i = 0; i< old.length; i++){
            if (old[i] != null){
                temp = old[i];
                do{
                    add(temp.getElem());
                    temp = temp.getNext();
                }//do
                while(temp != null);
            }//if
        }//for
        
    }//method
    
    public <T> boolean find(T el){
        int pos = Hash(el);
        boolean res = false;
        HashNode n = nodos[pos];
        while(n != null && !res){
            if(el.equals(n.getElem()))
                res = true;
            n = n.getNext();
        }//while
        return res;
    }//method
    
    //regresa un arreglo de length 2 en findNodes[0] viene el nodo previo al que contiene el elemento que buscas y en findNodes[1] viene el nodo con el elemento que buscas
    //si no encuentra el nodo con el elemento que buscas, se regresa null
    private <T> HashNode[] findNodes(T el){
        HashNode<T>[] res = new HashNode[2];
        int pos = Hash(el);
        boolean f = false;
        res[1] = (HashNode<T>) nodos[pos];
        if (res[1] != null && res[1].getElem().equals(el))
            f = true;
        while(res[1] != null && !f){
            res[0] = res[1];
            res[1] = res[1].getNext();
            if (res[1] != null && res[1].getElem().equals(el))
                f = true;
        }//while
        if (!f){
            return null;
        }//if
            return res;
    }//method
    
    public <T> boolean delete(T el){
        HashNode[] nodes = findNodes(el);
        if (nodes == null)
            return false;
        else{
            if (nodes[0] == null)
                nodos[Hash(el)] = nodes[1].getNext();
            else
                nodos[0].setNext(nodos[1].getNext());
            return true;
        }//else
    }//method
    
    public <T> T[] toArray(){
        T[] res =(T[]) (new Object[siz]);
        HashNode n;
        int cont = 0;
        for (int i = 0; i < siz; i++){
            n = nodos[i];
            if(n != null){
                do{
                    res[cont] = (T) n.getElem();
                    n = n.getNext();
                    cont ++;
                }//do
                while(n != null);
            }//if
        }//for
        return res;
    }//method
    
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("[");
        HashNode n;
        for (int i = 0; i < siz; i++){
            n = nodos[i];
            res.append("{");
            if(n != null){
                do{
                    res.append(n.getElem()).append(", ");
                    n = n.getNext();
                }//do
                while(n != null);
            }//if
            res.append("}");
            res.append(", ");
        }//for
        res.append("]");
        return res.toString();
    }//method

    public static void main (String args []){
        HashTable<Integer> t = new HashTable();
        Random r = new Random();
        for(int i = 0; i < 100; i++)
            t.add(r.nextInt());
        System.out.println(t.toString());
        System.out.println(t.siz);
    }//main
}//class
