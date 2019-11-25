/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package Tree.Prefix;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author jlgut
 */
public class Trie<T> {
    sent raiz;
    char [] simbolos;
    
    public Trie(char [] sim){
        raiz = new sent();
        sort(sim);
        simbolos = sim.clone();
    }//builder
    
    public void sort(char[] ar){
         int [] arr = {0};
        ordenaMergeSort(ar, 0, ar.length - 1, arr);
               
    }//method
    
    //Metodo que ordena el arreglo con el merge sort
    private static void ordenaMergeSort(char [] datos, int min, int max, int[] sum){
        char [] temp;
        int indice, izq, der;
        if (min >= max - 1)
            return;
        int tam = max - min + 1, mitad = (max + min)/2;
        temp = new char[tam];
        ordenaMergeSort(datos, min, mitad, sum);
        ordenaMergeSort(datos, mitad + 1, max, sum);

        izq = min; der = mitad + 1;
        for(int i = 0; i < tam; i++){
            sum[0]++;
            if(izq <= mitad && der <= max){
                if(datos[izq] < datos[der])
                    temp[i] = datos[izq++];
                else
                    temp[i] = datos[der++];
            }//if
            else{
                if(izq <= mitad)
                    temp[i] = datos[izq++];
                else   
                    temp[i] = datos[der++];
            }//else
        }//for


        for(int i = 0; i < temp.length; i++){
            sum[0]++;
            datos[min + i] = temp[i];
        }//for
        
    }//method
    
    public int busca(String llave){
        if (isEmpty())
            return 0;
        return busca(llave, raiz.getSig());
    }//method
    
    private int busca(String llave, NodoTrie actual){
        if (actual == null){
            return 0;
        }//if
        if (llave == null || llave.equals("")){            
            return actual.cont;
        }//if
        else{
            return busca(llave.substring(1), actual.getNodo(llave.charAt(0)));
        }//else
    }//method
    
    public void add(String key){
        if (isEmpty()){
            NodoTrie n = new NodoTrie(simbolos);
            raiz.setSig(n);
        }//if            
        raiz.getSig().add(key);
    }//method
    
    public boolean delete(String llave){
        if (isEmpty())
            return false;
        return delete(llave, raiz.getSig(), llave);
    }//method
    
    private boolean delete(String llave, NodoTrie actual, String llaveCompleta){
        //Si no hay mas apuntadores desde sus hijos
        if (llave.length() == 1){
            //si no esta registrada la palabra
            if (actual.getNodo(llave.charAt(0)) == null || actual.getNodo(llave.charAt(0)).cont <= 0)
                return false;
            //si hay mas de una entrada para la palabra
            if (actual.getNodo(llave.charAt(0)).cont > 1)
            actual.getNodo(llave.charAt(0)).cont --;                
            else{
                //se hace nulo el apuntador en el char de la llave que ya esta vacio
                if (actual.getNodo(llave.charAt(0)).isEmpty()){                    
                    eliminaInnecesarios(actual.getNodo(llave.charAt(0)), llaveCompleta);
                }//if
                else{
                    actual.getNodo(llave.charAt(0)).cont --;
                }//else
                
            }//else
            return true;
        }//if
        else{
            if (actual.getNodo(llave.charAt(0)) == null)
                return false;
            return delete(llave.substring(1), actual.getNodo(llave.charAt(0)), llaveCompleta);
        }//else
    }//method
    
    public void eliminaInnecesarios(NodoTrie n, String llave){
        while(n.getPapa() != null && llave.length() > 1 && n.emptyExcept(llave.charAt(llave.length()-1))){
            n = n.getPapa();
            n.hijos[n.pos(llave.charAt(llave.length()-1))] = null;
            llave = llave.substring(0,llave.length()-1);
        }//while
        if (n.getPapa() == null && n.emptyExcept(llave.charAt(0)))
            raiz.setSig(null);
    }//method
    

    
    public boolean isEmpty(){
        if (raiz.getSig() == null)
            return true;
        else
            return false;
    }//method
    
    public NodoTrie getRaiz(){
        return raiz.getSig();
    }//method
    
    public String imprime(){
        StringBuilder res = new StringBuilder();
        imprime(raiz.getSig(), res, "");
        return res.toString();
    }//method
    
    private void imprime(NodoTrie<T> n, StringBuilder res, String actual){
        int i;
        for (i = 0; i < n.cont; i++){
            res.append(actual).append("\n");
        }//for
        for (i = 0; i < simbolos.length; i++){
            if (n.hijos[i] != null)
                imprime(n.hijos[i], res, actual + simbolos[i]);
        }//for
    }//method
    
    public String[] toStringArray(){
        String s = imprime();
        String [] arr = s.split("\n");
        return arr;
    }//method
    
    private class sent{
        NodoTrie raiz;
        public sent(){
            raiz = null;
        }//method
        
        public void setSig(NodoTrie nod){
            raiz = nod;
        }//method
        
        public NodoTrie getSig(){
                return raiz;
        }//method
    }//private class
    
    
    
    public static void main (String args[]){
        char keys [] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Trie<Integer> t = new Trie(keys);
        System.out.println(t.imprime());
    }//main
    
}//class
