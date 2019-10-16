
package Sets;

public class ElementNotFoundException extends RuntimeException {
   /** Sets up this exception with an appropriate message.
    */
    public ElementNotFoundException(){
        super("ElementNotFoundException: " +
                "element is not in this collection\n");
    }
    
    public ElementNotFoundException(String collection) {
        super("ElementNotFoundException: " +
                "element is not in this " +  collection + "\n");
   }
}
