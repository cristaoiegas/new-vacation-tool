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
public class NewVacationPage extends PageObject {

	@FindBy(css= "ul[class='nav nav-list'] li:nth-child(2)")               
	private WebElementFacade newVacationRequest;
	
	@FindBy(css= "ul[class='nav nav-list'] li:nth-child(3)")               
	private WebElementFacade myRequests;
	
	@FindBy(css= "ul[class='nav nav-list'] li:nth-child(4)")               
	private WebElementFacade myFreeDays;
	
	@FindBy(css= "ul[class='nav nav-list'] li:nth-child(5)")               
	private WebElementFacade freeDaysHistory;
	
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
	
	
	
	
	
	
}


