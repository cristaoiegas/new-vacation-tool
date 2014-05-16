package com.pages;

import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://192.168.1.68:9080/web/qa-department")
public class HolidaysTablePage extends PageObject {

public int getHolidayDaysTaken(String... terms) {
		String noOfPagesContainer = getDriver()
				.findElement(
						By.cssSelector(".aui-paginator-current-page-report.aui-paginator-total"))
				.getText().trim();
		//System.out.println(noOfPagesContainer);
		int noOfPages = tools.StringUtils.getAllIntegerNumbersFromString(
				noOfPagesContainer).get(1);
		System.out.println(noOfPages);
		int total = 0;
		for (int i = 0; i < noOfPages - 1; i++) {
			List<WebElement> searchResults1 = getDriver().findElements(
					By.cssSelector(".portlet-section-body.results-row"));
			List<WebElement> searchResults2 = getDriver()
					.findElements(
							By.cssSelector(".portlet-section-alternate.results-row.alt"));
			List<WebElement> searchResults = new ArrayList<WebElement>();
			searchResults.addAll(searchResults1);
			searchResults.addAll(searchResults2);

			for (WebElement searchResult : searchResults) {
				System.out.println(searchResult.getText());
				if ($(searchResult).isCurrentlyVisible()) {
					//$(searchResult).waitUntilVisible();
					for (String term : terms) {
						if (searchResult.getText().toLowerCase()
								.contains(term.toLowerCase())) {
							String daysNo = searchResult.findElement(
									By.cssSelector("td:nth-child(3)"))
									.getText();
						int daysNomber = Integer.parseInt(daysNo);
							//System.out.println(daysNomber);
							total = total + daysNomber;
                           // System.out.println(total);
                           
						}

					}
				}
			}
			if (i < noOfPages - 1) {
				getDriver()
						.findElement(
								By.cssSelector(".aui-paginator-link.aui-paginator-next-link"))   
						.click();
				// waitFor(ExpectedConditions
				// .textToBePresentInElement(
				// By.cssSelector("div.page-links > span.aui-paginator-current-page-report.aui-paginator-total"),
				// String.format("(%d of %d)", i + 2, noOfPages)));
				waitABit(2000);
				
			}
		
		}
		//System.out.println(total);
		return total;  
		}

}
