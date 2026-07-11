package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Assert;

public class LoginStepDefinitions {
    
    private WebDriver driver;
    
    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        // Initialize the WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Configure Chrome options for headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        
        driver = new ChromeDriver(options);
        
        // Navigate to login page
        driver.navigate().to("https://letcode.in/");
        System.out.println("User navigated to login page");
    }
    
    @When("User enters valid email and password")
    public void userEntersValidCredentials() {
        System.out.println("User enters valid email and password");
        // Add Selenium code to enter credentials
    }
    
    @And("User clicks the login button")
    public void userClicksLoginButton() {
        System.out.println("User clicks login button");
        // Add Selenium code to click login button
    }
    
    @Then("User should be redirected to the dashboard")
    public void userRedirectedToDashboard() {
        System.out.println("User is on dashboard");
        Assert.assertTrue(true); // Add actual verification
    }
    
    @When("User enters invalid email and password")
    public void userEntersInvalidCredentials() {
        System.out.println("User enters invalid email and password");
        // Add Selenium code to enter invalid credentials
    }
    
    @Then("User should see an error message")
    public void userSeesErrorMessage() {
        System.out.println("User sees error message");
        Assert.assertTrue(true); // Add actual verification
        
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}
