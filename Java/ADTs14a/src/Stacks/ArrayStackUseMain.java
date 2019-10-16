/*
 * Use of ArrayStack.
 */
package Stacks;

/**
 * @author EDg1
 */
public class ArrayStackUseMain {
    public static void main(String[] args) {
        // Crear ArrayStack para 10 enteros
        System.out.println(" ---- PRUEBA 1 ----");
        ArrayStack<Integer> stackInt;
        stackInt = new ArrayStack<Integer>(10);
        
        // Agregar 8 enteros al stack: 11, 12, 13, ... 18
        for(int i = 0; i < 8; i++) {
            stackInt.push(i+11);
        }
        System.out.println("stackInt\n" + stackInt.toString());
        
        // Sacar del stack de enteros un par de enteros, comprobando
        System.out.println(" ---- PRUEBA 2 ----");
        System.out.println("stackInt.pop\n" + stackInt.pop());
        System.out.println("stackInt.pop\n" + stackInt.pop());
        System.out.println("stackInt\n" + stackInt);
        
        // Crear ArrayStack para 20 chars
        System.out.println(" ---- PRUEBA 3 ----");
        ArrayStack<Character> stackChar;
        stackChar = new ArrayStack<Character>(20);
        char ch;
        // Sacar un elemento del stack de chars
        try {
            ch = stackChar.pop();    
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        
        // Agregar caracters al stack, obteniendolos de un String
        System.out.println(" ---- PRUEBA 4 ----");
        String str = "ABCdefghIJK";
        for(int i = 0; i < str.length(); i++) {
            stackChar.push( str.charAt(i) );
        }
        System.out.println("stackChar\n" + stackChar.toString());
        
        // ====================================
        
        // Crear un arreglo con 15 Strings, imprimir dicho contenido de Strings y
        // después invertir el contenido de los elementos del arreglo, de tal
        // manera que el primer String inicial quede como el ultimo.
        // Imprimir el estado final del arreglo.
        // Nos podra ayudar un ArrayStack de Strings?
        System.out.println("\n ---- PRUEBA 5 ----");
        // Solo asinaremos los primeros 6 Strings al arreglo
        String arrStr[] = {"uno", "dos", "tres", "cuatro", "cinco", "seis"};

        ArrayStack<String> stackString;
        stackString = new ArrayStack<String>(15);

        // Imprimir cada String del arreglo, y guardarlo en el ArrayStack
        for(int i = 0; i < arrStr.length; i++) {
            System.out.print( arrStr[i] + "  ");   // imprimen en la misma linea
            stackString.push(arrStr[i]);    // agregando el siguiente String al stack
        }
        System.out.println("\n");
        
        // Mostrando el contenido del ArrayStack de Strings
        System.out.println("\n ---- PRUEBA 6 ----");
        System.out.println("stackString\n" + stackString.toString() + "\n");
        
        // Crear ArrayStack para 15 Strings
        System.out.println(" ---- PRUEBA 7 ----");
        // Sacar cada String del ArrayStack, guardarlo en el arreglo, e imprimirlo
        for(int i = 0; i < arrStr.length; i++) {
            arrStr[i] = stackString.pop();    // saca del ArrayStack y guarda
            System.out.print( arrStr[i] + "  ");   // imprime en la misma linea
        }
        System.out.println("\n");        

    }    
}
