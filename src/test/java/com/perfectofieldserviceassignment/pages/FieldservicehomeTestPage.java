package com.perfectofieldserviceassignment.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Reporter;

import com.perfectofieldserviceassignment.bean.ItemBean;
import com.perfectofieldserviceassignment.component.FieldserviceComponent;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class FieldservicehomeTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "homepage.button.allow")
	private QAFWebElement homepageButtonAllow;
	@FindBy(locator = "homepage.button.ok")
	private QAFWebElement homepageButtonOk;
	
	@FindBy(locator = "homepage.label.maincomponent")
	private List<FieldserviceComponent> homepageLabelMaincomponent;
	
	@FindBy(locator = "homepage.link.map")
	private QAFWebElement homepageLinkMap;
	
	@FindBy(locator = "actionbar.button.logout")
	private QAFWebElement actionbarButtonLogout;
	
	@FindBy(locator = "actionbar.button.jobs")
	private QAFWebElement actionbarButtonJobs;
	
	

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getHomepageButtonAllow() {
		return homepageButtonAllow;
	}

	public QAFWebElement getHomepageButtonOk() {
		return homepageButtonOk;
	}

	public List<FieldserviceComponent> getHomepageLabelMaincomponent() {
		return homepageLabelMaincomponent;
	}
	public QAFWebElement getHomepageLinkMap() {
		return homepageLinkMap;
	}
	public QAFWebElement getActionbarButtonJobs() {
		return actionbarButtonJobs;
	}
	public QAFWebElement getActionbarButtonLogout() {
		return actionbarButtonLogout;
	}
	

	
	@QAFTestStep(description = "user clicks on allow pop up")
	public void allowPopup()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(getHomepageButtonAllow().isPresent())
		{
			getHomepageButtonAllow().click();
		}
	}
	@QAFTestStep(description = "user verifies the home page")
	public void verifyHomePage()
	{
		
		if(actionbarButtonJobs.isPresent() || actionbarButtonLogout.isEnabled() )
		{
			Reporter.log("You are in home page ", true);
		}
	}
	@QAFTestStep(description = "user has to verify the map in home page")
	public void verifyMapInHomePage()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getHomepageLinkMap().isDisplayed();
		Reporter.log("Map is dispalyed", true);
	}
	@QAFTestStep(description = "user has to verify the list of items in home page")
	public void verifyItemList()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Validator.verifyThat("Item list verification", getHomepageLabelMaincomponent().size(), Matchers.greaterThan(0));
		
	}
	@QAFTestStep(description = "user selects the {0} item in the list")
	public void selectItem(int index)
	{
		ItemBean bean=new ItemBean();
//		bean.setItemTitle(getHomepageLabelMaincomponent().get(index).getHomepageLinkItemtitle().getText());
//		Reporter.log(getHomepageLabelMaincomponent().get(index).getHomepageLinkItemtitle().getText(),true);
		
		bean.setItemCategory(getHomepageLabelMaincomponent().get(index).getHomepageLinkItemtype().getText());
		Reporter.log(getHomepageLabelMaincomponent().get(index).getHomepageLinkItemtype().getText(),true);
		
		bean.setMiles(getHomepageLabelMaincomponent().get(index).getHomepageLinkMiles().getText());
		Reporter.log(getHomepageLabelMaincomponent().get(index).getHomepageLinkMiles().getText(),true);
		 ConfigurationManager.getBundle().setProperty("select.item",bean); 
		getHomepageLabelMaincomponent().get(index).getHomepageLinkItemtype().click();
	}
	@QAFTestStep(description = "user should logout from the application")
	public void logout()
	{
		getActionbarButtonLogout().click();
	}

}
