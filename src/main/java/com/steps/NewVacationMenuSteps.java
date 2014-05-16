package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.NewVacationMenuPage;

public class NewVacationMenuSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	NewVacationMenuPage newVacationMenuPage; 
    
    @Step
    public void newVacationReq(){
    	newVacationMenuPage.click_newVacationRequest();
    }
    
    @Step
    public void clickMyRequests(){
    	newVacationMenuPage.click_myRequests();
    }
    
    @Step
    public void clickmyFreeDays(){
    	newVacationMenuPage.click_myFreeDays();
    }
    
    @Step
    public void freeDaysHistory(){
    	newVacationMenuPage.click_freeDaysHistory();
    }
    
	@Step
    public void click_Requests(){
    	newVacationMenuPage.click_myRequests();
    }
    
}
