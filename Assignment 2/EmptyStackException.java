/**
 * The empty stack exception class
 * @author Germain Asaba
 *
 */
@SuppressWarnings("serial")
public class EmptyStackException extends Exception {
	
	/**
	 * Default constructor
	 */
	public EmptyStackException() {

		super ("Stack is empty");

	}

	/**
	 * Parameterized constructor
	 * @param message The message if the stack is empty
	 */
	public EmptyStackException(String message) {

		super (message);
	}

}
