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
import com.steps.InboxSteps;
import com.steps.LogInSteps;
import com.steps.NewRequestSteps;
import com.steps.NewVacationSteps;
import com.steps.MyRequestsSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class InboxTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://192.168.1.68:9080/login")
    public Pages pages;

  @Steps
  public LogInSteps logInSteps;
  
    @Steps
    public DepartmentMenuSteps enterDeparmentMenu;
    
    @Steps
    public NewVacationSteps inboxVariable;
    
    @Steps
    public InboxSteps assigned;
    
    
    @Test
    public void testare() throws Exception {
    	logInSteps.openHomePage();
    	logInSteps.logIn(Constants.user_dm, Constants.password_dm);
    	enterDeparmentMenu.click_newVacationSection();
    	inboxVariable.inboxClick();
    	assigned.assigned_click();
    	Thread.sleep(5000);
    	
    	
    	//newVacationrequest.newVacationReq();;
    	//newRequestSteps.enterStartDate(8, 28, 2013);
    	//newRequestSteps.enterEndDate(9, 20, 2013);
    	//String vacationID = newRequestSteps.clickSave();
    	//System.out.println(vacationID);
//    	newVacationrequest.click_myRequests();
//    	dropDown.click_dropDown("75");
//    	
    	//logInSteps.logOut();
    } 

}
