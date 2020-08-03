package comp.flights.helper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@SuppressWarnings("static-access")
public class Flight extends MainClass {
	
	public WebElement element;
	public List<WebElement> elements;
	public Boolean exists;
	
	public Flight(WebDriver driver) {
		super(driver);
	}
	
	public void setSource(String source) throws InterruptedException {
		element=placeHolderElement(MainClass.objectProperty.getProperty("originAirport"), MainClass.objectProperty.getProperty("placeIdentifier"));
		element.sendKeys(source);
		driver.findElement(By.xpath("//span[contains(text(),'"+source+"')]")).click();
		Thread.sleep(3000);	
	}

	public List returnElements(String value) {
		 elements =driver.findElements(By.xpath(value));
		return elements;
	}
	
	public WebElement returnElement(String value) {
		element = driver.findElement(By.xpath(value));
		return element;
	}
	public WebElement placeHolderElement(String place,String identifier) throws InterruptedException
	{
		elements=returnElements(place);
		elements.get(7).click();
		Thread.sleep(3000);
		element=returnElement(identifier);
		element.click();
		element.clear();
		return element;
	}
	public Boolean existenceByXpath(String value)
	{
		exists=driver.findElement(By.xpath("//span[@jstcache='7642']")).isDisplayed();
		return exists;
	}
	
	public Boolean existenceByCss(String value)
	{
		exists=driver.findElement(By.cssSelector("#gws-flights-results__best_flights_heading")).isDisplayed();
		return exists;
	}
	
	public void setDestination(String destination) throws InterruptedException {
		element=placeHolderElement(MainClass.objectProperty.getProperty("destinationAirport"), MainClass.objectProperty.getProperty("placeIdentifier"));
		element.sendKeys(destination);
		driver.findElement(By.xpath("//span[contains(text(),'"+destination+"')]")).click();
		Thread.sleep(3000);
	}
	
	public void search() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.findElement(By.cssSelector(MainClass.objectProperty.getProperty("searchFlights"))).click();	
		Thread.sleep(4000);
	}
	
	
	public static String returnOnlyDigitsFromString(String str) {

		        str = str.replaceAll("[^\\d]", " ");       
		    
		        str = str.trim();
		       
		        str = str.replaceAll(" +", "");
		 
		        if (str.equals(""))
		            return "-1";
		 
		        return str;
		}

}
