/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package Trees;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jlgut
 */
public class BinBalancedTree<T extends Comparable<T>>{
    
    private NodoBT<T> raiz;
    private int cont;

    public BinBalancedTree(){
        raiz = null;
        cont = 0;
    }//builder

    
    public boolean isEmpty() {
        return raiz == null;
    }//method

    
    public int size() {
        return cont;
    }//method

    
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

    
    public  void agrega(T elem) {
       if(elem!=null){
        if(!isEmpty()){
            if(elem.compareTo(raiz.element)<0){
                add(elem, raiz.getIzq(), raiz);
                raiz.equilibrio--;
            }//if
            else{
                add(elem,raiz.getDer(), raiz);
            }//else
        }//if
        else
            raiz=new NodoBT(elem);
       }//if
    }//method
    private void add(T elem, NodoBT<T> a, NodoBT<T> p){
        if(a!= null){
            if(elem.compareTo(a.element)<0){
                a.equilibrio--;
                add(elem, a.getIzq(), a);
                
            }//if
            else{
                a.equilibrio++;
                add(elem,a.getDer(), a);                
            }//if
        }//if
        else {
            NodoBT<T> nuevo = new NodoBT(elem);
            if(elem.compareTo(p.element)<0){
                p.setIzq(nuevo);
                p.getIzq().setPapa(p);
                p.equilibrio--;
                while (p != null){
                    System.out.println("while set izq");
                    p.calculaEquilibrio();
                    if (Math.abs(p.equilibrio) == 2){
                        rota(p);
                        break;
                    }//if
                    p = p.getPapa();
                }//while
            }//if
            else{
                p.setDer(elem);
                p.getDer().setPapa(p);
                p.equilibrio++;
                while (p != null){
                    System.out.println("while set der");
                    System.out.println(p.calculaEquilibrio() + "equilibrio");
                    if (Math.abs(p.equilibrio) == 2){
                        System.out.println("if break");
                        rota(p);
                        break;
                    }//if
                    p = p.getPapa();
                }//while
            }//else
            cont ++;                                  
        }//else                        
    }//method
    
