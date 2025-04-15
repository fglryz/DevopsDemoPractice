package stepdefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.YoutubeHomePage;
import utils.DriverFactory;

import java.util.List;

import static org.junit.Assert.assertTrue;
public class searchStep {
    WebDriver driver = DriverFactory.getDriver();
    YoutubeHomePage homePage = new YoutubeHomePage(driver);

    @Given("I open YouTube homepage")
    public void i_open_youtube_homepage() {
        driver.get("https://www.youtube.com");
    }

    @When("I search for {string}")
    public void i_search_for(String keyword) {

        homePage.searchFor(keyword);
    }

    @Then("I should see results related to {string}")
    public void i_should_see_results_related_to(String keyword) {
        List<WebElement> videoTitles = driver.findElements(By.cssSelector("a#video-title"));
        boolean found = videoTitles.stream().anyMatch(title -> title.getText().toLowerCase().contains(keyword.toLowerCase()));
        assertTrue("No video titles contain the keyword: " + keyword, found);
    }
}