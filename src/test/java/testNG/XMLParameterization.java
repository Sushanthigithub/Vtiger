package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class XMLParameterization 
{
  @Test
  public void vtigerLoginTest(XmlTest xml)
  {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(xml.getParameter("url"));
	  long time= Long.parseLong(xml.getParameter("time"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name"))
		                                  .sendKeys(xml.getParameter("user"));
		driver.findElement(By.name("user_password"))
		                                       .sendKeys(xml.getParameter("pwd"));
		driver.findElement(By.id("submitButton")).click();
		if(driver.getTitle().contains("Home"))
		    System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		driver.quit();
		
  }
}
