package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTextPratice {

	public static void main(String[] args) throws Exception
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Forgotten password?")).click();
		Thread.sleep(4000);
		driver.close();
	}
}
