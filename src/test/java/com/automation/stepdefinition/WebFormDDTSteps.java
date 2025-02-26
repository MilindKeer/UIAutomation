package com.automation.stepdefinition;

import com.automation.utility.BrowserDriver;
import com.automation.utility.TestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import io.cucumber.java.Before;
import io.cucumber.java.After;

public class WebFormDDTSteps {
    private WebDriver driver = BrowserDriver.getDriver();

    // This is intended for clean test execution but if not required can be handlled.
    @Before
    public void setUp() {
        // Initialize WebDriver
        BrowserDriver.getDriver();
    }

    @After
    public void tearDown() {
        // Quit WebDriver after each test
        BrowserDriver.closeBrowser();
    }

    @Given("User is on the web form page for DDT")
    public void user_is_on_web_form_page() {

        try {

            if (driver == null) {
                driver = BrowserDriver.getDriver();
            }
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        } catch (Exception e) {
            TestUtils.handleException(e);
        }

    }

    @When("User enters text {string} in the text input field")
    public void user_enters_text_input(String text) {
        try {

            WebElement textField = driver.findElement(By.id("my-text-id"));
            textField.clear();
            textField.sendKeys(text);

        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @When("User enters password {string} in the password field")
    public void user_enters_password(String password) {
        try {
            WebElement passwordField = driver.findElement(By.name("my-password"));
            passwordField.clear();
            passwordField.sendKeys(password);
        } catch (Exception e) {
            TestUtils.handleException(e);
        }

    }

    @When("User selects dropdown {string} from the dropdown")
    public void user_selects_dropdown_option(String dropdownOption) {
        try {
            WebElement dropdown = driver.findElement(By.name("my-select"));
            dropdown.sendKeys(dropdownOption);
        } catch (Exception e) {
            TestUtils.handleException(e);
        }

    }

    @Then("The text input field should populate {string}")
    public void the_text_input_field_should_contain(String expectedText) {

        try {
            WebElement textField = driver.findElement(By.id("my-text-id"));
            assertEquals(expectedText, textField.getAttribute("value"));
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @Then("The password field should populate {string}")
    public void the_password_field_should_contain(String expectedPassword) {
        try {
            WebElement passwordField = driver.findElement(By.name("my-password"));
            assertFalse(passwordField.getAttribute("value").isEmpty());
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @Then("The dropdown should have populate {string}")
    public void the_dropdown_should_have(String expectedDropdownValue) {
        try {
            Select dropdown = new Select(driver.findElement(By.name("my-select")));
            String actualValue = dropdown.getFirstSelectedOption().getText();
            assertEquals(expectedDropdownValue, actualValue);
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }
}
