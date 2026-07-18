package helloworld;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Button3 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LAPTOP\\eclipse-workspace\\Seleniumpro\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/button");
        WebElement point =driver.findElement(By.xpath("//button[@id='position']"));
        Point getvalue = point.getLocation();

        int x =getvalue.getX();
        int y =getvalue.getY();
        System.out.println("xvalue"+  x);
        System.out.println("yvalue"+  y);

        WebElement color =driver.findElement(By.id("color"));
        color.getCssValue("bulma-button-color");
        System.out.println(color);


        Rectangle rect =driver.findElement(By.id("property")).getRect();
        Dimension dimension=   rect.getDimension();
        System.out.println(dimension);


        boolean res= driver.findElement(By.id("isDisabled")).isEnabled();
        System.out.println(res);

        WebElement button = driver.findElement(By.xpath("//h2[contains(text(),'Button Hold!')]"));
        Actions action = new Actions(driver);
        action.clickAndHold(button).perform();
        action.release().perform();
        boolean dis =button.isEnabled();
        System.out.println(dis);




    }

}
