package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;
import utils.Flight;
import utils.FlightComparator;
import utils.CommonConstants;

public class SelectFlightPage extends BasePage{
	WebDriver driver;

	public SelectFlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "continue-button")
	private WebElement continueBtn;
	
	@FindBy(how = How.CSS, using = "div.container-fluid > div > div:nth-child(5) > button")
	private WebElement duration;
	
	@FindBy(how = How.CSS, using = "i[class*='icon-icSunSet']")
	private WebElement sunnyIcon;	
	
	@FindBy(how = How.CSS, using = "div[class*='row trips-row']")
	private List<WebElement> rows;
	
	@FindBy(how = How.CSS, using = "div[class='flight ']")
	private List<WebElement> flightNumbersList;
	
	@FindBy(how = How.CSS, using = "div[class='duration duration-Big']")
	private List<WebElement> durationList;
	
	@FindBy(how = How.CSS, using = "div[class*='row trips-row']>div:nth-child(2)>div>label:nth-child(1)>div>div:nth-child(2)>span")
	private List<WebElement> priceList;
	
	@FindBy(how = How.CSS, using = "input[type='radio']")
	private List<WebElement> radioBtns;
		
	/**
	 * Select Flight based on criteria
	 * @param selectionCriteria
	 */
	public void selectFlight(String selectionCriteria) {
		try {
			ArrayList<Flight> flightList = new ArrayList<Flight>();
			
			for( int i=0; i<rows.size(); i++ ) {
				String flightNumber = flightNumbersList.get(i).getText();
				String duration = durationList.get(i).getText();
				String price = priceList.get(i).getText();
				price = price.replace(",", "").substring(1);
				int priceInt = Integer.parseInt(price);
				
				Flight flight = new Flight(i, flightNumber, priceInt, getTotalTimeOfFlight(duration));
				flightList.add(flight);
			}
			Collections.sort(flightList,new FlightComparator(CommonConstants.DURATION));
			
			if (selectionCriteria.equalsIgnoreCase(CommonConstants.FASTEST)) {
				if (priceList.get(flightList.get(0).getIndex()).isDisplayed()) {
					for (int i = 0; i < priceList.size(); i++) {
						try {
							priceList.get(flightList.get(0).getIndex()).click();
						} catch (ElementClickInterceptedException e) {
							scrollToUsingJS();
						}
					}
				}
			} else if (selectionCriteria.equalsIgnoreCase(CommonConstants.EVENING)) {
				selectEveningFlight();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Selects the evening and fastest flight
	 */
	public void selectEveningFlight() {
		try {
			// getting the less duration flight
			duration.click();
			duration.click();
			sunnyIcon.click();
			for (WebElement element : radioBtns) {
				if (element.isDisplayed()) {
					element.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Converting time format in minutes
	 * @param duration
	 * @return
	 */
	private int getTotalTimeOfFlight(String duration) {
		String[] travelTime = duration.split(" ");
		String secondPart = travelTime[1].substring(0, 2);
		if (secondPart.contains("m")) {
			secondPart = secondPart.replace("m", "");
		}
		int travelTimeInMinutes = (Integer.parseInt(travelTime[0].replace("h", "")) * 60) + (Integer.parseInt(secondPart));
		return travelTimeInMinutes;
	}
	
	/**
	 * Click on Continue Button
	 */
	public void clickOnContinueBtn() {
		try {
			continueBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
