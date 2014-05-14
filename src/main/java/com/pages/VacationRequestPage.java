package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebElement;

public class VacationRequestPage extends PageObject {

	@FindBy(name="startDate")               
	private WebElement startDate;
	
	@FindBy(name="endDate")               
	private WebElement endDate;
	
	@FindBy(css=".aui-button.aui-button-submit >.aui-button-content input")               
	private WebElement save;

	public void clickStartDate(){
		element(startDate).waitUntilVisible();
		startDate.click();	
	}
	
	public void clickEndDate(){
		element(endDate).waitUntilVisible();
		endDate.click();	
	}
	
	public void clickSave(){
			element(save).waitUntilVisible();
			save.click();
	}
	
	public String getVacationId(){
		String url = getDriver().getCurrentUrl();
		String[] valueList = url.split("=");
		return  valueList[valueList.length-1];
	}
}


