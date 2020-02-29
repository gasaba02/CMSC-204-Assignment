
import java.util.Arrays;

/**
 * My Stack class
 * @author Germain Asaba
 *
 * @param <T>
 */
public class MyStack <T> implements StackInterface<T>{

	private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	private int size = 0;

	/**
	 * Default constructor
	 */
	public MyStack()
	{
		this(DEFAULT_CAPACITY);
	} 

	/**
	 * Parameterized constructor
	 * @param initialCapacity the initial capacity
	 */
	public MyStack(int initialCapacity)
	{
		integrityOK = false;
		checkCapacity(initialCapacity);		
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		integrityOK = true;
	} 

	/**
	 * Checks the capacity
	 * @param capacity the capacity to be checked
	 * @return true if the capacity fine or false otherwise
	 */
	private boolean checkCapacity(int capacity) {
		if (capacity < MAX_CAPACITY) {
			return true;
		}
		else 
			throw new MaxSizeStackException();
	}

	private void ensureCapacity()
	{
		if (topIndex >= stack.length - 1) 
		{
			int newLength = 2 * stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack, newLength);
		} 
	} 


	/**
	 * Checks if the stack is empty
	 * @return true if empty and false if not
	 */
	@Override
	public boolean isEmpty() {
		if(topIndex == -1) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if stack is full
	 * @return true if full or false otherwise
	 */
	@Override
	public boolean isFull() {
		if(stack.length == size ) {
			return true;
		}
		return false;
	}

	/**
	 * This method removes elements from the stack
	 * @throws EmptyStackException if the stack is empty
	 * returns true if element was removed or false otherwise
	 */
	@Override
	public T pop() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			size --;
			return top;
		}


	}

	/**
	 * This method gets the size of the stack
	 * @return the size of the stack
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * This method removes elements from the stack
	 * @return true if the element was removed and false otherwise
	 */
	@Override
	public boolean push(T e) {
		//	ensureCapacity();
		if (isFull()) 
			throw new MaxSizeStackException();
		else {
			stack[topIndex + 1] = e;
			topIndex++;
			size++;
			return integrityOK;
		}

	}

	/**
	 * This method returns an array with all the elements.
	 */
	@Override
	public T[] toArray() {
		
	
		return stack;
	}

}
