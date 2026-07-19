package helloworld;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class button {

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");
		
        ChromeDriver driver = new ChromeDriver();
         driver.get("https://letcode.in");
        
        driver.findElement(By.partialLinkText("Explore Workspace")).click();

        driver.findElement(By.partialLinkText("Cli")).click();
        
        driver.findElement(By.xpath("//button[@id='home']")).click();
        driver.navigate().to("https://letcode.in/button");
      String curenturl=  driver.getCurrentUrl();
      System.out.println("homepageurl" + curenturl);
	}
}
