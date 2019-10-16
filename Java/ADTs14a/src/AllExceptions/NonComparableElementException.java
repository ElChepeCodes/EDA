
package AllExceptions;

/**
 * NonComparableElementException  represents the situation in which an attempt 
 * is made to add an element that is not comparable to an ordered collection
 */
public class NonComparableElementException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * This exception goes with a constant message.
     */
    public NonComparableElementException() {
        super("NCompEx: the collection is EMPTY.\n");
    }

    /**
     * Sets up this exception with an appropriate message.
     */
    public NonComparableElementException (String collection) {
        super ("The " + collection + " requires comparable elements.");
    }
    
}
