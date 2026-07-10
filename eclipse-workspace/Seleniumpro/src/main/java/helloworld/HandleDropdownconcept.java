package helloworld;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdownconcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
             driver.get("https://letcode.in/dropdowns");
             
             driver.manage().window().maximize();
             
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     WebElement fruits= driver.findElement(By.id("fruits"));
     
     Select fruits1 = new Select(fruits);
     fruits1.selectByVisibleText("Apple");
     Thread.sleep(3000);
     fruits1.selectByIndex(2);
  WebElement selected = fruits1.getFirstSelectedOption();
  selected.getText();
  System.out.println(selected.getText());
  
  
 WebElement country= driver.findElement(By.id("country"));
  
 Select countrys = new Select(country);
 countrys.selectByVisibleText("India");
 WebElement text =countrys.getFirstSelectedOption();
 text.getText();
 System.out.println(text.getText());
 
 WebElement heroes=driver.findElement(By.id("superheros"));
  Select hero = new  Select (heroes);
  boolean find=   hero.isMultiple();
  System.out.println(find);
  hero.selectByIndex(1);
  hero.selectByValue("bt");
  hero.selectByVisibleText("The Avengers");
  Thread.sleep(2000);
 List<WebElement> allhero = hero.getAllSelectedOptions();
  for (int i = 0; i < allhero.size() ; i++) {
	  
	  hero.selectByIndex(i);
	
	  
	
}
 
  
  
  
  WebElement langs = driver.findElement(By.id("lang"));
  Select lang = new  Select (langs);
  lang.selectByIndex(4);
  Thread.sleep(2000);
  lang.getAllSelectedOptions();
  
 
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
             
		
		
		
		
	}

}
