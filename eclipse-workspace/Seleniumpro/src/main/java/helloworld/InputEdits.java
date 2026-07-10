package helloworld;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputEdits {


	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");
		
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/edit");
        driver.findElement(By.id("fullName")).sendKeys("MR Karthi");
        
        WebElement string =driver.findElement(By.xpath("//input[@id='join']"));
        string.sendKeys("i am back");
         string.sendKeys(Keys.TAB);
         
         String text = driver.findElement(By.id("getMe")).getAttribute("value");
         System.out.println(text);
                
      WebElement clear =  driver.findElement(By.id("clearMe"));
      clear.clear();
      
      boolean bool = driver.findElement(By.id("noEdit")).isEnabled();
       System.out.println(bool);
       
       String val=driver.findElement(By.id("dontwrite")).getAttribute("readonly");
       System.out.println(val);
      
      
        
        

	}

}
