# Project Architecture & Flow Diagram

## 🏗️ Project Structure

```
Seleniumpro/
│
├── 📄 pom.xml                          ← Maven Configuration
│   └── Dependencies: Selenium, Cucumber, JUnit, WebDriverManager
│
├── src/
│   ├── main/
│   │   └── java/helloworld/            ← Main application code
│   │
│   └── test/
│       ├── java/
│       │   ├── runners/
│       │   │   └── CucumberTestRunner.java    ← 🎯 ENTRY POINT (Run this!)
│       │   │       └── @RunWith(Cucumber.class)
│       │   │       └── @CucumberOptions
│       │   │
│       │   └── stepDefinitions/
│       │       └── LoginStepDefinitions.java  ← Step implementations
│       │           ├── @Given
│       │           ├── @When
│       │           ├── @And
│       │           └── @Then
│       │
│       └── resources/
│           └── features/
│               └── login.feature               ← 📝 Test scenarios (Gherkin)
│
├── Driver/
│   └── chromedriver.exe                ← Browser driver (auto-managed)
│
├── target/
│   └── cucumber-reports/
│       ├── cucumber.html               ← HTML Report 📊
│       └── cucumber.json               ← JSON Report 📋
│
└── 📚 Documentation Files:
    ├── QUICK_START.md                  ← 👈 START HERE
    ├── SETUP_AND_RUN_GUIDE.md
    ├── QUICK_REFERENCE.md
    ├── ADVANCED_SETUP.md
    ├── PROJECT_CONFIGURATION_SUMMARY.md
    └── ARCHITECTURE_AND_FLOW.md         ← You are here


```

## 🔄 Execution Flow

```
┌─────────────────────────────────────────────────────────────┐
│ Eclipse IDE - Right-click CucumberTestRunner.java           │
│             → Run As → JUnit Test                           │
└────────────────────┬────────────────────────────────────────┘
                     │
                     ▼
         ┌───────────────────────────┐
         │  CucumberTestRunner Loads  │
         │  @CucumberOptions Config  │
         └────────────┬──────────────┘
                      │
        ┌─────────────┼─────────────┐
        │             │             │
        ▼             ▼             ▼
    Features    Glue Path      Plugins
    (Scenarios) (Steps)        (Reports)
        │             │             │
        ▼             ▼             ▼
  login.feature  stepDefinitions  HTML/JSON
                                  Reports

                      │
                      ▼
    ┌────────────────────────────────────┐
    │ Reads: login.feature               │
    │ Finds 2 Scenarios                  │
    └────────────┬───────────────────────┘
                 │
        ┌────────┴────────┐
        │                 │
        ▼                 ▼
    Scenario 1:       Scenario 2:
    Valid Login       Invalid Login
        │                 │
        ▼                 ▼
    ┌─ Executes @Given steps (setup)
    │  - Navigate to login page
    │  - Initialize WebDriver
    │
    ├─ Executes @When steps (actions)
    │  - Enter credentials
    │  - Click button
    │
    ├─ Executes @Then steps (verify)
    │  - Check dashboard/error message
    │  - Assert conditions
    │
    └─ Executes @After hooks (cleanup)
       - Close browser
       - Generate reports

                      │
                      ▼
    ┌────────────────────────────────────┐
    │ Results Generated:                 │
    │ ✅ JUnit Panel (Green/Red)         │
    │ ✅ Console Output (Logs)           │
    │ ✅ HTML Report (cucumber.html)     │
    │ ✅ JSON Report (cucumber.json)     │
    └────────────────────────────────────┘
```

## 📊 Step Definition Mapping

```
Feature File (login.feature)          →  Java Implementation (LoginStepDefinitions.java)

Given: User is on the login page      →  @Given("User is on the login page")
                                          public void userIsOnLoginPage()

When: User enters valid credentials   →  @When("User enters valid email and password")
                                          public void userEntersValidCredentials()

And: User clicks the login button      →  @And("User clicks the login button")
                                          public void userClicksLoginButton()

Then: User should be redirected        →  @Then("User should be redirected to the dashboard")
                                          public void userRedirectedToDashboard()
```

## 🔌 Technology Stack

