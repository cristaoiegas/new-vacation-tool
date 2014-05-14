package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebElement;

public class VacationRequestPage extends PageObject {

	@FindBy(name="startDate")               
	private WebElement startDate;
	
	@FindBy(name="endDate")               
	private WebElement endDate;
	
	@FindBy(id="_evovacation_WAR_EvoVacationportlet_newVacationComment")
	private WebElement comment;
	
	@FindBy(css=".aui-button.aui-button-submit >.aui-button-content input")               
	private WebElement save;

	@FindBy(id="_evovacation_WAR_EvoVacationportlet_commentContent")
	private WebElement commentContent;
	
	@FindBy(css=".aui-button-input aui-button-input-cancel")
	private WebElement cancel;
	
	public void clickStartDate(){
		element(startDate).waitUntilVisible();
		startDate.click();	
	}
	
	public void clickEndDate(){
		element(endDate).waitUntilVisible();
		endDate.click();	
	}
	
	public void clickComment(){
		element(comment).waitUntilVisible();
		comment.click();
	}
	

	public void insertComment(String keyword) {
		element(commentContent).waitUntilVisible();
		commentContent.sendKeys(keyword); 
	}
	
	
	public void clickSave(){
			element(save).waitUntilVisible();
			save.click();
	}
	
	public void clickCancel(){
			element(cancel).waitUntilVisible();
			cancel.click();
	}
	
	public String getVacationId(){
		String url = getDriver().getCurrentUrl();
		String[] valueList = url.split("=");
		return  valueList[valueList.length-1];
	}
}


