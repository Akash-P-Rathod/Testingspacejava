package testngapp.com.weblink;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Login_pageidpass {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\INTEL\\eclipse-workspace-program\\javaprogram\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.weblinkservices.net/career/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void loginWithCorrectCredentials() {
        driver.findElement(By.name("email")).sendKeys("hr@weblinkservices.net");
        driver.findElement(By.name("password")).sendKeys("hr@#123");
        driver.findElement(By.className("form-btn")).click();

        // Add a short wait or check if page changed
        String title = driver.getTitle();
        System.out.println("Login with correct credentials - Page Title: " + title);
    }

    @Test(priority = 2)
    public void loginWithWrongEmail() {
        driver.findElement(By.name("email")).sendKeys("wrong@weblinkservices.net");
        driver.findElement(By.name("password")).sendKeys("hr@#123");
        driver.findElement(By.className("form-btn")).click();

        // Check for login failure message or stay on login page
        String title = driver.getTitle();
        System.out.println("Login with wrong email - Page Title: " + title);
    }

    @Test(priority = 3)
    public void loginWithWrongPassword() {
        driver.findElement(By.name("email")).sendKeys("hr@weblinkservices.net");
        driver.findElement(By.name("password")).sendKeys("wrongpassword");
        driver.findElement(By.className("form-btn")).click();

        String title = driver.getTitle();
        System.out.println("Login with wrong password - Page Title: " + title);
    }

    @AfterMethod
    public void afterMethod() {
        try {
            // Try to logout if possible
            if (driver.findElements(By.id("log_out")).size() > 0) {
                driver.findElement(By.id("log_out")).click();
            }
        } catch (Exception e) {
            System.out.println("Logout skipped (probably not logged in).");
        } finally {
            driver.quit();
        }
    }
}
