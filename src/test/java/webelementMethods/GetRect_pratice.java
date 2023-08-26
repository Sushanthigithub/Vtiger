package webelementMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetRect_pratice
{
   public static void main(String[] args) 
   {
	
	   WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
       driver.get("https://www.myntra.com/");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
       WebElement discount=driver.findElement(By.xpath("//img[contains(@src,'Main-Banner_Desktop_13')]"));
       Rectangle rect=discount.getRect();
       int x=rect.getX();
       int y=rect.getY();
       int height=rect.getHeight();
       int width=rect.getWidth();
       
       System.out.println("X coordinate :"+ x +"\n Y coordinate :"+ y);
       System.out.println("height:"+height+"\n width: "+ width);
       driver.close();
   }
}
