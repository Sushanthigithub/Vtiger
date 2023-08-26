package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenricLibraries.webDriverUtility;

public class CreateNewOrganizationPage 
{
	//Declaration
    @FindBy(xpath="//span[@class='lvtHeaderText']")
    private WebElement  pageHeader;
    
    @FindBy(name="accountname")
    private WebElement orgNameTF ;
    
    @FindBy(name="industry")
    private WebElement industryDropdown  ;
    
    @FindBy(name="accounttype")
    private WebElement typeDropdown;
    
    @FindBy(xpath="//input[normalize-space(@value)='Save']")
    private WebElement saveButton;
    
    //Initialization
    public CreateNewOrganizationPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    //Utilization
    public String getPageHeader()
    {
    	return pageHeader.getText();
    }
    
    public void setOrgName(String orgName)
    {
    	orgNameTF.sendKeys(orgName);
    }
    
//    public void selectIndustry( webDriverUtility web, String value)
//    {
//    web.selectFromDropdown(industryDropdown,value);
//    	
//    }
    public void selectIndustry(String value)
    {
    	industryDropdown.sendKeys(value);
    }
    
    public void clickSaveButton()
    {
    	saveButton.click();
    }
    
//    public void selectType( webDriverUtility web,String value)
//    {
//    	web.selectFromDropdown( typeDropdown,value);
//    }
    
    public void selectType(String value)
    {
    	typeDropdown.sendKeys(value);
    }
}
