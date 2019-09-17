package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPageObject extends BasePageClass {
    public static WebElement element = null;

    /**
     * Returns the search input
     */
    public static WebElement searchInput() {
        element = driver.findElement(By.id("search-input"));
        return element;
    }

    /**
     * Returns the submit search button
     */
    public static WebElement searchButton() {
        element = driver.findElement(By.className("button-search"));
        return element;
    }

    /**
     * Returns the auto-complete container after writing inside the search input
     */
    public static WebElement autocompleteContainer() {
        element = driver.findElement(By.id("eac-container-search-input"));
        return element;
    }

    /**
     * Selects a search suggestion by name
     */
    public static void ClickSuggestionByName(String name) {
        List<WebElement> items = autocompleteContainer().findElement(By.tagName("ul")).findElements(By.tagName("li"));
        for (WebElement item : items) {
            // List<WebElement> cells = item.findElements(By.tagName("td"));
            if (item.getText().equals(name)) {
                item.click();
                return;
            }
        }
    }
}