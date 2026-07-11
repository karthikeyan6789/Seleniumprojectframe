package helloworld;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsconcpets {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/edit");
		List<WebElement> labels = driver.findElements(By.tagName("label"));
		int siz = labels.size();
		System.out.println(siz);


		for (int i = 0; i < labels.size(); i++) {
			int get= labels.size();
			System.out.println(get);

			break;
		}





		for (WebElement label  : labels) {
			String gettx= label.getText();
			System.out.println(gettx);

		}
		for (WebElement label : labels) {
			String value=	label.getAttribute("class");
			boolean bool=   value.contains("google_esf");
			
			System.out.println(value);
			System.out.println(bool);



		}


		int siz1 = labels.size();
		if(siz1 == 6) {

			System.out.println("test case is passed coorect");
		} else 
			System.out.println("test case faile");

	}



}
