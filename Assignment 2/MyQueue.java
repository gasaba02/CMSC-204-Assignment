/**
 * The Queue class
 * @author Germain Asaba
 *
 * @param <T> generic data type
 */
public class MyQueue<T> implements QueueInterface<T> {

	private T[] queue;
	private int backIndex;
	private int frontIndex;
	private static final int DEFAULT_SIZE = 10;
	private int capacity;
	private int size; // to keep track of the elements in the queue

	/**
	 * Default Constructor
	 */
	@SuppressWarnings("unchecked")
	public MyQueue() {

		this(DEFAULT_SIZE);
		queue = (T[]) new Object[DEFAULT_SIZE];
	}

	/**
	 * Parameterized Contructor
	 * @param size The size of the queue
	 */
	@SuppressWarnings("unchecked")
	public MyQueue(int size) {
		
		this.capacity = size;
		frontIndex = this.capacity = 0;
		backIndex = 0;
		queue = (T[]) new Object[size];

	}




	public int getFrontIndex() {
		return frontIndex;
	}

	public int getBackIndex() {
		return backIndex;
	}

	/**
	 * The methods is used to check if the queue is empty
	 * @return returns true if empty and false otherwise
	 */
	@Override
	public boolean isEmpty() {
		if(this.size == 0)
			return true;
		return false;
	}

	/**
	 * The methods is used to check if the queue is full
	 * @return returns true if full and false otherwise
	 */
	@Override
	public boolean isFull() {
		if(size == queue.length)
			return true;
		return false;
	}

	/**
	 * This method removes from the queue
	 * @throws RecipientException if the is no recipient
	 * @throws VolunteerException if there is no volunteer
	 */
	@Override
	public T dequeue() throws RecipientException, VolunteerException {
	
		
		if(isEmpty()){
			throw new RecipientException();
		}
		else {
			T item = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex++;
			size--;
			return item;
		}
		
	}

	/**
	 * the size of the queue
	 * @return the size of the queue
	 */
	@Override
	public int size() {
		return size ;
	}

	/**
	 * This method adds to the queue
	 * @throws QueueIsFullException if the que is full
	 */
	@Override
	public boolean enqueue(T e) throws VolunteerException, QueueIsFullException {
		if (size() == 0) {
			queue[backIndex] = e;
			backIndex++;
			size++;
			return true;
		}

		else if (backIndex == queue.length ) {
			if (queue[0] != null ) 
				throw new QueueIsFullException();
			else if (this.isFull() != true){
				backIndex = 0;
				queue[backIndex] = e;
				backIndex++;
				size++;
				return true;
			}
		}
		else if (this.isFull() == true) 
			throw new QueueIsFullException();
		else {

			queue[backIndex] = e;
			backIndex++;
			size++;
			return true;
		}


		return false;
	}

	/**
	 * Returns the elements of the Queue in an array
	 * @return an array of the Object elements in the Queue
	 */
	@Override
	public T[] toArray() {
		return queue;
	}
}

