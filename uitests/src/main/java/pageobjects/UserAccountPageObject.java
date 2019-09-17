package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserAccountPageObject extends BasePageClass {
    public static WebElement element = null;

    /**
     * Returns the My Account tab element
     */
    public static WebElement goToCheckoutButton() {
        element = driver.findElement(By.className("acc-account"));
        return element;
    }

    /**
     * Gets the text of the main title
     */
    public static String getAccountNameText() {
        String textTitle = goToCheckoutButton().findElements(By.tagName("p")).get(0).getText();
        String textTitle1 = goToCheckoutButton().findElements(By.tagName("p")).get(1).getText();
        return textTitle + textTitle1;
    }
}
