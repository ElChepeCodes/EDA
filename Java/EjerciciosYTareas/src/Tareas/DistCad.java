package Tareas;

import Sets.LnkStrSet;

public class DistCad {
/*
    private int max;
    private MiLista <Character> list1, list2;
    private String st1, st2;

    public DistCad(){
        list1 = new MiLista();
        list2 = new MiLista();
    }//builder

    public int distancia(String s1, String s2){
        if (s1.equals(s2))
            return 0;
        if (s1.length() == 0 && s2.length() > 0)
            return s2.length();
        if (s2.length() == 0 && s1.length() > 0)
            return s2.length();    
        
        st1 = s1; st2 = s2;

        if (s1.length()>s2.length())
            max = s1.length();
        else
            max = s2.length();
            
        LnkStrSet <Character> car1 = new LnkStrSet(), car2 = new LnkStrSet();
        car1.toSet(s1.toCharArray()); car2.toSet(s1.toCharArray());
        MiLista <Character> l1 = toList(s1);
        MiLista <Character> l2 = toList(s2);
        list1 = l1; list2 = l2;
        return distancia(l1, l2, 0);
    }//method

    private int distancia(MiLista <Character> l1, MiLista <Character> l2, int num){
        if (num == max){

        }//if
    }//method

    private int [][] letrasIguales(){

    }//method

    private MiLista toList(String s){
        MiLista <Character> list = new MiLista();
        for (int i = 0; i < s.length(); i++)
            list.addToRear(s.charAt(i));
        return list;
    }//method

    public int edit(String st1, String st2, int cont, int max){
        
        if (st1.length() == 0 || st2.length() == 0)
            return cont + st1.length() + st2.length();
        if (cont >= max)
            return max;

        if (st1.charAt(0) == st2.charAt(0)){
            return edit(st1.substring(1), st2.substring(1), cont, max);            
        }//if

        int r1 = edit(st1.substring(1), st2.substring(2), cont+1, max);//sutituir
        int r2 = edit(st1.substring(1), st2, cont+1, max);//borrar
        int r3 = edit(st1, st2.substring(1), cont+1, max);

        if (r1<r2 && r1<r3)
            return r1;
        if (r2<r3 && r2<r1)
            return r2;
        return r3;
    }//method





    
    public static void main(String args[]){
        DistCad ej = new DistCad();
        System.out.println(ej.edit("hola","bola",0,4));
    }//main*/
}//class