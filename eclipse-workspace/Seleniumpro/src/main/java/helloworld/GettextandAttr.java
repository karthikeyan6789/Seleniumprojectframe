package helloworld;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GettextandAttr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");
				
				ChromeDriver driver = new ChromeDriver();
		             driver.get("https://letcode.in/dropdowns");
		             driver.manage().window().maximize();
		             
		             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		             
		             
		    WebElement gett  =  driver.findElement(By.xpath("//h1[text()='Dropdown']"));
		    
	String gettext=	   gett.getText();
	System.out.println(gettext);
	
	//get attribute
	 WebElement att  =   driver.findElement(By.xpath("//label[@class='label'] [contains(text(),'Select the apple ')]"));
	    String str=    att.getAttribute("for");
	System.out.println(str);
  
	
	
	
	
	
	
	
	
	
	
	
	

	}

}
