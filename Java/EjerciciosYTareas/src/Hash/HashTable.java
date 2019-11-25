/*
 * Estructuras de datos
 * Autor: Jose Luis Gutierrez Espinosa
 */
package Hash;

/**
 *
 * @author jlgut
 */
public class HashTable <T>{
    //insertar
    //buscar
    //eliminar
    //hashFunction
    //
    HashNode<T>[] nodos;
    int siz;
    public HashTable(){
        nodos = new HashNode[10]; 
        siz = 10;
    }//builder
    public HashTable(int tam){
        nodos = new HashNode[tam];
        siz = tam;
    }//builder
    public int Hash(T dato){
        if (dato.toString() != null){
            String st = dato.toString();
            int hash = 13, size = st.length();
            for (int i = 0; i < size; i++){
                hash = (int) (hash * st.charAt(i) + Math.pow(st.charAt(i), i)/1);
            }//for
            return hash % siz;
        }//if
        else
        {
            return dato.hashCode() % siz;
        }//else
    }//method
    

    public static void main (String args []){
        HashTable<Integer> t = new HashTable();

    }//main
}//class
