package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultsPageObject extends BasePageClass {
    public static WebElement element = null;

    /**
     * Returns the main title of the search result page
     */
    public static WebElement mainTitle() {
        element = driver.findElement(By.className("search-title"));
        return element;
    }

    /**
     * Gets the text of the main title
     */
    public static String getMainTitleText() {
        String textTitle = mainTitle().getText();
        return textTitle;
    }

    /**
     * Gets the first result inside the search result list
     */
    public static WebElement firstResult() {
        WebElement resultContainer = driver.findElement(By.className("vw-searchProductList"))
                .findElement(By.className("container"));
        element = resultContainer.findElements(By.className("vw-productCard")).get(0);
        return element;
    }
}
