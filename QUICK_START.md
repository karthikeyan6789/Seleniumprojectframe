# 🚀 QUICK START - Run Your First Test

## Step-by-Step: Execute Tests in Eclipse

### Step 1: Refresh Maven Project
1. In Eclipse, right-click on **Seleniumpro** project
2. Select: **Maven** → **Update Project**
3. Click **OK** (wait for downloads to complete)

### Step 2: Run Test via JUnit
1. Navigate to: `src/test/java/runners/CucumberTestRunner.java`
2. Right-click on the file
3. Select: **Run As** → **JUnit Test**

### Step 3: View Results

**Option A: JUnit Panel (Recommended)**
- Look for the "JUnit" tab at the bottom of Eclipse
- You'll see:
  - Green bar = ✅ Tests passed
  - Red bar = ❌ Tests failed
  - Test count displayed

**Option B: Console Output**
- Click the "Console" tab
- Scroll to see execution logs:
  ```
  User navigated to login page
  User enters valid email and password
  User clicks login button
  User is on dashboard
  ```

### Step 4: View Test Reports
After tests complete:
1. Navigate to: `target/cucumber-reports/cucumber.html`
2. Double-click to open in browser
3. View detailed test report with screenshots (if added)

---

## 📋 What's Configured

✅ **Feature File**: `login.feature`  
✅ **Step Definitions**: `LoginStepDefinitions.java`  
✅ **Test Runner**: `CucumberTestRunner.java`  
✅ **Dependencies**: All Selenium & Cucumber libraries  
✅ **WebDriver**: Auto-managed by WebDriverManager  

---

## 🔧 Common Issues & Solutions

### Issue 1: "CucumberTestRunner not found"
**Solution**: 
- Right-click project → Maven → Update Project
- Clean and rebuild project

### Issue 2: "Step implementation not found"
**Solution**:
- Check glue path in CucumberTestRunner: `glue = {"stepDefinitions"}`
- Ensure step definitions package is named exactly: `stepDefinitions`

### Issue 3: "No tests executed"
**Solution**:
- Right-click on CucumberTestRunner.java → Run As → JUnit Test
- DO NOT try to run .feature files directly

---

## 📝 Customizing Tests

### Want to add a new scenario?
1. Edit: `src/test/resources/features/login.feature`
2. Add your scenario in Gherkin format
3. Implement steps in: `LoginStepDefinitions.java`
4. Run tests again

### Want to create a new test suite?
1. Create new .feature file in: `src/test/resources/features/`
2. Create new step definitions class in: `src/test/java/stepDefinitions/`
3. JUnit automatically discovers all scenarios

---

## 📦 Project Dependencies

```
✅ Selenium 4.43.0
✅ Cucumber Java 7.14.0
✅ Cucumber JUnit 7.14.0
✅ JUnit 4.13.2
✅ WebDriverManager 5.6.3
✅ Java 21
```

---

## 🎯 Test Execution Flow

```
CucumberTestRunner (JUnit Entry Point)
    ↓
Reads login.feature file
    ↓
Finds matching step definitions
    ↓
Executes @Given steps (setup)
    ↓
Executes @When steps (actions)
    ↓
Executes @Then steps (verification)
    ↓
Generates HTML/JSON reports
    ↓
✅ Test Complete
```

---

## 📂 Important Files

| File | Purpose |
|------|---------|
| `login.feature` | Test scenarios in readable format |
| `LoginStepDefinitions.java` | Implementation of test steps |
| `CucumberTestRunner.java` | JUnit test entry point |
| `pom.xml` | Project configuration & dependencies |

---

## ✅ Pre-Execution Checklist

- [ ] Eclipse opened and project loaded
- [ ] Right-click project → Maven → Update Project completed
- [ ] No red error marks on project
- [ ] Java is OpenJDK 21 (verified earlier)
- [ ] All .md documentation files visible in project

---

## 🎬 You're Ready!

**Everything is configured. Now:**

1. Right-click: `CucumberTestRunner.java`
2. Select: `Run As` → `JUnit Test`
3. Watch it execute! 🚀

---

## 📞 Need Help?

Refer to:
- `SETUP_AND_RUN_GUIDE.md` - Complete setup guide
- `QUICK_REFERENCE.md` - How to add more tests
- `ADVANCED_SETUP.md` - Advanced configurations
- `PROJECT_CONFIGURATION_SUMMARY.md` - Full summary

---

**Happy Testing! 🧪**
