package com.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.WebElement;

@DefaultUrl("http://192.168.1.68:9080/web/qa-department")
public class DepartmentMenuPage extends PageObject {

	@FindBy(css="a[href*=new-vacation]")               
	private WebElementFacade newVacationSection;
	

	@FindBy(css = "a[href='/c/portal/logout']")
	private WebElement signOutButton;
	
	public void click_newVacationSection(){
		element(newVacationSection).waitUntilVisible();
		newVacationSection.click();
	}
	public void click_SignOutButton(){
		signOutButton.click();
	}
}