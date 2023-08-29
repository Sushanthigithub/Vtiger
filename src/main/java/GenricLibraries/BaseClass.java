package GenricLibraries;
// this is an example of Baseclass  
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pomPages.ContactsPage;
import pomPages.CreateNewContactPage;
import pomPages.CreateNewEventPage;
import pomPages.CreateNewLeadPage;
import pomPages.CreateNewOrganizationPage;
import pomPages.DuplicatingLeadPage;
import pomPages.HomePage;
import pomPages.LeadsPage;
import pomPages.Loginpage;
import pomPages.NewContactInfoPage;
import pomPages.NewEventInfoPage;
import pomPages.NewLeadInfoPage;
import pomPages.NewOrgInfoPage;
import pomPages.OrganisationPage;

public class BaseClass 
{
   protected PropertiesUtility property;
   protected ExcelUtility excel;
   protected JavaUtility jutil;
   protected webDriverUtility web;
   protected WebDriver driver;
   
   
   protected Loginpage login;
   protected HomePage home;
   protected OrganisationPage org;
   protected ContactsPage contacts;
   protected LeadsPage lead;
   protected CreateNewOrganizationPage  createOrg;
   protected CreateNewContactPage createContact;
   protected CreateNewLeadPage createLead;
   protected CreateNewEventPage createEvent;
   protected NewOrgInfoPage newOrgInfo;
   protected NewContactInfoPage newContactInfo;
   protected NewLeadInfoPage newLeadInfo;
   protected  NewEventInfoPage newEventInfo;
   protected  DuplicatingLeadPage duplicatingLead;
   
   public static WebDriver sdriver;
   public static JavaUtility sjutil;
   
   
   
   //@BeforeSuite
  // @BeforeTest
   
   @BeforeClass
   public void classSetup()
   {
	   property =new PropertiesUtility();
	   excel =new ExcelUtility();
	   jutil=new JavaUtility();
	   web= new webDriverUtility();
	   
	   property.propertiesInitialiation(IConstantPath.PROPERTIES_PATH);
	   driver=web.launchBrowser(property.readFromPropeties("browser"));
	   web.maximizeBrowser();
	   web.waitTilllementFound(Long.parseLong(property.readFromPropeties("time"))); 
	   
	   sdriver=driver;
	   sjutil=jutil;
   }
   
   @BeforeMethod
    public void methodSetup() 
   {
	   excel.excelInitialization(IConstantPath.EXCEL_PATH);
	   
	   login=new Loginpage(driver);
	   home =new  HomePage(driver);
	   org= new OrganisationPage(driver);
	   contacts= new ContactsPage(driver);
	   lead=new LeadsPage(driver);
	   createOrg=new CreateNewOrganizationPage(driver);
	   createContact =new CreateNewContactPage(driver);
	   createLead=new CreateNewLeadPage(driver);
	   createEvent=new CreateNewEventPage(driver);
	   newOrgInfo=new NewOrgInfoPage(driver);
	   newContactInfo=new NewContactInfoPage(driver);
	   newLeadInfo= new NewLeadInfoPage(driver);
	   newEventInfo=new NewEventInfoPage(driver);
	   duplicatingLead=new  DuplicatingLeadPage(driver);
	   
	   web.navigateToApp(property.readFromPropeties("url"));
	   Assert.assertTrue(driver.getTitle().contains("vtiger"));
	   login.loginToApp(property.readFromPropeties("username"),
			   property.readFromPropeties("password"));
	   
	   Assert.assertTrue(driver.getTitle().contains("Home"));   
   }
   
   @AfterMethod
   public void methodTearDown()
   {
	   home.signOutVitger(web);
	   excel.closeExcel();
   }
   @AfterClass
   
   public void classYearDown()
   {
	   web.quitAllWindows();
   }
  // @AfterTest
  // @AfterSuite
   
   
   
}
