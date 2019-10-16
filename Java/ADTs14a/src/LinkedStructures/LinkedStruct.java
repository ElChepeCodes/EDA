
package LinkedStructures;
import java.util.Iterator;

/** Clase para manejar una estructura enlazada. */
public class LinkedStruct<T> {
    /** "count", number of nodes or elements,
     * "front", first node or element */
    private int count;
    private LinearNode<T> front;

    /** Crea una Estructura Enlazada vacía */
    public LinkedStruct() {
        count = 0;
        front = null;
    }

    /** Agrega el elemento especificado en la posicion pos.
     * Si pos<=1, agrega en la posición 1;
     * si pos>count, agrega en la posicion count+1. */
    public void add(T element, int pos) {
        LinearNode<T> node= new LinearNode<T>(element);
        LinearNode<T> current;
        int i;

        if( this.isEmpty() ) {    // Linked Structure vacia
            front= node;
        } else {    //Estructura no vacía.
            if( pos <= 1 ) {
                node.setNext(front);    //Inserta en la posición 1.
                front= node;
            } else {
                //Inserta en una posición >= 2.
                i= 1;
                current= front;
                while( i<(pos-1) && current.getNext() != null ) {
                    i++;        //Avanzar en la estructura.
                    current= current.getNext();
                }
                //Inserta el nuevo nodo.
                node.setNext( current.getNext() );
                current.setNext( node );
            }
        }
        count++;
    }

    /** Remueve el elemento en la posicion pos y regresa una referencia
     * a el. Lanza una ElementNotFoundException si la posicion
     * esta fuera de los limites. */
    public T remove(int pos) throws ElementNotFoundException {
        LinearNode<T> current, previous= null;
        T result= null;
        int i;

        if( pos<1 || pos>size() ) {
            throw new ElementNotFoundException(
                    "LinkedStruct: posicion fuera de limites o vacio.");
            // Queda incluido el estado de vacio
        }

        if( pos==1 ) {     //Recupera el elemento del nodo de la posición 1.
            result= front.getElement();
            front= front.getNext();
        } else {
            //Recupera el elemento de un nodo en posición >= 2.
            i= 1; current= front;
            while( i<pos ) {   //Recorre la estructura hasta el nodo en pos.
                previous= current;
                current= current.getNext();
                i++;
            }
            //Recupera el elemento del nodo de la posición pos.
            result= current.getElement();
            previous.setNext(current.getNext());
        }
        count--;
        return result;
    }

    /** Regresa una referencia al elemento que está en la posicion pos.
     * Lanza una ElementNotFoundException si la posicion
     * esta fuera de los limites. */
    public T get(int pos) throws ElementNotFoundException {
        LinearNode<T> current;

        if( pos<1 || pos>size() ) {
            throw new ElementNotFoundException(
                    "LinkedStruct: posicion fuera de limites o vacio.");
            // Queda incluido el estado de vacio

        }

        current= front;
        for( int i=1; i<pos; i++ ) {
            current= current.getNext();
        }

        return current.getElement();
    }

    /** Coloca el elemento especificado en la posicion pos.
     * Lanza una ElementNotFoundException si la posicion
     * esta fuera de los limites. */
    public void set(T element, int pos) throws ElementNotFoundException {
        LinearNode<T> current;

        if( pos<1 || pos>size() ) {
            throw new ElementNotFoundException(
                    "LinkedStruct: posicion fuera de limites o vacio.");
            // Queda incluido el estado de vacio
        }

        current= front;
        for( int i=1; i<pos; i++ ) {
            current= current.getNext();
        }

        current.setElement(element);
    }

    /** Regresa true si la estructura esta vacia o falso en caso contrario. */
    public boolean isEmpty() {
        return (count == 0);
    }

    /** Regresa la cantidad de elementos en la estructura. */
    public int size() {
        return count;
    }

    /** Returns an iterator for the elements currently in this set.
     */
    public Iterator<T> iterator() {
        return ( new LinkedStructIter<T>(front) );
    }


    /** Regresa una cadena representando a la estructura. */
    @Override
    public String toString() {

        String result = "{LinkedStruct:";
        LinearNode<T> current = front;

        if( front == null) {
            result = result + " <EMPTY>";
        }
        while (current != null) {
            result = result + " " + (current.getElement()).toString() + ",";
            current = current.getNext();
        }
        result = result + " }\n";
        return result;
    }

