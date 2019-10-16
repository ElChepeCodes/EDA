package LinkedStructures;

public class ElementNotFoundException extends RuntimeException{
    public ElementNotFoundException(){
        super("ElementNotFoundException: "+ "element is not in this collection\n");
    }
}//class
