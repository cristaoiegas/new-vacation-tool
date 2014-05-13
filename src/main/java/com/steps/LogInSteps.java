package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.LoginPage;

public class LogInSteps extends ScenarioSteps {

    LoginPage loginPage;

    @Step
    public void logIn(String username, String password) {
        loginPage.enter_userName(username);
        loginPage.enter_password(password);
        loginPage.click_SignInButton();
    }
    
    @Step
    public void openHomePage(){
    	loginPage.open();
    }

 
 
    
}