    /** Problema 40: elimina el nodo anterior al que contiene el dato info
     * dado como parametro. Regresa true, si lo elimino; false, si no.
     */
    public boolean eliminaAnteriorA(T info)
                throws ParamErrException {
        if( info == null ) {
            throw new ParamErrException("LinkedStruct: <info> con null");
        }

        LinearNode<T> current, previous= null, anteprevious= null;
        boolean elimi= false;
        int i= 1;

        if( !isEmpty() ) {
            //Recorre la estructura, mientras haya nodos y no se encuentre info.
            i= 1;
            current= this.front;    //Inicio de la estructura.
            while( i<=size() && !elimi ) {
                if (current.getElement().equals(info)) {
                    elimi= true;     //Lo encontro y puede haber eliminacion.
                } else {    //Avanza al siguiente nodo.
                    anteprevious= previous;
                    previous= current;
                    current= current.getNext();
                    i++;
                }
            }
            if( elimi ) {   // elimi : true
                if( i == 1 ) {
                    //Caso 3: el info esta en pos. 1 y no hay nodo a eliminar.
                    elimi= false;
                } else {    // pos > 1
                    // Encontro el info en una posicion >= 2.
                    // En lugar del siguiente codigo: remove(pos-1)
                    if( anteprevious == null ) {
                        //Elimina el nodo de la pos. 1.
                        front= current;    // Caso 4
                    } else {
                        //Elimina nodo a partir de pos>=2.
                        anteprevious.setNext(current);    // Caso 5
                    }
                    count--;
                }
            }   // else: Caso 2: el info no esta, elimi : false.
        }    // else, Caso 1: regresa elimi : false
        return elimi;
    }

    /** Problema 41: elimina el nodo posterior al que contiene el dato info
     * dado como parametro. Regresa true, si lo elimino; false, si no.
     */
    public boolean eliminaSiguienteDe(T info)
                throws ParamErrException {

        if( info == null ) {
            throw new ParamErrException("LinkedStruct: <info> con null");
        }

        LinearNode<T> current, poste= null, sigposte = null;
        boolean elimi= false;
        int i= 1;

        if( !isEmpty() ) {
            //Recorre la estructura, mientras haya nodos y no se encuentre info.
            i= 1;
            current= this.front;    //Inicio de la estructura.
            while( i<=size() && !elimi ) {
                if (current.getElement().equals(info)) {
                    elimi= true;     //Lo encontro y puede haber eliminacion.
                } else {    //Avanza al siguiente nodo.
                    current = current.getNext();
                    i++;
                }
            }
            if( elimi ) {   // elimi : true
                if( i == size() ) {
                    //Caso 3: el info esta en ultima pos y no hay nodo a eliminar.
                    elimi= false;
                } else {    // pos>=1 e pos<size()
                    // Encontro el info en una pos >=1 y < size().
                    // En lugar del siguiente codigo: remove(pos+1)
                    // Caso 4: Elimina el nodo de la pos==size(), o
                    // Caso 5: Elimina el nodo de una pos>=1 y <size()
                    poste = current.getNext();    // <= penultimo nodo
                    sigposte = poste.getNext();
                    current.setNext(sigposte);
                    count--;
                }
            }   // else: Caso 2: el info no esta, elimi : false.
        }    // else, Caso 1: regresa elimi : false
        return elimi;
    }

    /** Problema 42: inserta un nuevo elemento antes que el elemento refer
     * dado como parametro. Regresa true, si lo inserto; false, si no.
     */
    public boolean insertaAntesQue(T refer, T nuevo)
                throws ParamErrException {
        if( refer==null || nuevo==null) {
            throw new ParamErrException(
                    "LinkedStruct: <refer> y <nuevo>, con null");
        }

        LinearNode<T> current, previous= null, anteprevious= null;
        boolean insert= false;
        int i = 1;

        if( !isEmpty() ) {
            //Recorre la estructura mientras haya nodos y no se encuentre refer.
            i= 1;
            current= front;    //Inicio de la estructura.
            while( i<=size() && !insert ) {
                if (current.getElement().equals(refer)) {
                    insert= true;     //Lo encontro y puede haber insercion.
                } else {    //Avanza al siguiente nodo.
                    anteprevious= previous;
                    previous= current;
                    current= current.getNext();
                    i++;
                }
            }
            LinearNode<T> nodoNuevo =
                    new LinearNode(nuevo);  // Nuevo nodo y elemento
            if( insert ) {   // insert=true, refer encontrado
                if( i == 1 ) {
                    //Caso 3: el refer esta en pos 1 y se puede insertar nuevo
                    nodoNuevo.setNext(front);
                    front = nodoNuevo;
                } else {    // pos > 1
                    // Caso 4: refer en una pos >= 2 y pos<=size(): inserta.
                    anteprevious = previous;
                    previous = nodoNuevo;
                    anteprevious.setNext(previous);
                    previous.setNext(current);
                }
                count++;
            }    // else, Caso 2: el refer no esta, insert : false.
        }    // else, Caso 1: regresa insert : false
        return insert;
    }

