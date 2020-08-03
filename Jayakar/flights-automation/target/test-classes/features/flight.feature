Feature: Flight itinerary planner

  Background: User is navigates to the google flight search page
  	Given I navigate to the site
  	
 Scenario Outline: Search for a given flight source/destination and get the fares
    When I enter "<source>" and "<destination>"
    Then I am shown the result page with the fares
    And I check the available flight results
    

    Examples: 
      | source   | destination|
      | Bengaluru| Hyderabad  |
      | Mumbai   | Delhi      |
  
 Scenario: Selecting the best itinerary based on the fastest and cheapest travel
 	When I enter "Pune" and "Hyderabad"
 	And I am shown the result page with the fares
 	Then the best itinerary is displayed based on fastest and cheapest travel
 	
 Scenario: Selecting the evening flight when multiple itinerary options are shown
 	When I enter "Delhi" and "Hyderabad"
 	And I am shown the result page with the fares
 	Then I select the evening flight which is the fastest