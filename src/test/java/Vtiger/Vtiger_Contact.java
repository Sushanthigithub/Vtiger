package Vtiger;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Vtiger_Contact {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe" );
		WebDriver driver=new 	ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://localhost:8888/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    if(driver.getTitle().contains("vtiger"))
	    	System.out.println("Login Page Displayed");
	    else
	    	System.out.println("Login Page Not Found");
	    
	    driver.findElement(By.name("user_name")).sendKeys("admin");
	    driver.findElement(By.name("user_password")).sendKeys("sushanthi");
	    driver.findElement(By.id("submitButton")).submit();
	    
	    if(driver.getTitle().contains("Home"))
	    	System.out.println("Home Page Displayed");
	    else
	    	System.out.println("Home Page Not Found");
	    
	    driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	    
	    if(driver.getTitle().contains("Contacts"))
	    	System.out.println("Contacts Page Displayed");
	    else
	    	System.out.println("Contacts Page Not Found");
	   
	    driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	    
	    WebElement createcontct= driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
	    
	   // if(createcontct.getText().equals("Creating New Contact"))
	    if(createcontct.isDisplayed())
	    	System.out.println("Creating New Contacts Page Displayed");
	    else
	    	System.out.println("Creating New Contacts Page Not Found");
	    
	    
		   Random random=new Random();
		   int randomnum=random.nextInt(100);
		    
		   String lastName="Harika"+randomnum;
	    driver.findElement(By.name("lastname")).sendKeys(lastName);
	    driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
	    
	    String Headertext=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    
	    if(Headertext.contains(lastName))
	    	System.out.println("Contacts Created successfully");
	    else
	    	System.out.println("Contacts not created");
	    
	    WebElement  adminicon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions a=new Actions(driver);
	    a.moveToElement(adminicon).perform();
	    
	   driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    

	    
	}

}
