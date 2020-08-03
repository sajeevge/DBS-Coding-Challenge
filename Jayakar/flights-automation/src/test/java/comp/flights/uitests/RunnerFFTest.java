package comp.flights.uitests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "html:target1/cucumber-html-report", "json:target1/cucumber.json",
		"pretty:target1/cucumber-pretty.txt", "usage:target1/cucumber-usage.json",
		"junit:target1/cucumber-results.xml", }, features = { "src/test/resources/features/crossbrowser.feature" }
)

public class RunnerFFTest {
	

}