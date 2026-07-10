package helloworld;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Validation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/button");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement display =	driver.findElement(By.xpath("//button[text()='Goto Home']"));
		boolean verify =display.isDisplayed();
		System.out.println(verify);

		boolean verify2=display.isEnabled();
		System.out.println(verify2);

		WebElement dis  =driver.findElement(By.id("isDisabled"));
	boolean check=	dis.isDisplayed();
	System.out.println(check);
	dis.isEnabled();
	System.out.println(dis.isEnabled());
	//driver.close();
	String find=dis.getAttribute("id");
	System.out.println(find.contains("isDisabled"));
	driver.close();
	
	
	ChromeDriver driver2 = new ChromeDriver();
	driver2.get("https://letcode.in/radio");
	driver2.manage().window().maximize();
	driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement ele = driver2.findElement(By.xpath("//div[@class='control']//input[@id='yes']"));
	ele.click();
	boolean yes =ele.isSelected();
	System.out.println(yes);
	driver2.quit();
	






	}

}
