package webelementMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitingDriverSpace_pratice {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
       driver.get("https://www.amazon.com/");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
       
       WebElement footer=driver.findElement(By.xpath("//div[@class='navFooterVerticalRow navAccessibility']"));
       
       List<WebElement> footerlink=footer.findElements(By.tagName("a"));
       for(WebElement link:footerlink)
       {
    	   System.out.println(link.getText());
       }
       
     //driver.quit();
	}

}
