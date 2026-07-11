# Selenium Cucumber BDD Test Setup Guide

## Project Overview
This is a Maven-based Selenium Cucumber BDD (Behavior-Driven Development) project with JUnit test runner.

### Project Structure
```
Seleniumpro/
├── pom.xml                          # Maven configuration
├── src/
│   ├── main/java/helloworld/        # Main application code
│   └── test/
│       ├── java/
│       │   ├── runners/
│       │   │   └── CucumberTestRunner.java
│       │   └── stepDefinitions/
│       │       └── LoginStepDefinitions.java
│       └── resources/
│           └── features/
│               └── login.feature
├── Driver/
│   └── chromedriver.exe
└── target/                          # Build output
```

## Configuration Details

### 1. Dependencies Installed
- **Selenium Java**: 4.43.0
- **Cucumber Java**: 7.14.0
- **Cucumber JUnit**: 7.14.0
- **JUnit**: 4.13.2
- **WebDriverManager**: 5.6.3

### 2. Build Configuration
- **Java Version**: 21
- **Maven Compiler**: 3.11.0
- **Maven Surefire**: 3.0.0 (for running tests)

## How to Run Tests

### Option 1: Using Eclipse (Recommended)
1. **Refresh Project**: Right-click on project → `Maven` → `Update Project`
2. **Run as JUnit Test**:
   - Right-click on `CucumberTestRunner.java`
   - Select `Run As` → `JUnit Test`
3. **View Results**: Results appear in the JUnit view

### Option 2: Using Command Line (Requires Maven)
```bash
# Navigate to project directory
cd C:\Users\LAPTOP\eclipse-workspace\Seleniumpro

# Clean and compile
mvn clean compile

# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=runners.CucumberTestRunner
```

### Option 3: Using Eclipse Maven Integration
1. Right-click on project → `Run As` → `Maven test`
2. Or right-click on project → `Run As` → `Maven clean`

## Feature File Details

### File: `login.feature`
Located at: `src/test/resources/features/login.feature`

Contains two scenarios:
1. **Successful login with valid credentials**
2. **Failed login with invalid credentials**

### Step Definitions
Located at: `src/test/java/stepDefinitions/LoginStepDefinitions.java`

Each Gherkin step is mapped to a Java method:
- `@Given` - Setup/preconditions
- `@When` - User actions
- `@And` - Additional actions
- `@Then` - Verification/assertions

## Test Reports

After running tests, reports are generated in:
- HTML Report: `target/cucumber-reports/cucumber.html`
- JSON Report: `target/cucumber-reports/cucumber.json`

## Important Notes

1. **WebDriverManager**: Automatically handles ChromeDriver setup, no need to manually place driver files
2. **Browser**: Tests are configured to run Chrome browser
3. **Base URL**: Tests navigate to `https://letcode.in/`

## Troubleshooting

### Issue: "Maven not found"
**Solution**: Use Eclipse's built-in Maven or install Maven standalone

### Issue: "ChromeDriver version mismatch"
**Solution**: WebDriverManager automatically handles this

### Issue: Tests not found
**Solution**: 
- Ensure Maven project is recognized in Eclipse
- Right-click → `Configure` → `Convert to Maven Project`
- Refresh project

## Next Steps

1. Update `LoginStepDefinitions.java` with actual Selenium code
2. Locate elements using XPath/CSS selectors
3. Implement login functionality
4. Add more feature files as needed
5. Run and verify tests work correctly

## File Modifications Made

✅ **pom.xml**
- Added WebDriverManager dependency
- Added Maven Compiler Plugin configuration
- Added Maven Surefire Plugin configuration

✅ **LoginStepDefinitions.java**
- Updated to use WebDriverManager instead of manual driver setup
- Improved code best practices

✅ **Feature Structure**
- Already properly configured with features/stepDefinitions/runners pattern

---
**Last Updated**: July 11, 2026
**Java Version**: OpenJDK 21.0.10
