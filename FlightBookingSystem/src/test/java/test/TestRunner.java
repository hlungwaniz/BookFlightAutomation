package test;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features="src/test/resources/BookFlight.feature",
	glue= {"bookflightStepDefinition"},
	plugin={"pretty",
		"html:target/HTMLReports/report.html",
		"json:target/JSonReports/report.json",
		"junit:target/JUnitReports/report.xml"},
		dryRun = true,
		monochrome = true
)
public class TestRunner {

}
