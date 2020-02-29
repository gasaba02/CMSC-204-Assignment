/**
 * The max size stack exception class
 * @author Germain Asaba
 *
 */
@SuppressWarnings("serial")
public class MaxSizeStackException extends RuntimeException{

	/** 
	 * Default constructor
	 */
	public MaxSizeStackException() {

		super ("Stack is full");

	}


	/**
	 * Parameterized constructor
	 * @param message message if stack is full
	 */
	public MaxSizeStackException(String message) {

		super (message);
	}

}
