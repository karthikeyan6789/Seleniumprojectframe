package helloworld;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://letcode.in/droppable");

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());

		driver.switchTo().defaultContent();
		 
		WebElement dragme = driver.findElement(By.id("draggable"));
		WebElement Dropme  = driver.findElement(By.id("droppable"));
		
		Actions Builder = new Actions (driver);
		
		Builder.clickAndHold(dragme).moveToElement(Dropme).release().perform();
		



	}

}
