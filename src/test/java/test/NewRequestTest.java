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
    public LoginSteps logInSteps;
  
    @Steps
    public DepartmentMenuSteps enterDeparmentMenu;
  
    @Steps
    public NewVacationMenuSteps newVacationMenuSteps;
    
    @Steps
    public NewVacationRequestSteps newRequestSteps;
    
    @Steps
    public NewVacationMenuPage newVacationMenuPage;
     
    @Steps
    public MyRequestSteps myRequestSteps;
    
    @Test
    public void testare() throws Exception {
    	logInSteps.openHomePage();
      	logInSteps.logIn(Constants.user_dm, Constants.password_dm);
    	enterDeparmentMenu.click_newVacationSection();
    	newVacationMenuSteps.newVacationReq();
    	newRequestSteps.enterStartDate(19, 05, 2014);
    	newRequestSteps.enterEndDate(20, 05, 2014);
    	newRequestSteps.clickSave();
  
    	String vacationId = newRequestSteps.getVacationId();
    	System.out.println(vacationId);
    	newVacationMenuSteps.clickMyRequests();
    	myRequestSteps.click_dropDown("75");
    	myRequestSteps.clickOnARequestIsInTheTableList(vacationId);
    	
//newRequestSteps.clickComment();
//newRequestSteps.insertComment("blabla");
//System.out.println(vacationID);
//String vacationId = newRequestSteps.getVacationId();
//newRequestSteps.goToRequest(vacationId);
//newRequestSteps.withdrawRequest(); 	
//myRequestSteps.click_Requests();  
//myRequestSteps.clickOnARequestIsInTheTableList(vacationID);
//System.out.println(vacationID);
// newRequestSteps.clickCancel();
//logInSteps.logOut();
    } 
}
