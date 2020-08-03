package com.flights.steps;


import org.openqa.selenium.WebDriver;

import com.flight.pages.FlightSearchPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightSearchSteps {

	FlightSearchPage flightSearchPage;
	WebDriver driver;
	MasterHooks masterhooks;
	@Before
	public void setBrowser() {
		masterhooks = new MasterHooks();
		this.driver = masterhooks.setup();
		flightSearchPage = new FlightSearchPage(driver);
	}
	
	
	@Given("I access website {string} url")
	public void i_access_website_url(String string) {
		flightSearchPage.UrlOpen(string);
	}

	@When("I click on Flight button on homepage")
	public void i_click_on_Flight_button_on_homepage() {
		flightSearchPage.clickOnFlightButton();
	}

	@When("I select trip type as OneWay")
	public void i_select_trip_type_as_OneWay() {
		flightSearchPage.clickOnOneWay();
	}

	@When("I enter origin as {string} in Depart field")
	public void i_enter_origin_as_in_Depart_field(String string) {
		flightSearchPage.enterDepartCity(string);
	}

	@When("I enter destination as {string} in Arrival field")
	public void i_enter_destination_as_in_Arrival_field(String string) {
		flightSearchPage.enterArrivalCity(string);
	}

	@When("I select the date as today plus {string} in Depart date")
	public void i_select_the_date_as_today_plus_in_Depart_date(String string) {
		flightSearchPage.selectTravelDate(string);
	}

	@When("I click on Search Flights button")
	public void i_click_on_Search_Flights_button() {
		flightSearchPage.clickOnSearchButton();
	}

	@Then("I verify user is taken to select depart page with flight results page")
	public void i_verify_user_is_taken_to_select_depart_page_with_flight_results_page() {
		flightSearchPage.verifyFlightResultsPage();
	}

	@When("I select suitable flight")
	public void i_select_suitable_flight() {
		flightSearchPage.selectFlight();
	}

	@After
	public void tearDown(Scenario s) {
		masterhooks.destroy(s);
	}

}
