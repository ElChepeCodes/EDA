package Tareas;

import Sets.LnkStrSet;

public class Permutaciones{
    String cadena;
    LnkStrSet<Character> set = new LnkStrSet();
    LnkStrSet<String> setSt = new LnkStrSet();

    public Permutaciones(){}//builder

    public String permutacionesString(String cad){
        if (cad.length() <= 1)
            return cad;
        cadena = cad;
        int i = 0, max;
        while(i < cad.length()){
            set.addR(cad.charAt(i));
            i++;
        }//while   
        max = calcMax(cad);
        setSt.add(cad);
        String temp;
        while (setSt.size() < max){
            temp = "";
            while(!set.isEmpty()){
                temp += set.removeRandom();
            }//while
            if (!setSt.contains(temp))
                setSt.add(temp);
            if (setSt.size() < max)
                rellenaSet();
        }//while
        return "Son "+max+ " permutaciones\n"+setSt.toString();
    }//method

    private void rellenaSet(){
        int i = 0;
        while(i<cadena.length()){
            set.addR(cadena.charAt(i));
            i++;
        }//while          
    }//method

    private int calcMax(String cad){
        int cont = 0, i = 0;
        char ch;
        char [] caracteres = cad.toCharArray();
        int [] numReps = new int [cad.length()];
        boolean [] cuenta = new boolean [cad.length()];
        LnkStrSet <Character> rep = new LnkStrSet();
        LnkStrSet <Character> temp = new LnkStrSet();

        for (int j = 0; j < numReps.length; j++){
            numReps[j] = 0;
            cuenta[j] = true;
        }//for

        for (int j = 0; j < numReps.length; j++){
            for (int k = 0; k < caracteres.length; k++){
                if (caracteres[k] == caracteres[j])
                    numReps[j]++;
            }//for
        }//for

        for (int j = 0; j < cuenta.length; j++){
            if (cuenta[j])
            for (int k = 0; k < caracteres.length; k++){
                if (caracteres[k] == caracteres[j] && j != k){
                    cuenta[k] = false;
                }//if
            }//for
        }//for


        
        while (!set.isEmpty()){
            ch = set.removeRandom();
            if (temp.contains(ch))
                cont++;
            temp.addR(ch);
        }//while
   
        while (!temp.isEmpty())
            set.addR(temp.removeRandom());

        int res=calcFact(cad.length());
        for(int j = 0; j < cuenta.length; j++){
            //System.out.println(numReps[j]+"\n"+cuenta[j]);
            if (cuenta[j]){
                
                res /= calcFact(numReps[j]);
            }//if
        }//for

        return res;
    }//method

    private int calcFact(int n){
        if (n<=1)
            return 1;
        return n*calcFact(n-1);
    }//method01

    public static void main (String args[]){
        Permutaciones p = new Permutaciones();
        System.out.println(p.permutacionesString("1234567"));
    }//main
}//class

