/*
 * Use of SET collections.
 * Exercises: 30
 */
package Sets;

/**
 * @author EDg1
 * Exercises: 30
 */
public class ArraySetUseRvMain {
    public static void main(String[] args) {
        //Ejercicios simples del uso de las operaciones del conjunto.
        ArraySet<Integer> c1= new ArraySet<Integer>(15);
        ArraySet<Integer> c2= new ArraySet<Integer>(15);
        ArraySet<Integer> c3= new ArraySet<Integer>(15);
        ArraySet<Integer> c4= new ArraySet<Integer>(30);
        ArraySet<Integer> c5= new ArraySet<Integer>(30);
        ArraySet<Integer> c6= new ArraySet<Integer>(30);
        
        //Agrega elementos al conjunto.
        c1.add(70);   c1.add(70);   c1.add(-40);   c1.add(30);
        System.out.println("T1--c1\n" + c1.toString());

        c1.add(-50);   c1.add(-40);   c1.add(60);
        System.out.println("T2--c1\n" + c1.toString());

        System.out.println("T3-- c2: "+c2.toString() + "\n");

        //Prueba de addAll.
        c2.add(200);   c2.add(-300);   c2.add(30);   c2.add(-50); 
        c1.addAll(c2);
        System.out.println("T8.1-- c2: "+c2.toString() + "\n");
        System.out.println("T8.2-- c1 después addAll: "+c1.toString());
        
        //Prueba de contains
        System.out.println("T9.1-- ContainsRv c2,30: " + c2.containsRv(30) + "\n");
        System.out.println("T9.2-- ContainsRv c2,201: " + c2.containsRv(201) + "\n");

        //Prueba de union.
        c3.add(440);   c3.add(800);    c3.add(60);    c3.add(-40);
        System.out.println("T10.1-- c1: "+c1.toString());
        System.out.println("T10.2-- c3: "+c3.toString());
        c4 = (ArraySet) c1.unionRv(c3);
        System.out.println("T10.3-- UnionRv de c1 y c3, en c4: " + c4.toString());

        //Prueba de intersección.
        c5 = (ArraySet) c1.intersectionRv(c3);
        System.out.println("T11-- InterseccionRv de c1 y c3, en c5: " +
                c5.toString());
  
        //Prueba de diferencia.
        c6 = (ArraySet) c1.differenceRv(c3);
        System.out.println("T12-- DiferenciaRv c1 - c3, en c6: " + c6.toString());

        c6 = (ArraySet) c3.differenceRv(c1);
        System.out.println("T13-- DiferenciaRv c3 - c1, en c6: " + c6.toString());
    }
    
}
