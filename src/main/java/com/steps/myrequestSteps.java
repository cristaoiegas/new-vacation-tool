package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.CalendarPage;
import com.pages.NewVacationMenuPage;
import com.pages.VacationRequestPage;
import com.pages.WithdrawPage;

public class myrequestSteps extends ScenarioSteps {

	VacationRequestPage vacationRequestPage;
	NewVacationMenuPage myRequests;
	CalendarPage calendarPage;
	WithdrawPage dropDown;

	@Step
    public void enterStartDate(int month, int day, int year) throws Exception {

		vacationRequestPage.clickStartDate();
		calendarPage.setDate(month, day, year);
    	
    	Thread.sleep(3000);
    }

	public void enterEndDate(int month, int day, int year) throws Exception {

		vacationRequestPage.clickEndDate();
		calendarPage.setDate(month, day, year);
    	
    	Thread.sleep(3000);
    }
	
	public String clickSave() throws Exception {
		vacationRequestPage.clickSave();
		return vacationRequestPage.getVacationId();
	}
	
    public void click_Requests(){
    	myRequests.click_myRequests();
    }
    @Step
    public void click_dropDown(String value) throws Exception {
    	dropDown.click_nrItems(value);   
    	Thread.sleep(4000);
	}
}