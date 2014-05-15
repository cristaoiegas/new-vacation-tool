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

	public class InboxPage extends PageObject {

	@FindBy(css="a:contains('Assigned To Others')")               
	private WebElementFacade assignedToOthers;
	
	public void click_assignedToOthers(){
		element(assignedToOthers).waitUntilVisible();
		assignedToOthers.click();	
	}

}


