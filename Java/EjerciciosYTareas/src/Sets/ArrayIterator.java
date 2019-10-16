/**
 * ArrayIterator represents an iterator over the elements of an array.
 */

package Sets;
import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
  private int count;    // the number of elements in the collection
  private int currPos;  // the current position in the iteration
  private T[] items;    // elements
  
  /**
   * Sets up this iterator using the specified items.
   */
  public ArrayIterator (T[] collection, int size) {
    items = collection;
    count = size;
    currPos = 0;
  }
  
  /**
   * Returns true if this iterator has at least one more element
   * to deliver in the iteration.
   */
  public boolean hasNext() {
    return (currPos < count);
  }
  
  /**
   * Returns the next element in the iteration. If there are no
   * more elements in this iteration, a NoSuchElementException is
   * thrown.
   */
  public T next() {
    T result= null;
    
    if (!hasNext())
      throw new ElementNotFoundException("Set");
    
    result= items[currPos];
    currPos++;

    return result;
  }
  
  /**
   * The remove operation is not supported in this collection.
   */
  public void remove() throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }
}
