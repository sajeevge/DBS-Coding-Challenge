package TestPages;

import org.openqa.selenium.WebDriver;

import com.intuit.karate.driver.Key;
import com.intuit.karate.driver.Keys;
import com.intuit.karate.driver.chrome.Chrome;



public class TestPage {
	 public Chrome driver;
	 public static WebDriver web= null;
	 public static Chrome driverKarate=null;
	 
	 
	 public void setDriver(Chrome karate) {
         driverKarate=karate;
     }
	 
	 public void BookFlight() {
		 
		 driverKarate.click(TestPageElements.FlightSearch);
		 driverKarate.input(TestPageElements.Source,""+Keys.DELETE);
		 driverKarate.input(TestPageElements.Source, "Chennai"+Keys.TAB);
		 driverKarate.input(TestPageElements.Destination, "Bangalore"+Keys.TAB);
		 driverKarate.click(TestPageElements.Search);
		 driverKarate.waitForUrl(TestPageElements.RedirectURL);
		 driverKarate.click(TestPageElements.SelectFlight);
		 driverKarate.click(TestPageElements.ConfirmFlight);
		 driverKarate.delay(1000).screenshot();
		}
}
