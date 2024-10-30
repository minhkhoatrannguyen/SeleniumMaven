package automation.testsuite;

import org.testng.annotations.*;

public class Login {

	@BeforeMethod
	public void init() {
		System.out.println("This is before method");
	}
	
	@Test
	public void TC1() {
		System.out.println("This is test case 1");
	}
	
	@Test
	public void TC2() {
		System.out.println("This is test case 2");
	}

}
