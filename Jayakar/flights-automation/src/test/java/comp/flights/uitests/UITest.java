package comp.flights.uitests;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

import static org.testng.Assert.assertEquals;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import comp.flights.helper.Flight;
import comp.flights.helper.Log;
import comp.flights.helper.MainClass;
import comp.flights.constant.*;

@SuppressWarnings("static-access")

public class UITest {
	public MainClass mainclass;
	public Flight flight;
	public Scenario scenario;
	public int flightResultLength;
	public static JavascriptExecutor javaScriptExec;
	public List timing = new ArrayList();
	public List duration = new ArrayList();
	public List price = new ArrayList();
	public List<String> flightDetails=new ArrayList();
	public List<String> tempFlightDetails=new ArrayList();
	HashMap<Integer, List<String>> itineraryMap = new HashMap<Integer, List<String>>();
	
	@Before
	public void setUp(Scenario scenario) {
		this.scenario = scenario;
		Log.info("Scenario name is:-" + scenario.getName().toUpperCase());
		flightDetails.clear();
		itineraryMap.clear();
	}

	@After
	public void after(Scenario scenario) {
		this.scenario = scenario;
		//flight.closeDriver();
	}

	@Given("^I navigate to the site$")
	public void navigateToUI() throws InterruptedException {
		flight = new Flight(mainclass.driver);
		ChromeOptions options = new ChromeOptions();
		flight.driver = new ChromeDriver(options);
		flight.driver.navigate().to(Constants.url);
		flight.maximizeWindow();
		flight.driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		Flight.driver.findElement(By.cssSelector("span.gws-flights-form__menu-button-icon:nth-child(4) > span")).click();

		WebDriverWait wait=new WebDriverWait(Flight.driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("menu-item.mSPnZKpnf91__menu-item:nth-child(2)")));
		Flight.driver.findElement(By.cssSelector("menu-item.mSPnZKpnf91__menu-item:nth-child(2)")).click();
	}

	@When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enterSourceDestination(String Source, String Destination) throws InterruptedException {
		System.out.println("source is " +Source);
		System.out.println("destination is " +Destination);
		flight.setSource(Source);
		flight.setDestination(Destination);
	}

	@Then("^I am shown the result page with the fares$")
	public void bestItineraryChooser() throws InterruptedException {
		flight.search();
		assertEquals(flight.existenceByCss("#gws-flights-results__best_flights_heading"), Boolean.TRUE,"Flight search results not displayed");
		System.out.println("Search Results are displayed");
	}
	
	@Then("^I check the available flight results$")
	public void checkAvailableFlightResult() throws InterruptedException {
		
		flight.driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		javaScriptExec = (JavascriptExecutor) flight.driver;
		
		String flightResult=javaScriptExec.executeScript("return " +mainclass.objectProperty.getProperty("flightSearchResultLenth")).toString();
		flightResultLength=Integer.parseInt(flightResult);
		System.out.println("length is  "+ flightResultLength);
		for (int i=0;i<flightResultLength;i++)
		{
			String carrier=javaScriptExec.executeScript("return " +MessageFormat.format(mainclass.objectProperty.getProperty("carrier"), i)).toString();
			String timing=javaScriptExec.executeScript("return " +MessageFormat.format(mainclass.objectProperty.getProperty("timing"), i)).toString();
			String duration=javaScriptExec.executeScript("return " +MessageFormat.format(mainclass.objectProperty.getProperty("duration"), i)).toString();
			String airport=javaScriptExec.executeScript("return " +MessageFormat.format(mainclass.objectProperty.getProperty("airport"), i)).toString();
			String price=javaScriptExec.executeScript("return " +MessageFormat.format(mainclass.objectProperty.getProperty("price"), i)).toString();
			itineraryMap.put(i, Arrays.asList(carrier,timing,duration,airport,price));
			
		}
	}
	
	@Then("^the best itinerary is displayed based on fastest and cheapest travel$")
	
	public void bestItineraryChoosers() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(Flight.driver, 20);
		List<WebElement> itineraryOptionsForPrice;
		List<WebElement> itineraryOptionsForDuration;
		List<Integer> priceList=new ArrayList<>();


		itineraryOptionsForPrice=Flight.driver.findElements(By.xpath("//*[@jstcache='7723']//div[@class='gws-flights-results__itinerary-price']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(itineraryOptionsForPrice));

		itineraryOptionsForDuration=Flight.driver.findElements(By.xpath("//*[@jstcache='7696']//div[@class='gws-flights-results__duration flt-subhead1Normal']"));
		System.out.println("Number of flights->"+itineraryOptionsForPrice.size());
		for(int priceOptions=0;priceOptions<itineraryOptionsForPrice.size();priceOptions++) {
		for(int durationOptions=priceOptions;durationOptions<=priceOptions;durationOptions++) {
		System.out.println("Price in int format-> "+Integer.parseInt(Flight.returnOnlyDigitsFromString(itineraryOptionsForPrice.get(priceOptions).getText()))+"\tDuration in int format-> "+Integer.parseInt(Flight.returnOnlyDigitsFromString(itineraryOptionsForDuration.get(durationOptions).getText())));
		priceList.add(Integer.parseInt(Flight.returnOnlyDigitsFromString(itineraryOptionsForPrice.get(priceOptions).getText())));
		}
		}
		
		Collections.sort(priceList);
 

		for(int i=0;i<itineraryOptionsForPrice.size();i++) {
		if(priceList.get(0)==Integer.parseInt(Flight.returnOnlyDigitsFromString(itineraryOptionsForPrice.get(i).getText()))) {
		itineraryOptionsForPrice.get(i).click();
		break;
		}
		}

		System.out.println("Sorted List of prices one way journey:");
		for(int sortedPriceList:priceList) {
		System.out.println(sortedPriceList);
		}
		
		flight.driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}
	
	@Then("^I select the evening flight which is the fastest$")
	public void bestItineraryChooserByTime() throws InterruptedException {
			WebDriverWait wait=new WebDriverWait(Flight.driver, 20);
			List<WebElement> itineraryOptionsByTime;
			List<WebElement> itineraryOptionsForDuration;
			List<Integer> timeList=new ArrayList<>();


			itineraryOptionsByTime=Flight.driver.findElements(By.xpath("//*[@jstcache='7723']//div[@class='gws-flights-results__times flt-subhead1']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(itineraryOptionsByTime));

			itineraryOptionsForDuration=Flight.driver.findElements(By.xpath("//*[@jstcache='7696']//div[@class='gws-flights-results__duration flt-subhead1Normal']"));
			System.out.println("Number of flights->"+itineraryOptionsByTime.size());
			for(int timeOptions=0;timeOptions<itineraryOptionsByTime.size();timeOptions++) {
			for(int durationOptions=timeOptions;durationOptions<=timeOptions;durationOptions++) {
			System.out.println("Price in int format-> "+Integer.parseInt(Flight.returnOnlyDigitsFromString(itineraryOptionsByTime.get(timeOptions).getText()))+"\tDuration in int format-> "+Integer.parseInt(Flight.returnOnlyDigitsFromString(itineraryOptionsForDuration.get(durationOptions).getText())));
			timeList.add(Integer.parseInt(Flight.returnOnlyDigitsFromString(itineraryOptionsByTime.get(timeOptions).getText())));
			}
			}
			
			Collections.sort(timeList);

			for(int i=0;i<itineraryOptionsByTime.size();i++) {
			if(timeList.get(0)==Integer.parseInt(Flight.returnOnlyDigitsFromString(itineraryOptionsByTime.get(i).getText()))) {
			itineraryOptionsByTime.get(i).click();
			break;
			}
			}

			System.out.println("Sorted List based on start time of the journey:");
			for(int sortedtimeList:timeList) {
			System.out.println(sortedtimeList);
			}
		
			flight.driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		}
	}