package test;

import static org.fest.assertions.Assertions.assertThat;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.pages.HolidaysTablePage;
import com.pages.MyFreeDaysPage;
import com.requirements.Application;
import com.requirements.tools.Constants;
import com.steps.DepartmentMenuSteps;
import com.steps.LoginSteps;
import com.steps.MyFreeDaysSteps;
import com.steps.NewVacationMenuSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class DaysTakenThisYearTest {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://192.168.1.68:9080/login")
    public Pages pages;

  @Steps
  public LoginSteps loginSteps;
  
  @Steps
  public DepartmentMenuSteps enterDeparmentMenu;
   
  @Steps
  public MyFreeDaysSteps freedaystaken; 
  
  @Steps
  public NewVacationMenuSteps newVacationMenuSteps; 
  
    @Test
    public void testare() throws Exception {
    	loginSteps.openHomePage();
    	loginSteps.logIn(Constants.user_usual, Constants.password_usual);
    	enterDeparmentMenu.click_newVacationSection();
    	int tot = freedaystaken.checkTable("Pending","Approved");
    	//System.out.println(String.valueOf(tot));
    	newVacationMenuSteps.clickmyFreeDays();    	
    	freedaystaken.VacationDTakenThisYNo(tot);

    	
    } 

}
