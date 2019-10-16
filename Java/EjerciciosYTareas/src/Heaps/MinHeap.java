/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package Heaps;

/**
 *
 * @author jlgut
 */
public class MinHeap <T extends Comparable <T>> implements HeapADT{

    private NodoHeap<T>[] heap;
    private int cont;
    
    public MinHeap(){
       // heap = (NodoHeap<T>[])(new Object[10]);
                heap = new NodoHeap[10];

        cont = 0;
    }//builder
    
    
    @Override
    public void add(Comparable elem) {
        NodoHeap<T> n = new NodoHeap(elem), temp;
        
        if (isEmpty()){
            heap[1] = n;
            System.out.println(heap[1].getElem());
            cont ++;
            return;
        }//if
        else{
            if (cont == heap.length - 1)
                expand();
            heap[++cont] = n;
            int papa = cont / 2, pos = cont;
            while (papa != 0 && (heap[pos].getElem().compareTo(heap[papa].getElem()) < 0)){
                    temp = heap[pos];
                    heap[pos] = heap[papa];
                    heap[papa] = temp;
                    pos = papa;
                    papa /= 2;
            }//while
            
        }//else
            
        
        return;
    }//method
    
    private void expand(){
        NodoHeap<T> [] nuevo = (NodoHeap[])(new Object[heap.length * 2]);
        for (int i = 1; i < heap.length; i ++)
            nuevo[i] = heap[i];
        heap = nuevo;
    }//method

    @Override
    public Comparable delete() {
        NodoHeap<T> n = heap[1];
        heap[1] = heap[cont];
        reorganiza();        
        cont--;
        return n.getElem();
    }//method
    
    private void reorganiza(){
       NodoHeap<T> n = heap[1];
       int pos = 2, current = 1;
       while (pos < cont && (n.getElem().compareTo(heap[pos].getElem()) > 0 || n.getElem().compareTo(heap[pos + 1].getElem()) > 0)){
           if (n.getElem().compareTo(heap[pos + 1].getElem()) > 0 && heap[pos + 1].getElem().compareTo(heap[pos].getElem()) < 0){
               pos++;
           }//if
           heap[current] = heap[pos];
           heap[pos] = n;
           current = pos++;           
       }//while           
    }//method

    @Override
    public Comparable find(Comparable elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }//method
    
    @Override
    public boolean isEmpty(){
        return cont == 0;
    }//method
    
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= cont; i++){
            res.append(heap[i].getElem()).append(", ");
        }//method
        
        return res.toString();
    }//method
    
    public T getMin(){
        return heap[1].getElem();
    }//method
    
    public static void main(String [] args){
        MinHeap<Integer> h = new MinHeap();
        h.add(1);
        System.out.println(h);
        h.add(2);
        System.out.println(h);
        h.add(0);
        System.out.println(h);
        h.add(5);
        System.out.println(h);
        h.add(3);
        System.out.println(h);
        h.delete();
        System.out.println(h);
        h.delete();
        System.out.println(h);
        
    }//main
}//class
