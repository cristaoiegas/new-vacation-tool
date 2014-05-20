package test;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
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
import com.steps.VerifyEmailSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class CheckEmailTest {

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
	
	@Steps
	public VerifyEmailSteps verifyemail = new VerifyEmailSteps();

	@Test
	public void testare() throws Exception {
		logInSteps.openHomePage();
		logInSteps.logIn(Constants.user_usual2, Constants.password_usual2);
		enterDeparmentMenu.click_newVacationSection();
		newVacationrequest.newVacationReq();
		newRequestSteps.enterStartDate(10, 7, 2014);
		newRequestSteps.enterEndDate(10, 9, 2014);
		newRequestSteps.clickSave();
		verifyemail.verifyEmail("You have submitted a new Vacation Request", "Dear Dani Tise,  You have submitted a new Vacation Request. The Vacation interval is: 07/10/2014 - 09/10/2014.  Sincerely,  EvoPortal Team");		
	
	} 

}
