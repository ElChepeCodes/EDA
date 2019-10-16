package Tareas;

import java.util.Iterator;



public class ord {
    
    public static<T> void invierteArreglo(T[] a){
        T temp;
        int l = a.length;
        for(int i = 0; i < l ; i++){
            temp = a[i];
            a[i] = a[l - i - 1];
            a[l - i - 1] = temp;
        }//for
    }//method
    
    public static<T> void randomizerArreglo(T[] a){
        int pos;
        T temp;
        for (int i = 0; i < a.length; i++){
            pos = (int) ((Math.random() * a.length));
            temp = a[i];
            a[i] = a[pos];
            a[pos] = temp;
        }//for
    }//method

    //Metodo que ordena utilizando selection sort
    public static <T extends Comparable<T>> void ordenaSelectSort(T[] arr){
        //T[]arr =(T[])(ar);
        int pos, sum = 0;
        T temp;
        for (int i = 0; i < arr.length; i++){
            pos = i;
            sum++;
            for (int j = i; j < arr.length; j++){
                sum++;
                if(arr[j].compareTo(arr[pos]) < 0){
                    pos = j;
                }//if                
            }//for
            temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;
        }//for
        System.out.println("selectSort reviso " + sum + " datos conentrada de " + arr.length);
    }//method

    //Metodo que ordena utilizando insertion sort
    public static<T extends Comparable<T>> void ordenaInsertSort(T[] arr){
        int i = 1, j, sum = 0;
        T temp;
        while (i < arr.length){
            sum++;
            if (arr[i].compareTo(arr[i - 1]) < 0){
                j = i;
                while(j > 0 && arr[j].compareTo(arr[j - 1]) < 0){
                    sum++;
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    j--;
                }//while
            }//if
            i++;
        }//while
        System.out.println("insertSort reviso " + sum + " datos conentrada de " + arr.length);
    }//method

    public static <T extends Comparable <T>> void ordenaBubbleSort(T[] arr){
        int n = arr.length, sum = 0; 
        for (int i = 0; i < n-1; i++){ 
            sum++;
            for (int j = 0; j < n-i-1; j++){
                sum++;
                if (arr[j].compareTo(arr[j+1]) > 0){                     
                    T temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                }//if
            }//for
        }//for
        System.out.println("bubbleSort reviso " + sum + " datos conentrada de " + arr.length);
    }//method

    //Metodo que inicia quick sort utilizando el inicio del arreglo y el final del arreglo como parametros
    public static<T extends Comparable <T>> void ordenaQuickSort(T [] arr){
        int sum []= {0};
        ordenaQuickSort(arr, 0, arr.length - 1, sum);
        System.out.println("quickSort reviso " + sum[0] + " datos conentrada de " + arr.length);
    }//method

    //Metodo recursivo que ordena utilizando el quick sort
    private static <T extends Comparable <T>> void ordenaQuickSort(T [] arr, int in, int fin, int[] sum){    	
    	if (in >= fin) {
    		return;
        }
        int i = in, piv = (int) (Math.random() * ((fin - in) + 1)) + in, aux;
        T temp;
        while (i <= fin){
            sum[0]++;
            if (i < piv && arr[i].compareTo(arr[piv]) > 0){
                
                    temp = arr[i];
                    arr[i] = arr[piv];
                    arr[piv] = temp;
                
            }//if
            else
                if (i > piv && arr[i].compareTo(arr[piv]) < 0){
                    temp = arr[i];
                    arr[i] = arr[piv];
                    arr[piv] = temp;
                    aux = i;
                    i = piv;
                    piv = aux;
                }//if
            i++;
        }//while
        ordenaQuickSort(arr, 0, piv-1, sum);                
    }//method
    
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

    public static <T extends Comparable<T>> void mergeSortMixcoac(T[] arr){
        int tam = arr.length, s = 2, i = 0;
        while (s <= tam){
            while(i < tam){

            }//while
        }//while


    }//method

    






   

    //Metodo que regresa el arreglo como un String
    public static <T> String impArr(T [] arr){
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < arr.length; i++)
            res.append(arr[i]).append(", ");

        return res.toString();
    }//method

    public static void main (String args []){        
        Integer[] arr = {3,2,6,1,4,2,6,3,4,3,3,6,2,6,3,4,2,3,6,7,3,4,5,-3};
        System.out.println("Original");
        System.out.println(impArr(arr));
        ordenaInsertSort(arr);
        System.out.println("Ordenado");
        System.out.println(impArr(arr));
    }//main


}//class
