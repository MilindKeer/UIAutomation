package com.automation.runner;

import org.junit.runner.RunWith;

// import org.junit.AfterClass;
// import com.automation.utility.BrowserDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/automation/features", glue = { "com.automation.stepdefinition",
                "com.automation.utility" }, plugin = { "pretty", "html:target/cucumber-reports.html",
                                "json:target/cucumber-reports.json" },
                // plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
                monochrome = true, dryRun = false //
)
public class TestRunner {
        // No need for a main method, JUnit will execute this
        // @AfterClass
        // public static void tearDown() {
        // BrowserDriver.closeBrowser();
        // }
}