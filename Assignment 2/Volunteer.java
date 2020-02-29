/**
 * The volunteer class
 * @author Germain Asaba
 *
 */
public class Volunteer {
	private String name;
	
	/**
	 * The parameterized constructor
	 * @param name
	 */
	public Volunteer(String name) {
		
		this.name = name;
	}

	/**
	 * Gets the name of the volunteer
	 * @return the name of the volunteer
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the volunteer
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method returns the name of the volunteer
	 * @return the name of the volunteer
	 */
	@Override
	public String toString() {
		return name;
	}
	
	

}
