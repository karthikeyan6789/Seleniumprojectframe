package helloworld;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesconcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String url =driver.getCurrentUrl();
		System.out.println(url);
		String windowhandle=	driver.getWindowHandle();
		System.out.println(windowhandle);

		WebElement windows=	driver.findElement(By.id("home"));
		windows.click();
		Set<String>handles=driver.getWindowHandles();
		System.out.println(handles);
		List<String> mylist= new ArrayList<String>(handles);
		WebDriver found=driver.switchTo().window(mylist.get(1));
		System.out.println(found);

		
		//found1.getCurrentUrl();
		//System.out.println(found1.getCurrentUrl());
		//driver.close();
		

		
		
		
		
		






	}

}
