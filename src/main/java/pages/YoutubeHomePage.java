package pages;



import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class YoutubeHomePage {

    WebDriver driver;
    WebDriverWait wait;

    public YoutubeHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By searchBox = By.name("search_query");

    public void searchFor(String keyword) {
        acceptCookiesIfVisible();
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        input.sendKeys(keyword + Keys.ENTER);
        waitForResultsToAppear();
    }
    By searchResults = By.cssSelector("ytd-video-renderer");

    public void waitForResultsToAppear() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
    }

    private void acceptCookiesIfVisible() {
        try {
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'Accept all')]")));
            acceptButton.click();
        } catch (TimeoutException | NoSuchElementException ignored) {
            // No consent modal appeared — continue silently
        }
    }

}
