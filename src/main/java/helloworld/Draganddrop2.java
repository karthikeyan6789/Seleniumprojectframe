package helloworld;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draganddrop2 {

	public static void main(String[] args) {

		// set chromedriver path
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		// open website
		driver.get("https://letcode.in/droppable");

		// get all iframes
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Total frames: " + frames.size());

		// loop through each iframe
		for (int i = 0; i < frames.size(); i++) {

			// go back to main page
			driver.switchTo().defaultContent();

			// switch to iframe i
			driver.switchTo().frame(i);

			// check if draggable exists in this iframe
			List<WebElement> drag = driver.findElements(By.id("draggable"));

			// if found, this is correct iframe
			if (drag.size() >= 0) {

				System.out.println("Correct frame index: " + i);
				
				driver.switchTo().defaultContent();

				// locate elements
				WebElement dragme = driver.findElement(By.id("draggable"));
				WebElement dropme = driver.findElement(By.id("droppable"));

				// perform drag and drop
				Actions act = new Actions(driver);

				act.clickAndHold(dragme)
				   .moveToElement(dropme)
				   .release()
				   .perform();

				break; // stop loop
			}
		}

		// close browser
		//driver.quit();
	}
}