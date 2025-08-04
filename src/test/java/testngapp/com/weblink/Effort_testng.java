package testngapp.com.weblink;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Effort_testng {

    ChromeDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Login is part of the setup here
        driver.get("https://www.wlspl.com/");
        driver.findElement(By.name("username")).sendKeys("AkashR");
        driver.findElement(By.name("password")).sendKeys("akash");
        driver.findElement(By.id("btnLogin")).click();
        
        // Wait for the dashboard to load after login
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void navigateToAddProjects() {
        // --- Navigation to "Add Projects" ---
        
        // 1. Find and click the "Efforts" dropdown
        WebElement effortsDropdown = driver.findElement(By.linkText("Efforts"));
        effortsDropdown.click();
        
        // Wait for the dropdown to expand
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 2. Find and click "Add Projects"
        WebElement addProjectsLink = driver.findElement(By.linkText("Add Projects"));
        addProjectsLink.click();
        
        // TODO: Add an assertion to verify that you are on the "Add Projects" page.
        // For example:
        // Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Add Projects"));
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}