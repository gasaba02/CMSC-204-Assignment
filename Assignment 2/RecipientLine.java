/**
 * The recipient line class
 * @author Germain Asaba
 *
 */
public class RecipientLine implements RecipientLineInterface {

	private MyQueue<Recipient> queue;


	/**
	 * Parameterized constructor
	 * @param size the size of the recipient line
	 */
	public RecipientLine(int size) {
		queue = new MyQueue<Recipient>(size);

	}

	/**
	 * Default constructor
	 */
	public RecipientLine() {
		queue = new MyQueue<Recipient>();

	}

	/**
	 * Enqueue a new Recipient to the queue of the Recipients in the Recipient line
	 * @param rc a Recipient
	 *return true if recipient is queued successfully
	 * @throws RecipientException if queue is full
	 */
	@Override
	public boolean addNewRecipient(Recipient rc) throws RecipientException {

		try {
			return queue.enqueue(rc);
		} catch (QueueIsFullException e) {
			throw new RecipientException();

		}

	}

	/**
	 * When it is the recipient turn, recipient will be dequeued from the recipient line
	 * @return a Recipient object
	 * @throws RecipientException if there is no Recipient in the line
	 */
	@Override
	public Recipient recipientTurn() throws RecipientException {


		return queue.dequeue();
	}

	/**
	 * checks if Recipient  queue line is empty
	 * @return true if queue is empty, false otherwise
	 */
	@Override
	public boolean recipientLineEmpty() {

		return queue.isEmpty();
	}

	/**
	 *  Returns an array of the Recipients in the queue.
	 *  @return an array of the Recipients in the queue
	 */
	@Override
	public Recipient[] toArrayRecipient() {

		
		Object [] tempObjArr = new Object[queue.size()];
		Recipient [] tempRecipientArr = new Recipient[queue.getBackIndex() - queue.getFrontIndex() ];

		tempObjArr = queue.toArray();
		
		

		for (int i = 0; i < tempRecipientArr.length; i++) {

			tempRecipientArr[i] = (Recipient)tempObjArr[queue.getFrontIndex() +i];

		}


		return tempRecipientArr;
	}

}
