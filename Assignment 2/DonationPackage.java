
/**
 * The Donation package class
 * @author Germain Asaba
 *
 */
public class DonationPackage {
	
	private double weight;
	private String description;
	
	
	/**
	 * Parameterized constructor
	 * @param description The description of the package
	 * @param pWeight The weight of the package
	 */
	public DonationPackage( String description, double pWeight) {
		
		this.weight = pWeight;
		this.description = description;
		
	}

	/**
	 * This method gets the weight of the package
	 * @return The weight of the package
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Sets the weight of the package
	 * @param weight The weight of the package
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * Gets the description of the package
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the package
	 * @param description the package description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Determines if the package is heavy
	 * @return true or false
	 */
	public boolean isHeavy() {
		if(weight > 201 ) {
			return true;
		}else
				return false;
	}
	
	/**
	 * The to string method which returns the description
	 */
	@Override
	public String toString() {
		return description;
	}
	
	
	
	

}
