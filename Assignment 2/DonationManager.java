/**
 * The donation manager class
 * @author Germain Asaba
 *
 */
public class DonationManager implements DonationManageInterface {
	
	private Container container;
	private VolunteerLine vl;
	private RecipientLine rl;
	private Volunteer v;
	private Recipient r;
	private DonationPackage pl;
	
	
	/**
	 * Default constructor
	 */
	public DonationManager() {
		container = new Container();
		vl = new VolunteerLine();
		
		rl = new RecipientLine();
		
	}
	
	

	/**
	 * Loads a new Donation package to the container
	 * @param  Donation package that is stacked to the container
	 * @throws ContainerException if the container is full
	 */
	@Override
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		return container.loadContainer(dPackage);
	}

	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException if the Volunteer Line queue is full
	 */
	@Override
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		
		try {
			return vl.addNewVolunteer(v);
		} catch (VolunteerException e) {
			
			e.getMessage();
		}
		return false;
	}

	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param r a Recipient
	 * @return true if recipient is queued successfully , false if queue is full
	 * @throws RecipientException if the Recipient line is full
	 */
	@Override
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		
		return rl.addNewRecipient(r);
	}

	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  volunteer line and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
	 * @throws VolunteerException if there are no volunteers
	 * @throws ContainerExcpetion if the container is empty
	 * @throws RecipientException if there are no recipients
	 * 
	 */
	@Override
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		
		pl = container.removePackageFromContainer();
		v = vl.volunteerTurn();
		
		try {
			vl.addNewVolunteer(v);
			
		} catch (VolunteerException e) {
			
			throw new VolunteerException();
		}
		r = rl.recipientTurn();
		
		
		return 0;
	}

	/**
	 * Returns an array of DonationPackages
	 * @return an array of Donation Packages
	 */
	@Override
	public DonationPackage[] managerArrayPackage() {
		
		return container.toArrayPackage();
	}

	/**
	 * Returns an array of Volunteers
	 * @return an array of Volunteers
	 */
	@Override
	public Volunteer[] managerArrayVolunteer() {
		
		return vl.toArrayVolunteer();
	}

	/**
	 * Returns an array of Recipients
	 * @return an array of Recipients
	 */
	@Override
	public Recipient[] managerArrayRecipient() {
		
		return rl.toArrayRecipient();
	}
	
	/**
	 * The to string method which returns a message
	 */
	@Override
	public String toString() {
		return v.getName() + " donated " + pl.getDescription() + " to " + r.getName();
	}



	
}
