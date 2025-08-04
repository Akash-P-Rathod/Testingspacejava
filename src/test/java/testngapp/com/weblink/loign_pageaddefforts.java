package testngapp.com.weblink;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loign_pageaddefforts {

    public static void main(String[] args) {
        
        // Define the username and password here
        String id = "AkashR";
        String pass = "akash";
        
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        
        // Open the URL
        driver.get("https://www.wlspl.com/");
        driver.manage().window().maximize();
        
        // --- Login Process ---
        driver.findElement(By.name("username")).sendKeys(id);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.id("btnLogin")).click();
        
        // Wait for the page to load after login (a better wait strategy should be used here)
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // --- Navigation to "Add Projects" ---
        
        // 1. Find and click the "Efforts" dropdown
        // I'm using a By.xpath locator because it's robust for finding text.
        // You might be able to use By.linkText or By.partialLinkText depending on the HTML structure.
        
        WebElement effortsDropdown = driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[3]/a/span[2]"));
        effortsDropdown.click();
        
        // Wait for the dropdown to expand
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 2. Find and click "Add Projects"
        WebElement addProjectsLink = driver.findElement(By.name("Add Projects"));
        addProjectsLink.click();
        
        // Optional: Add a final wait to see the new page
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Close the browser
        driver.quit();
    }
}