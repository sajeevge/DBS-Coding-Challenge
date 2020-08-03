package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	/***
	 * Method for getting driver instance
	 * @return
	 */
	public WebDriver getDriver() {
		return InstancesManager.driverMap.get(Thread.currentThread().getId());
	}

	/***
	 * Waiting for an element
	 * @param webElement
	 * @param driver
	 */
	public static void waitForElement(final WebElement webElement, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ExpectedCondition<Boolean> elementIsDisplayed = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					webElement.isDisplayed();
					return true;
				} catch (NoSuchElementException e) {
					return false;
				} catch (StaleElementReferenceException f) {
					return false;
				}
			}
		};
		wait.until(elementIsDisplayed);
	}

	/***
	 * Wait for title
	 * @param string
	 * @param driver
	 */
	public void waitForTitle(String string, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.titleContains(string));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * Scroll web page using JSExecutor
	 */
	public void scrollToUsingJS() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0,100)");
	}

	/***
	 * Gets integer value of specified month
	 * @param monthName
	 * @return
	 * @throws ParseException
	 */
	public static int getMonthJavaInt(String monthName) throws ParseException {
		Date date = new SimpleDateFormat("MMMM").parse(monthName);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}
	
	
}
