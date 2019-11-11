/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package SkipLists;

import java.util.Random;

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
            if (n.getDer() == null)
                return n.getIzq();
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
            if (n.getAbajo() == null)
                return n.getIzq();
            else
                return busca(n.getIzq(), elem);
        }//if
        else
            return busca(n.getDer(), elem);
    }//method        
    
    public boolean isEmpty(){
        return top.getDer().equals(tail);
    }//method
    
    
    public void add(T elem){
        NodoSkip actual = busca(top, elem),
        nuevo = new NodoSkip(elem), izq, der, arr, ab;        
        der = actual.getDer();
        actual.setDer(nuevo);
        nuevo.setIzq(actual);
        nuevo.setDer(der);
        der.setIzq(nuevo);
        Random rd = new Random();
        ab = nuevo;
        while (rd.nextBoolean()){
            System.out.println("Sube");
            der = nuevo.getDer();
            izq = nuevo.getIzq();
            while (izq.getArriba() ==  null && izq.getElem() != null)
                izq = izq.getIzq();
            while (der.getArriba() == null && der.getElem() != null)
                der = der.getDer();
            if (izq.getElem() ==  null && der.getElem() == null){
                System.out.println("orilla");
                if (numListas < log2(cont)){
                    NodoSkip nTop = new NodoSkip(),
                            nTail = new NodoSkip();
                    top.setArriba(nTop);
                    nTop.setAbajo(top);
                    tail.setArriba(nTail);
                    nTail.setAbajo(tail);
                    top = nTop; tail = nTail;
                    izq = top;
                    der = tail;
                    numListas++;
                }//if
                else
                    break;
            }//if
            else{
                izq = izq.getArriba();
                der = der.getArriba();
            }//else
            arr = new NodoSkip(elem);
            arr.setIzq(izq);
            izq.setDer(arr);
            arr.setDer(der);
            der.setIzq(arr);
            ab.setArriba(arr);
            arr.setAbajo(ab);
            ab = arr;
        }//while
        cont ++;
    }//method
    
    public void delete(T elem){
        NodoSkip actual = busca(top, elem), izq, der;
        if (actual.getElem() == null || !actual.getElem().equals(elem))
            return;
        while (actual != null){
            izq = actual.getIzq();
            der = actual.getDer();
            izq.setDer(der);
            der.setIzq(izq);
            actual = actual.getArriba();
        }//while
        if(numListas > log2(cont + 2)){
            top = top.getAbajo();
            tail = tail.getAbajo();
            actual = top;
            while(actual != null){
             actual.setArriba(null);
             actual = actual.getDer();
            }//while            
        }//if
        numListas--;
    }//method
    
    public int log2(int num){
        return (int) (Math.log(num)/Math.log(2));
    }//method
    
    public String imprime(){
        StringBuilder res = new StringBuilder();
        NodoSkip actual = top;
        while (actual.getAbajo() != null)
            actual = actual.getAbajo();
        actual = actual.getDer();
        while(actual.getElem() != null){
            res.append(actual.getElem().toString()).append(", ");
            actual = actual.getDer();
        }//while
        return res.toString();
    }//imprime
    
    public void imprimeDiag(){
        NodoSkip nTop = top,n = top;
        while (n.getAbajo() != null)
            n = n.getAbajo();
        while (!(n.getDer() == null && n.getArriba() == null)){
            if (n.getElem() == null){
                System.out.print("[|]");
                if (n.getDer() == null){
                    if (n.getArriba() == null)
                        return;
                    n = n.getArriba();
                    System.out.println();
                    while (n.getIzq() != null)
                        n = n.getIzq();
                }//if
                else
                    n = n.getDer();
            }//if
            else{
                System.out.print("-"+n.getElem().toString());
                n = n.getDer();
            }//else            
        }//while
        System.out.print("[|]\n");
    }//method
    
    public static void main(String args[]){
        SkipList<Integer> sl = new SkipList();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(2); 
        sl.add(1);

        System.out.println(sl.imprime());
        sl.imprimeDiag();
        sl.delete(2);
        System.out.println(sl.imprime());
    }//main
    
}//class






