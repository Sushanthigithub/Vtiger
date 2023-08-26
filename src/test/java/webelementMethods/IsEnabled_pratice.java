package webelementMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsEnabled_pratice {

	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
       driver.get("https://www.instagram.com/");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
       WebElement loginButton = driver.findElement(By.xpath("//button[.='Log in']"));
       if(loginButton.isEnabled())
    	   System.out.println("Enabled");
       else
    	   System.out.println("Disabled");
       
       driver.findElement(By.name("username")).sendKeys("4567894568");
       driver.findElement(By.name("password")).sendKeys("6543798776");
       
       if(loginButton.isEnabled())
       {
    	   System.out.println("Enabled");
    	   loginButton.click();
       }
       else
       {
    	   System.out.println("Disabled");
       }
	}

}
