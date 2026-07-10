package helloworld;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DraganddropBy {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
             driver.get("https://jqueryui.com/draggable/");
             
             driver.manage().window().maximize();
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
             
        List<WebElement> frame= driver.findElements(By.tagName("iframe"));
        System.out.println(frame.size());
             
             driver.switchTo().frame(0);
             
       WebElement dra  = driver.findElement(By.id("draggable"));
       
       Actions act = new Actions(driver);
       
       int x=dra.getLocation().getX();
       int y=dra.getLocation().getY();
       
       act.dragAndDropBy(dra, x+70, y+90).perform();
             
             
             
             
             
             
             
	}

}
