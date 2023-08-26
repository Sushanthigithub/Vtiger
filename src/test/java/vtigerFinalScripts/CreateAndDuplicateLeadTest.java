package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenricLibraries.BaseClass;
import GenricLibraries.IConstantPath;

public class CreateAndDuplicateLeadTest extends BaseClass 
{
   @Test
   public void createAndDuplicateLeadTest()
   {
	   SoftAssert soft=new SoftAssert();
	   home.clickLeads();
	   lead.clickPlusButton();
	   soft.assertTrue(driver.getTitle().contains("Leads"));
	   lead.clickPlusButton();
	   soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
	   Map<String,String> map=excel.readFromExcel("LeadTestData", "Create and Duplicate Lead");
	   String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
	   createLead.setLastName(lastName);
	   createLead.setCompantName("Company");
	   createLead.clickSaveButton();
	   soft.assertTrue(newLeadInfo.getPageHeader().contains(lastName));
	   newLeadInfo.clickDuplicateButton();
	   soft.assertTrue(duplicatingLead.getPageHeader().contains("Duplicating"));
	   String newLastName=map.get("New Last Name")+jutil.generateRandomNum(100);
	   duplicatingLead.setLastName(newLastName);
	   duplicatingLead.clickSaveButton();
	   if(newLeadInfo.getPageHeader().contains(newLastName))
		   excel.writeToExcel("LeadTestData", "Create and Duplicate Lead", "Pass", IConstantPath.EXCEL_PATH);
	   else
	   excel.writeToExcel("LeadTestData", "Create and Duplicate Lead", "Fail", IConstantPath.EXCEL_PATH);
	   
	   soft.assertAll(); 
   }
}
