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

 //la formula para estimar el error:
 //(1-e^(-kn/m))^k
 //k = numero de funciones de hash
 //m = size del arreglo
 //n numero de datos esperados
 //la formula para el numero optimo de funciones de hash:
 //k = m/n ln2
 //la formula para calcular el porcentaje de falsos positivos:
 //p = e^(-(m/n)(ln2)^2
 //La formula para calcular el tamaño del arreglo:
 //m = -(n(lnp))/(ln2)^2
public class BloomFilter <T>{
    private boolean [] list;
    private HashTable<T> data;
    int cont, m, k;
    
    public BloomFilter(){
        m = 100;
        list = new boolean[m];
        for (int i = 0; i< list.length; i++)
            list[i] = false;
        cont = 0;
        data = new HashTable<T>(m);
        k = (int) (Math.log(m) / Math.log(2));
        System.out.println("K" + k);
    }//builder

    //se reciben como parametros el tamaño del arreglo que se desea y el numero de datos esperados y se asigna k funciones de hash
    //se usara como control en las pruebas experimentales
    public BloomFilter(int tam, int n){
        m = tam;
        list = new boolean[m];
        for (int i = 0; i< list.length; i++)
            list[i] = false;
        cont = 0;
        data = new HashTable<T>(n);
        k = (int) (m * Math.log(2)/n);
        System.out.println("K" + k);
    }//builder

    //constructor para hacer las pruebas variando el numero de funciones de hash
    public BloomFilter(int tam, int n, int hash){
        m = tam;
        list = new boolean[m];
        for (int i = 0; i< list.length; i++)
            list[i] = false;
        cont = 0;
        data = new HashTable<T>(m);
        k = hash;
    }//builder
    
    //Se crea un arreglo con 15 hashes diferentes para el valor del toString del elemento dado
    private <T> int[] hash(T el){
        String toSt = el.toString();
        int hash = toSt.charAt(0), h0, h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14;
        for (int i = 0; i< toSt.length(); i++){
            hash += Math.pow(3, i + 1) * toSt.charAt(i) - i * i;
        }//for
        h0 = Math.abs(hash);
        hash = toSt.charAt(0);
        for (int i = 0; i< toSt.length(); i++){
            hash += Math.pow(2, i + 1) * toSt.charAt(i) - i * (i-1);
        }//for
        h1 = Math.abs(hash);
        hash = toSt.charAt(0);
        for (int i = 0; i< toSt.length(); i++){
            hash += toSt.charAt(i)*toSt.charAt(i) * (i - 1);
        }//for
        h2 = Math.abs(hash);
        h3 = Math.abs(h0 + h1);
        h4 = Math.abs(h1 - h0);
        h5 = Math.abs(h0 * h1);
        h6 = Math.abs(h0 + h2);
        h7 = Math.abs(h0 - h2);
        h8 = Math.abs(h0 * h2);
        h9 = Math.abs(h1 + h2);
        h10 = Math.abs(h1 - h2);
        h11 = Math.abs(h1 * h2);
        h12 = Math.abs((h1 + h4) * h10);
        h13 = Math.abs((h0 + h9) * h7);
        h14 = Math.abs((h8 + h2) * h9);
        h0%=list.length;h1%=list.length;h2%=list.length;h3%=list.length;h4%=list.length;
        h5%=list.length;h6%=list.length;h7%=list.length;h8%=list.length;h9%=list.length;
        h10%=list.length;h11%=list.length;h12%=list.length;h13%=list.length;h14%=list.length;
        return new int[]{h0,h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12,h13,h14};
    }//method
    public <T> void add(T el){
        data.add(el);
        if (cont * k > (m / 2)){
            expand();
        }//if
        int[] hsh = hash(el);
        System.out.println(m);
        for (int i = 0; i < k; i++){
            System.out.println(hsh[i]);
            list[hsh[i]] = true;
        }//for
    }//method
    
    private<T> void expand(){
        m *= 10;
        k ++;
        list = new boolean[m];
        T [] elements = (T[]) data.toArray();
        for(int i = 0; i < elements.length; i++){
            add(elements[i]);
        }//for
    }//method
    
    public<T> boolean contains(T el){
        boolean res = true;
        int [] hsh = hash(el);
        int i = 0;
        while(i < k && res){
            res = list[hsh[i]];
            i++;
        }//while
        return res;
    }//method

    public<T> boolean containsHash(T el){
        return data.find(el);
    }//method

    public double FalsosPositivos(){
        return Math.pow(Math.E, ((-1) * k * Math.log(2)));
    }//method
    
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("[");
        for(int i = 0; i < m; i++)
            res.append(list[i]).append(", ");
        return res.toString();
    }//method
    
    public String hashString(){
        return data.toString();
    }//method
    
    public static void main(String[] args){
        BloomFilter<Integer> bl = new BloomFilter(1000, 100);
        Random r = new Random();
        int rand = 0;
        for(int i = 0; i < 100; i++){
            rand = r.nextInt();
            bl.add(rand);
        }//for
        System.out.println(bl.toString());
        System.out.println(bl.hashString());
        System.out.println(bl.FalsosPositivos());
    }//main
}//class
