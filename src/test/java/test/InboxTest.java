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
import com.steps.InboxSteps;
import com.steps.LoginSteps;
import com.steps.MyRequestSteps;
import com.steps.NewVacationMenuSteps;
import com.steps.NewVacationRequestSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class InboxTest {

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
    public MyRequestSteps myRequestSteps;
    @Steps
    public InboxSteps inboxSteps;
    
    @Steps
    public NewVacationRequestSteps newRequestSteps;
    
    
    @Test
    public void testare() throws Exception {
    	logInSteps.openHomePage();
      	logInSteps.logIn(Constants.user_usual1, Constants.password_usual1);
    	enterDeparmentMenu.click_newVacationSection();
    	newVacationMenuSteps.newVacationReq();
    	newRequestSteps.enterStartDate(5, 19, 2014);
    	newRequestSteps.enterEndDate(5, 19, 2014);
    	String varID = newRequestSteps.clickSave();
     	
     	logInSteps.logOut();
     	logInSteps.openHomePage();
      	logInSteps.logIn(Constants.user_dm, Constants.password_dm);
      	enterDeparmentMenu.click_newVacationSection();
    	newVacationMenuSteps.clickInbox();
    	inboxSteps.assignedToOthers();
    	inboxSteps.selectElement(varID);
    	inboxSteps.approveButton();   	
   } 
}
