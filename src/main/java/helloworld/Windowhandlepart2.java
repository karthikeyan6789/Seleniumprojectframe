package helloworld;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandlepart2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		String parenthandle=driver.getWindowHandle();
		System.out.println(parenthandle);
		WebElement ele=	driver.findElement(By.id("home"));
		ele.click();
	Set<String> childhandles=	driver.getWindowHandles();
	int size= childhandles.size();
	System.out.println(size);
	
	      for (String window : childhandles) {
	    	  if (!window.equals(parenthandle)) {
				driver.switchTo().window(window);
				
				String sti=driver.getTitle();
				System.out.println(sti);
				driver.getCurrentUrl();
				System.out.println(driver.getCurrentUrl());
				System.out.println(childhandles);
				
				
			}
			
			
			driver.switchTo().window(parenthandle);
		String current =	driver.getCurrentUrl();
		System.out.println(current);
			
			
		
			
		}
		
		
		
		
		


	}



}


