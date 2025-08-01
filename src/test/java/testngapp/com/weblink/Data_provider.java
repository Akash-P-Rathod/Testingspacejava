package testngapp.com.weblink;



import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Data_provider {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\INTEL\\eclipse-workspace-program\\javaprogram\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.weblinkservices.net/career/");
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"hr@weblinkservices.net", "hr@#123", "correct_credentials"},
                {"wrong@weblinkservices.net", "hr@#123", "wrong_email"},
                {"hr@weblinkservices.net", "wrongpass", "wrong_password"}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password, String label) throws IOException {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.className("form-btn")).click();

        // Wait a moment to allow login processing
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Ignore
        }

        takeScreenshot(label);

        // Check if logout button is present (i.e., login success)
        if (driver.findElements(By.id("log_out")).size() > 0) {
            System.out.println("Login attempt (" + label + "): SUCCESS");
        } else {
            System.out.println("Login attempt (" + label + "): FAILED");
        }
    }

    @AfterMethod
    public void teardown() {
        try {
            if (driver.findElements(By.id("log_out")).size() > 0) {
                driver.findElement(By.id("log_out")).click();
            }
        } catch (Exception e) {
            System.out.println("Logout skipped.");
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void takeScreenshot(String label) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String dirPath = "screenshots";
        Files.createDirectories(Paths.get(dirPath));

        String fullPath = dirPath + "/" + label + "_" + System.currentTimeMillis() + ".png";
        Files.copy(screenshot.toPath(), Paths.get(fullPath));
        System.out.println("Screenshot saved: " + fullPath);
    }
}
