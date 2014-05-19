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
	
	
	
	@FindBy(css = "div[aria-hidden='false'] .aui-calendar-title")
	private WebElementFacade calendarTitle;

	@FindBy(css = "div[aria-hidden='false'] .aui-icon.aui-icon-circle-triangle-r.aui-calendar-next")
	private WebElementFacade nextButton;

	@FindBy(css = "div[aria-hidden='false'] .aui-icon.aui-icon-circle-triangle-l.aui-calendar-prev")
	private WebElementFacade previousButton;
	
	@FindBy(id="_evovacation_WAR_EvoVacationportlet_withdrawnVacationRequest")
	private WebElement withdraw;
	
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
		 
//	public void goToRequest(String VacationId){
//		getDriver().findElement(By.cssSelector("a[href*=vacationId]"+VacationId)).click();
//		}
	
	public void clickWithdraw(){
		element(withdraw).waitUntilVisible();
		withdraw.click();
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


