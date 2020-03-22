/**
This interface specifies the basic operations of any list-like object.
This interface contains a variation of the methods of the
standard java.util.List interface.
*/

package ArrayListLinkedList;

public interface MyList {
	/**
	   Adds an element at the end of the list.
	*/
	public void add(Object o);
	
	/**
	   Inserts an element at the specified index
	   Throws NoSuchElementException if index is out of bounds.
	*/
	public void insert(int index, Object o);
	
	/**
	   Removes the element at the specified index
	   Throws NoSuchElementException if index is out of bounds.
	*/
	public void remove(int index);
	
	/**
	   Returns the element at the specified index
	   Throws NoSuchElementException if index is out of bounds.
	*/
	public Object get(int index);
	
	/**
	   Returns the size of the list.
	   @return the number of elements in the list
	*/
	public int size();
	
	/**
	   Returns a list iterator for this list.
	   @return a list iterator for this list
	*/
	public MyListIterator getIterator();
}
