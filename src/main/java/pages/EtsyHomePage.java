package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class EtsyHomePage {
    WebDriver driver;

    public EtsyHomePage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.name("search_query");
    By searchButton = By.xpath("//button[@value='Search']");

    public void searchFor(String keyword) {
        driver.findElement(searchBox).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }
}
