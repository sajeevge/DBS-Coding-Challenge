package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonConstants;
import utils.InstancesManager;

public class Hooks {
		
	@Before
	public void launchBrowser() {
		WebDriver driver = null;
		String browser = System.getProperty("browser");

		switch (browser) {

			case CommonConstants.CHROME:
				System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-extensions");
				options.addArguments("start-maximized");
				driver = new ChromeDriver(options);
				break;
				
			case CommonConstants.FIREFOX:
				System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().deleteAllCookies();
				break;

			case CommonConstants.IE:
				System.setProperty("webdriver.ie.driver", "src\\test\\resources\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
				
		}

		Long threadID = Thread.currentThread().getId();
		InstancesManager.driverMap.put(threadID, driver);
	}
	
	public WebDriver getDriver() {
		return InstancesManager.driverMap.get(Thread.currentThread().getId());
	}
	
	@After
	public void tearDown() {
		WebDriver driver = getDriver();
        if(driver != null) {
           driver.close();
           driver.quit();
        }
	}
}
