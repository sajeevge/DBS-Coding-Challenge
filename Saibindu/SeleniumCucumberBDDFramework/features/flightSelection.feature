Feature: Flight Selction Functionality

Background:
Given User navigates to customer application

@FlightPortalTest
Scenario: User navigates to  Flight results page 
When User enters fromStation "Bangalore" and toStation "Mumbai"
And User selects future date
And User clicks "SearchFlight" button
Then FlightResults page is populated

@FlightPortalTest
Scenario: User navigates to  Flight results page 
When User enters fromStation "Bangalore" and toStation "Mumbai"
And User selects future date
And User clicks "SearchFlight" button
Then FlightResults page is populated
And User selects cheapest and fastest flight

