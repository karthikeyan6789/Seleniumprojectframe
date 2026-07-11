package helloworld;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Contextmenus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
             driver.get("https://the-internet.herokuapp.com/context_menu");
             
             driver.manage().window().maximize();
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
             
        WebElement ele =  driver.findElement(By.id("hot-spot"));
        
        
        Actions act = new Actions(driver);
             act.contextClick(ele).perform();
      Alert gettx=  driver.switchTo().alert();
     String text= gettx.getText();
     System.out.println(text);
     
      gettx.accept();
        
             
             

	}

}
