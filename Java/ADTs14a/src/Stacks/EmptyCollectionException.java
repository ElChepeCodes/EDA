/**
 *  Represents the situation in which the collection is empty.
 */

package Stacks;

public class EmptyCollectionException  extends RuntimeException {
    /** Sets up this exception with an appropriate message.
     */
    public EmptyCollectionException (String collection) {
        super ("The " + collection + " is EMPTY.\n");
  }
}
