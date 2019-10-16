package EjerciciosClase;

import Lists.LinkedList;
import Lists.LinkedUnorderedList;

public class Prueba2 {
	public static void main(String [] args) {
		LinkedUnorderedList<Integer> lista=new LinkedUnorderedList();
		
		lista.addToFront(1);lista.addToFront(2);lista.addToFront(3);lista.addToFront(4);
		
		System.out.println("Original\n");
		System.out.println(lista.toString());
		System.out.println("Numero de elementos: "+lista.cuentaElementos());
		lista.eliminaElemento(2);
		System.out.println("Despues de eliminar el 2\n");
		System.out.println(lista.toString());
		lista.eliminaElemento(1);
		System.out.println("Despues de eliminar el 1\n");
		System.out.println(lista.toString());
		lista.eliminaElemento(1);
		System.out.println("Despues de tratar de eliminar el 1 otra vez\n");
		System.out.println(lista.toString());
	}//main
}//class
