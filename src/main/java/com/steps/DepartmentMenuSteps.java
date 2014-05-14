package com.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;

import com.pages.DictionaryPage;
import com.pages.DeparmentMenuPage;

public class DepartmentMenuSteps extends ScenarioSteps {

    DeparmentMenuPage newVacationPage;
    
    @Step
    public void click_newVacationSection(){
    	newVacationPage.click_newVacationSection();
    	
    }  
}