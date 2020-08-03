@flightSearch
Feature: This test will search for the flights for given city pair without using scenario outline

  Scenario: It will search for the flight in between given source and destination city
  Given I access website "https://www.goibibo.com/" url  
  When I click on Flight button on homepage
  And I select trip type as OneWay
  And I enter origin as "Pune" in Depart field
  And I enter destination as "Bengaluru" in Arrival field
  And I select the date as today plus "10" in Depart date
  And I click on Search Flights button
  Then I verify user is taken to select depart page with flight results page
  When I select suitable flight