    /** Problema 43: elimina todos los elementos repetidos de una
     * LinkedStruct, dejando una ocurrencia de cada elemento.
     * Regresa como resultado el total de elementos eliminados.
     * Los elementos de LinkedStruct estan ORDENADOS, por lo tanto
     * los repetidos ocupan posiciones consecutivas.
     */
    public int eliminaTodosRepetidosOrdenado() {

        LinearNode<T> current, previous= null;
        int totelim = 0, pos = 1;
        T aux = null;

        /*
        El siguiente codigo es muy ineficiente, por el uso de
        get() y remove(), cada vez, recorriendo toda la estructura.
        while( pos <= size() ) {    //Recorre la estructura.
            aux= get(pos);         //Obtiene el primero "distinto".
            pos++;              //Para obtener el siguiente.
            while( pos <= size() && aux.equals( get(pos) ) ) {
                remove(pos);     //Elimina los que son iguales.
                totelim++;
            }
        }*/
        current = front;    // El primero nunca sera eliminado
        while( current != null) {    //Recorre la estructura.
            aux = current.getElement();
            previous = current;
            current = current.getNext();    //Obtiene el primero "distinto".
            while( current != null && aux.equals( current.getElement() )) {
                current = current.getNext();    //Elimina los que son iguales.
                previous.setNext( current );
                totelim++;
                count--;
            }
        }

        return totelim;
    }

    /** Problema 44: elimina todos los elementos repetidos de una
     * LinkedStruct, dejando una ocurrencia de cada elemento.
     * Regresa como resultado el total de elementos eliminados.
     * Los elementos de LinkedStruct estan DESORDENADOS, por lo tanto
     * los repetidos pueden estar en cualquier lugar del LinkedStruct.
     */
    public int eliminaTodosRepetidosDesordenado() {

        LinearNode<T> current, previous= null, previous1 = null;
        int totelim = 0, pos = 1;
        T aux = null;

        current = front;    // El primero nunca sera eliminado
        while( current != null) {    //Recorre la estructura.
            aux = current.getElement();
            previous = current;
            previous1 = previous;
            current = current.getNext();    //Obtiene el siguiente.
            while( current != null ) {
                if( aux.equals( current.getElement() ) ) {
                    current = current.getNext();    //Elimina el que es igual.
                    previous1.setNext( current );
                    totelim++;
                    count--;
                } else {
                    previous1 = current;    // Avanza
                    current = current.getNext();
                }
            }
            current = previous.getNext();
        }

        return totelim;
    }

    /** Problema 45:
     * Escribe un metodo en la clase LinkedStruct (LS) que reciba como parámetro
     * un objeto LS (otraLS) de la misma clase <T> de los elementos de LS (this).
     * Este metodo modificara la LS (this), mezclando sus nodos con los de otraLS.
     * A this se le deberá intercalar (insertar) un nodo de otraLS entre cada par
     * de sus nodos. Es decir, en el this, al final quedara: 1er nodo de this,
     * 1er nodo de otraLS, 2do nodo de this, 2do nodo de otraLS, etc.
     * Si tienen diferente cantidad de nodos, al final quedaran los nodos de
     * LS mas larga.
     * SE DEBEN USAR LOS NODOS DE AMBAS LS, this Y otraLS, NO SOLO LAS INFORMACIONES
     * QUE ALMACENAN.
     * Una vez ejecutado este metodo, ¿en qué estado quedan las dos LS involucradas?
     * El metodo regresara el total de nodos resultantes de la mezcla.
     */
    public int mezclaNodos(LinkedStruct otraLS) throws ParamErrException {
        if( otraLS==null || this.isEmpty() || otraLS.isEmpty() ) {
            throw new ParamErrException(
                    "LinkedStruct: <otraLS> con null, alguna LS vacia");
        }
        int tnod, tamthis, tamotra;
        tamthis = this.size();    // size() varia
        tamotra = otraLS.size();
        tnod = tamthis + tamotra;
        // Hay al menos un nodo en cada una de las dos LS
        LinearNode<T> currthis, currotra, sigthis, sigotra,
                antethis=null;
        currthis = front;
        currotra = otraLS.front;    // por ser de la misma clase

        // Parte en que ambas LS tienen la misma cantidad de nodos-elementos
        int pteidem = Math.min(tamthis, tamotra);
        for (int i = 1; i<=pteidem; i++) {
            sigthis = currthis.getNext();
            sigotra = currotra.getNext();
            currthis.setNext(currotra);    // Insertando en this, de otraLS
            antethis = currotra;    // Recordando el anterior nodo de this
            currotra.setNext(sigthis);    // Completando la insercion
            currthis = sigthis;
            currotra = sigotra;
            this.count++;    // Incrementa el this.size()
            otraLS.count--;    // Decrementa el otraLS.size()
        }

        // Pueden ser de diferente size()
        if( tamthis <  tamotra ) {
            antethis.setNext(currotra);    // Agregando nodo de otraLS, a this
            this.count = this.count + (tamotra-tamthis);
            otraLS.count = otraLS.count - (tamotra-tamthis);
        }    // else: tamthis >  tamotra: nada mas que hacer
        otraLS.front = null;    // Dejando otraLS vacia.

        return tnod;
    }

    public LinearNode<T> getFront(){
      return front;
    }//method


}
