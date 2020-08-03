package com.flight.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flights.utils.BasePage;

/**
 * @author M1041984
 *
 */
public class FlightSearchPage extends BasePage {
	WebDriver driver;

	public FlightSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//span[text()='Flights']")
	WebElement flightButton;

	@FindBy(css = "input[placeholder='From']")
	WebElement fromCity;

	@FindBy(css = "input[placeholder='Destination']")
	WebElement arrivalCity;
	@FindBy(xpath = "//ul[@id='react-autosuggest-1']")
	WebElement flightAutoSuggest;
	@FindBy(css = "span#oneway")

	WebElement oneWayButton;
	@FindBy(xpath = "//button[text()='SEARCH']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@value='BOOK']")
	List<WebElement> bookButton;

	@FindBy(xpath = "//div[@id='fare_xxx']")
	public WebElement selectDate;

	private String RequiredSystemNameXpath = "//div[@id='fare_xxxxx']";

	private WebElement prepareWebElementWithDynamicXpath(String xpathValue, String string) {

		return driver.findElement(By.xpath(xpathValue.replace("xxxxx", returnDate(string))));
	}

	public void selectTravelDate(String systemName) {

		WebElement RequiredSystemName = prepareWebElementWithDynamicXpath(RequiredSystemNameXpath, systemName);

		RequiredSystemName.click();

	}

	public void UrlOpen(String string) {
		getUrl(string);
	}

	public void clickOnFlightButton() {
		Click(flightButton);

	}

	public void clickOnOneWay() {
		Click(oneWayButton);

	}

	public void clickOnSearchButton() {
		Click(searchButton);

	}

	public void selectFlight() {
		selectSuitableFare();

	}

	public void verifyFlightResultsPage() {
		verifyMoreThanOneElements(bookButton);

	}

	public void enterDepartCity(String string) {

		sendKeys(fromCity, flightAutoSuggest, string);

	}

	public void enterArrivalCity(String string) {

		sendKeys(arrivalCity, flightAutoSuggest, string);

	}

	private void selectSuitableFare() {
		String baseXpath = "(//div[@class='marginB10']//div[contains(@data-cy,'flightItem_')])";
		selectDepartFlight(baseXpath);
	}
}
