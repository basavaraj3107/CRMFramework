package com.comcast.crm.createleadtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewLeadPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadInformationPage;
import com.comcast.crm.objectrepositoryutility.LeadsPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;

public class CreateLeadTest extends BaseClass{
	@Test
	public void createLead() throws Throwable {
		String lastName = eLib.getDataFromExcelFile("Leads", 1, 2);
		String orgName = eLib.getDataFromExcelFile("Leads", 1, 3);
		String opportunityName = eLib.getDataFromExcelFile("Leads", 1, 4);
		
		//Navigate to Leads
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();
		
		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();
		
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createLead(lastName, orgName);
		
		// Verify leads details
		LeadInformationPage lip = new LeadInformationPage(driver);
		boolean isContains =wLib.verifyTextOfElementContainsExpectedText(lip.getHeaderMsg(), lastName);
		Assert.assertTrue(isContains);
		boolean isEquals = wLib.verifyTextOfElementEqualsExpectedText(lip.getLastNameTxt(), lastName);
		Assert.assertTrue(isEquals);
		isEquals = wLib.verifyTextOfElementEqualsExpectedText(lip.getCompanyTxt(), orgName);
		Assert.assertTrue(isEquals);
		
		lip.getConvertLeadLnk().click();
		wLib.waitForElementPresent(driver, lip.getConvertLeadPopupHdr());
		isContains =wLib.verifyTextOfElementContainsExpectedText(lip.getConvertLeadPopupHdr(), lastName);
		Assert.assertTrue(isContains);
				
		lip.getOpportunityCheckBox().click();
		lip.getOpportunityNameEdt().clear();
		lip.getOpportunityNameEdt().sendKeys(opportunityName);
		String expectedClosedate = jLib.getRequiredDateInSpecifiedFormat("yyyy-MM-dd", 7);
		lip.getExpectedCloseDateEdt().sendKeys(expectedClosedate);
		lip.getSaveBtn().click();
			
		//Verify Org Name
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		isContains =wLib.verifyTextOfElementContainsExpectedText(oip.getHeaderMsg(), orgName);
		Assert.assertTrue(isContains);
	}
}
