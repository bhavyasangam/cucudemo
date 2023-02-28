package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		//features={".//features//Login.feature"},
		features={".//features//LoginDDT.feature"},
		glue="com.stepfiles",
		plugin={"pretty",
				"html:reports/report.html",
				"json:reports/report.json",
				
		},
		dryRun=false,
		monochrome=true,
		tags="@sanity"
		
		)

public class TestRunner {

}
