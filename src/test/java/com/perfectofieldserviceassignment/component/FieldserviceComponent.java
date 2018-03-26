package com.perfectofieldserviceassignment.component;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class FieldserviceComponent extends QAFWebComponent {

	public FieldserviceComponent(String locator) {
		super(locator);
		
	}
	// TODO Auto-generated constructor stub
			@FindBy(locator = "homepage.link.itemtitle")
			private QAFWebElement homepageLinkItemtitle;
			@FindBy(locator = "homepage.link.itemtype")
			private QAFWebElement homepageLinkItemtype;
			@FindBy(locator = "homepage.link.miles")
			private QAFWebElement homepageLinkMiles;
			
			public QAFWebElement getHomepageLinkItemtitle() {
				return homepageLinkItemtitle;
			}

			public QAFWebElement getHomepageLinkItemtype() {
				return homepageLinkItemtype;
			}

			public QAFWebElement getHomepageLinkMiles() {
				return homepageLinkMiles;
			}
}
