package popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileuploadUsing_SendKeys {

	public static void main(String[] args)
	{
		
		WebDriver driver=new 	ChromeDriver();
	    driver.manage().window().maximize();
	   driver.get(" https://www.foundit.in/");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	   driver.findElement(By.xpath("//div[normalize-space(text())='Upload Resume']")).click();
	   driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\HOME\\Downloads\\WhatsApp Image 2023-07-12 at 9.16.33 PM.jpeg");
	   
	   driver.quit();
	   

	}

}
