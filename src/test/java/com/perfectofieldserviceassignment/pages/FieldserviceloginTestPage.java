package com.perfectofieldserviceassignment.pages;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class FieldserviceloginTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "loginpage.textbox.username")
	private QAFWebElement loginpageTextboxUsername;
	@FindBy(locator = "loginpage.textbox.password")
	private QAFWebElement loginpageTextboxPassword;
	@FindBy(locator = "loginpage.button.signin")
	private QAFWebElement loginpageButtonSignin;
	@FindBy(locator = "actionbar.button.logout")
	private QAFWebElement actionbarButtonLogout;
	@FindBy(locator = "itemdetailspage.button.back")
	private QAFWebElement itemdetailspageButtonBack;
	@FindBy(locator = "loginpage.button.ok")
	private QAFWebElement loginpageButtonBack;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getLoginpageTextboxUsername() {
		return loginpageTextboxUsername;
	}

	public QAFWebElement getLoginpageTextboxPassword() {
		return loginpageTextboxPassword;
	}

	public QAFWebElement getLoginpageButtonSignin() {
		return loginpageButtonSignin;
	}
	public QAFWebElement getActionbarButtonLogout() {
		return actionbarButtonLogout;
	}
	public QAFWebElement getItemdetailspageButtonBack() {
		return itemdetailspageButtonBack;
	}
	public QAFWebElement getloginpageButtonOk() {
		return loginpageButtonBack;
	}
	@QAFTestStep(description = "user launches the Fieldservice app")
	public void launchApp()
	{
//		Map params = new HashMap<>();		
//		params.put("package", "com.infostretch.sourceapp");	
//		params.put("activity", "com.infostretch.sourceapp.LoginActivity");		
//		driver.executeScript("mobile:activity:open", params);
//		Reporter.log("App launched",true);
		
		
		
		
		Map<String, Object> params = new HashMap<>();
		if(ConfigurationManager.getBundle().getProperty("platform.Name").equals("android"))
		{
		params.put("package", ConfigurationManager.getBundle().getProperty("driver.capabilities.appPackage"));
		params.put("activity", "com.infostretch.sourceapp.LoginActivity");
		driver.executeScript("mobile:activity:open", params);
		}
		else
		{
			params.put("identifier", ConfigurationManager.getBundle().getProperty("driver.capabilities.bundleId"));
			driver.executeScript("mobile:application:open", params);
		}
	}
	
	@QAFTestStep(description = "user is already loggedin logout first")
	public void logoutIfLoggedIn()
	{
		if(actionbarButtonLogout.isPresent())
		{
			getActionbarButtonLogout().click();
			
		}
//		else if(itemdetailspageButtonBack.isPresent())
//		{
//			getItemdetailspageButtonBack().click();
//			getActionbarButtonLogout().click();
//		}
		
		
	}
	@QAFTestStep(description = "user unistalls the application")
	public void uninstallApp()	
	{		
		Map params = new HashMap<>();		   		
		params.put("identifier", "com.infostretch.sourceapp");		 
		driver.executeScript("mobile:application:uninstall", params);	
	}
	@QAFTestStep(description = "installs the application")
	public void installApp()	
	{		
		Map params = new HashMap<>();		  		
		params.put("file", ConfigurationManager.getBundle().getPropertyValue("driver.capabilities.appPath"));		
		params.put("instrument", "noinstrument");		
		driver.executeScript("mobile:application:install", params); 	
	}

	@QAFTestStep(description = "login again with valid username {0} and password {1}")
	public void login(String un,String pwd)
	{
		if(getloginpageButtonOk().isPresent())
		{
			getloginpageButtonOk().click();
		}
		getLoginpageTextboxUsername().verifyPresent();
		getLoginpageTextboxUsername().click();
		getLoginpageTextboxUsername().clear();
		getLoginpageTextboxUsername().sendKeys(un);
		getLoginpageTextboxPassword().click();
		getLoginpageTextboxPassword().clear();
		getLoginpageTextboxPassword().sendKeys(pwd);
		
		loginpageButtonSignin.click();
		
	}
	
	

}
