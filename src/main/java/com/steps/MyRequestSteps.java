package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.MyRequestPage;
import com.pages.NewVacationMenuPage;
import com.pages.NewVacationRequestPage;

public class MyRequestSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	NewVacationRequestPage vacationRequestPage;
	NewVacationMenuPage newVacationMenuPage;
	MyRequestPage myRequestPage;
	
	@Step
    public void enterStartDate(int month, int day, int year) throws Exception {

		vacationRequestPage.clickStartDate();
		vacationRequestPage.setDate(month, day, year);
    	
    	Thread.sleep(3000);
    }

	public void enterEndDate(int month, int day, int year) throws Exception {

		vacationRequestPage.clickEndDate();
		vacationRequestPage.setDate(month, day, year);
    	
    	Thread.sleep(3000);
    }
	
	public String clickSave() throws Exception {
		vacationRequestPage.clickSave();
		return vacationRequestPage.getVacationId();
	}
	
	public void clickOnARequestIsInTheTableList(String vacationId) throws Exception{
		myRequestPage.clickOnARequestIsInTheTableList(vacationId);
		
	}
	@Step
    public void click_Requests() throws Exception{
    	newVacationMenuPage.click_myRequests();
    	Thread.sleep(4000);
    }
    @Step
    public void click_dropDown(String value) throws Exception {
    	myRequestPage.click_nrItems(value);   
    	Thread.sleep(4000);
	}

    @Step
    public void click_myRequestsCheck() throws Exception{
    	myRequestPage.clickHoliday();
    	Thread.sleep(3000);
    }
}