package EjerciciosClase;

import Stacks.LnkStrStack;

public class Prueba1 {



  public static void main (String [] args){
    LnkStrStack<Integer> stack=new LnkStrStack<>();
    stack.push(1);stack.push(2);stack.push(3);stack.push(4);stack.push(5);stack.push(6);
    System.out.println("Original:\n");
    System.out.println(stack.toString());
    stack.volteaStack();
    System.out.println("Volteado:\n");
    System.out.println(stack.toString());
  }//main
}//class
