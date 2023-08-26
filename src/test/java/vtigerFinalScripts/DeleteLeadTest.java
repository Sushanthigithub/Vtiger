package vtigerFinalScripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenricLibraries.BaseClass;
import GenricLibraries.IConstantPath;

public class DeleteLeadTest  extends BaseClass
{
   @Test
   public void deleteLeadTest()
   {
	   SoftAssert soft=new SoftAssert();
	   home.clickLeads();
	   soft.assertTrue(driver.getTitle().contains("Leads"));
	   Map<String,String> map=excel.readFromExcel("LeadTestData", "Delete lead");
	   lead.traverseToRequiredLead(web, map.get("Lead Name"));
	   lead.clickDelete();
	   
	   web.handleAlert("ok");
	   List<WebElement> leadNmaeList=lead.getLeadNamesList();
	   boolean status=false;
	   for(WebElement leads: leadNmaeList) 
	   {
		   if(!leads.getText().equals("Lead4"))
		   {
			   status=true;
		   }
	   }
	   soft.assertTrue(status);
	   if(status)
		   excel.writeToExcel("LeadTestData", "Delete lead", "Pass",IConstantPath.EXCEL_PATH);
	   else
		   excel.writeToExcel("LeadTestData", "Delete lead", "Fail",IConstantPath.EXCEL_PATH);  
	   
	   
	   soft.assertAll();
	      
	   
   }
}
