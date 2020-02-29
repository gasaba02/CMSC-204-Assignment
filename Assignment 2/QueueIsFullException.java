/**
 * The Queue is full Exception class
 * @author Germain Asaba
 *
 */
@SuppressWarnings("serial")
public class QueueIsFullException extends Exception {


	/**
	 * Default constructor
	 */
	public QueueIsFullException(){
		super("Queue is full");
	}
	
	/**
	 * Parameterized constructor
	 * @param message the message if the queue is full
	 */
	public QueueIsFullException(String message) {
		
		super (message);
	}
	
}
