package com.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;

import com.pages.DictionaryPage;
import com.pages.DeparmentMenuPage;
import com.pages.NewVacationMenuPage;

public class NewVacationSteps extends ScenarioSteps {

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
    
}
