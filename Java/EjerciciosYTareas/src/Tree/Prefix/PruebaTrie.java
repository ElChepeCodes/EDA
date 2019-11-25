/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package Tree.Prefix;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jlgut
 */
public class PruebaTrie {
    
    public static void cargaPalabrasArreglo(String[] arr, String nomArch){
        try{
            File f = new File(nomArch);
            Scanner sc = new Scanner(f);
            int i = 0;
            while(sc.hasNext() && i < arr.length){
                arr[i] = sc.next();
                i++;
            }//while
        }//try
        catch(Exception e){
            System.out.println(e);
        }//catch
    }//method
    
    public static char[] generaLlaves(String nomArch){
        ArrayList<Character> arr = new ArrayList();        
        try{
            File f = new File(nomArch);
            Scanner sc = new Scanner(f);
            String linea;
            while (sc.hasNext()){
                linea = sc.nextLine();
                if (!linea.contains("#")){
                    for (int i = 0; i < linea.length(); i++){
                        if (!arr.contains(linea.charAt(i))){
                            arr.add(linea.charAt(i));
                        }//if
                    }//for                    
                }//if
            }//while
        }//try
        catch(Exception e){
            System.out.println(e);
        }//catch
        char [] ar = new char [arr.size()];
        for (int i = 0; i < arr.size(); i++)
            ar [i] = arr.get(i);
        return ar;
    }//method
    
    public static void cargaPalabras(String nomArch, Trie t){
        try{
            File f = new File(nomArch);
            Scanner sc = new Scanner(f);
            String s;
            while(sc.hasNext()){
                s = sc.nextLine();
                if (!s.contains("#"))
                    t.add(s);                
            }//while
        }//try
        catch(Exception e){
            System.out.println(e);            
        }//catch
    }//method
    
    
    public static void imprimeArr(String [] arr){
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }//method
    
    //copia del codigo para el algoritmo merge sort proporcionado en la tarea de ordenamientos
    public static <T extends Comparable <T>> void ordenaMergeSort(T [] datos){
        int [] ar = {0};
        ordenaMergeSort(datos, 0, datos.length - 1, ar);
        System.out.println("mergeSort reviso " + ar[0] + " datos conentrada de " + datos.length);
    }//method
    //Metodo que ordena el arreglo con el merge sort
    private static <T extends Comparable <T>> void ordenaMergeSort(T [] datos, int min, int max, int[] sum){
        T [] temp;
        int indice, izq, der;
        if (min >= max - 1)
            return;
        int tam = max - min + 1, mitad = (max + min)/2;
        temp = (T[])(new Comparable [tam]);
        ordenaMergeSort(datos, min, mitad, sum);
        ordenaMergeSort(datos, mitad + 1, max, sum);

        izq = min; der = mitad + 1;
        for(int i = 0; i < tam; i++){
            sum[0]++;
            if(izq <= mitad && der <= max){
                if(datos[izq].compareTo(datos[der]) < 0)
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
    
    
    public static void main(String args[]){
        long st, ord, imp, end;
        //====================================Pruebas ordenamiento mergeSort===================================
        String [] arreglo = new String[100000];
        String nombreArch = "wiki-100k.txt";
        st = System.nanoTime();
        cargaPalabrasArreglo(arreglo, nombreArch);
        ord = System.nanoTime();
        ordenaMergeSort(arreglo);
        end = System.nanoTime();
        //imprimeArr(arreglo);
        imp = System.nanoTime();
        System.out.println("Valores merge sort:");
        System.out.println("Tiempo para insertar palabras:");
        System.out.println(ord - st);
        System.out.println("Tiempo para ordenar palabras:");
        System.out.println(end - ord);
        System.out.println("Tiempo para insertar palabras y ordenarlas:");
        System.out.println(end - st);
        
        //================================Pruebas trie==================================
        char keys [] = generaLlaves(nombreArch);
        Trie t = new Trie(keys);
        st = System.nanoTime();
        cargaPalabras(nombreArch, t);
        end = System.nanoTime();
        String [] s = t.toStringArray();
        long ar = System.nanoTime();
        System.out.println("Valores trie:");
        System.out.println("Tiempo para insertar palabras ordenadas:");
        System.out.println(end - st);
        System.out.println("Tiempo para insertar las palabras ordenadas en un arreglo:");
        System.out.println(ar-end);
        System.out.println("Tiempo total");
        System.out.println(ar-st);
    }//main
}//class
