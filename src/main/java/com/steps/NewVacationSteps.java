package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.NewVacationMenuPage;

public class NewVacationSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	NewVacationMenuPage newVacationPage; 
    
    @Step
    public void newVacationReq(){
    	newVacationPage.click_newVacationRequest();
    }
    
    @Step
    public void myRequests(){
    	newVacationPage.click_myRequests();
    }
    
    @Step
    public void myFreeDays(){
    	newVacationPage.click_myFreeDays();
    }
    
    @Step
    public void freeDaysHistory(){
    	newVacationPage.click_freeDaysHistory();
    }
    
    @Step
    public void inboxClick(){
    	newVacationPage.click_Inbox();
    }
    
}
