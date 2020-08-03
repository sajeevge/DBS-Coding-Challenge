Feature: UI example
  Background: 
    * def TestPage = Java.type('TestPages.TestPage');
    * def jd = new TestPage();

    
    Scenario Outline: Book flight
      Given driver "https://www.skyscanner.co.in/"
      When maximize()
      Then waitForUrl("https://www.skyscanner.co.in/")
      
       # Set Karate Driver
    * def setDriver =
      """
      function(arg) {
      	return jd.setDriver(arg);
      }
      """
    # Book Flight
    * def BookFlight =
      """
      function() {
      	return jd.BookFlight();
      }
      """
    # Calling Setdriver and Book flight function
    * call setDriver(driver)
    * call BookFlight()
    # Taking Screenshot
    * delay(2000).screenshot()
    # Closing browser
    And close()
    
      Examples:
      | config |
      | { type: 'chrome' } | 
 		

