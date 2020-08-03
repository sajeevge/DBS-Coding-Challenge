package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\test\\java\\features"},
		glue = {"stepdefinitions"},
		monochrome = true,
		tags = {"@flightsearch"},
		dryRun = false,
		plugin = {"pretty", "html:target/test-output", "json:target/cucumber.json"}
		)
public class TestRunner {

}