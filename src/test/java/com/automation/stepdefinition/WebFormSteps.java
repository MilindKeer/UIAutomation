package com.automation.stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
// import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.automation.utility.BrowserDriver;
import com.automation.utility.TestUtils;

import java.io.File;

import static org.junit.Assert.*;


public class WebFormSteps {
    // WebDriver driver;
    private WebDriver driver = BrowserDriver.getDriver();
    
    // Set the WebDriver instance in TestUtils
    public static void setDriver(WebDriver driver) {
        TestUtils.setDriver(driver); 
    }

    @Given("User is on the web form page")
    public void user_is_on_web_form_page() {

        try {
            // System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            // driver = new ChromeDriver();
            // driver.manage().window().maximize();
            // driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            // to make sure we get driver dynamically as one of the requirement is test should run OS independent.
            driver = BrowserDriver.getDriver(); 
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        
        } catch (Exception e) {
            TestUtils.handleException(e);
        }

    }

    @When("User enters {string} in the text input field")
    public void user_enters_in_text_input_field(String text) {

        try {

            WebElement textField = driver.findElement(By.id("my-text-id"));
            textField.clear();
            textField.sendKeys(text);

        } catch (Exception e) {
            TestUtils.handleException(e);
        }

    }

    @Then("The text input field should contain {string}")
    public void the_text_input_field_should_contain(String expectedText) {

        try {
            WebElement textField = driver.findElement(By.id("my-text-id"));
            assertEquals(expectedText, textField.getAttribute("value"));
        } catch (Exception e) {
            TestUtils.handleException(e);
        }

    }

