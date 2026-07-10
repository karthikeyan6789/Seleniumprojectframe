package helloworld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesConcepts {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
		        "C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://letcode.in/frame");
		
		driver.manage().window().maximize();
		
	WebElement frames =	driver.findElement(By.id("firstFr"));

		       driver.switchTo().frame(frames);
		    WebElement gett= driver.findElement(By.name("fname"));
		    gett.sendKeys("mr karthik");
	String value  =	 gett.getAttribute("value");
		System.out.println(value);
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Karthikeyan@gmail.com");
		//driver.switchTo().parentFrame().switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[contains(text(),'Watch tutorial')]")).click();
		    
		       

	}

}
