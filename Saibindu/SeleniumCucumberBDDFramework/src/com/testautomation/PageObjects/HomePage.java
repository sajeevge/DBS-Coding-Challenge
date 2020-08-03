package com.testautomation.PageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		 //driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
		 }
	

	 @FindBy(how = How.NAME, using = "origin") 
	 private WebElement fromStation;
	 
	 @FindBy(how = How.NAME, using = "destination") 
	 private WebElement toStation;
	 
	 @FindBy(how = How.ID, using = "DepartDate") 
	 private WebElement depDate;
	 
	 @FindBy(how = How.ID, using = "SearchBtn") 
	 private WebElement Btn_SearchFlights;
	 
		 
	 public void enterOriginAndDestination(String strOrigin,String strDestination) {
		
		 fromStation.clear();
		 fromStation.sendKeys(strOrigin);
		 fromStation.sendKeys(Keys.ENTER);
	
		 toStation.clear();
		 toStation.sendKeys(strDestination);
		 toStation.sendKeys(Keys.ENTER);
	 }
	 public void enterdepDate() {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 Calendar c = Calendar.getInstance();
		 c.add(Calendar.DAY_OF_MONTH, 7);  
		 String newDate = formatter.format(c.getTime());  
		 depDate.clear();
		 depDate.sendKeys(newDate);
	 }
	 public void clickSearchFlightBtn() {
		 Btn_SearchFlights.click();
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	public void verifyFlightResultPage() {
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Assert.assertTrue(driver.getCurrentUrl().contains("results"));
	 }
	 public void selectFlight() throws ParseException {
		 
		 driver.findElement(By.xpath("(//span[contains(@class,'checkbox')])[1]")).click();
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 int priceIndex=0;
		 int durationIndex = 0;
		 String priceFirst = driver.findElement(By.xpath("(//div[@data-ct-handle='solutionPrice']/p[contains(text(),'₹')])[1]")).getText();
		 List<WebElement> priceList = driver.findElements(By.xpath("//div[@data-ct-handle='solutionPrice']/p[contains(text(),'₹')]"));
		 String durationFirst = driver.findElement(By.xpath("(//div[@data-ct-handle='solutionPrice']/p[contains(text(),'₹')]/parent::div/parent::div/parent::div/div[2]/div/div[3]/p)[1]")).getText();
				
			for(WebElement wb :priceList) {
			 if(wb.getText().contentEquals(priceFirst)) {
				 priceIndex=priceIndex+1;
			     String duration = wb.findElement(By.xpath("/parent::div/parent::div/parent::div/div[2]/div/div[3]/p")).getText();
			     if(duration.contentEquals(durationFirst)) {
			    	 durationIndex = durationIndex+1;
			    	 String startTime = wb.findElement(By.xpath("/parent::div/parent::div/parent::div/div[2]/div/div[1]/p")).getText();
			    	 SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
			    	 Date eighteen = parser.parse("18:00");
			    	 Date twentyone = parser.parse("21:00");
			    	 try {
			    		 Date userDate = parser.parse(startTime);
			    		 if(userDate.after(eighteen) && userDate.before(twentyone)) {
			    			  wb.findElement(By.xpath("/parent::div/parent::div/parent::div/div[4]/button")).click();
			    			  System.out.println("first evening flight is selected:  multiple itenaries with same price and same duration");
			 				 break;
			    		 }
			    		 
			    	 }catch(ParseException e) {}
			    	
			   
			     }else
			    	 break;
			 } 
			 else
				 wb.findElement(By.xpath("/parent::div/parent::div/parent::div/div[4]/button")).click();
			     System.out.println("first cheapest flight is selected: no multiple itenaries with same price");
				 break;
			 
		 }
		 
	 }
	 
	 
}
