package Trees;

import java.util.ArrayList;
import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements BinarySearchTreeADT<T> {

    private NodoBT<T> raiz;
    private int cont;

    public BinarySearchTree(){
        raiz = null;
        cont = 0;
    }//builder

    @Override
    public boolean isEmpty() {
        return raiz == null;
    }//method

    @Override
    public int size() {
        return cont;
    }//method

    @Override
    public boolean contains(T elem) {
        if (isEmpty() || elem == null)
            return false;
        if (raiz.getElement().equals(elem))
            return true;            
        return contains(elem, raiz.getDer()) || contains(elem, raiz.getIzq());
    }//method

    private boolean contains(T elem, NodoBT<T> nodo){
        if (nodo == null || nodo.element == null)
            return false;
        if (nodo.getElement().equals(elem))
            return true;
        return contains(elem, nodo.getIzq()) || contains(elem, nodo.getDer());

    }//method 

    @Override
    public Iterator<T> inOrden() {
        ArrayList<T> lista = new ArrayList<T>();
        inOrden(raiz, lista);
        System.out.println(lista.toString());
        return lista.iterator();        
    }//method

    private void inOrden(NodoBT<T> nodo, ArrayList<T> lista){
        if (nodo==null)
            return;        
        inOrden(nodo.getIzq(), lista);
        lista.add(nodo.getElement());
        inOrden(nodo.getDer(), lista);
    }//method

    @Override
    public Iterator<T> preOrden() {
        ArrayList<T> lista = new ArrayList<T>();
        preOrden(raiz, lista);
        
        return lista.iterator();        
    }//method

    private void preOrden(NodoBT<T> nodo, ArrayList<T> lista){
        if (nodo==null)
            return;
        lista.add(nodo.getElement());
        preOrden(nodo.getIzq(), lista);
        preOrden(nodo.getDer(), lista);
    }//method

    @Override
    public Iterator<T> postOrden() {
        ArrayList<T> lista = new ArrayList<T>();
        postOrden(raiz, lista);
        return lista.iterator();                
    }//method

    private void postOrden(NodoBT<T> nodo, ArrayList<T> lista){
        if (nodo==null)
            return;        
        postOrden(nodo.getIzq(), lista);
        postOrden(nodo.getDer(), lista);
        lista.add(nodo.getElement());
    }//method

    @Override
    public int altura() {
        return altura(raiz);
    }//method

    private int altura(NodoBT<T> nodo){        
        if (nodo == null)
            return 0;
        int i, d;
        i = altura(nodo.getIzq());
        d = altura(nodo.getDer());                
        if (i > d)
            return i + 1;
        else
            return d + 1;
    }//method

    @Override
    public  void agrega(T elem) {
       if(elem!=null){
        if(!isEmpty()){
            if(elem.compareTo(raiz.element)<0){
                add(elem, raiz.getIzq(), raiz);
            }
            else
                add(elem,raiz.getDer(), raiz);
        }
        else
            raiz=new NodoBT(elem);
       }
    }private void add(T elem, NodoBT<T> a, NodoBT<T> p){
        if(a!= null){
            if(elem.compareTo(a.element)<0)
                add(elem, a.getIzq(), a);
            
            else
                add(elem,a.getDer(), a);
        }
        else {
            NodoBT<T> nuevo = new NodoBT(elem);
            if(elem.compareTo(p.element)<0){
                p.setIzq(nuevo);
                p.getIzq().setPapa(p);
            }//if
            else{
                p.setDer(elem);
                p.getDer().setPapa(p);
            }//else
        }
        cont ++;
    }
    
    public NodoBT getRaiz(){
        return raiz;
    }//method

    @Override
    public boolean delete(T elem){
        NodoBT<T> temp = null;
        NodoBT n = find(raiz, elem);
        if (n == null)
            return false;
        //Si la raiz es una hoja
        if (n.getDer()==null && n.getIzq()==null){
            if (n.getPapa()==null){
                n = null;                
            }
            else
                if (n.getElement().compareTo(n.getPapa().getElement())<0){
                    n.getPapa().setIzq(temp);
                }//if
                else{
                    n.getPapa().setDer(temp);        
                }//else
            
        }//if
        else//Si solo tiene un hijo
            if (n.getIzq()==null){
                if(n.getPapa() == null){                                
                    raiz = n.getDer();
                    raiz.setPapa(temp);
                }//if
                else{
                    System.out.println("webos");
                    n.getPapa().cuelga(n.getDer());
                }//else
            }else
            if (n.getDer()==null){
                if(n == raiz){
                    raiz = n.getIzq();
                    raiz.setPapa(temp);
                }else
                    n.getPapa().cuelga(n.getIzq());
            }//if
            else{//Si tiene dos hijos. 
                NodoBT<T> suc = n.getDer();
                while(suc.getIzq()!=null)
                    suc = suc.getIzq();
                n.setElement(suc.getElement());
                if(suc == n.getDer())
                    n.setDer(suc.getDer());
                else
                    suc.getPapa().setIzq(suc.getDer());
            }        
            cont--;
            return true;
    }
    public <T extends Comparable<T>> NodoBT<T> find(T ele){
        if (!isEmpty())
            return find(raiz, ele);
        else
            return null;
    }//method
    
    
    private <T extends Comparable<T>> NodoBT<T> find(NodoBT nodo, T elem){
        if (nodo == null)
            return null;
        if (nodo.getElement().equals(elem))
            return nodo;        
        if (nodo.getElement().compareTo(elem) > 0)
            return find(nodo.getIzq(), elem);
        else
            return find(nodo.getDer(), elem);
    }//method
    
 /*   public String toStringALV() {
    	
    }//method
*/

    public static void main(String[] args){
        BinarySearchTree <Integer> a = new BinarySearchTree();
        Integer[] datos = {1,2,-1, 4, 3, 6};
        for (int i = 0; i < datos.length; i++) {
            a.agrega(datos[i]);
            System.out.println(datos[i]);
        }
        Iterator it = a.inOrden();
        while(it.hasNext())
        	System.out.println(it.next().toString());       
        System.out.println(a.find(2).getElement());
        a.delete(4);
        it = a.inOrden();
        while(it.hasNext())
        	System.out.println(it.next().toString());       
        //System.out.println(a.getRaiz().getIzq());
        //System.out.println(a.getRaiz().getDer());
    }//main
//no sirve el metodo delete
}//class