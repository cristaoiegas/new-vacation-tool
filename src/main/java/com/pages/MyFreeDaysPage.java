package com.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Years;
import org.junit.Assert;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

@DefaultUrl("http://192.168.1.68:9080/web/qa-department")
public class MyFreeDaysPage extends PageObject {

	@FindBy(css = ".my-free-days-content table tbody tr:nth-child(1)")
	private WebElementFacade DateHiredElement;

	@FindBy(css = ".my-free-days-content table tbody tr:nth-child(2) td:nth-child(2)")
	private WebElementFacade StartingBonusDaysNumber;

	@FindBy(css = ".my-free-days-content table tbody tr:nth-child(3) td:nth-child(2)")
	private WebElementFacade EvozonBonusDaysNumber;

	@FindBy(css = ".my-free-days-content table tbody tr:nth-child(5) td:nth-child(2)")
	private WebElementFacade FreeDaysGivenInCurrentYearNumber;

	@FindBy(css = ".my-free-days-content table tbody tr:nth-child(6) td:nth-child(2)")
	private WebElementFacade FreeDaysLeftfromLastYearNumber;

	@FindBy(css = ".my-free-days-content table tbody tr:nth-child(7) td:nth-child(2)")
	private WebElementFacade ExtraDaysReceivedNumber;

	@FindBy(css = ".my-free-days-content table tbody tr:nth-child(8) td:nth-child(2)")
	private WebElementFacade ExtraDaysTakenNumber;

	@FindBy(css = ".my-free-days-content table tbody tr:nth-child(9) td:nth-child(2)")
	private WebElementFacade VacationDaysTakenThisYearNumber;

	@FindBy(css = ".my-free-days-content table tbody tr:nth-child(11) td:nth-child(2)")
	private WebElementFacade TotalAvailableFreeDaysNumber;

	public int getDates() throws ParseException {

		String EvozonBonusDays = EvozonBonusDaysNumber.getText();
		int EvBonusD = Integer.parseInt(EvozonBonusDays);

		SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCurrent = new Date();
		//System.out.println(currentDate.format(dateCurrent));
		String stringDateHired = DateHiredElement.getText();
		String dateHired = stringDateHired.replace("Date hired: ", "");

		SimpleDateFormat dateHired1 = new SimpleDateFormat("dd/MM/yyyy");
		Date hiringDate;
		hiringDate = dateHired1.parse(dateHired);

		SimpleDateFormat dateHired2 = new SimpleDateFormat("dd/MM/yyyy");
		//System.out.println(dateHired2.format(hiringDate));

		DateTime dateCurrentDT = new DateTime(dateCurrent);
		DateTime hiringDateDT = new DateTime(hiringDate);

		int yearsDiff = Years.yearsBetween(hiringDateDT, dateCurrentDT)
				.getYears();
		// System.out.println(EvBonusD);
		// System.out.println(yearsDiff);
		return yearsDiff;

	}

	public int EvozonBonusD() {
		String EvozonBonusDays = EvozonBonusDaysNumber.getText();
		int EvBonusD = Integer.parseInt(EvozonBonusDays);
		return EvBonusD;
	}
   
	public int VacationDTakenThisYNr(){
    	String VacationDaysTakenThisYearNr=VacationDaysTakenThisYearNumber.getText();
    	int VacDTakenThisY = Integer.parseInt(VacationDaysTakenThisYearNr);
    	return VacDTakenThisY;
    }
	
	public int freeDaysGivenInCurrentYear() {

		String EvozonBonusDays = EvozonBonusDaysNumber.getText();
		String StartingBonusDays = StartingBonusDaysNumber.getText();
		

		int EvBonusD = Integer.parseInt(EvozonBonusDays);
		int StartBonusD = Integer.parseInt(StartingBonusDays);
		

		int FreeDaysGivThisY = 21 + EvBonusD + StartBonusD;
	//	System.out.println(FreeDaysGivThisY);
        return  FreeDaysGivThisY;
	}

	public int freeDGivenCurrentY(){
		String FreeDaysGivenInCurrentYear = FreeDaysGivenInCurrentYearNumber.getText();
		int FreeDGivenThisY = Integer.parseInt(FreeDaysGivenInCurrentYear);
		
		return FreeDGivenThisY;
	}
	
	public int availableFreeDays() {

		String FreeDaysGivenInCurrentYear = FreeDaysGivenInCurrentYearNumber
				.getText();
		String ExtraDaysReceived = ExtraDaysReceivedNumber.getText();
		String VacationDaysTakenThisYear = VacationDaysTakenThisYearNumber
				.getText();
		

		int FreeDGivenThisY = Integer.parseInt(FreeDaysGivenInCurrentYear);
		int ExtrDReceived = Integer.parseInt(ExtraDaysReceived);
		int VacDTakenThisY = Integer.parseInt(VacationDaysTakenThisYear);
		

		int TotAvailFreeD = FreeDGivenThisY + ExtrDReceived - VacDTakenThisY;

	//	System.out.println(TotAvailFreeD);
		return TotAvailFreeD;

	}

	public int TotalAvailableFreeDays() {
		
		String TotalAvailableFreeDays = TotalAvailableFreeDaysNumber.getText();
		int TotalAvailableFreeD = Integer.parseInt(TotalAvailableFreeDays);
		return TotalAvailableFreeD;
	}
}
