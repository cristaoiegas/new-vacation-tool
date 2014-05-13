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
import com.steps.DepartmentMenuSteps;
import com.steps.LogInSteps;
import com.steps.NewVacationSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class LogInTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://192.168.1.68:9080/login")
    public Pages pages;

  @Steps
  public LogInSteps logInSteps;
  
    @Steps
    public DepartmentMenuSteps enterDeparmentMenu;
  
    @Steps
    public NewVacationSteps newVacationrequest;
   
    @Test
    public void testare() {
    	logInSteps.openHomePage();
    	logInSteps.logIn("george", "gimmy");
    	enterDeparmentMenu.click_newVacationSection();
    	newVacationrequest.click_newVacationReq();
    	
    	//logInSteps.logOut();
    } 

}