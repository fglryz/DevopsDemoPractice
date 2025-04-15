package stepdefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyHomePage;
import utils.DriverFactory;

import static org.junit.Assert.assertTrue;
public class searchStep {
    WebDriver driver = DriverFactory.getDriver();
    EtsyHomePage homePage = new EtsyHomePage(driver);

    @Given("I open Etsy homepage")
    public void i_open_etsy_homepage() {
        driver.get("https://www.etsy.com");
    }

    @When("I search for {string}")
    public void i_search_for(String keyword) {
        homePage.searchFor(keyword);
    }

    @Then("I should see results related to {string}")
    public void i_should_see_results_related_to(String keyword) {
        assertTrue(driver.getTitle().toLowerCase().contains(keyword.toLowerCase()));
    }
}
