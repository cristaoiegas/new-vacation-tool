package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.InboxPage;

public class InboxSteps extends ScenarioSteps {

    InboxPage inbox;
    
    @Step
    public void assigned_click(){
    	inbox.click_assignedToOthers();
    	
    }
       
}
