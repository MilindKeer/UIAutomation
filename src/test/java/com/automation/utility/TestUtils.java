package com.automation.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class TestUtils {
    private static final Logger logger = LogManager.getLogger(TestUtils.class);
    
    private static WebDriver driver;

    // Capture screenshot and log exception details
    public static void handleException(Exception e) {
        logger.error("Test failed due to: " + e.getMessage());
        takeScreenshot();  
        throw new RuntimeException(e); 
    }

    // Utility to take a screenshot
    public static void takeScreenshot() {
        
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("target/screenshots/test-failure.png"));
        } catch (IOException e) {
            logger.error("Error while saving the screenshot: " + e.getMessage());
        }
    }

    public static void setDriver(WebDriver driver) {
        TestUtils.driver = driver;
    }
}
