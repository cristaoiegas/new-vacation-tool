package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebElement;

public class MyRequestPage extends PageObject {

	@FindBy(css= "label[for='_evovacation_WAR_EvoVacationportlet_HOLIDAYCheckbox']")    
	private WebElement holidayCheck;
	
	//@FindBy(name="endDate")               
	//private WebElement endDate;
	
	//@FindBy(css=".aui-button.aui-button-submit >.aui-button-content input")               
	//private WebElement save;

	public void clickHoliday(){
		element(holidayCheck).waitUntilVisible();
		holidayCheck.click();	
	}
	
//	public void clickEndDate(){
//		element(endDate).waitUntilVisible();
//		endDate.click();	
//	}
//	
//	public void clickSave(){
//			element(save).waitUntilVisible();
//			save.click();
//	}
	
}


