package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.WebElement;

public class FilterPage extends PageObject {

	@FindBy(name = "HOLIDAY")        // username
	private WebElementFacade holidaybox;

	

	public void click_holidaybox(){
		holidaybox.click();

	}

}


//public void lookup_terms() {
//	lookupButton.click();
//}
