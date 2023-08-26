package Pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomPages.Loginpage;

public class VtigerLoginTest {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Loginpage login=new Loginpage(driver);
		login.loginToApp("admin","sushanthi");
		
		if(driver.getTitle().contains("Vtiger"))
			System.out.println("Login Passed");
		else
			System.out.println("Login Failed");
		driver.quit();

	}

}
