import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Germain Asaba
 *
 */
public class PasswordCheckerSTUDENT_Test {

	ArrayList<String> passwords;
	@Before
	public void setUp() throws Exception {
		
		passwords = new ArrayList<String>();
		passwords.add("5ACA3FGA");
		passwords.add("snoPPPy675");
		passwords.add("techgod4568");
		passwords.add("aacdueh");
		passwords.add("AAzeroUyH");
		
	}

	@After
	public void tearDown() throws Exception {
	
		passwords = null;
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("uwpDAW4"));
			PasswordCheckerUtility.isValidPassword("uwp4");
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
		
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("abzsdh123D"));
			PasswordCheckerUtility.isValidPassword("abzsdh123");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
		
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("THEBOYISFUN02a"));
			PasswordCheckerUtility.isValidPassword("THEBOYISFUN02");
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
		
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("Worldcu9"));
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("Worldcu9");
			assertTrue(weakPwd);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
		
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("ThePuPPY3"));
			PasswordCheckerUtility.isValidPassword("ThePuPPPY3");
			assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("WorldcupI9"));
			PasswordCheckerUtility.isValidPassword("WorldcupI");
			assertTrue("Did not throw NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Threw a NoDigitException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitException",false);
		}
		
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertEquals(true,PasswordCheckerUtility.isValidPassword("Worldcu9"));

		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides NoDigitException",false);

		}
	}
	
	/**
	 * Test the validPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testValidPasswords() throws FileNotFoundException {
		
		ArrayList<String> results;
		results = PasswordCheckerUtility.invalidPassword(passwords);
		Scanner scan = new Scanner(results.get(0));
		assertEquals(scan.next(), "5ACA3FGA");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		scan = new Scanner(results.get(1));
		assertEquals(scan.next(), "snoPPPy675");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("more than two"));
		scan = new Scanner(results.get(3));
		assertEquals(scan.next(), "aacdueh");
		nextResults = scan.nextLine().toLowerCase();

	}
	
}