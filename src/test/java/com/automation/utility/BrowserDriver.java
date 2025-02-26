package com.automation.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriver { 
    private static WebDriver driver;

    // // constructor
    // public BrowserDriver() {
    //     System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    //     driver = new ChromeDriver();
    //     driver.manage().window().maximize();
    // }

    // // instance of WebDriver
    // public static WebDriver getDriver() {
    //     if (driver == null) {
    //         new BrowserDriver(); 
    //     }
    //     return driver;
    // }

    // get driver dynamically
    public static WebDriver getDriver() {
        if (driver == null) {  
            WebDriverManager.chromedriver().setup();  
            driver = new ChromeDriver();  
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    // close the WebDriver instance
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
