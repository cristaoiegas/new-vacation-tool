package com.steps;

import static org.fest.assertions.Assertions.assertThat;

import java.text.ParseException;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.HolidaysTablePage;
import com.pages.MyFreeDaysPage;
import com.pages.NewVacationMenuPage;

public class MyFreeDaysSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	NewVacationMenuPage myFreeDays;
	HolidaysTablePage holidayPage;
    MyFreeDaysPage myFreeDaysPage;
    @Step
    public void click_myFreeDays(){
    	myFreeDays.click_myFreeDays();
       	
    } 
    
    @Step
    public void getDates() throws ParseException{
    	assertThat(myFreeDaysPage.getDates()).isEqualTo(myFreeDaysPage.EvozonBonusD());
    
    }
    
    @Step
    public void availableFreeDays(){
    	assertThat(myFreeDaysPage.availableFreeDays()).isEqualTo(myFreeDaysPage.TotalAvailableFreeDays());
    }
    
    @Step
    public void freeDaysGivenInCurrentYear(){
    	assertThat(myFreeDaysPage.freeDaysGivenInCurrentYear()).isEqualTo(myFreeDaysPage.freeDGivenCurrentY());
    }

    
    @Step 
    public int checkTable(String... terms){
    	return holidayPage.getHolidayDaysTaken(terms);
    }
    public void VacationDTakenThisYNo(int tot){
    	
    	System.out.println(tot);
    	myFreeDaysPage.VacationDTakenThisYNr();
    	assertThat(myFreeDaysPage.VacationDTakenThisYNr()).isEqualTo(tot);
    	//Assert.assertTrue("The days are not equal", VacDTakenThisY==tot);
    	//Assert.assertEquals(VacDTakenThisY,tot);
    }

}
