/**
 * The volunteer line class
 * @author Germain Asaba
 *
 */
public class VolunteerLine implements VolunteerLineInterface {

	private MyQueue<Volunteer> queue;
	

	/**
	 * The parameterized Constructor
	 * @param size the size of the volunteer line
	 */
	public VolunteerLine(int size) {
		queue = new MyQueue<Volunteer>(size);

	}

	/** 
	 * Default constructor
	 */
	public VolunteerLine() {
		queue = new MyQueue<Volunteer>();
	}


	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Queue is full") is queue is full
	 * @throws QueueIsFullException 
	 */
	@Override
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException{
		try {
			return queue.enqueue(v);
		} catch (QueueIsFullException e) {

			e.getMessage();
		
		}
		return false;
	}

	/**
	 * removes volunteer from the volunteer queue line
	 * @return Volunteer Object
	 * @throws VolunteerException("Volunteer queue is empty") if queue is empty
	 * @throws RecipientException 
	 */
	@Override
	public Volunteer volunteerTurn() throws VolunteerException, RecipientException {
		Volunteer v;
		try {
			v = queue.dequeue();

			
			//queue.enqueue(v);
			
			return v;
		} catch (VolunteerException e) {
			e.getMessage();
		} 
		return null;
	}

	/**
	 * checks if there are volunteers in line 
	 * @return true if volunteer line is empty, true otherwise
	 */
	@Override
	public boolean volunteerLineEmpty() {
		return queue.isEmpty();
	}

	/**
	 *  Returns an array of the Volunteers in the queue.
	 *  @return an array of the Volunteers in the queue
	 */
	@Override
	public Volunteer[] toArrayVolunteer() {
		Object [] tempObjArr = new Object[queue.size()];
		Volunteer [] tempVolunteerArr = new Volunteer[queue.getBackIndex() - queue.getFrontIndex() ];

		tempObjArr = queue.toArray();
		
		

		for (int i = 0; i < tempVolunteerArr.length; i++) {

			tempVolunteerArr[i] = (Volunteer)tempObjArr[queue.getFrontIndex() +i];

		}


		return tempVolunteerArr;
	}

	


}
