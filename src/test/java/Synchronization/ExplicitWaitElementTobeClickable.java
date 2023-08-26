package Synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitElementTobeClickable {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement loginbutton= driver.findElement(By.xpath("//button[.='Log in']"));
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
		}catch(Exception e) {
			System.out.println("element disabled");
			
		}
		
		driver.close();

	}

}
