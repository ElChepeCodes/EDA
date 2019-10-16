package Queues;

public class ElementNotFoundException extends RuntimeException {
    /**
     * This exception goes with a constant message.
     */
    public ElementNotFoundException(){
        super("ElementNotFoundException: " +
                "element is not in this collection\n");
    }
    
    /**
     * Sets up this exception with an appropriate message.
     */
    public ElementNotFoundException(String collection) {
        super("ElementNotFoundException: " +
                "element is not in this " +  collection + "\n");
    }
}