    @When("User enters {string} in the password field")
    public void user_enters_in_password_field(String password) {
        try {
            WebElement passwordField = driver.findElement(By.name("my-password"));
            passwordField.clear();
            passwordField.sendKeys(password);
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @Then("The password field should not be empty")
    public void the_password_field_should_not_be_empty() {
        try {
            WebElement passwordField = driver.findElement(By.name("my-password"));
            assertFalse(passwordField.getAttribute("value").isEmpty());
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @When("User enters {string} in the textarea field")
    public void user_enters_in_textarea_field(String text) {
        try {
            WebElement textareaField = driver.findElement(By.name("my-textarea"));
            textareaField.clear();
            textareaField.sendKeys(text);
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @Then("The textarea field should contain {string}")
    public void the_textarea_field_should_contain(String expectedText) {
        try {
            WebElement textareaField = driver.findElement(By.name("my-textarea"));
            assertEquals(expectedText, textareaField.getAttribute("value"));
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @Then("The disabled input field should not be editable")
    public void the_disabled_input_field_should_not_be_editable() {
        try {
            WebElement disabledField = driver.findElement(By.name("my-disabled"));
            assertFalse(disabledField.isEnabled());
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @Then("The read-only input field should contain {string}")
    public void the_read_only_input_field_should_contain(String expectedText) {
        try {
            WebElement readOnlyField = driver.findElement(By.name("my-readonly"));
            assertEquals(expectedText, readOnlyField.getAttribute("value"));
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @When("User selects {string} from the dropdown menu")
    public void user_selects_from_dropdown_menu(String option) {
        try {
            Select dropdown = new Select(driver.findElement(By.name("my-select")));
            dropdown.selectByVisibleText(option);
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @Then("The dropdown menu should have {string} selected")
    public void the_dropdown_menu_should_have_selected(String expectedOption) {
        try {
            Select dropdown = new Select(driver.findElement(By.name("my-select")));
            assertEquals(expectedOption, dropdown.getFirstSelectedOption().getText());
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @When("User enters {string} in the datalist input field")
    public void user_enters_in_datalist_input_field(String value) {
        try {
            WebElement datalistInput = driver.findElement(By.name("my-datalist"));
            datalistInput.sendKeys(value);
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @Then("The datalist input field should contain {string}")
    public void the_datalist_input_field_should_contain(String expectedValue) {
        try {
            WebElement datalistInput = driver.findElement(By.name("my-datalist"));
            assertEquals(expectedValue, datalistInput.getAttribute("value"));
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @When("User uploads a file {string}")
    public void user_uploads_a_file(String fileName) {
        try {
            WebElement fileInput = driver.findElement(By.name("my-file"));
            File file = new File("src/test/resources/files/" + fileName);
            fileInput.sendKeys(file.getAbsolutePath());
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @Then("The file input field should display {string}")
    public void the_file_input_field_should_display(String expectedFileName) {
        try {
            WebElement fileInput = driver.findElement(By.name("my-file"));
            String uploadedFileName = new File(fileInput.getAttribute("value")).getName();
            assertEquals(expectedFileName, uploadedFileName);
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @When("User checks the checked checkbox")
    public void user_checks_the_checked_checkbox() {
        try {
            WebElement checkbox = driver.findElement(By.id("my-check-1"));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @Then("The checked checkbox should be selected")
    public void the_checked_checkbox_should_be_selected() {
        try {
            WebElement checkbox = driver.findElement(By.id("my-check-1"));
            assertTrue(checkbox.isSelected());
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @When("User selects the checked radio button")
    public void user_selects_the_checked_radio_button() {
        try {
            WebElement radioButton = driver.findElement(By.id("my-radio-1"));
            radioButton.click();
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @Then("The checked radio button should be selected")
    public void the_checked_radio_button_should_be_selected() {
        try {
            WebElement radioButton = driver.findElement(By.id("my-radio-1"));
            assertTrue(radioButton.isSelected());
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @When("User selects the color {string}")
    public void user_selects_the_color(String color) {
        try {
            WebElement colorPicker = driver.findElement(By.name("my-colors"));
            // WebElement colorPicker =
            // driver.findElement(By.cssSelector("input.form-control-color"));
            colorPicker.sendKeys(color);
            // JavascriptExecutor js = (JavascriptExecutor) driver;
            // js.executeScript(
            // "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new
            // Event('input', { bubbles: true }));",
            // colorPicker, color);
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @Then("The color picker should show {string}")
    public void the_color_picker_should_show(String expectedColor) {
        try {
            WebElement colorPicker = driver.findElement(By.name("my-colors"));
            assertEquals(expectedColor, colorPicker.getAttribute("value"));
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @When("User selects {string} in the date picker")
    public void user_selects_in_date_picker(String date) {
        try {
            WebElement datePicker = driver.findElement(By.name("my-date"));
            datePicker.sendKeys(date);
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @Then("The date picker should display {string}")
    public void the_date_picker_should_display(String expectedDate) {
        try {
            WebElement datePicker = driver.findElement(By.name("my-date"));
            assertEquals(expectedDate, datePicker.getAttribute("value"));
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @When("User moves the range slider to {string}")
    public void user_moves_the_range_slider_to(String value) {
        try {
            WebElement slider = driver.findElement(By.name("my-range"));
            // slider.sendKeys(value);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
                    slider, value);
        } catch (Exception e) {
            TestUtils.handleException(e);
        }

    }

    @Then("The range slider should show {string}")
    public void the_range_slider_should_show(String expectedValue) {
        try {
            WebElement slider = driver.findElement(By.name("my-range"));
            assertEquals(expectedValue, slider.getAttribute("value"));
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @When("User clicks the submit button")
    public void user_clicks_the_submit_button() {
        try {
            driver.findElement(By.cssSelector("button")).click();
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }

    @Then("User should see the message {string}")
    public void user_should_see_the_message(String expectedMessage) {
        try {
            WebElement message = driver.findElement(By.id("message"));
            assertEquals(expectedMessage, message.getText());
            driver.quit();
        } catch (Exception e) {
            TestUtils.handleException(e);
        }
    }
}