```
┌──────────────────────────────────────────┐
│         Project Technology Stack         │
├──────────────────────────────────────────┤
│  OpenJDK 21.0.10 (Java Runtime)          │
│  Maven 3.x+ (Build & Dependency Mgr)    │
│  Eclipse (IDE)                           │
├──────────────────────────────────────────┤
│         Testing Framework                │
├──────────────────────────────────────────┤
│  Cucumber 7.14.0 (BDD Framework)         │
│  JUnit 4.13.2 (Test Runner)              │
│  Cucumber JUnit 7.14.0 (Integration)     │
├──────────────────────────────────────────┤
│         Browser Automation               │
├──────────────────────────────────────────┤
│  Selenium 4.43.0 (WebDriver)             │
│  WebDriverManager 5.6.3 (Driver Mgr)    │
│  ChromeDriver (Browser Driver)           │
└──────────────────────────────────────────┘
```

## 🎯 Running Tests - Decision Tree

```
Want to run tests?
│
├─ Using Eclipse JUnit Panel?
│  ├─ Right-click CucumberTestRunner.java
│  ├─ Run As → JUnit Test
│  └─ View results in JUnit tab
│
├─ Using Command Line?
│  ├─ cd C:\Users\LAPTOP\eclipse-workspace\Seleniumpro
│  ├─ mvn clean test
│  └─ Check console for output
│
├─ Using Eclipse Maven?
│  ├─ Right-click project
│  ├─ Run As → Maven test
│  └─ Watch build progress
│
└─ View Reports?
   ├─ HTML: target/cucumber-reports/cucumber.html
   ├─ JSON: target/cucumber-reports/cucumber.json
   └─ Console: Eclipse Console tab
```

## 🔧 Configuration Hierarchy

```
pom.xml (Parent)
├── Maven Compiler (Java 21 compilation)
├── Maven Surefire (Test Execution)
└── Dependencies
    ├── Selenium Java 4.43.0
    ├── Cucumber Java 7.14.0
    ├── Cucumber JUnit 7.14.0
    ├── JUnit 4.13.2
    └── WebDriverManager 5.6.3

CucumberTestRunner.java (Child)
├── @RunWith(Cucumber.class)
└── @CucumberOptions
    ├── features = src/test/resources/features
    ├── glue = stepDefinitions
    └── plugins = [pretty, html:..., json:...]

Step Definitions (Grand-child)
└── LoginStepDefinitions.java
    ├── @Given
    ├── @When
    ├── @And
    └── @Then
```

## 📈 Test Execution Metrics

```
Test File:     login.feature
Scenarios:     2 total
  ✅ Scenario 1: Successful login
  ✅ Scenario 2: Failed login

Steps per Scenario: 3-4 steps
Total Steps:       ~14 steps

Execution Time:    ~5-15 seconds (depends on browser loading)
Reports Generated: HTML + JSON + Console
```

## 🎓 How Cucumber Works

```
Step 1: Parse Feature File
└─ Reads login.feature
└─ Identifies Given/When/Then keywords
└─ Extracts step text

Step 2: Map to Step Definitions
└─ Matches "User is on login page" 
└─ Finds @Given("User is on the login page")
└─ Links feature steps to Java methods

Step 3: Execute Steps in Order
└─ @Before hooks (setup)
└─ @Given methods (preconditions)
└─ @When methods (actions)
└─ @Then methods (assertions)
└─ @After hooks (cleanup)

Step 4: Generate Reports
└─ Pass/Fail status
└─ Execution time
└─ HTML/JSON output
└─ Screenshot attachments (if added)
```

## 📋 File Relationships

```
login.feature (What to test)
    │
    ├─ references phrases like "User is on the login page"
    │
    ▼
LoginStepDefinitions.java (How to test)
    │
    ├─ contains @Given("User is on the login page")
    ├─ implements the actual Selenium code
    │
    ▼
CucumberTestRunner.java (Where to find them)
    │
    ├─ glue = {"stepDefinitions"}
    ├─ features = "src/test/resources/features"
    │
    ▼
pom.xml (What to use)
    │
    ├─ Selenium 4.43.0
    ├─ Cucumber 7.14.0
    ├─ JUnit 4.13.2
    │
    ▼
✅ Complete Test Suite
```

## 🚀 Quick Reference Commands

```bash
# Clean build
mvn clean install

# Run tests
mvn test

# Run with verbose output
mvn test -X

# Skip tests during build
mvn clean install -DskipTests

# Run specific test class
mvn test -Dtest=CucumberTestRunner
```

---

**Now you understand the complete architecture!**  
Ready to run? See: `QUICK_START.md`
