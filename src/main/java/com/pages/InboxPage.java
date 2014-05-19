package com.pages;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.WebElement;

public class InboxPage extends PageObject {

	@FindBy(css = "ul[class='nav nav-tabs'] li:nth-child(2) a")       
	private WebElementFacade assignedToOthers;
	
	@FindBy(css = "ul[class='nav nav-tabs'] li:nth-child(2) a")        
	private WebElementFacade selectItem;
	
	@FindBy(id="_evovacation_WAR_EvoVacationportlet_multipleApproveButton")        
	private WebElementFacade approveButton;
	
	public void enter_assignedToOthers() {        
		element(assignedToOthers).waitUntilVisible();
		assignedToOthers.click();
	}
	
	public void getElement(String varID){
	getDriver().findElement(By.cssSelector("input[value='"+varID+"']")).click();
	}
	
	public void click_approveButton() {        
		element(approveButton).waitUntilVisible();
		approveButton.click();
	}
	

}