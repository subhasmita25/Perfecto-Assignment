package com.perfectofieldserviceassignment.steps;

import org.testng.annotations.Test;

import com.perfectofieldserviceassignment.pages.FieldservicehomeTestPage;
import com.perfectofieldserviceassignment.pages.FieldserviceitemdetailsTestPage;
import com.perfectofieldserviceassignment.pages.FieldserviceloginTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class TestCaseScenarioSteps extends WebDriverTestCase {
	FieldserviceloginTestPage loginpage=new FieldserviceloginTestPage();
	FieldservicehomeTestPage homepage=new FieldservicehomeTestPage();
	FieldserviceitemdetailsTestPage itemDetailsPage=new FieldserviceitemdetailsTestPage();


	@Test
	public void executionOfTc1()
	{
		//loginpage.uninstallApp();
		//loginpage.installApp();
		//loginpage.launchApp();
		loginpage.login("test@test.com", "test");
		homepage.allowPopup();
		homepage.verifyHomePage();
		homepage.verifyMapInHomePage();
		homepage.verifyItemList();
		homepage.selectItem(0);
		itemDetailsPage.verifyOnItemDetailsPage();
		
	}


}
