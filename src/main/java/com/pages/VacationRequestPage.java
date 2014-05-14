package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebElement;

public class VacationRequestPage extends PageObject {

	@FindBy(name="startDate")               
	private WebElement startDate;
	
	@FindBy(name="endDate")               
	private WebElement endDate;

	public void clickStartDate(){
		element(startDate).waitUntilVisible();
		startDate.click();	
	}
	
	public void clickEndDate(){
		element(endDate).waitUntilVisible();
		endDate.click();	
	}
}


