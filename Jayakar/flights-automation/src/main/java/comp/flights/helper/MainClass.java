package comp.flights.helper;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.*;

@SuppressWarnings("static-access")
public class MainClass {
	public static WebDriver driver;
	public static Properties objectProperty;
		
	static {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Tools\\chromedriver.exe");
		objectProperty= new Properties();
		try {
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
			objectProperty.load(objfile);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	static {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Tools\\geckodriver.exe");
		objectProperty= new Properties();
		try {
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
			objectProperty.load(objfile);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public MainClass(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void closeDriver() {
		driver.close();
	}
}
