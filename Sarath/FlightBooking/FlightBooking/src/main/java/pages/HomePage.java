package pages;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class HomePage extends BasePage{
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "or-src")
	private WebElement fromCity;

	@FindBy(how = How.NAME, using = "or-dest")
	private WebElement toCity;
	
	@FindBy(how = How.NAME, using = "or-depart")
	private WebElement departDate;
	
	@FindBy(how = How.CSS, using = "label[for='oneWayTrip']")
	private WebElement onewayBtn;
	
	@FindBy(how = How.CSS, using = "span[class='hp-src-btn']")
	private WebElement searchBtn;
	
	@FindBy(how = How.CSS, using = "span[class='ui-datepicker-year']")
	private WebElement datePickerYear;
	
	@FindBy(how = How.CSS, using = "a[class='ui-datepicker-next ui-corner-all']>span")
	private WebElement datePickerNextBtn;
	
	@FindBy(how = How.CSS, using = "span[class='ui-datepicker-month']")
	private WebElement datePickerMonth;

	/**
	 * Select Source City
	 * @param source
	 */
	public void selectSourceCity(String source) {
		try {
			BasePage.waitForElement(fromCity,driver);
			fromCity.clear();
			fromCity.click();
			fromCity.sendKeys(source);
			fromCity.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Verify text in Source and reenter if not correct
	 * @param source
	 */
	public void verifySource(String source) {
		try {
			if (!(fromCity.getText().contains(source))) {
				selectSourceCity(source);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Select Destination city
	 * @param dest
	 */
	public void selectDestinationCity(String dest) {
		try {
			BasePage.waitForElement(toCity, driver);
			toCity.clear();
			toCity.click();
			toCity.sendKeys(dest);
			toCity.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Click on oneway radio button
	 */
	public void clickOnOnewayBtn() {
		try {
			onewayBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Click on search button
	 */
	public void clickOnSearchButton() {
		try {
			searchBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Select depart date
	 * @param year
	 * @param month
	 * @param date
	 */
	public void selectDepartdate(String year, String month, String date) {
		try {
			selectDates(departDate, year, month, date, driver);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * Select date in home page
	 * @param calendar
	 * @param year
	 * @param monthName
	 * @param day
	 * @param driver
	 * @throws ParseException
	 */
	public void selectDates(WebElement calendar, String year, String monthName, String day, WebDriver driver)
			throws ParseException {
		calendar.click();
		String currentYear = datePickerYear.getText();
		if (!currentYear.equals(year)) {
			do {
				datePickerNextBtn.click();
			} while (!datePickerYear.getText().equals(year));
		}
		String currentMonth = datePickerMonth.getText();
		if (!currentMonth.equalsIgnoreCase(monthName)) {
			do {
				datePickerNextBtn.click();
			} while (!datePickerMonth.getText().trim().equalsIgnoreCase(monthName));
		}
		int javaMonthInt = BasePage.getMonthJavaInt(monthName);

		List<WebElement> allDateOfDesiredMonth = driver.findElements(By.xpath(
				"//div[@class='ui-datepicker-group ui-datepicker-group-first']//table/tbody[1]//td[(@class=' ' or @class=' ui-datepicker-week-end ' ) and @data-month='"
						+ javaMonthInt + "']"));
		for (WebElement date : allDateOfDesiredMonth) {
			if (date.getText().trim().equals(day)) {
				date.click();
				break;
			}
		}
	}


}
