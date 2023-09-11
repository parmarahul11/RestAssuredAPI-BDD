package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features={"src\\test\\resources\\Features\\postMethods"},
plugin= {"json:target/jsonReports/cucumber1-report.json"},
glue={"StepsDefinition"},
dryRun = false,
monochrome = true)
public class StepRunner {

}
