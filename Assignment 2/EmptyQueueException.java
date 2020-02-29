/**
 * The empty queue exception class
 * @author Germain Asaba
 *
 */
@SuppressWarnings("serial")
public class EmptyQueueException extends Exception {
	
	/**
	 * Default constructor
	 */
	public EmptyQueueException() {
		
		super ("Queue is empty");
	}
	
	/**
	 * Parameterized constructor
	 * @param message The message if queue is empty
	 */
	public EmptyQueueException(String message) {
		
		super(message);
	}

}
