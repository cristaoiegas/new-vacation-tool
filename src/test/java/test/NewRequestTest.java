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
    public LoginSteps logInSteps;
  
    @Steps
    public DepartmentMenuSteps enterDeparmentMenu;
  
    @Steps
    public NewVacationMenuSteps newVacationrequest;
    
    @Steps
    public NewVacationRequestSteps newRequestSteps;
    
     
    @Steps
    public MyRequestSteps myRequestSteps;
   
    @Test
    public void testare() throws Exception {
    	logInSteps.openHomePage();
      	logInSteps.logIn(Constants.user_dm, Constants.password_dm);
    	enterDeparmentMenu.click_newVacationSection();
    	newVacationrequest.newVacationReq();
    	
    	newRequestSteps.enterStartDate(8, 28, 2014);
    	newRequestSteps.enterEndDate(8, 29, 2014);
    	newRequestSteps.clickComment();
    	newRequestSteps.insertComment("blabla");
    	String vacationID = newRequestSteps.clickSave();
    	myRequestSteps.verifyIfRequestIsInTheTableList(vacationID);
    	System.out.println(vacationID);
//    	newRequestSteps.clickCancel();
//    	newVacationrequest.click_myRequests();
//    	dropDown.click_dropDown("75");
//    	
    	//logInSteps.logOut();
    } 

}
