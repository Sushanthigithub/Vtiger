package popups;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Notificationpopup {

	public static void main(String[] args) throws InterruptedException 
	{
	    ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriver driver=new 	ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.get("https://www.ajio.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    Thread.sleep(3000);
	   // driver.quit();

	}

}
