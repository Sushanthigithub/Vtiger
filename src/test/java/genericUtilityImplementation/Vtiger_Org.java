package genericUtilityImplementation;

import java.time.Duration;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import GenricLibraries.ExcelUtility;
import GenricLibraries.IConstantPath;
import GenricLibraries.JavaUtility;
import GenricLibraries.PropertiesUtility;
import GenricLibraries.webDriverUtility;

public class Vtiger_Org {

	public static void main(String[] args)
	{
		PropertiesUtility property=new PropertiesUtility();
		ExcelUtility excel=new ExcelUtility();
		JavaUtility jutil=new JavaUtility();
		webDriverUtility webUtil=new  webDriverUtility();
		
		property.propertiesInitialiation(IConstantPath.PROPERTIES_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_PATH);
		
		 
//		WebDriver driver=new 	ChromeDriver();
//	    driver.manage().window().maximize();
//	    driver.get("http://localhost:8888/");
//	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriver driver=webUtil.launchBrowser(property.readFromPropeties("browser"));
		webUtil.maximizeBrowser();
		webUtil.navigateToApp(property.readFromPropeties("url"));
		webUtil.waitTilllementFound(Long.parseLong(property.readFromPropeties("time")));
				
	    
	    if(driver.getTitle().contains("vtiger"))
	    	System.out.println("Login Page Displayed");
	    else
	    	System.out.println("Login Page Not Found");
	    
	    driver.findElement(By.name("user_name")).sendKeys(property.readFromPropeties("username"));
	    driver.findElement(By.name("user_password")).sendKeys(property.readFromPropeties("password"));
	    driver.findElement(By.id("submitButton")).submit();
	    
	    
	    if(driver.getTitle().contains("Home"))
	    	System.out.println("Home Page Displayed");
	    else
	    	System.out.println("Home Page Not Found");
	    
	    driver.findElement(By.xpath("//a[text()='Organizations' and contains(@href,'action=index')]")).click();
	    
	    if(driver.getTitle().contains("Organizations"))
	    	System.out.println("Organization Page Displayed");
	    else
	    	System.out.println("Organization Page Not Found");
	    
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    
	    WebElement createorg= driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
	    
	    if(createorg.getText().equals("Creating New Organization"))
	    	System.out.println("Creating New Organization Page Displayed");
	    else
	    	System.out.println("Creating New Organization Page Not Found");

	    
//	   Random random=new Random();
//	   int randomnum=random.nextInt(100);
	                                                     //sheet name        //test casename
	    Map<String,String> map=excel.readFromExcel("OrganisationTestData","Create Organisation" );
	    String OrgName=map.get("Organisation Name")+jutil.generateRandomNum(100);
	  
	   driver.findElement(By.name("accountname")).sendKeys(OrgName);
	   driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
	   
	   
	   String NewOrgInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	   
	   if(NewOrgInfo.contains(OrgName)) {
	    	System.out.println("Organization Created successfully");
	   excel.writeToExcel("OrganisationTestData", "Create Organisation", "Pass",IConstantPath.EXCEL_PATH);
	   }
	   else
	    {
	    	System.out.println("Organization not created");
	   excel.writeToExcel("OrganisationTestData", "Create Organisation", "Fail",IConstantPath.EXCEL_PATH);
	    }
	   
	    WebElement  adminicon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//	    Actions a=new Actions(driver);
//	    a.moveToElement(adminicon).perform();
	    webUtil.mouseHover(adminicon);
	    
	   driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	   
	   // driver.quit();
	   webUtil.quitAllWindows();
	   excel.closeExcel();

	}

}
