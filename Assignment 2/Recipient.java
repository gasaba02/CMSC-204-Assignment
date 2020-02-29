/**
 * The Recipient class
 * @author Germain Asaba
 *
 */
public class Recipient {
	private String name;
	
	/**
	 * Parameterized Constructor
	 * @param name the name of the recipient
	 */
	public Recipient(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of the recipient
	 * @return returns the name 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the recipient
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method returns the name of the recipient
	 * @return the name of the recipient
	 */
	@Override
	public String toString() {
		return name;
	}
	
	

}
