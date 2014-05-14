package com.pages;

import java.nio.channels.Selector;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebElement;

public class WithdrawPage extends PageObject {

	@FindBy(css = ".aui-field-input.aui-field-input-select.aui-field-input-menu")
	private WebElementFacade nrItems;  
	
	public void click_nrItems(String value){
		nrItems.selectByVisibleText(value);
	}
}
	