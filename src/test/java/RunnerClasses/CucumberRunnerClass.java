package RunnerClasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(plugin = { "pretty", "html:target/site/cucumber-pretty",
		"json:target/cucumber-reports/Cucumber1.json" }, features = "src/test/resources/Features", glue = "StepDefinitions", monochrome = true, tags = "@Regression")
public class CucumberRunnerClass {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass
	public void setUPClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(dataProvider = "features")
	public void feature(PickleEventWrapper eventwrapper, CucumberFeatureWrapper cucumberFeature) throws Throwable {
		testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
	}

	@DataProvider(parallel=true)
	public Object[][] features() {

		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		testNGCucumberRunner.finish();
	}

}
