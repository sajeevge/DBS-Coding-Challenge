$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/flight.feature");
formatter.feature({
  "line": 1,
  "name": "Flight itinerary planner",
  "description": "",
  "id": "flight-itinerary-planner",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 6,
  "name": "Search for a given flight source/destination and get the fares",
  "description": "",
  "id": "flight-itinerary-planner;search-for-a-given-flight-source/destination-and-get-the-fares",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "I enter \"\u003csource\u003e\" and \"\u003cdestination\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I am shown the result page with the fares",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I check the available flight results",
  "keyword": "And "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "flight-itinerary-planner;search-for-a-given-flight-source/destination-and-get-the-fares;",
  "rows": [
    {
      "cells": [
        "source",
        "destination"
      ],
      "line": 13,
      "id": "flight-itinerary-planner;search-for-a-given-flight-source/destination-and-get-the-fares;;1"
    },
    {
      "cells": [
        "Bengaluru",
        "Hyderabad"
      ],
      "line": 14,
      "id": "flight-itinerary-planner;search-for-a-given-flight-source/destination-and-get-the-fares;;2"
    },
    {
      "cells": [
        "Mumbai",
        "Delhi"
      ],
      "line": 15,
      "id": "flight-itinerary-planner;search-for-a-given-flight-source/destination-and-get-the-fares;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 248000,
  "status": "passed"
});
formatter.before({
  "duration": 165777,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "User is navigates to the google flight search page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "I navigate to the site",
  "keyword": "Given "
});
formatter.match({
  "location": "UITest.navigateToUI()"
});
formatter.result({
  "duration": 8489350903,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Search for a given flight source/destination and get the fares",
  "description": "",
  "id": "flight-itinerary-planner;search-for-a-given-flight-source/destination-and-get-the-fares;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "I enter \"Bengaluru\" and \"Hyderabad\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I am shown the result page with the fares",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I check the available flight results",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Bengaluru",
      "offset": 9
    },
    {
      "val": "Hyderabad",
      "offset": 25
    }
  ],
  "location": "UITest.enterSourceDestination(String,String)"
});
formatter.result({
  "duration": 14289522725,
  "status": "passed"
});
formatter.match({
  "location": "UITest.bestItineraryChooser()"
});
formatter.result({
  "duration": 4403742573,
  "status": "passed"
});
formatter.match({
  "location": "UITest.checkAvailableFlightResult()"
});
formatter.result({
  "duration": 525173522,
  "status": "passed"
});
formatter.after({
  "duration": 17778,
  "status": "passed"
});
formatter.after({
  "duration": 13778,
  "status": "passed"
});
formatter.before({
  "duration": 182666,
  "status": "passed"
});
formatter.before({
  "duration": 122667,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "User is navigates to the google flight search page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "I navigate to the site",
  "keyword": "Given "
});
formatter.match({
  "location": "UITest.navigateToUI()"
});
formatter.result({
  "duration": 10066823022,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Search for a given flight source/destination and get the fares",
  "description": "",
  "id": "flight-itinerary-planner;search-for-a-given-flight-source/destination-and-get-the-fares;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "I enter \"Mumbai\" and \"Delhi\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I am shown the result page with the fares",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I check the available flight results",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Mumbai",
      "offset": 9
    },
    {
      "val": "Delhi",
      "offset": 22
    }
  ],
  "location": "UITest.enterSourceDestination(String,String)"
});
formatter.result({
  "duration": 14023912413,
  "status": "passed"
});
formatter.match({
  "location": "UITest.bestItineraryChooser()"
});
formatter.result({
  "duration": 4496263782,
  "status": "passed"
});
formatter.match({
  "location": "UITest.checkAvailableFlightResult()"
});
formatter.result({
  "duration": 611034741,
  "status": "passed"
});
formatter.after({
  "duration": 34222,
  "status": "passed"
});
formatter.after({
  "duration": 17778,
  "status": "passed"
});
formatter.before({
  "duration": 190667,
  "status": "passed"
});
formatter.before({
  "duration": 119999,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "User is navigates to the google flight search page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "I navigate to the site",
  "keyword": "Given "
});
formatter.match({
  "location": "UITest.navigateToUI()"
});
formatter.result({
  "duration": 7749654111,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Selecting the best itinerary based on the fastest and cheapest travel",
  "description": "",
  "id": "flight-itinerary-planner;selecting-the-best-itinerary-based-on-the-fastest-and-cheapest-travel",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "I enter \"Pune\" and \"Hyderabad\"",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "I am shown the result page with the fares",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "the best itinerary is displayed based on fastest and cheapest travel",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Pune",
      "offset": 9
    },
    {
      "val": "Hyderabad",
      "offset": 20
    }
  ],
  "location": "UITest.enterSourceDestination(String,String)"
});
formatter.result({
  "duration": 14055718593,
  "status": "passed"
});
formatter.match({
  "location": "UITest.bestItineraryChooser()"
});
formatter.result({
  "duration": 4284158732,
  "status": "passed"
});
formatter.match({
  "location": "UITest.bestItineraryChoosers()"
});
formatter.result({
  "duration": 1155494015,
  "status": "passed"
});
formatter.after({
  "duration": 24000,
  "status": "passed"
});
formatter.after({
  "duration": 16445,
  "status": "passed"
});
formatter.before({
  "duration": 261333,
  "status": "passed"
});
formatter.before({
  "duration": 185333,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "User is navigates to the google flight search page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "I navigate to the site",
  "keyword": "Given "
});
formatter.match({
  "location": "UITest.navigateToUI()"
});
formatter.result({
  "duration": 8174473101,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Selecting the evening flight when multiple itinerary options are shown",
  "description": "",
  "id": "flight-itinerary-planner;selecting-the-evening-flight-when-multiple-itinerary-options-are-shown",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 23,
  "name": "I enter \"Delhi\" and \"Hyderabad\"",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "I am shown the result page with the fares",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "I select the evening flight which is the fastest",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Delhi",
      "offset": 9
    },
    {
      "val": "Hyderabad",
      "offset": 21
    }
  ],
  "location": "UITest.enterSourceDestination(String,String)"
});
formatter.result({
  "duration": 14041507945,
  "status": "passed"
});
formatter.match({
  "location": "UITest.bestItineraryChooser()"
});
formatter.result({
  "duration": 4382753267,
  "status": "passed"
});
formatter.match({
  "location": "UITest.bestItineraryChooserByTime()"
});
formatter.result({
  "duration": 1461418940,
  "status": "passed"
});
formatter.after({
  "duration": 28000,
  "status": "passed"
});
formatter.after({
  "duration": 56889,
  "status": "passed"
});
});