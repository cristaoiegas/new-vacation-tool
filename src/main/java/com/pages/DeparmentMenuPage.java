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

@DefaultUrl("http://192.168.1.68:9080/web/qa-department")
public class DeparmentMenuPage extends PageObject {

	@FindBy(css="a[href*=new-vacation]")               
	private WebElementFacade newVacationSection;
	
	public void click_newVacationSection(){
		element(newVacationSection).waitUntilVisible();
		newVacationSection.click();
		
	}
}