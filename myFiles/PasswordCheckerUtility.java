
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This program checks is a password is valid
 * 
 * @author Germain Asaba
 *
 */
public class PasswordCheckerUtility {


	/**
	 * Default constructor
	 */
	public PasswordCheckerUtility () {}

	
	/**
	 * Checks the length of the password
	 * @param password
	 * @return
	 * @throws LengthException
	 */
	private static boolean lengthCheck (String password) throws LengthException {

		int lengthOfChar = 6;
		if (password.length() >= lengthOfChar) {
			return true;
		}
		throw new LengthException();
	}
	
	
	/**
	 * Checks if the password has a digit
	 * @param password
	 * @return
	 */
	private static boolean hasDigit(String password) {
		for (int i = 0; i < password.length(); i++) {
			if ( Character.isDigit(password.charAt(i)) ) {
				return true;
			}
		}
		throw new NoDigitException();
	}

	
	/**
	 * checks if the password has and upper case letter
	 * @param password
	 * @return
	 * @throws NoUpperAlphaException
	 */
	private static boolean hasUpperCase(String password) throws NoUpperAlphaException {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	
	
	/**
	 * Checks if the password has a lower case letter
	 * @param password
	 * @return
	 * @throws NoLowerAlphaException
	 */
	private static boolean hasLowercase(String password) throws NoLowerAlphaException{
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				return true;
			}
		}
		throw new NoLowerAlphaException();

	}
	
	
	/**
	 * Checks of the password has more than 2 of the same characters in a sequence
	 * @param password
	 * @return
	 * @throws InvalidSequenceException
	 */
	private static boolean sequentialCharCheck(String password) throws InvalidSequenceException{
		for (int i = 0; i < password.length()-2; i++) {
			char currentChar = password.charAt(i);
			char nextChar = password.charAt(i+1);
			char thirdChar = password.charAt(i+2);
			if ((currentChar  ==  nextChar) && (currentChar  ==  thirdChar)) {
				throw new InvalidSequenceException();
			}
		}

		return false;
	}
	
	/**
	 * Checks if the password meets the requirements to be a valid password
	 * @param passwordString
	 * @return
	 * @throws LengthException
	 * @throws NoDigitException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoLowerAlphaException
	 */
	public static boolean isValidPassword(String passwordString) throws LengthException,
	NoDigitException, NoUpperAlphaException, NoLowerAlphaException, NoLowerAlphaException {
		
		boolean hasDigit = hasDigit(passwordString);
		boolean sequentialCharCheck = sequentialCharCheck(passwordString);
		boolean lengthCheck = lengthCheck(passwordString);
		boolean hasLowerCase = hasLowercase(passwordString);
		boolean hasUpperCase = hasUpperCase(passwordString);

		if ( lengthCheck && hasDigit && hasLowerCase && hasUpperCase && !sequentialCharCheck) {
			return true;
		}
		return false;


	}

	
	/**
	 * Checks if the password is weak
	 * @param passwordString
	 * @return Returns true if it's weak and false if it isnt
	 */
	public static boolean isWeakPassword(String passwordString) {
		int lowerLength = 6;
		int upperLength = 9;

		if (passwordString.length() >= lowerLength && passwordString.length() <= upperLength ) {

			return true;
		}
		else
		return false;
	}


	
	/**
	 * This method checks an Array list of passwords and returns the invalid ones
	 * @param passwords The Array list to be checked
	 * @return returns an Array list with invalid passwords
	 * @throws FileNotFoundException
	 */
	public static ArrayList<String> invalidPassword(ArrayList<String> passwords) throws FileNotFoundException{

		ArrayList<String> invalidPass = new ArrayList<String>();

		boolean result = true;


		try {
		BufferedReader bufReader = new BufferedReader(new FileReader("../passwords.txt"));
		String word = bufReader.readLine();
		while(word != null) {
			passwords.add(word);
			word = bufReader.readLine();
		}}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	
		for(String pass: passwords) {

			try {
				result = isValidPassword(pass);
			}
			catch (Exception e) {
				String message = e.getMessage();
				String r = pass + " " + message;
				invalidPass.add(r);
			}

		}


		return invalidPass;
	}


}
