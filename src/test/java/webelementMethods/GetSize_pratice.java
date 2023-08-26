package webelementMethods;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetSize_pratice {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://www.swiggy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        WebElement phoneImage=driver.findElement(By.xpath("//img[@class='_2SJnz']"));
        Dimension d=phoneImage.getSize();
        int height=d.getHeight();
        int width=d.getWidth();
        
        System.out.println("heigth: "+height +"\nwidth: "+width);
        driver.close();
        
        
	}

}
