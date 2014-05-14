package com.steps;

import org.openqa.selenium.WebDriver;

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
	
	public void clickComment(){
		vacationRequestPage.clickComment();
	}
	
	public void insertComment(String keyword){
		vacationRequestPage.insertComment(keyword);
	}
	
	public void clickCancel(){
		vacationRequestPage.clickCancel();
	}
	
	public String clickSave() throws Exception {
		vacationRequestPage.clickSave();
		return vacationRequestPage.getVacationId();
	}
}
