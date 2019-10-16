package LinkedStructures;

public class EmptyCollectionException  extends RuntimeException {
    /**
     * This exception goes with a constant message.
     */
    public EmptyCollectionException(){
        super("EmptyCollectionException: the collection is EMPTY.\n");
    }
    
    /**
     * Sets up this exception with an appropriate message.
     */
    public EmptyCollectionException (String collection)
    {
        super ("EmptyCollectionException: the " + collection +
                " is EMPTY.");
    }
}
