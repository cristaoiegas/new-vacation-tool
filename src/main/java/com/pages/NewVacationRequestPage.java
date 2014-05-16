package com.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewVacationRequestPage extends PageObject {

	@FindBy(name="startDate")               
	private WebElement startDate;
	
	@FindBy(name="endDate")               
	private WebElement endDate;
	
	@FindBy(id="_evovacation_WAR_EvoVacationportlet_newVacationComment")
	private WebElement comment;
	
	@FindBy(css=".aui-button.aui-button-submit >.aui-button-content input")               
	private WebElement save;

	@FindBy(id="_evovacation_WAR_EvoVacationportlet_commentContent")
	private WebElement commentContent;
	
	@FindBy(css=".aui-button-input aui-button-input-cancel")
	private WebElement cancel;
	
	@FindBy(css="#_evovacation_WAR_EvoVacationportlet_duration input" )
	private WebElement duration;
	
	@FindBy(css="#_evovacation_WAR_EvoVacationportlet_institution input")
	private WebElement institution;
	
	@FindBy(css = "div[aria-hidden='false'] .aui-calendar-title")
	private WebElementFacade calendarTitle;

	@FindBy(css = "div[aria-hidden='false'] .aui-icon.aui-icon-circle-triangle-r.aui-calendar-next")
	private WebElementFacade nextButton;

	@FindBy(css = "div[aria-hidden='false'] .aui-icon.aui-icon-circle-triangle-l.aui-calendar-prev")
	private WebElementFacade previousButton;
	
	@FindBy(id="_evovacation_WAR_EvoVacationportlet_withdrawnVacationRequest")
	private WebElement withdraw;
	
	@FindBy(css="#_evovacation_WAR_EvoVacationportlet_specialReason")
    private WebElementFacade ChooseASpecialVacation;
	
	@FindBy(css = "select[name='specialReason']")
	private WebElementFacade specialReason; 
	
	public void clickStartDate(){
		element(startDate).waitUntilVisible();
		startDate.click();	
	}
	
	public void clickEndDate(){
		element(endDate).waitUntilVisible();
		endDate.click();	
	}
	
	public void clickComment(){
		element(comment).waitUntilVisible();
		comment.click();
	}
	

	public void insertComment(String keyword) {
		element(commentContent).waitUntilVisible();
		commentContent.sendKeys(keyword); 
	}
	
	
	public void clickSave(){
			element(save).waitUntilVisible();
			save.click();
	}
	
	public void clickCancel(){
			element(cancel).waitUntilVisible();
			cancel.click();
	}
	
	public String getVacationId() {
		  String[] urlList = getDriver().getCurrentUrl().split("=");
		  return urlList[urlList.length-1];
		 }
		 
	public void goToRequest(String VacationId){
		  getDriver().get("http://192.168.1.68:9080/web/lt/new-vacation?p_p_auth=nt6olSiz&p_p_id=evovacation_WAR_EvoVacationportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_evovacation_WAR_EvoVacationportlet_menuItem=my-requests&_evovacation_WAR_EvoVacationportlet_myRequestState=view-vacation&_evovacation_WAR_EvoVacationportlet_backMenuItem=my-requests&_evovacation_WAR_EvoVacationportlet_vacationId=" + VacationId);
		}

	public void clickWithdraw(){
		element(withdraw).waitUntilVisible();
		withdraw.click();
		}
	
	public void insertDuration(String keyword){
		element(duration).waitUntilVisible();
		duration.sendKeys(keyword);
	}
	
	public void insertInstitution(String keyword){
		element(institution).waitUntilVisible();
		institution.sendKeys(keyword);
	}
	
	public void insertSpecialReason(String value){
		specialReason.selectByVisibleText(value);
	}

	 public void selectAVacationType(String vacationType, String keywordDuration,
			   String keywordInstitution, String value) {
			  String var;
			  switch (vacationType) {
			  case "Holiday": {
			   var = "CO";
			   WebElement element = getDriver()
			     .findElement(
			       By.cssSelector(String
			         .format("#_evovacation_WAR_EvoVacationportlet_type_"
			           + var)));
			   element.click();
			   break;
			  }
			  case "Vacation without payment": {
			   var = "CF";
			   WebElement element = getDriver()
			     .findElement(
			       By.cssSelector(String
			         .format("#_evovacation_WAR_EvoVacationportlet_type_"
			           + var)));
			    element.click();
			  insertDuration(keywordDuration);
			  insertInstitution(keywordInstitution);
			   break;
			  }
			  case "Special vacation": {
			   var = "CS";
			   WebElement element = getDriver()
			     .findElement(
			       By.cssSelector(String
			         .format("#_evovacation_WAR_EvoVacationportlet_type_"
			           + var)));
			    element.click();
			    insertSpecialReason(value);
			   break;
			  }
			  case "Sick leave": 
			   var = "CM";
			   WebElement element = getDriver()
			     .findElement(
			       By.cssSelector(String
			         .format("#_evovacation_WAR_EvoVacationportlet_type_"
			           + var)));
			    element.click();
			   break;
			  }
			 }
			  
	
	public void setDate(int month, int day, int year) throws ParseException {

		Calendar calNew = Calendar.getInstance();
		SimpleDateFormat sdfNew = new SimpleDateFormat("dd/MM/yyyy");
		calNew.setTime(sdfNew.parse("1/" + String.valueOf(month) + "/"
				+ String.valueOf(year)));

		Calendar cal = Calendar.getInstance();
		do {
			element(calendarTitle).waitUntilVisible();
			String MandY = calendarTitle.getText();
			SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy dd");
			System.out.println(MandY + " 1");
			cal.setTime(sdf.parse(MandY + " 1"));

			if (cal.compareTo(calNew) == -1) {
				nextButton.click();
			}
			if (cal.compareTo(calNew) == 1) {
				previousButton.click();
			}
		} while (cal.compareTo(calNew) != 0);

		List<WebElement> days = getDriver()
				.findElements(
						By.cssSelector("div[aria-hidden='false'] .aui-calendar-day.aui-calendar-day-month.aui-state-default"));
		for (WebElement currentDay : days) {
			if (currentDay.getText().toLowerCase()
					.contains(String.valueOf(day).toLowerCase()))
				currentDay.click();
		}

	}
	
	
}


