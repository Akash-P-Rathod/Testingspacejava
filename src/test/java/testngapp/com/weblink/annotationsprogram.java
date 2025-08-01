package testngapp.com.weblink;

import org.testng.annotations.*;

public class annotationsprogram {
	@BeforeClass
	public void beforeclass() {
		System.out.println("I am Run Before All Method I Am Run");
	}
	
	public void afterclass() {
		System.out.println("I am Run After All Method Thank You");
	}
	
	@BeforeMethod
	public void before() {
		System.out.println("I Am Run Before All Test Cases Run");
	}
	 @AfterMethod
	public void after() {
		System.out.println("I Am Run After All Test Cases Run");
	}
	
	
@Test
	public void test1() {
		System.out.println("Hello This Is First");
	}
	
@Test
	public void test2() {
	System.out.println("Hello This Is Second");
		
	} 
}
