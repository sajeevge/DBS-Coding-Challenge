$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/crossbrowser.feature");
formatter.feature({
  "line": 1,
  "name": "Flight itinerary planner for parellel execution",
  "description": "",
  "id": "flight-itinerary-planner-for-parellel-execution",
  "keyword": "Feature"
});
formatter.before({
  "duration": 69897685,
  "status": "passed"
});
formatter.before({
  "duration": 329778,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "User navigates to the google flight search page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user navigates to the site",
  "keyword": "Given "
});
formatter.match({
  "location": "UIFFTest.user_navigates_to_the_site()"
});
formatter.result({
  "duration": 12982473357,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Selecting the best itinerary based on the fastest and cheapest travel",
  "description": "",
  "id": "flight-itinerary-planner-for-parellel-execution;selecting-the-best-itinerary-based-on-the-fastest-and-cheapest-travel",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "user enters \"Pune\" and \"Hyderabad\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user is shown the result page with the fare",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user is shown the best itinerary based on fastest and cheapest travel",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Pune",
      "offset": 13
    },
    {
      "val": "Hyderabad",
      "offset": 24
    }
  ],
  "location": "UIFFTest.user_enter_and(String,String)"
});
formatter.result({
  "duration": 14869573951,
  "status": "passed"
});
formatter.match({
  "location": "UIFFTest.user_is_shown_the_result_page_with_the_fare()"
});
formatter.result({
  "duration": 4836324218,
  "status": "passed"
});
formatter.match({
  "location": "UIFFTest.user_is_shown_the_best_itinerary_based_on_fastest_and_cheapest_travel()"
});
formatter.result({
  "duration": 1174651323,
  "status": "passed"
});
formatter.after({
  "duration": 39111,
  "status": "passed"
});
formatter.after({
  "duration": 42222,
  "status": "passed"
});
formatter.before({
  "duration": 238222,
  "status": "passed"
});
formatter.before({
  "duration": 204444,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "User navigates to the google flight search page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user navigates to the site",
  "keyword": "Given "
});
formatter.match({
  "location": "UIFFTest.user_navigates_to_the_site()"
});
formatter.result({
  "duration": 11332646667,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Selecting the evening flight when multiple itinerary options are shown",
  "description": "",
  "id": "flight-itinerary-planner-for-parellel-execution;selecting-the-evening-flight-when-multiple-itinerary-options-are-shown",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "user enters \"Delhi\" and \"Hyderabad\"",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "user is shown the result page with the fare",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "user selects the evening flight which is the fastest",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Delhi",
      "offset": 13
    },
    {
      "val": "Hyderabad",
      "offset": 25
    }
  ],
  "location": "UIFFTest.user_enter_and(String,String)"
});
formatter.result({
  "duration": 14429068317,
  "status": "passed"
});
formatter.match({
  "location": "UIFFTest.user_is_shown_the_result_page_with_the_fare()"
});
formatter.result({
  "duration": 4831651780,
  "status": "passed"
});
formatter.match({
  "location": "UIFFTest.user_selects_the_evening_flight_which_is_the_fastest()"
});
formatter.result({
  "duration": 1649090246,
  "status": "passed"
});
formatter.after({
  "duration": 262666,
  "status": "passed"
});
formatter.after({
  "duration": 33778,
  "status": "passed"
});
});