package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.CalendarPage;
import com.pages.VacationRequestPage;

public class NewRequestSteps extends ScenarioSteps {

	VacationRequestPage vacationRequestPage;

	CalendarPage calendarPage;

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
	
	public void clickSave() throws Exception {
		vacationRequestPage.clickSave();
		
		Thread.sleep(5000);
	}
}