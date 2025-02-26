package com.automation.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
// import java.io.IOException;

public class TestUtils {
    private static final Logger logger = LogManager.getLogger(TestUtils.class);

    private static WebDriver driver;

    // Capture screenshot and log exception details
    public static void handleException(Exception e) {
        logger.error("Test failed due to: " + e.getMessage());
        takeScreenshot();
        throw new RuntimeException(e);
    }

    public static void takeScreenshot() {
        try {
            if (driver == null) {
                System.out.println("Driver is not initialized.");
                return; 
            }

            if (driver instanceof TakesScreenshot) {
                TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
                File srcFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
                File destFile = new File("target/screenshots/screenshot.png");
                FileUtils.copyFile(srcFile, destFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setDriver(WebDriver driver) {
        TestUtils.driver = driver;
    }
}
