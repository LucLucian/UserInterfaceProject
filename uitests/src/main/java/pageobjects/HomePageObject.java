package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePageObject extends BasePageClass {
    public static WebElement element = null;

    /**
     * Returns the login button
     */
    public static WebElement loginButton() {
        element = driver.findElement(By.cssSelector(".-login")).findElements(By.tagName("a")).get(0);
        return element;
    }

    public static WebElement registerButton() {
        element = driver.findElement(By.cssSelector(".-login")).findElements(By.tagName("a")).get(1);
        return element;
    }
}
