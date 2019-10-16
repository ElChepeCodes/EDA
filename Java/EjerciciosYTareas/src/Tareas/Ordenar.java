package Tareas;

class Ordenar{
    public static<T extends Comparable <T>> void ordenaQuickSort(T [] arr){
        ordenaQuickSort(arr, 0, arr.length - 1);
    }//method

    private static <T extends Comparable <T>> void ordenaQuickSort(T [] arr, int in, int fin){    	
    	if (in >= fin) {
    		return;
        }
        int i = in, piv = (int) (Math.random() * ((fin - in) + 1)) + in, aux;
        T temp;
        while (i <= fin){
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
        ordenaQuickSort(arr, 0, piv-1);        
        
    }//method


    public static <T> String impArr(T [] arr){
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < arr.length; i++)
            res.append(arr[i]).append(", ");

        return res.toString();
    }//method

    public static void main (String args []){        
        Integer[] arr = {8,9,1,4,3,5,3,45,2,3,4,2,2,2,3,4,5,3,7,6,8,6,4,2,4,3,4,7,8,9,0,5,3,4,5,5,2,2};
        System.out.println("Original");
        System.out.println(impArr(arr));
        ordenaQuickSort(arr);
        System.out.println("Ordenado");
        System.out.println(impArr(arr));
    }//main



}//class