package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrivacyPopupPageObject extends BasePageClass {
    public static WebElement element = null;

    /**
     * Returns the privacy prompt box input
     */
    public static WebElement closesPrivacyBox() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("privacy_prompt_box")));
        element = driver.findElement(By.id("consent_prompt_submit"));

        return element;
    }
}
