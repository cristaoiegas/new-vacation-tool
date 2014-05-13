package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.WebElement;

public class LoginPage extends PageObject {

	@FindBy(name = "_58_login")        // username
	private WebElementFacade userName;
	
	@FindBy(name = "_58_password")
	private WebElementFacade password;  // pass
	
	@FindBy(css = "input[type=submit]")       // pt buton
	private WebElement signInButton;;

	public void enter_userName(String keywordUsername) {        
		element(userName).waitUntilVisible();
		userName.type(keywordUsername);
	}
	
	public void enter_password(String keywordPassword) {        
		element(password).waitUntilVisible();
		password.type(keywordPassword);
	}
	
	
	public void click_SignInButton(){
	signInButton.click();
		
	}

	//public void lookup_terms() {
	//	lookupButton.click();
	//}

}