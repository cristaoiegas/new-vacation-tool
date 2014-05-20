package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.DepartmentMenuPage;
import com.pages.InboxPage;
import com.pages.LoginPage;
import com.pages.NewVacationMenuPage;

public class InboxSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	InboxPage inboxPage;
	
    @Step
    public void assignedToOthers()
    {
    	inboxPage.enter_assignedToOthers();
    } 
    
    @Step
    public void approveButton()
    {
    	inboxPage.click_approveButton();
    } 
    
    @Step
    public void selectElement(String VarID) throws Exception
    {
    	inboxPage.getElement(VarID);
    	Thread.sleep(5000);
    } 
    
    
}
