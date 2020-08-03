package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utils.BasePage;

import java.util.concurrent.TimeUnit;


public class HomePageSteps extends BasePage {

	WebDriver driver = getDriver();
	HomePage homePage;

	@Given("User is navigated successfully to the indigo website")
	public void user_is_navigated_successfully_to_the_indigo_website() {
		driver.manage().window().maximize();
		driver.get("https://www.goindigo.in/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@Then("I verify {string} page title")
	public void i_verify_page_title(String string) {
		waitForTitle(string, driver);
		String title = driver.getTitle();
		Assert.assertTrue(title.contains(string));
	}
	
	@When("I Enter {string} as Origin")
	public void i_Enter_Origin(String source) {
		homePage = new HomePage(driver);
		homePage.selectSourceCity(source);
		homePage.verifySource(source);
	}

	@When("I Enter {string} as Destination")
	public void i_Enter_Destination_as(String dest) {
		homePage = new HomePage(driver);
		homePage.selectDestinationCity(dest);
	}

	@When("Select depart date as {string} in from field")
	public void select_depart_date(String date) {
		homePage = new HomePage(driver);
		String[] departDate = date.split("-");
		String year = departDate[0];
		String month = departDate[1];
		String dateParam = departDate[2];
		homePage.selectDepartdate(year, month, dateParam);
	}

	@When("I select One way radio button")
	public void i_select_radio_button() {
		homePage = new HomePage(driver);
		homePage.clickOnOnewayBtn();
	}

	@When("I click on search button")
	public void i_click_on_search_button() {
		homePage = new HomePage(driver);
		homePage.clickOnSearchButton();
	}
	
}
