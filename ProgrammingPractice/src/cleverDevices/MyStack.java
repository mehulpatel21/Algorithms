package cleverDevices;
import java.util.Iterator;
/**
 * Generic Stack implementation using singly-linked list.
 * Each stack element is of type T.
 * 
 * @Description
 * Java program to implement Stack data structure supporting following operations
 * 1) Push: Adds a data element to the top of the stack
 * 2) Pop: Removes a data element from the top of the stack
 * 3) Size: Returns the total number of elements in the stack
 * 4) isEmpty: Returns true if the stack is empty
 * 5) (optional) Peek: Returns(not remove) most recently added element from the stack
 * 
 */
import java.util.NoSuchElementException;

/**
 * @author Mehul Patel
 * @Date 07/27/2017
 * @param <T>
 */

public class MyStack<T> implements Iterable<T> {
	/* Top of the stack */
    private Node<T> top; 
    /* Stack size*/
    private int n;
    
    /**
     *  Singly Linked List Node
     */
    private static class Node<T> {
        private T T;
        private Node<T> next;
    }

    /**
     * Initializes an empty stack.
     */
    public MyStack() {
        top = null;
        n = 0;
    }

    /**
     * @return true if stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * @return Number of elements in the stack
     */
    public int size() {
        return n;
    }

    /**
     * Adds the T to this stack.
     * @param T to add
     */
    public void push(T T) {
        Node<T> oldTop = top;
        top = new Node<T>();
        top.T = T;
        top.next = oldTop;
        n++;
    }

    /**
     * Removes and returns most recently added T to the stack.
     * @return the T most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        /* Saving T to return*/
        T T = top.T;
        /* Delete top node*/
        top = top.next;
        n--;
        return T;
    }

    // PEEK FUNCTION IS NOT IN THE REQUIREMENTS FOR THE TEST FROM CLEVER DEVICES
    /**
   
     * Returns (not remove) the T most recently added to this stack.
     * @return T most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return top.T;
    }
    /**
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>(top);
	}
	
	@SuppressWarnings("hiding")
	private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T T = current.T;
            current = current.next; 
            return T;
        }
    }

}