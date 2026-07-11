# Advanced Configuration: Hooks and Utilities

## Creating Hooks for Setup/Teardown

Create a new file: `src/test/java/stepDefinitions/Hooks.java`

```java
package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    
    public static WebDriver driver;
    
    @Before
    public void setUp() {
        System.out.println("============ Starting Test ============");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @After
    public void tearDown() {
        System.out.println("============ Ending Test ============");
        if (driver != null) {
            driver.quit();
        }
    }
}
```

## Creating a Base Class (Optional)

Create: `src/test/java/stepDefinitions/BaseClass.java`

```java
package stepDefinitions;

import org.openqa.selenium.WebDriver;

public class BaseClass {
    
    protected WebDriver driver;
    
    public BaseClass() {
        // Get driver from Hooks
        this.driver = Hooks.driver;
    }
}
```

## Updated Step Definitions Using Base Class

```java
package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginStepDefinitions extends BaseClass {
    
    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        driver.navigate().to("https://letcode.in/");
        System.out.println("User navigated to login page");
    }
    
    // ... rest of methods ...
}
```

## Updated CucumberTestRunner

Update `@CucumberOptions` to include hooks package:

```java
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions"},  // This will find both Hooks and Step Definitions
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"
    },
    monochrome = true,
    dryRun = false,
    tags = ""
)
```

## Creating Utility Classes

### 1. Wait Utility: `src/test/java/utilities/WaitUtils.java`

```java
package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {
    
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public static void waitForUrlToContain(WebDriver driver, String urlPortion) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(urlPortion));
    }
}
```

### 2. Element Actions Utility: `src/test/java/utilities/ElementActions.java`

```java
package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementActions {
    
    public static void click(WebDriver driver, By locator) {
        WaitUtils.waitForElementToBeClickable(driver, locator).click();
    }
    
    public static void sendKeys(WebDriver driver, By locator, String text) {
        WaitUtils.waitForElementToBeVisible(driver, locator).sendKeys(text);
    }
    
    public static String getText(WebDriver driver, By locator) {
        return WaitUtils.waitForElementToBeVisible(driver, locator).getText();
    }
    
    public static void doubleClick(WebDriver driver, By locator) {
        WebElement element = WaitUtils.waitForElementToBeClickable(driver, locator);
        new Actions(driver).doubleClick(element).perform();
    }
    
    public static void mouseHover(WebDriver driver, By locator) {
        WebElement element = WaitUtils.waitForElementToBeVisible(driver, locator);
        new Actions(driver).moveToElement(element).perform();
    }
}
```

## Using Utilities in Step Definitions

```java
package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import utilities.ElementActions;

public class LoginStepDefinitions extends BaseClass {
    
    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        driver.navigate().to("https://letcode.in/");
    }
    
    @When("User enters email")
    public void userEntersEmail() {
        ElementActions.sendKeys(driver, By.id("email"), "user@example.com");
    }
    
    @When("User clicks login")
    public void userClicksLogin() {
        ElementActions.click(driver, By.xpath("//button[@type='submit']"));
    }
}
```

## Updated pom.xml for Utilities

Add this to `<build><plugins>` in pom.xml if not already present:

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.11.0</version>
    <configuration>
        <source>21</source>
        <target>21</target>
    </configuration>
</plugin>
```

## Directory Structure with Utilities

```
src/
├── main/
│   └── java/helloworld/
└── test/
    ├── java/
    │   ├── runners/
    │   │   └── CucumberTestRunner.java
    │   ├── stepDefinitions/
    │   │   ├── BaseClass.java
    │   │   ├── Hooks.java
    │   │   ├── LoginStepDefinitions.java
    │   │   └── CheckoutStepDefinitions.java
    │   └── utilities/
    │       ├── ElementActions.java
    │       ├── WaitUtils.java
    │       └── ConfigReader.java
    └── resources/
        ├── features/
        │   ├── login.feature
        │   └── checkout.feature
        └── config.properties
```

## Running Tests from Eclipse

1. **Right-click test runner class** → `Run As` → `JUnit Test`
2. **View in JUnit panel** with pass/fail status
3. **Check console output** for logs
4. **View reports** in `target/cucumber-reports/`

---

This structure makes your project more maintainable and scalable!
