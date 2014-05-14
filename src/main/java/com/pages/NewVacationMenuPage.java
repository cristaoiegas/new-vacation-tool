package com.pages;

import static ch.lambdaj.Lambda.convert;

import java.util.List;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ch.lambdaj.function.convert.Converter;

	@DefaultUrl("http://192.168.1.68:9080/web/qa-department/new-vacation")
	public class NewVacationMenuPage extends PageObject {

	@FindBy(css= ".nav-list a[href*='new-request']")               
	private WebElementFacade newVacationRequest;
	
	@FindBy(css= ".nav-list a[href*='my-request']")               
	private WebElementFacade myRequests;
	
	@FindBy(css= ".nav-list a[href*='my-free-days']")               
	private WebElementFacade myFreeDays;
	
	@FindBy(css= ".nav-list a[href*='free-days-history']")               
	private WebElementFacade freeDaysHistory;
	
	@FindBy(css= ".icon-user")               
	private WebElementFacade inbox;
	
	public void click_newVacationRequest(){
		element(newVacationRequest).waitUntilVisible();
		newVacationRequest.click();	
	}
	
	public void click_myRequests(){
		element(myRequests).waitUntilVisible();
		myRequests.click();
	}
	
	public void click_myFreeDays(){
		element(myFreeDays).waitUntilVisible();
		myFreeDays.click();
	}
	
	public void click_freeDaysHistory(){
		element(freeDaysHistory).waitUntilVisible();
		freeDaysHistory.click();
		
	}
	
	public void click_Inbox(){
		element(inbox).waitUntilVisible();
		inbox.click();	
	}
	
	
	
	
	
	
}


