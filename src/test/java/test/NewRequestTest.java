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

import com.pages.NewVacationMenuPage;
import com.requirements.Application;
import com.requirements.tools.Constants;
import com.steps.DepartmentMenuSteps;
import com.steps.LoginSteps;
import com.steps.MyRequestSteps;
import com.steps.NewVacationMenuSteps;
import com.steps.NewVacationRequestSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class NewRequestTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9080/login")
	public Pages pages;

    @Steps
    public LoginSteps logInSteps1;
  
    @Steps
    public DepartmentMenuSteps enterDeparmentMenu1;
  
    @Steps
    public NewVacationMenuSteps newVacationMenuSteps;
    
    @Steps
    public NewVacationRequestSteps newRequestSteps1;
    
    @Steps
    public NewVacationMenuPage newVacationMenuPage;
     
    @Steps
    public MyRequestSteps myRequestSteps1;
    
    @Test
    public void testare() throws Exception {
    	logInSteps1.openHomePage();
      	logInSteps1.logIn(Constants.user_dm, Constants.password_dm);
    	enterDeparmentMenu1.click_newVacationSection();
    	newVacationMenuSteps.newVacationReq();
    	newRequestSteps1.enterStartDate(19, 05, 2014);
    	newRequestSteps1.enterEndDate(20, 05, 2014);
    	newRequestSteps1.clickSave();
  
    	String vacationId = newRequestSteps1.getVacationId();
    	System.out.println(vacationId);
    	newVacationMenuSteps.clickMyRequests();
    	myRequestSteps1.click_dropDown("75");
    	myRequestSteps1.clickOnARequestIsInTheTableList(vacationId);
    	
} 
}
