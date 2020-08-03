Feature: Select a Flight

	@flightsearch
	Scenario Outline: Search flight and select

		Given User is navigated successfully to the indigo website
		When I Enter "<originCity>" as Origin
		And I Enter "<destinationCity>" as Destination
		And I select One way radio button
		And Select depart date as "<departDate>" in from field
		And I click on search button
		Then I verify "<pageTitle>" page title
		When I select the "<criteria>" flight
		And I click on continue button in select page
		
	Examples:
			| originCity|destinationCity| departDate 		 | pageTitle		 | criteria |
			| Delhi			| Hyderabad			| 2020-August-4 | Select Flights | Evening  |