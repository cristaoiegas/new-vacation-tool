package test;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.requirements.tools.Constants;
import com.steps.DepartmentMenuSteps;
import com.steps.LoginSteps;
import com.steps.NewVacationRequestSteps;
import com.steps.NewVacationMenuSteps;
import com.steps.MyRequestSteps;

import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("resource/Input.csv")

public class NewRequestDataDrivenTest {
	String vacationType, keywordDuration,
	    keywordInstitution, com, typeOfSpecialVacation;
	    int startMonth, startDay, startYear, endMonth, endDay, endYear;
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/login")
	public Pages pages;

	@Steps
	public LoginSteps logInSteps;

	@Steps
	public DepartmentMenuSteps enterDeparmentMenu;

	@Steps
	public NewVacationMenuSteps newVacationrequest;

	@Steps
	public NewVacationRequestSteps newRequestSteps;


	@Steps
	public MyRequestSteps myRequestSteps;
	
	@Qualifier
	public String getVacationType() {
		return vacationType;
	}
	public void setVacationType(String vacationType) {
		this.vacationType = vacationType;
	}
	public String getKeywordDuration() {
		return keywordDuration;
	}
	public void setKeywordDuration(String keywordDuration) {
		this.keywordDuration = keywordDuration;
	}
	public String getKeywordInstitution() {
		return keywordInstitution;
	}
	public void setKeywordInstitution(String keywordInstitution) {
		this.keywordInstitution = keywordInstitution;
	}
	public String getTypeOfSpecialVacation() {
		return typeOfSpecialVacation;
	}
	public void setTypeOfSpecialVacation(String typeOfSpecialVacation) {
		this.typeOfSpecialVacation = typeOfSpecialVacation;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	
//	 @Test
//	 public void failedRequestDataDriven() throws Exception {
//	  
//
//	 enterDeparmentMenu.click_newVacationSection();
//	 newVacationrequest.newVacationReq();
//	 newRequestSteps.makeANewVacation(vacationType, keywordDuration,
//	 keywordInstitution, startMonth, startDay, startYear, endMonth,	 endDay, endYear, typeOfSpecialVacation,com);
////	 String vacationID = newRequestSteps.clickSave();
//	 newRequestSteps.checkErrorMessage("Your request failed to complete.");
//	  
//	 }
	 @Test
	 public void succesfullRequestDataDriven() throws Exception {
		logInSteps.openHomePage();
		logInSteps.logIn(Constants.user_usual, Constants.password_usual);
		enterDeparmentMenu.click_newVacationSection();
		newVacationrequest.newVacationReq();
	 	String vacationID = newRequestSteps.makeANewVacation(vacationType, keywordDuration,
	    keywordInstitution, typeOfSpecialVacation, com,  startMonth, startDay, startYear, endMonth, endDay, endYear);
	    newRequestSteps.checkSuccessMessage("Your request completed successfully.");
	    String vacationId = newRequestSteps.getVacationId();
	    newRequestSteps.goToRequest(vacationId);
	    newRequestSteps.withdrawRequest();
	}
	

}
