package helloworld;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/advancedtable");
		
		
		
	}

}
