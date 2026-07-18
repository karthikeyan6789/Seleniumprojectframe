package hellowworld2;


	

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hello {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 
		driver.get("https://letcode.in/alert");
		
		 driver.findElement(By.id("confirm")).click();
		Alert ale =  driver.switchTo().alert();
		String string =ale.getText();
		System.out.println(string);
		ale.accept();
		
		
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//driver.findElement(By.id("prompt")).click();
		driver.findElement(By.xpath("//button[@id='prompt']")).click();
		Alert ale2 =driver.switchTo().alert();
		ale2.sendKeys("karthik");
		String val = ale2.getText();
		System.out.println(val);
		ale2.accept();
      String text = driver.findElement(By.xpath("//p[@id='myName']")).getText();
	System.out.println(text);
	
		//ale2.accept();
		//String val = ale2.getText();
		//System.out.println(val);
		
		
	

	}

}



