package testngapp.com.weblink;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Screenshootprogram {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\INTEL\\eclipse-workspace-program\\com.weblink\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.weblinkservices.net/career/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void loginWithCorrectCredentials() throws IOException {
        driver.findElement(By.name("email")).sendKeys("hr@weblinkservices.net");
        driver.findElement(By.name("password")).sendKeys("hr@#123");
        driver.findElement(By.className("form-btn")).click();

        System.out.println("Login with correct credentials - Page Title: " + driver.getTitle());

        // Take screenshot after login
        takeScreenshot("login_success");
    }

    @Test(priority = 2)
    public void loginWithWrongEmail() throws IOException {
        driver.findElement(By.name("email")).sendKeys("wrong@weblinkservices.net");
        driver.findElement(By.name("password")).sendKeys("hr@#123");
        driver.findElement(By.className("form-btn")).click();

        System.out.println("Login with wrong email - Page Title: " + driver.getTitle());

        // Optional: Take screenshot for failed login
        takeScreenshot("login_wrong_email");
    }

    @Test(priority = 3)
    public void loginWithWrongPassword() throws IOException {
        driver.findElement(By.name("email")).sendKeys("hr@weblinkservices.net");
        driver.findElement(By.name("password")).sendKeys("wrongpassword");
        driver.findElement(By.className("form-btn")).click();

        System.out.println("Login with wrong password - Page Title: " + driver.getTitle());

        // Optional: Take screenshot for failed login
        takeScreenshot("login_wrong_password");
    }

    @AfterMethod
    public void afterMethod() {
        try {
            if (driver.findElements(By.id("log_out")).size() > 0) {
                driver.findElement(By.id("log_out")).click();
            }
        } catch (Exception e) {
            System.out.println("Logout skipped (probably not logged in).");
        } finally {
            driver.quit();
        }
    }

    // Utility method to take screenshot
    public void takeScreenshot(String fileName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Create directory if not exists
        String dirPath = "screenshots";
        Files.createDirectories(Paths.get(dirPath));

        // Save file with timestamp to avoid overwrite
        String fullPath = dirPath + "/" + fileName + "_" + System.currentTimeMillis() + ".png";
        Files.copy(screenshot.toPath(), Paths.get(fullPath));

        System.out.println("Screenshot saved: " + fullPath);
    }
}
