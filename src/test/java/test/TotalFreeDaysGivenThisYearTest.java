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
import com.steps.MyFreeDaysSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class TotalFreeDaysGivenThisYearTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://192.168.1.68:9080/login")
    public Pages pages;

    @Steps
    public LoginSteps logInSteps;
  
  @Steps
  public DepartmentMenuSteps enterDeparmentMenu;
  
  @Steps
  public MyFreeDaysSteps myFreeDaysSteps;
  
   
    @Test
    public void testare() throws Exception {
    	logInSteps.openHomePage();
    	logInSteps.logIn(Constants.user_usual, Constants.password_usual);
    	enterDeparmentMenu.click_newVacationSection();
    	myFreeDaysSteps.click_myFreeDays();
    	myFreeDaysSteps.freeDaysGivenInCurrentYear();
    	
    	//logInSteps.logOut();
    } 

}
