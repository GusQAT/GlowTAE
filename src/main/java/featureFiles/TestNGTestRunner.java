package featureFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/featureFiles",glue = "stepDefinitions.CitrixLoginStep",
monochrome = true, plugin = {"html:target/cucumber.html"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
//To execute it
}
