package bank;

// LIBRARIES HAVE TO BE .jupiter

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {
	

	// This variable was created so that each method has access to the content of that attribute
	
	private BankAccount ba;




	// BeforeAll , AfterAll, BeforeEach and AfterEach
	// These will be executed before or after test cases, @Test	
	
	
	
	
	
	// 1
	// @BeforeAll will be executed only one time, at the beginning.
	// It is used to initialize the Test class, to show messages, etc
		
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		System.out.println("********************STARTING THE TEST********************"); // ADDED BY ME. I implement this code to announce the beginning of tests
				
	}
	
	
	
	
	
	
	
	
	// 3
	// @AfterAll will be executed at the end of executing all else

	@AfterAll
	static void tearDownAfterClass() throws Exception {
				
		System.out.println("********************FINISHING THE TEST********************"); // ADDED BY ME. I implement this code to announce the beginning of tests
						
	}

	
	
	
	
	
	
	// 2
	// @BeforeEach and @AfterEach will be executed for each @Test
	// It will be used to initialize objects
	// For example, Each @Test has in common The initialization of an object, ' BankAccount ba = new BankAccount(2800, "pass"); ' 
	// I will initialize the object 'BankAccount ba' before each @Test  in this method '@BeforeEach'
	// It has to be deleted every 'BankAccount ba' object for each @Test
		
	@BeforeEach // The First one for one @Test
	void setUp() throws Exception {
		
		// This variable has to be 'refactored' because if it is not an Attribute of the class, it is not visible for the other methods
		// So it has to be created an attribute with this name
		// Select the variable name, 'ba', click with the right button of the mouse and select 'refactor/Convert Local Variable to Field(campo o atributo de la clase)...
		
		ba = new BankAccount(2800, "pass"); // ADDED BY ME
		
		System.out.println("STARTING THE TEST CASE"); // ADDED BY ME
		
	}

	@AfterEach // The Second one for the same @Test
	void tearDown() throws Exception {
		
		ba = null; // ADDED BY ME. After every test the variable 'ba' will be cleaned.
				
		System.out.println("FINISHING THE TEST CASE"); // ADDED BY ME
		
	}

		
	
	
	
	
	
	// -------------------------------------------------------------------testDeposit------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	// - Deposit() method has to be tested at least two times, because it is possible to enter a positive quantity or a negative quantity.
	// - So, It has to be created two different methods one for a positive number and one for a negative number.
	// - THIS IS THE ENTERED POSITIVE AMOUNT-> At the beginning the name of this method was testDeposit(), now we will call it 'testDeposit_correctPositive()'
	
	@Test
	void testDeposit_Positive() {
		
		System.out.println("Performing the test Deposit_Positive"); 
		
		
		
		// fail("Not yet implemented"); // This is a fail line which produce a fail at the beginning, before implementing the code. It has to be deleted. It has to be changed by changing the code from the class 'BankAccount'
		
		
		
		// - To execute the method from another class, an object from the BankAccount class has to be created.
		
		// BankAccount ba = new BankAccount(2800, "pass"); // This is the money which is inside of this account and the password. Now there is an attribute in this class to access from every method.
		
		int expectedResult = 3300; // This is what we are expecting
		
		int realResult = ba.deposit(500); // This is the real result. We call the method deposit() from the object 'ba' from the class BankAccount.
		
		
				
		// - To compare the results, it is necessary to use the JUnit method, assertEquals.
		// - It is possible to do it, without using the variables, like this: assertEquals(3300, ba.deposit(500)); 
		
		assertEquals(expectedResult,realResult); // If both results are equals, it means that the method is ok
		
	}
	
	
	
	
	
	
	// - THIS IS THE ENTERED NEGATIVE AMOUNT-> At the beginning the name of this method was testDeposit(), now we will call it 'testDeposit_correctNegative()'
		
	@Test
	void testDeposit_Negative() {
		
		System.out.println("Performing the test Deposit_negative");		
		
		
		
		// fail("Not yet implemented"); // This is a fail line which produce a fail at the beginning, before implementing the code. It has to be deleted by changing the code from the class 'BankAccount'
		
		
		
		
		// BankAccount ba = new BankAccount(2800, "pass"); // This is the money which is inside of this account and the password.Now there is an attribute in this class to access from every method.
				
		int expectedResult = -1; // This is what we are expecting
		
		int realResult = ba.deposit(-500); // This is the real result. We call the method deposit() from the object 'ba' from the class BankAccount.
		
		
				
		// - To compare the results, it is necessary to use the JUnit method, assertEquals.
		// - It is possible to do it, without using the variables, like this: assertEquals(3300, ba.deposit(500)); 
		
		assertEquals(expectedResult,realResult); // If both results are equals, it means that the method is ok		
		
	}
	
	
	
		
	
	
	
	
	
	
	
	// ---------------------------------------------------------------------testWithrdraw-------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	// - This method has to be tested, three times at least, because it is possible to have three results. 
	// Cases:
	// 1. If the password is correct and balance >= amount
	// 2. If the password is correct and balance < amount
	// 3. If the password is not correct
	

	@Test
	void testWithrdraw_case1() {
		
		System.out.println("Performing the test withdraw_case1");
		
		
		
		// fail("Not yet implemented"); NOT NECESARY
		
		
		// BankAccount ba = new BankAccount(2800, "pass"); // This is the money which is inside of this account and the password. Now there is an attribute in this class to access from every method.
				
		int expectedResult =2300; // This is what we are expecting
		
		int realResult = ba.withrdraw(500,"pass"); // This is the real result. We call the method deposit() from the object 'ba' from the class BankAccount.
		
		
		assertEquals(expectedResult,realResult);
		
		
	}

	
	
	
	
	@Test
	void testWithrdraw_case2() {
		
		System.out.println("Performing the test withdraw_case2");		
		
		
		// fail("Not yet implemented"); NOT NECESARY

		
		// BankAccount ba = new BankAccount(2800, "pass"); // This is the money which is inside of this account and the password. Now there is an attribute in this class to access from every method.
				
		int expectedResult =-1; // This is what we are expecting
		
		int realResult = ba.withrdraw(3000,"pass"); // This is the real result. We call the method deposit() from the object 'ba' from the class BankAccount.
		
		
		assertEquals(expectedResult,realResult);
		
				
	}
	
	
	
	
	
	@Test
	void testWithrdraw_case3() {
		
		System.out.println("Performing the tes twithdraw_case3");
		
		
		
		// fail("Not yet implemented");

		
		// BankAccount ba = new BankAccount(2800, "pass"); // This is the money which is inside of this account and the password. Now there is an attribute in this class to access from every method.
						
		int expectedResult =-2; // This is what we are expecting
				
		int realResult = ba.withrdraw(3000,"false"); // This is the real result. We call the method deposit() from the object 'ba' from the class BankAccount.
				
				
		assertEquals(expectedResult,realResult);
				
				
	}
	
	
	
	
	
	
	
	// ----------------------------------------------password-----------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	// - This method has to be tested two times , because it is possible to have two results, true or false, depending on the password 
	// Cases:
	// 1. If the password is correct. 
	// 2. If the password is not correct.
		
	
	@Test
	void testCorrectPassword_case1() {
		
		System.out.println("Performing the test CorrectPassword_case1");
		
		
		
		// fail("Not yet implemented");
		
		
		// BankAccount ba = new BankAccount(2800, "pass"); // This is the money which is inside of this account and the password. Now there is an attribute in this class to access from every method.
				
		// boolean expectedResult = true ; // In this case, the result has to be boolean, like it is indicated in the method. In this case must be 'true'
		
		// boolean realResult = ba.correctPassword("pass"); // In this case, the result has to be boolean, like it is indicated in the method. In this case must be 'true'
			
		
		
		// In this case it is compared directly the realResult, with true
		
		assertTrue(ba.correctPassword("pass"));
		
		
		// assertEquals(expectedResult,realResult); -> This is possible too. Here is compared both results
		
		
	}
	
	
	
	
	@Test
	void testCorrectPassword_case2() {
		
		System.out.println("Performing the test CorrectPassword_case2");
		
		
		
		// fail("Not yet implemented");
		
		
		// BankAccount ba = new BankAccount(2800, "pass"); // This is the money which is inside of this account and the password. Now there is an attribute in this class to access from every method.
				
		// boolean expectedResult = false ; // In this case, the result has to be boolean, like it is indicated in the method. In this case must be 'false'
		
		// boolean realResult = ba.correctPassword("hola"); // In this case, the result has to be boolean, like it is indicated in the method. In this case must be 'false'
		
		
		
		// In this case it is compared directly the realResult, with false
		
		assertFalse(ba.correctPassword("hola"));
				
				
		// assertEquals(expectedResult,realResult); -> This is possible too. Here is compared both results
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
