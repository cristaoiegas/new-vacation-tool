package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.Login_outPage;

public class LogInSteps extends ScenarioSteps {

    Login_outPage loginPage;

    @Step
    public void logIn(String username, String password) {
        loginPage.enter_userName(username);
        loginPage.enter_password(password);
        loginPage.click_SignInButton();
    }
    
    @Step
    public void logOut()
    {
    	loginPage.click_SignOutButton();
    }
    
    @Step
    public void openHomePage(){
    	loginPage.open();
    	getDriver().manage().window().maximize();
    }

    
 
    
}
