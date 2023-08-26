package actionsClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick_Example {

	public static void main(String[] args) throws AWTException, InterruptedException
	{
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
	      driver.get("https://www.ebay.com/");
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      
	      WebElement electronics=driver.findElement(By.xpath("//li/a[text()='Electronics']"));
	      Actions a=new Actions(driver);
	      a.contextClick(electronics).perform();
	      
	      Robot r=new Robot();
	      
	      r.keyPress(KeyEvent.VK_RIGHT);
	      r.keyRelease(KeyEvent.VK_RIGHT);    //VK->virtual key
	      
	      
	      r.keyPress(KeyEvent.VK_ENTER);
	      r.keyRelease(KeyEvent.VK_ENTER);
	      Thread.sleep(3000);
	    //  driver.quit();
	      
	}

}
