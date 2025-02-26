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

**1.Run All Tests (UI + API)**
To run all tests (both UI and API tests), use:
```
mvn clean test
```

**2.Run Only UI Tests**
To run only UI tests, use:
```
mvn test -Dcucumber.options="--tags @ui"
```

**3.Run Only API Tests**
To run only API tests, use:
```
mvn test -Dcucumber.options="--tags @api"
```

---
### **Viewing Test Reports**
**1. Cucumber HTML Report**
After running the tests, the HTML report is generated. Open it with:
```
start target/cucumber-reports.html
```

Mac/Linux:
```

open target/cucumber-reports.html
```

Or manually open target/cucumber-reports.html in any browser.

**2.JSON Report (for integrations)**
The JSON report is available at:
```
target/cucumber-reports.json
```
**3.Screenshots (if tests fail)**

If any test fails, a screenshot will be saved in the following directory:
```
target/screenshots/
```
