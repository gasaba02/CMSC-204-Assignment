/**
 * The Recipient Exception class
 * @author Germain Asaba
 *
 */
@SuppressWarnings("serial")
public class RecipientException extends Exception {
	
	/** 
	 * Default constructor
	 */
	public RecipientException() {}
	
	/**
	 * Parameterized constuctor
	 * @param message the message if the recipient line is full
	 */
	public RecipientException(String message) {
		super(message);
	}

}
