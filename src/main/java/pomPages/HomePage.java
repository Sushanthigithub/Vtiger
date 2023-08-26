package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenricLibraries.webDriverUtility;

public class HomePage {
	// Declaration
	@FindBy(xpath = "//a[text()='Leads'and contains(@href,'action=index')]")
	private WebElement leadTab;
	@FindBy(xpath = "//a[text()='Organizations'and contains(@href,'action=index')]")
	private WebElement orgainsationsTab;
	@FindBy(xpath = "//a[text()='Contacts'and contains(@href,'action=index')]")
	private WebElement contactsTab;
	@FindBy(id = "qccombo")
	private WebElement quickCreateDropdown;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutButton;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public  void clickLeads()
	{
		leadTab.click();
	}
	
	public  void clickorganisations()
	{
		orgainsationsTab.click();
	}
	
	public  void clickContacts()
	{
		contactsTab.click();
	}
	
	public void selectFromQuickCreate(webDriverUtility web,String value)
	{
		web.selectFromDropdown(quickCreateDropdown,value);
	}
	public void signOutVitger(webDriverUtility web)
	{
		web.mouseHover(adminIcon);
	}
	
	

}
