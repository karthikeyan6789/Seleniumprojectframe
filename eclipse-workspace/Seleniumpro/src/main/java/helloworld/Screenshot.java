package helloworld;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


public class Screenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/button");
		
		TakesScreenshot tsc =(TakesScreenshot) driver;
		  File src =tsc.getScreenshotAs(OutputType.FILE);
		  
		 File des = new File("./Snaps/img.png");
		 FileHandler.copy(src, des);
		  
		 
		WebElement ele = driver.findElement(By.id("home"));
		File src1 = ele.getScreenshotAs(OutputType.FILE);
		
		File des1= new  File("./Snaps/img1.png");
		FileHandler.copy(src1, des1);
		
	WebElement ele1 =driver.findElement(By.xpath("(//span[@class='icon']/following::div[@class='card-content'])[2]"));
	
	File src2= ele1.getScreenshotAs(OutputType.FILE);
		
	File des2 = new File("C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Snaps\\img4.png");
	FileHandler.copy(src2, des2);
		
		
	
		

	}

}
