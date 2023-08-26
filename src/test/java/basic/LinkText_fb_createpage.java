package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText_fb_createpage
{

	public static void main(String[] args) throws Exception {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Create a Page")).click();
		Thread.sleep(4000);
		driver.close();
	}
}
