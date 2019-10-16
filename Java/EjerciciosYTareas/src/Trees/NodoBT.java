package Trees;

public class  NodoBT <T extends Comparable<T>>{
    T element;
    NodoBT<T> izq, der, papa;
    public int equilibrio;
    NodoBT(T elem){
        element = elem;
        izq = null; der = null; papa = null;
        equilibrio = 0;
    }//builder

    public int numDescendientes(){
        int hijos = 0;
        if (izq != null)
            hijos += 1 + izq.numDescendientes();
        if (der != null)
            hijos += 1 + der.numDescendientes();
        return hijos;
    }//method
    
    public int calculaNivel(){  
        if (this == null)
            return 0;
        int izq, der;
        if (getIzq() == null)
            izq = 0;
        else
            izq = getIzq().calculaNivel();
        if (getDer() == null)
            der = 0;
        else
            der = getDer().calculaNivel();
        int res = (izq < der) ? der : izq;
        return res + 1;
    }//method
    
    public void cuelga(NodoBT<T> nodo){        
        if (nodo.getElement().compareTo(element) < 0){
            izq = nodo;   
            
        }//if
        else{
            der = nodo;
            
        }//else        
        nodo.setPapa(this);
    }//method
    
    public T getElement(){
        return element;
    }//method
    
    public void setElement(T dato){
        element = dato;
    }//method

    public String toString(){
        return element.toString() + "\n[" + izq.toString() +"---" + der.toString()+"]";
    }//method

    public NodoBT getDer(){
        return der;
    }//method

    public NodoBT getIzq(){
        return izq;
    }//method

    public NodoBT getPapa(){
        return papa;
    }//method

    public void setIzq(T elem){
        izq = new NodoBT(elem);
        
    }//method

    public void setDer(T elem){
        der = new NodoBT(elem);
        
    }//method

    public void setPapa(T elem){
        papa = new NodoBT(elem);
    }//method

    public void setIzq(NodoBT nodo){
        izq = nodo;
        
    }//method

    public void setDer(NodoBT nodo){
        der = nodo;
        
    }//method

    public void setPapa(NodoBT nodo){
        papa = nodo;
    }//method
    
    public int calculaEquilibrio(){
        int d, i;
        if (der == null)
            d = 0;
        else
            d = der.calculaNivel();
        if (izq == null)
            i = 0;
        else
            i = izq.calculaNivel();
        equilibrio = d - i;
        return equilibrio;
            
    }//method
    
    
    
}//class