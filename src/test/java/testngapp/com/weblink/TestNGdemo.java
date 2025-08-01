package testngapp.com.weblink;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestNGdemo {
@Test
	public void verifyPagetitle() {
		//launch bro
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver=new ChromeDriver();
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
		//openurl
		driver.get("https://www.weblinkservices.net/");
		//System.out.println("Title Is"+driver.getTitle());
		//
		String acualtitle=driver.getTitle();
		
		String accptedltitle="Web Link Service: Best web design and development and Digital marketing company in Pune";
		
		
		AssertJUnit.assertEquals(acualtitle, accptedltitle);
		driver.quit();
	
	} 
}
