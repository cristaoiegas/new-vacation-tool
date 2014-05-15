package com.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;

import com.pages.DictionaryPage;
import com.pages.DeparmentMenuPage;
import com.pages.InboxPage;
import com.pages.NewVacationMenuPage;

public class InboxSteps extends ScenarioSteps {

    InboxPage inbox;
    
    @Step
    public void assigned_click(){
    	inbox.click_assignedToOthers();
    	
    }
       
}
