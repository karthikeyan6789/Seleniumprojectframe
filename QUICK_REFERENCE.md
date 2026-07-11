# Quick Reference: Adding More Tests

## Adding a New Feature File

### Step 1: Create Feature File
Create a new `.feature` file in `src/test/resources/features/`

Example: `src/test/resources/features/checkout.feature`

```gherkin
Feature: Checkout Functionality
  As a user
  I want to checkout my cart
  So that I can complete my purchase

  Scenario: Successful checkout
    Given User has items in cart
    When User clicks checkout
    Then User should see order confirmation
```

## Adding Step Definitions

### Step 1: Create New Step Definition Class
Create in `src/test/java/stepDefinitions/`

Example: `CheckoutStepDefinitions.java`

```java
package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class CheckoutStepDefinitions {
    
    private WebDriver driver;
    
    @Given("User has items in cart")
    public void userHasItemsInCart() {
        // Implementation here
        System.out.println("User has items in cart");
    }
    
    @When("User clicks checkout")
    public void userClicksCheckout() {
        // Implementation here
        System.out.println("User clicks checkout");
    }
    
    @Then("User should see order confirmation")
    public void userSeesOrderConfirmation() {
        // Implementation here
        System.out.println("User sees order confirmation");
        Assert.assertTrue(true);
    }
}
```

## Running Specific Scenarios

### By Tag
Update `CucumberTestRunner.java`:

```java
@CucumberOptions(
    // ... other options ...
    tags = "@checkout"  // Run only scenarios with @checkout tag
)
```

Then add tag to feature file:
```gherkin
@checkout
Scenario: Successful checkout
    ...
```

### By Scenario Name
In Eclipse:
1. Right-click on a specific scenario in the feature file
2. Select `Run As` → `JUnit Test`

## Common Annotations

| Annotation | Purpose | Example |
|-----------|---------|---------|
| `@Before` | Setup before scenario | Database connection |
| `@After` | Cleanup after scenario | Close browser, delete data |
| `@Given` | Precondition | User is on login page |
| `@When` | Action | User clicks button |
| `@Then` | Verification | User sees message |
| `@And` | Additional step | Can follow any step |

## Best Practices

1. **One responsibility per step**: Each step should do one thing
2. **Use Page Object Model**: For larger projects
3. **Share driver instance**: Use hooks or constructor injection
4. **Descriptive scenarios**: Make them readable for non-technical stakeholders
5. **Avoid hard-coding**: Use feature file data or external data sources

## Useful Commands

```bash
# Run all tests
mvn clean test

# Run specific test class
mvn test -Dtest=runners.CucumberTestRunner

# Run with specific tag
mvn test -Dgroups=@smoke

# Generate HTML report
mvn clean test surefire-report:report
```

---

For more help, refer to:
- Cucumber Documentation: https://cucumber.io/docs/cucumber/
- Selenium Documentation: https://www.selenium.dev/documentation/
