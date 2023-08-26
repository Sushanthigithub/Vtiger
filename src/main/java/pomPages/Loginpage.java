package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage
{
  // (1) Declaration
	@FindBy(name="user_name")   //vtiger inspect username  
	private WebElement usernameTF;    //TF=textfield
	
	@FindBy(name="user_password")    
	private WebElement passwordTF;
	
	@FindBy(id="submitButton")   
	private WebElement loginButton;
	
	// (2) Initialization
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// (3) Utilization
	public void loginToApp(String username, String password)
	{
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginButton.submit();
		
		
		
	}
	
}
