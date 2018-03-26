package com.perfectofieldserviceassignment.pages;

import org.hamcrest.Matchers;

import com.perfectofieldserviceassignment.bean.ItemBean;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class FieldserviceitemdetailsTestPage
		extends
			WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "itemdetailspage.label.itemtitle")
	private QAFWebElement itemdetailspageLabelItemtitle;
	@FindBy(locator = "itemdetailspage.label.itemcategory")
	private QAFWebElement itemdetailspageLabelItemcategory;
	@FindBy(locator = "itemdetailspage.textbox.note")
	private QAFWebElement itemdetailspageTextboxNote;
	@FindBy(locator = "itemdetailspage.button.back")
	private QAFWebElement itemdetailspageButtonBack;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getItemdetailspageLabelItemtitle() {
		return itemdetailspageLabelItemtitle;
	}

	public QAFWebElement getItemdetailspageLabelItemcategory() {
		return itemdetailspageLabelItemcategory;
	}

	public QAFWebElement getItemdetailspageTextboxNote() {
		return itemdetailspageTextboxNote;
	}

	public QAFWebElement getItemdetailspageButtonBack() {
		return itemdetailspageButtonBack;
	}
	@QAFTestStep(description = "user has to verify that respective page in the item details page")
	public void verifyOnItemDetailsPage()
	{
		ItemBean item = (ItemBean)ConfigurationManager.getBundle().getProperty("select.item"); 
		Validator.verifyThat("Productdetails Page Validation",getItemdetailspageLabelItemcategory().getText(),Matchers.containsString(item.getItemCategory()));
		
	}
	@QAFTestStep(description = "user is in item details page he has to go back to logout")
	public void goBackToHomePage()
	{
		itemdetailspageButtonBack.click();
		
	}

}
