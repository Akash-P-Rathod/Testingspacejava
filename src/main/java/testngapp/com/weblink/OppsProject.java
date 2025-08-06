package testngapp.com.weblink;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OppsProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Hello Akash");
		WebDriver driver;
		System.setProperty("wedriver.chrome.driver","C:\\Users\\INTEL\\eclipse-workspace-program\\com.weblink\\drivers\\chromedriver.exe");
			WebDriver driver1= new ChromeDriver();
		driver1.get("https://www.weblinkservices.net");
		
			
	}

}
