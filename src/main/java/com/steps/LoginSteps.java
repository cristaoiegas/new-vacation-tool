package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.DepartmentMenuPage;
import com.pages.LoginPage;

public class LoginSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	LoginPage loginPage;
	DepartmentMenuPage departmentMenuPage;

    @Step
    public void logIn(String username, String password) {
        loginPage.enter_userName(username);
        loginPage.enter_password(password);
        loginPage.click_SignInButton();
    }
    
    @Step
    public void logOut()
    {
    	departmentMenuPage.click_SignOutButton();
    }
    
    @Step
    public void openHomePage(){
    	loginPage.open();
    	getDriver().manage().window().maximize();
    }

    
 
    
}
