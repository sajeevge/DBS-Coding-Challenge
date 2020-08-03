package com.testautomation.StepDef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.testautomation.Listeners.ExtentReportListener;

import com.testautomation.PageObjects.HomePage;
import com.testautomation.Utility.BrowserUtility;
import com.testautomation.Utility.PropertiesFileReader;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef extends ExtentReportListener
{
	PropertiesFileReader obj= new PropertiesFileReader();
	private WebDriver driver;
	
	
	  @Given("^User navigates to customer application$")
	    public void user_navigates_to_customer_application() throws Throwable {
		  ExtentTest logInfo=null;
			try {
				test = extent.createTest(Feature.class, "Flight portal navigation");							
				test=test.createNode(Scenario.class, "Flight portal navigation");						
				logInfo=test.createNode(new GherkinKeyword("Given"), "User navigates to customer application");
				Properties properties=obj.getProperty(); 		
				driver=BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL"));
				
				logInfo.pass("Opened chrome browser and entered url");
				//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));			
				
			} catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);			
			}	
	    }

	    @When("^User enters fromStation \"([^\"]*)\" and toStation \"([^\"]*)\"$")
	    public void user_enters_fromStation_and_toStation(String arg1, String arg2) throws Throwable {
	    	ExtentTest logInfo=null;
			try {
										
				logInfo=test.createNode(new GherkinKeyword("When"), "user_enters_fromStation_and_toStation");
				new HomePage(driver).enterOriginAndDestination(arg1,arg2);
				logInfo.pass("User entered origin and destination");
				//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				
			} catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);			
			}

	    }

	    @When("^User selects future date$")
	    public void user_selects_future_date() throws Throwable {
	    	ExtentTest logInfo=null;
			try {
										
				logInfo=test.createNode(new GherkinKeyword("When"), "user_selects_future_date");
				new HomePage(driver).enterdepDate();
				logInfo.pass("User selected future date");
				//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				
			} catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);			
			}

	    }

	    @When("^User clicks \"([^\"]*)\" button$")
	    public void user_clicks_button(String arg1) throws Throwable {
	    	ExtentTest logInfo=null;
			try {
										
				logInfo=test.createNode(new GherkinKeyword("When"), "user_clicks_button");
				new HomePage(driver).clickSearchFlightBtn();
				logInfo.pass("User clciked searchFlights button");
				//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				
			} catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);			
			}
	
	    }

	    @Then("^FlightResults page is populated$")
	    public void flightresults_page_is_populated() throws Throwable {
	    	ExtentTest logInfo=null;
			try {
										
				logInfo=test.createNode(new GherkinKeyword("Then"), "user_verifies_flightResultspage");
				new HomePage(driver).verifyFlightResultPage();
				logInfo.pass("User verified flight results page");
				//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				
			} catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);			
			}
	      
	    }

	    @Then("^User selects cheapest and fastest flight$")
	    public void user_selects_cheapest_and_fastest_flight() throws Throwable {
	    	ExtentTest logInfo=null;
			try {
										
				logInfo=test.createNode(new GherkinKeyword("Then"), "user_selects_cheapest_and_fastest_flight");
				new HomePage(driver).selectFlight();
				logInfo.pass("User slected cheapest and fasted flight with iteneraies");
				//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				
			} catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);			
			}
	      
	   
	    }
	

}
