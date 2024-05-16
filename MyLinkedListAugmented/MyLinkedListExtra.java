
public class MyLinkedListExtra<E> extends MyLinkedList<E> {

	  @Override /** Return true if this list contains the element e */
	  public boolean contains(Object e) {
		  Node<E> current = head;
		  	for (int i = 0; i < size; i++) {
		  		if (current.element.equals(e))
		  			return true;
	    	current = current.next;
	    }
	    return false;
	  }

	  @Override /** Return the element at the specified index */
	  public E get(int index) {
		  Node<E> current = head;
		    for (int i = 0; i < size; i++) {
		      if (i == index)
		        return current.element;
		      current = current.next;
		    }
		    return null;
	  }

	  @Override /** Return the index of the first matching element in 
	   *  this list. Return -1 if no match. */
	  public int indexOf(Object e) {
		  Node<E> current = head;
		    for (int i = 0; i < size; i++) {
		      if (current.element.equals(e))
		        return i;
		      current = current.next;
		    }
		    return -1;
	  }

	  @Override /** Return the index of the last matching element in 
	   *  this list. Return -1 if no match. */
	  public int lastIndexOf(E e) {
		  Node<E> current = head;
		    int lastIndex = -1;
		    for (int i = 0; i < size; i++) {
		      if (current.element.equals(e))
		        lastIndex = i;
		      current = current.next;
		    }
		    return lastIndex;
	  }

	  @Override /** Replace the element at the specified position 
	   *  in this list with the specified element. */
	  public E set(int index, E e) {
		  Node<E> current = head;
		    E oldValue = null;
		    for (int i = 0; i < size; i++) {
		      if (i == index) {
		        oldValue = current.element;
		        current.element = e;
		        break;
		      }
		      current = current.next;
		    }
		    return oldValue;
	  }
	
}
