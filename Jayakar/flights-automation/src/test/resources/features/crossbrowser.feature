Feature: Flight itinerary planner for parellel execution

  Background: User navigates to the google flight search page
  	Given user navigates to the site
  	
  
 Scenario: Selecting the best itinerary based on the fastest and cheapest travel
 	When user enters "Pune" and "Hyderabad"
 	And user is shown the result page with the fare
 	Then user is shown the best itinerary based on fastest and cheapest travel
 	
 Scenario: Selecting the evening flight when multiple itinerary options are shown
 	When user enters "Delhi" and "Hyderabad"
 	And user is shown the result page with the fare
 	Then user selects the evening flight which is the fastest