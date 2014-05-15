package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.DepartmentMenuPage;

public class DepartmentMenuSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	DepartmentMenuPage newVacationPage;
    
    @Step
    public void click_newVacationSection(){
    	newVacationPage.click_newVacationSection();
    	
    }
 
    
}