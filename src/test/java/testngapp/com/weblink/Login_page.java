package testngapp.com.weblink;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class Login_page {

    WebDriver driver;  // Declare WebDriver at class level to share between methods

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\INTEL\\eclipse-workspace-program\\javaprogram\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.wlspl.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void login() {
        // Now driver is already initialized in @BeforeMethod
        driver.findElement(By.name("username")).sendKeys("AkashR");
        driver.findElement(By.name("password")).sendKeys("akash");
        driver.findElement(By.id("btnLogin")).click();

        // Optionally wait for login to complete and check title or success message
        System.out.println("Page Title after login: " + driver.getTitle());
    }

    @AfterMethod(enabled=true)
    public void afterMethod() {
        // Ensure logout only if login is successful
//        try {
//            driver.findElement(By.id("log_out")).click();
//        } catch (Exception e) {
//            System.out.println("Logout button not found or not logged in.");
//        } finally {
//            if (driver != null) {
//                driver.quit();
//            }
//        }
    	
    	// Inside your test method:
    	WebElement dropdownElement = driver.findElement(By.linkText("Efforts"));
    	Select dropdown = new Select(dropdownElement);

    	// Select by visible text
    	dropdown.selectByVisibleText("Add Projects");
    	
    	
    	driver.findElement(By.linkText("Add Task")).click();
    }
}