    public NodoBT getRaiz(){
        return raiz;
    }//method

    
    public boolean delete(T elem){
        NodoBT<T> temp = null, temp2;
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
            temp2 = n.getPapa();
            n.setPapa(temp);
            int eq = temp2.equilibrio ,a = temp2.calculaEquilibrio();
            while (eq != a && temp2 != null){
                System.out.println("while delete raro");
                if (Math.abs(a) == 2)
                    rota(temp2);
                temp2 = temp2.getPapa();
                eq = temp2.equilibrio;
                a = temp2.calculaEquilibrio();
            }//while
        }//if
        else//Si solo tiene un hijo
            if (n.getIzq()==null){
                if(n.getPapa() == null){                                
                    raiz = n.getDer();
                    raiz.setPapa(temp);
                }//if
                else{                    
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
    
    
    public NodoBT<T> rota(NodoBT<T> nodo){
        System.out.println("inicio rota");
        NodoBT<T> alfa, beta, gamma, A, B, C, D, papa;
        A = nodo;
        papa = nodo.getPapa();
        B = nodo.getIzq();
        C = nodo.getDer();
        //izq-izq
        if (nodo.equilibrio == -2 && (nodo.getIzq().equilibrio == -1 || nodo.getIzq().equilibrio == 0)){
            System.out.println("izq-izq");
            alfa = B.getIzq();
            beta = B.getDer();
            if (papa == null){
                raiz = B;                
                B.setPapa(papa);
            }//if
            else{
                if (B.getElement().compareTo(papa.getElement()) < 0)
                    papa.setIzq(B);
                else
                    papa.setDer(B);                
                B.setPapa(papa);
            }//else
            B.setDer(A);
            A.setPapa(B);
            A.setIzq(beta);
            if (beta != null)
                beta.setPapa(A);
            A.calculaEquilibrio();            
            alfa.calculaEquilibrio();
            B.calculaEquilibrio();
            while (papa != null){
                System.out.println("while 1 rota");
                papa.calculaEquilibrio();
                if (Math.abs(papa.equilibrio) == 2){
                    rota(papa);
                    break;
                }//if
                papa = papa.getPapa();
            }//while
        }//if
        else{
            //der-izq
            if (nodo.equilibrio == -2 && nodo.getIzq().equilibrio == 1){
                System.out.println("der-izq");
                D = B.getIzq();
                alfa = B.getDer();
                beta = alfa.getIzq();
                gamma = alfa.getDer();
                if (papa == null){                    
                    raiz = alfa;
                    alfa.setPapa(papa);                    
                }//if
                else{
                    if (alfa.getElement().compareTo(papa.getElement()) < 0)
                    papa.setIzq(alfa);
                else
                    papa.setDer(alfa);                
                alfa.setPapa(papa);
                }//else
                alfa.setIzq(B);
                B.setPapa(alfa);
                alfa.setDer(A);
                A.setPapa(alfa);
                B.setDer(beta);
                if (beta != null)
                    beta.setPapa(B);
                A.setIzq(gamma);
                if (gamma != null)
                    gamma.setPapa(A);
                A.calculaEquilibrio();
                B.calculaEquilibrio();
                alfa.calculaEquilibrio();
                while (papa != null){
                    System.out.println("while rota 2");
                    papa.calculaEquilibrio();
                    if (Math.abs(papa.equilibrio) == 2){
                        rota(papa);
                        break;
                    }//if
                    papa = papa.getPapa();
                }//while
            }//if
            else{
                //der-der
                if (nodo.equilibrio == 2 && (nodo.getDer().equilibrio == 1 || nodo.getDer().equilibrio == 0)){
                    System.out.println("der-der");
                    D = C.getIzq();
                    alfa = C.getDer();
                    if (papa == null){
                        raiz = C;
                        C.setPapa(papa);
                    }//if
                    else{
                        C.setPapa(papa);
                        if (C.getElement().compareTo(papa.getElement()) < 0)
                            papa.setIzq(C);
                        else
                            papa.setDer(C); 
                    }//else
                    C.setIzq(A);
                    A.setPapa(C);
                    A.setDer(D);
                    if (D != null)
                        D.setPapa(A);
                    alfa.calculaEquilibrio();
                    A.calculaEquilibrio();
                    C.calculaEquilibrio();
                    while (papa != null){
                        System.out.println("while rota 3");
                        papa.calculaEquilibrio();
                        if (Math.abs(papa.equilibrio) == 2){
                            rota(papa);
                            break;
                        }//if
                        papa = papa.getPapa();
                    }//while
                }//if
                //izq-der
                else{
                    System.out.println("izq-der");
                    D = C.getIzq();
                    alfa = C.getDer();
                    beta = D.getIzq();
                    gamma = D.getDer();
                    if (papa == null){
                        System.out.println(D.getElement());
                        raiz = D;
                    }//if
                    else{
                        if (D.getElement().compareTo(papa.getElement()) < 0)
                            papa.setIzq(D);
                        else
                            papa.setDer(D); 
                    }//else
                    D.setPapa(papa);
                    D.setIzq(A);
                    A.setPapa(D);
                    D.setDer(C);
                    C.setPapa(D);
                    A.setDer(beta);
                    if (beta != null)
                        beta.setPapa(A);
                    C.setIzq(gamma);
                    if (gamma != null)
                        gamma.setPapa(C);
                    C.calculaEquilibrio();
                    A.calculaEquilibrio();
                    D.calculaEquilibrio();
                    
                }//else
            }//else
            
        }//else
        
        
        return A;
    }//method
    
    //codigo print2DUtil modificado a partir de https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/
    public void print2DUtil(NodoBT<T> nodo, int tam)  
    {  
        // Base case  
        if (nodo == null)  
            return;  

        // Increase distance between levels  
        tam += cont;  

        // Process right child first  
        print2DUtil(nodo.getDer(), tam);  

        // Print current node after space  
        // count  
        System.out.print("\n");  
        for (int i = cont; i < tam; i++)  
            System.out.print(" ");  
        System.out.print(nodo.getElement() + " (eq " + nodo.equilibrio + ")\n");  

        // Process left child  
        print2DUtil(nodo.getIzq(), tam);  
    }  
  
// Wrapper over print2DUtil()  
    public void print2D(NodoBT<T> root)  
    {  
        // Pass initial space count as 0  
        print2DUtil(root, 0);  
    }     
    
    public static void main (String args[]){
        BinBalancedTree<Integer> t = new BinBalancedTree();
        Iterator<Integer> it;
        t.agrega(7);        
        t.agrega(8);
        t.agrega(1);
        t.agrega(0);
        t.agrega(2);
        t.agrega(3);
        t.agrega(-1);
        t.agrega(10);
        it = t.preOrden();
        StringBuilder s = new StringBuilder();
        while (it.hasNext())
            s.append(it.next()).append(", ");
        System.out.println(s.toString());
        System.out.println(t.raiz.equilibrio);
        t.print2D(t.raiz);
    }//main
}//class
