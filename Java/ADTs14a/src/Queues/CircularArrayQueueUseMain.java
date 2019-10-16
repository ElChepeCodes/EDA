package Queues;

/**
 * Ejemplos de uso de Colas de Arreglos Circulares
 * @author EDg1
 */
public class CircularArrayQueueUseMain {

    /**
     * Ejercicios simples de colas CircularArrayQueue
     */
    public static void main(String[] args) {
        CircularArrayQueue<Integer> colaI = new CircularArrayQueue(4);
        
        // Guardando en colaI {10,20,30}
        colaI.enqueue(10);    colaI.enqueue(20);    colaI.enqueue(30);
        System.out.println("A)- Primer elemento: " + colaI.first());
        System.out.println("B)- ¿Cola vacía? " + colaI.isEmpty());
        System.out.println("C)- Cantidad de elementos: " + colaI.size());
        System.out.println("D- Cola completa: \n  " + colaI.toString());

        System.out.println("E)- Valor retirado: " + colaI.dequeue());
        System.out.println("F)- Valor retirado: " + colaI.dequeue());
        System.out.println("G)- Cola completa: \n  " + colaI.toString());
    
        colaI.enqueue(40);    colaI.enqueue(50);
        colaI.enqueue(60);    colaI.enqueue(70);
        System.out.println("H)- Cola completa: \n  " + colaI.toString());

        System.out.println("I)- Vaciado de elementos de colaI:");
        while (!colaI.isEmpty()) {
            System.out.println("    J)- Valor retirado: " + colaI.dequeue());            
        }
        System.out.println("\nK)- Cola completa: \n  " + colaI.toString());
    
        try {
            System.out.println("\nL)- Valor: " + colaI.dequeue());    //Error.
        }
        catch (Exception e) {
            System.out.println("M)-" + e.getMessage() + "\n");
        }
    }
    
}
