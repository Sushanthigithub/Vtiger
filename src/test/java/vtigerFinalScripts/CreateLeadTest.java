package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenricLibraries.BaseClass;
import GenricLibraries.IConstantPath;

public class CreateLeadTest extends BaseClass 
{
	
   @Test
   public void createLeadTest()
   {
	   
	   SoftAssert soft=new SoftAssert();
	   home.clickLeads();
	   lead.clickPlusButton();
	   soft.assertTrue(driver.getTitle().contains("Leads"));
	   lead.clickPlusButton();
	   soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
	   Map<String,String> map=excel.readFromExcel("LeadTestData", "Create Lead");
	   String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
	    excel.writeToExcel("LeadsTestData", 11, 3, lastName,IConstantPath.EXCEL_PATH);
	   createLead.setLastName(lastName);
	   createLead.setCompantName("Company");
	   createLead.clickSaveButton();
	   soft.assertTrue(newLeadInfo.getPageHeader().contains(lastName));
	   if(newLeadInfo.getPageHeader().contains(lastName))
		   excel.writeToExcel("LeadTestData", "Create Lead", "Pass", IConstantPath.EXCEL_PATH);
	   else
	   excel.writeToExcel("LeadTestData", "Create Lead", "Fail", IConstantPath.EXCEL_PATH);
	   
	   soft.assertAll(); 
   }
   
}
