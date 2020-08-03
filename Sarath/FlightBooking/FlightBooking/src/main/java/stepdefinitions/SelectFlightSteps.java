package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import pages.SelectFlightPage;
import utils.BasePage;

public class SelectFlightSteps extends BasePage{

	WebDriver driver = getDriver();
	SelectFlightPage selectPage;
	
	@When("I select the {string} flight")
	public void i_select_flight(String string) {
		selectPage = new SelectFlightPage(driver);
		selectPage.selectFlight(string);
	}
	
	@When("I click on continue button in select page")
	public void i_click_on_continue() {
		selectPage = new SelectFlightPage(driver);
		selectPage.clickOnContinueBtn();
	}
}
