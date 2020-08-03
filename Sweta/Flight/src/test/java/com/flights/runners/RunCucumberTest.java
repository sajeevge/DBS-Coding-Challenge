package com.flights.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features" }, glue = { "com/flights/steps" }, plugin = { "pretty",
		"html:target/cucumber", "json:target/cucumber.json" }, monochrome = true, tags = "@flightSearch"

)
public class RunCucumberTest {

}
