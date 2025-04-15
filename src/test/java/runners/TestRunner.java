package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utils.DriverFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)
public class TestRunner {
    @AfterClass
    public static void cleanUp() {
        DriverFactory.quitDriver();
    }
}