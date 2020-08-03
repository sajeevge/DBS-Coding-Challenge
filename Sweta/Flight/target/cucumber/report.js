$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/flightSearch.feature");
formatter.feature({
  "name": "This test will search for the flights for given city pair with using scenario outline",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@flightSearch"
    }
  ]
});
formatter.scenarioOutline({
  "name": "It will search for the flight in between given source and destination city",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I access website \"\u003cwebsiteUrl\u003e\" url",
  "keyword": "Given "
});
formatter.step({
  "name": "I click on Flight button on homepage",
  "keyword": "When "
});
formatter.step({
  "name": "I select trip type as OneWay",
  "keyword": "And "
});
formatter.step({
  "name": "I enter origin as \"\u003cPune\u003e\" in Depart field",
  "keyword": "And "
});
formatter.step({
  "name": "I enter destination as \"\u003cDestination\u003e\" in Arrival field",
  "keyword": "And "
});
formatter.step({
  "name": "I select the date as today plus \"\u003cdays\u003e\" in Depart date",
  "keyword": "And "
});
formatter.step({
  "name": "I click on Search Flights button",
  "keyword": "And "
});
formatter.step({
  "name": "I verify user is taken to select depart page with flight results page",
  "keyword": "Then "
});
formatter.step({
  "name": "I select suitable flight",
  "keyword": "When "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "websiteUrl",
        "Origin",
        "Destination",
        "days"
      ]
    },
    {
      "cells": [
        "https://www.goibibo.com/",
        "Delhi",
        "Bengaluru",
        "5"
      ]
    }
  ]
});
formatter.scenario({
  "name": "It will search for the flight in between given source and destination city",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@flightSearch"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I access website \"https://www.goibibo.com/\" url",
  "keyword": "Given "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_access_website_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Flight button on homepage",
  "keyword": "When "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_click_on_Flight_button_on_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select trip type as OneWay",
  "keyword": "And "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_select_trip_type_as_OneWay()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter origin as \"\u003cPune\u003e\" in Depart field",
  "keyword": "And "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_enter_origin_as_in_Depart_field(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter destination as \"Bengaluru\" in Arrival field",
  "keyword": "And "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_enter_destination_as_in_Arrival_field(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select the date as today plus \"5\" in Depart date",
  "keyword": "And "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_select_the_date_as_today_plus_in_Depart_date(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Search Flights button",
  "keyword": "And "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_click_on_Search_Flights_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify user is taken to select depart page with flight results page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_verify_user_is_taken_to_select_depart_page_with_flight_results_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select suitable flight",
  "keyword": "When "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_select_suitable_flight()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/flightSearchTwo.feature");
formatter.feature({
  "name": "This test will search for the flights for given city pair without using scenario outline",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@flightSearch"
    }
  ]
});
formatter.scenario({
  "name": "It will search for the flight in between given source and destination city",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@flightSearch"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I access website \"https://www.goibibo.com/\" url",
  "keyword": "Given "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_access_website_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Flight button on homepage",
  "keyword": "When "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_click_on_Flight_button_on_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select trip type as OneWay",
  "keyword": "And "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_select_trip_type_as_OneWay()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter origin as \"Pune\" in Depart field",
  "keyword": "And "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_enter_origin_as_in_Depart_field(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter destination as \"Bengaluru\" in Arrival field",
  "keyword": "And "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_enter_destination_as_in_Arrival_field(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select the date as today plus \"10\" in Depart date",
  "keyword": "And "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_select_the_date_as_today_plus_in_Depart_date(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Search Flights button",
  "keyword": "And "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_click_on_Search_Flights_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify user is taken to select depart page with flight results page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_verify_user_is_taken_to_select_depart_page_with_flight_results_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select suitable flight",
  "keyword": "When "
});
formatter.match({
  "location": "com.flights.steps.FlightSearchSteps.i_select_suitable_flight()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});