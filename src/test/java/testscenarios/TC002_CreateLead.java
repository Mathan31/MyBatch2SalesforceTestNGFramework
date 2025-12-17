package testscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC002_CreateLead extends BaseClass{
	
		
	@Test(priority = 1)
	public void createSalesLeadWithmandatoryFields() {
		boolean result = new LoginPage()
		.enterUserName("mathan@credosystemz.sanbox")
		.enterPassword("Mylearning$7")
		.clickOnLogin()
		.verifyHomeElement()
		.clickOnAppLauncher()
		.clickOnViewAll()
		.clickOnSales()
		.clickOnLeadsLink()
		.clickOnNewButton()
		.enterLastName("KVInfoAutomation1")
		.clickAndSelectLeadStatus()
		.enterCompanyName("KVInfo")
		.clickOnSaveButton()
		.clickUserImg()
		.clickLogout()
		.verifyLoginElements();
		
		Assert.assertEquals(result, true);
		
	}

}
