package com.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;

import com.pages.DictionaryPage;
import com.pages.DeparmentMenuPage;
import com.pages.NewVacationPage;

public class NewVacationSteps extends ScenarioSteps {

     NewVacationPage newVacationPage; 
    
    @Step
    public void click_newVacationReq(){
    	newVacationPage.click_newVacationRequest();
    	
    }
 
    
}