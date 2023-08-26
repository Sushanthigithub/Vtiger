package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenricLibraries.BaseClass;
import GenricLibraries.IConstantPath;

public class CreateOrgwithTypeAndIndustry  extends BaseClass
{
	@Test
	public void CreateOrgwithIndustryAndTypeTest()
	{
		SoftAssert soft = new SoftAssert();
		home.clickorganisations();
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		org.clickPlusButton();
		soft.assertTrue(createOrg.getPageHeader().equals("Creating New Organization"));
		Map<String,String> map=excel.readFromExcel("OrganizationTestData", "Create Organization");
		   String orgName=map.get("Organization Name")+jutil.generateRandomNum(100);
		   createOrg.setOrgName(orgName);
		   
		   createOrg.selectIndustry(("Industry"));
		   createOrg.selectType(("Type"));
		   createOrg.clickSaveButton();
		   
		   
		   soft.assertTrue(newOrgInfo.getPageHeader().contains(orgName));
		   if(newOrgInfo.getPageHeader().contains(orgName))
			   excel.writeToExcel("OrganizationTestData", "Create Organization With Industry And Type", "Pass", IConstantPath.EXCEL_PATH);
		   else
			   excel.writeToExcel("OrganizationTestData", "Create Organization With Industry And Type", "Fail", IConstantPath.EXCEL_PATH);
		   
		  soft.assertAll();
	}
}
