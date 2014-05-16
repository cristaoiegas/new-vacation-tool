package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.NewVacationRequestPage;

public class NewVacationRequestSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	NewVacationRequestPage newVacationRequestPage;

	


	@Step
    public void enterStartDate(int month, int day, int year) throws Exception {

		newVacationRequestPage.clickStartDate();
		newVacationRequestPage.setDate(month, day, year);
    	
    	Thread.sleep(3000);
    }

	public void enterEndDate(int month, int day, int year) throws Exception {

		newVacationRequestPage.clickEndDate();
		newVacationRequestPage.setDate(month, day, year);
    	
    	Thread.sleep(3000);
    }
	
	public void clickComment(){
		newVacationRequestPage.clickComment();
	}
	
	public void insertComment(String keyword){
		newVacationRequestPage.insertComment(keyword);
	}
	
	public void clickCancel(){
		newVacationRequestPage.clickCancel();
	}
	
	public String clickSave() throws Exception {
		newVacationRequestPage.clickSave();
		return newVacationRequestPage.getVacationId();
	}
	
	@Step
	 public String getVacationId() {
	  return newVacationRequestPage.getVacationId();
	 }
	 
	 @Step
	 public void goToRequest(String vacationId){
	  newVacationRequestPage.goToRequest(vacationId);
	 }
	 
	 @Step
	 public void withdrawRequest() throws Exception{ 
		 newVacationRequestPage.clickWithdraw();
		 Thread.sleep(3000);
	 }
	
}
