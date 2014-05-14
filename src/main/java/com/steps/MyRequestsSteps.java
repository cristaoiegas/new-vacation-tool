package com.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;

import com.pages.DictionaryPage;
import com.pages.DeparmentMenuPage;
import com.pages.NewVacationMenuPage;
import com.pages.MyRequestPage;

public class MyRequestsSteps extends ScenarioSteps {

    MyRequestPage verifyRequests;
    NewVacationMenuPage myrequestPage;
    
    @Step
    public void click_myRequests() throws Exception{
    	myrequestPage.click_myRequests();
    }
    
    @Step
    public void click_myRequestsCheck() throws Exception{
    	verifyRequests.clickHoliday();
    	Thread.sleep(3000);
    }
 
    
}