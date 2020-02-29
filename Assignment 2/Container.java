/**
 * The container class
 * @author Germain Asaba
 *
 */
public class Container implements ContainerInterface {

	private MyStack<DonationPackage> stack;

	/**
	 * Parameterized constructor
	 * @param size The size of the container
	 */
	public Container(int size) {
		stack = new MyStack<DonationPackage>(size);
	}

	/**
	 * Default constructor
	 */
	public Container() {

		stack = new MyStack<DonationPackage>();

	}

	/**
	 * Loads a package in the container
	 * @param dPackage the loaded package
	 * @throws ContainerException if the container is full
	 */
	@Override
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
		try { 
			return stack.push(dPackage);
		}catch(MaxSizeStackException e) {
			throw new ContainerException();
		}
	}

	/**
	 * Removes a package in a container
	 * 
	 */
	@Override
	public DonationPackage removePackageFromContainer() throws ContainerException {

		try {
			return stack.pop();
		} catch (EmptyStackException e) {

			throw new ContainerException();
		}

	}

	/**
	 * An array that has all the packages
	 * @return An Array with all packages
	 */
	@Override
	public DonationPackage[] toArrayPackage() {

		Object[] tempObjArr = new Object[stack.size()];
		DonationPackage tempDonationPackageArr[] = new DonationPackage[stack.size()];

		tempObjArr = stack.toArray();

		for(int i = 0; i < stack.size(); i++) {
			tempDonationPackageArr[i] = (DonationPackage)tempObjArr[i];

		}


		return tempDonationPackageArr;
	}

}
