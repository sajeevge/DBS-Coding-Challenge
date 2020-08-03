package com.flights.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	Logger logger;

	/**
	 * @param driver
	 */
	public BasePage(WebDriver driver) {
		this.driver = driver;
		logger = Logger.getLogger(this.getClass());
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	public void getUrl(String url) {

		try {
			if (!url.equals("")) {
				driver.get(url);
				logger.info("Able to open " + driver.getCurrentUrl() + " url");
			} else {
				logger.error("Unable to get Page URL " + driver.getCurrentUrl() + " url");

			}
		} catch (Exception e) {
			logger.error("Exception in getUrl method- " + e.getMessage());

		}
	}

	public void Click(WebElement element) {
		try {

			logger.info("Element " + element.getText() + " clicked successfully");
			element.click();
		} catch (Exception e) {
			logger.error("Exception in Click method- " + e.getMessage());

		}
	}

	public void sendData(WebElement element, String data) {
		try {
			logger.info("Cleared the " + element.getText() + " text field");

			element.sendKeys(data);
			logger.info("Send data to " + element.getText() + " sucessfully");

		} catch (Exception e) {
			logger.error("Exception in sendData method- " + e.getMessage());

		}
	}

	public void swipeWhileNotFound(WebElement element, int maxRounds) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			for (int scrollCounter = 0; scrollCounter < maxRounds; scrollCounter++) {
				if (isElementPresent(element)) {
					break;
				}
				js.executeScript("window.scrollBy(0,100)");
				logger.info("Swiping : ");

			}
		} catch (Exception e) {
			logger.error("Exception in swipeWhileNotFound method- " + e.getMessage());

		}
	}

	private boolean isElementPresent(WebElement element) {
		try {
			driver.findElement(By.xpath(element.toString()));
			logger.info("Element " + element.getText() + " found");

			return true;
		} catch (NoSuchElementException e) {
			logger.error("Exception in isElementPresent method- " + e.getMessage());
			return false;
		}
	}

	public void verifyPageHeader(String header) {
		String pageTitle = null;
		try {
			pageTitle = driver.getTitle();
			if (pageTitle.equalsIgnoreCase(header)) {
				logger.info("Header " + header + " is found");

			} else {
				logger.info("Header " + header + " is not found");

			}
		} catch (Exception e) {
			logger.error("Exception in verifyPageHeader method- " + e.getMessage());

		}
	}

	public void clearATextField(WebElement element) {
		try {
			if (!(element.getAttribute("value").equalsIgnoreCase(""))) {
				logger.info("Element field " + element.getText() + " value attribute recived sucessfully");

				element.clear();
				logger.info("Element field " + element.getText() + " is cleared sucessfully");

			}
		} catch (Exception e) {
			logger.error("Exception in clearATextField method- " + e.getMessage());

		}
	}

	public void waitForAnElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		try {
			String xpathExpressionTemp = element.toString().split("xpath: ")[1].trim();
			String xpathExpression = xpathExpressionTemp.substring(0, xpathExpressionTemp.length() - 1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			logger.error("Element" + element + " not found");
		}
	}

	public void waitTillInvisbilityOfToastMsg(WebElement element) {
		try {
			String xpathExpressionTemp = element.toString().split("xpath: ")[1].trim();
			String xpathExpression = xpathExpressionTemp.substring(0, xpathExpressionTemp.length() - 1);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			logger.info("Wait for the " + element.getText() + " to be invisible");

			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpathExpression))));
			logger.info("element is invisible now");

		} catch (Exception e) {
			logger.error("Exception in waitTillInvisbilityOfToastMsg method- " + e.getMessage());

		}
	}

	public void ActionClickDownArrow() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
	}

	public void verifyMoreThanOneElements(List<WebElement> flightResults) {
		try {
			if (flightResults.size() > 0)
				logger.info("Flights are available");
		} catch (Exception e) {
			logger.error("Exception in getUrl method- " + e.getMessage());

		}
	}

	public void selectDepartFlight(String baseXpath) {
		//waitForAnElementToBeVisible(driver.findElement(By.xpath(baseXpath)));
		List<FlightData> flightData = new ArrayList<FlightData>();
		FlightData flight;

		for (int i = 0; i < (driver.findElements(By.xpath(baseXpath))).size(); i++) {
			String flightNumber = driver.findElement(By.xpath("(" + baseXpath + "[" + (i + 1) + "]//img[@class='flightImagesNew'])[2]/../../*[3]")).getAttribute("innerHTML");
			
			String travelTime = driver.findElement(By.xpath(baseXpath + "[" + (i + 1) + "]//div[@data-cy='duration']")).getText();
			
			String fare = driver.findElement(By.xpath(baseXpath + "[" + (i + 1) + "]//span[@data-cy='finalPrice']")).getText().replace(",", "");
			
			flight = new FlightData(flightNumber, fare, travelTime);
			
			flightData.add(flight);

		}

		Comparator<FlightData> comp = new Comparator<FlightData>() {
			@Override
			public int compare(FlightData o1, FlightData o2) {

				int hourValue = Integer.parseInt(o1.getTravelTime().split(" ")[0].replace("h", "")) * 60;
				int minute = Integer.parseInt(o1.getTravelTime().split(" ")[1].replace("m", ""));
				int totalTimeInMinutes1 = hourValue + minute;
				hourValue = Integer.parseInt(o2.getTravelTime().split(" ")[0].replace("h", "")) * 60;
				minute = Integer.parseInt(o2.getTravelTime().split(" ")[1].replace("m", ""));
				int totalTimeInMinutes2 = hourValue + minute;
				if (totalTimeInMinutes1 < totalTimeInMinutes2)
					return -1;

				else if (totalTimeInMinutes1 > totalTimeInMinutes2) {
					return 1;
				} else {
					if (Double.parseDouble(o1.getFare()) < Double.parseDouble(o1.getFare()))
						return -1;
					else if (Double.parseDouble(o1.getFare()) > Double.parseDouble(o1.getFare()))
						return 1;
					else
						return 0;
				}
			}
		};

		Collections.sort(flightData, comp);
		
		driver.findElement(By.xpath("(//span[text()='" + flightData.get(0).getFlightNumber()
				+ "']//ancestor::div[contains(@data-cy,'flightItem_')]//*//input[@value='BOOK'])[1]")).click();

	}

	public String returnDate(String string) {
		DateFormat SelectId = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, Integer.parseInt(string));
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.MONTH, 1);
		String date = SelectId.format(cal.getTime());
		//It will check if the travel date is within the current month or not
		if(Integer.parseInt(date.substring(4,6))==Integer.parseInt((SelectId.format(cal1.getTime())).substring(4, 6))) {
			driver.findElement(By.xpath("//span[contains(@class,'DayPicker-NavButton')]")).click();
		}
		
		
		return (date);
	}

	public void sendKeys(WebElement element, WebElement waitFor, String string) {
		element.click();
		element.clear();
		element.sendKeys(string);
		waitForAnElementToBeVisible(waitFor);
		ActionClickDownArrow();
	}
}
