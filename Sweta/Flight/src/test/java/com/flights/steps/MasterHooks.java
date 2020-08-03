package com.flights.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.flights.utils.Constants;

import io.cucumber.java.Scenario;

public class MasterHooks {

	private WebDriver driver;

	public WebDriver setup() {

		
		//String browserName = System.getProperty("browserValue");
		String browserName = "chrome";
		try {
			switch (browserName) {
			case "chrome":
				if (driver == null) {
					System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_LOCATION);
					driver = new ChromeDriver();
					driver.manage().window().maximize();

				}
				break;

			case "ie":
				if (driver == null) {
					System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_LOCATION);
					InternetExplorerOptions iop = new InternetExplorerOptions();
					iop.ignoreZoomSettings();
					iop.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					driver = new InternetExplorerDriver(iop);
				}
				break;
				
			case "firefox":
				if (driver == null) {
					System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_LOCATION);
					FirefoxOptions options = new FirefoxOptions();
					options.setLegacy(true);
					driver=new FirefoxDriver();
				}
				break;
			}
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

		} catch (Exception e) {
			System.out.println("Could not start the browser " + e.getMessage());
		}
		return driver;
	}

	public void destroy(Scenario scenario) {
		
		if (scenario.isFailed()) {
			byte[] screenshot = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png","The failure screenshot");
		}
		
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}

}
