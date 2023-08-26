package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage 
{
	//Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement plusButton;
	
	
	//Initialization
	public OrganisationPage(WebDriver driver)
	{
     PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public void clickPlusButton()
	{
		plusButton.click();
	}
	

}
