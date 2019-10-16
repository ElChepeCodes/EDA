
package Sets;

public class EmptyCollectionException  extends RuntimeException {
  /**
   * Sets up this exception with an appropriate message.
   */
    public EmptyCollectionException(){
        super("EmptyCollectionException: the collection is EMPTY.\n");
    }
    
    public EmptyCollectionException (String collection)
    {
        super ("EmptyCollectionException: the " + collection +
                " is EMPTY.");
    }
}
