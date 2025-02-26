# Selenium Automation Testing Framework

This project is a **Selenium-based test automation framework** using **Java, Cucumber, and Maven**.  
It covers both **UI Testing** and **API Testing** with detailed reporting.

---

## Technologies Stack Used

- **Java** (17+)
- **Selenium WebDriver** (UI Testing)
- **Cucumber** (BDD Framework)
- **Maven** (Build & Dependency Management)
- **RestAssured** (API Testing)
- **JUnit** (Test Execution)
- **WebDriverManager** (Automatic Driver Management)
- **Cucumber Reports** (Test Reporting)

---

## **Setup Instructions**
Before running the tests, ensure you have the following installed:


### **1. Install Java (17 or later)**
Check if Java is installed:  
```
java -version
```

### **2. Install Maven**
Check if Maven is installed:

```
mvn -version
```
If not installed, download from Maven Downloads.

### **3. Clone the GitHub Repository**
Run the following command in your terminal:

```
git clone https://github.com/YOUR_USERNAME/YOUR_REPO.git
cd YOUR_REPO

```

### **4. Install Dependencies**
Run the following command to download all required dependencies:

```
mvn clean install
```

---

### **Running the Tests**

### **1.Run All Tests (UI + API)**
To run all tests (both UI and API tests), use:
```
mvn clean test
```

### **2.Run Only UI Tests**
To run only UI tests, use:
```
mvn test -Dcucumber.options="--tags @ui"
```

### **3.Run Only API Tests**
To run only API tests, use:
```
mvn test -Dcucumber.options="--tags @api"
```

---
### **Viewing Test Reports**

### **1. Cucumber HTML Report**
After running the tests, the HTML report is generated. Open it with:
```
start target/cucumber-reports.html
```

Mac/Linux:
```

open target/cucumber-reports.html
```

Or manually open target/cucumber-reports.html in any browser.

### **2.JSON Report (for integrations)**
The JSON report is available at:
```
target/cucumber-reports.json
```

### **3.Screenshots (if tests fail)**

If any test fails, a screenshot will be saved in the following directory:
```
target/screenshots/
```

---

## Overview
This project currently implements **UI automation using Selenium with Cucumber** and **API testing using RestAssured**.  
It has both feature files,
- **webform.feature**
This is implementation uses **static test data** in feature files and step definitions
- **webform.feature**
This is introducing **Data-Driven Testing (DDT)** would significantly enhance **test coverage, flexibility, and maintainability**.
- **api-testing.feature** 
This is for API Testing using "https://jsonplaceholder.typicode.com/posts"

---
## Data-Driven Testing (DDT) Approach

## **What is Data-Driven Testing?**
**Data-Driven Testing (DDT)** is an approach where **test data is stored externally** (e.g., in **CSV files, Excel sheets, JSON, or databases**) and dynamically fed into test scripts.  
This allows running **multiple test iterations** with different input values **without modifying the test script**.

For a **Cucumber-Selenium framework**, we can implement DDT using:
- **Cucumber `Scenario Outline` (built-in data table)**
- **External file sources (CSV, Excel, JSON, or a database)**

**Here I have imoplemented using Cucumber `Scenario Outline`**
### **1️. Approach: Using Cucumber `Scenario Outline`**
Instead of hardcoding values in the step definitions, we can pass test data through **Cucumber Examples Tables**.

#### **Example Feature File (`webform.feature`)**
```gherkin
Scenario Outline: Validate text input, password, and dropdown selection using CSV data
    Given User is on the web form page for DDT
    When User enters text "<text_input>" in the text input field
    And User enters password "<password>" in the password field
    And User selects dropdown "<dropdown_option>" from the dropdown
    Then The text input field should populate "<text_input>"
    And The password field should populate "<password>"
    And The dropdown should have populate "<dropdown_option>"

  Examples: 
    | text_input | password  | dropdown_option |
    | test_1 | password_1 | One |
    | test_2 | password_2 | Two |
    | test_3 | password_3 | Three |
```

Advantage: This approach works directly within Cucumber and does not require external files.

## **Next possible improvement:**
If the number of records are more it would be more feasible to maintain them in a CSV or Excel or JASON
This has not be implemented but below is the approach 
### **2. Approach: Reading Test Data from an External File**
To make test execution more flexible, we can store test data in CSV, Excel, or JSON files (or database) and read it dynamically.
Step1 - Storing Test Data in CSV (testdata.csv)
Step2 - Java Code to Read Data from CSV (TestDataReader.java)
Step3 - Run the script in a loop for all records given in the CSV

Advantage: Testers can update test data externally without modifying code.

**Advantages of Data-Driven Testing** <br>
**Scalability:	Enables running the same test with multiple datasets without modifying the code.**<br>
**Maintainability:	Test data can be updated externally without changing test scripts.**<br>
**Reusability:	The same test script can be reused across different input values.**<br>
**Better Coverage:	Helps test various scenarios (valid/invalid inputs, boundary cases).**<br>

---