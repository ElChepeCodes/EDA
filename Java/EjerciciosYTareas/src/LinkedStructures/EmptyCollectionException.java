package LinkedStructures;

public class EmptyCollectionException extends RuntimeException{
	/**
     * This exception goes with a constant message.
     */
    public EmptyCollectionException(){
        super("EmptyCollectionException: the collection is EMPTY.\n");
    }

}//class
