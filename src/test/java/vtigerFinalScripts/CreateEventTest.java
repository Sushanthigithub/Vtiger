package vtigerFinalScripts;

import java.util.Map;

import org.testng.asserts.SoftAssert;

import GenricLibraries.BaseClass;
import GenricLibraries.IConstantPath;

public class CreateEventTest extends BaseClass 
{
  public void createEventTest()
  {
	  SoftAssert soft=new SoftAssert();
	  Map<String,String> map=excel.readFromExcel("EventTestData", "Create New Event");
	  home.selectFromQuickCreate(web, map.get("Quick Create"));
	  soft.assertEquals(createEvent.getPageHeader(), "Create To Do");
	  String subject=map.get("Subject")+jutil.generateRandomNum(100);
	  createEvent.setSubject(subject);
	  createEvent.clickOnStartDate();
	  createEvent.chooseRequiredDate(web, map.get("Start Date"), jutil);
	  createEvent.clickOnDueDate();
	  createEvent.chooseRequiredDate(web, map.get("Due Date"), jutil);
	  createEvent.clickSaveButton();
	  soft.assertTrue(newEventInfo.getPageHeader().contains(subject));
	  if(newEventInfo.getPageHeader().contains(subject))
		   excel.writeToExcel("EventTestData", "Create New Event", "Pass", IConstantPath.EXCEL_PATH);
	   else
	   excel.writeToExcel("EventTestData", "Create New Event", "Fail", IConstantPath.EXCEL_PATH);
	   
	   soft.assertAll(); 
  }
}
