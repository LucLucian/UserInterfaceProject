package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShopCartPageObject extends BasePageClass {
    public static WebElement element = null;

    /**
     * Returns the Go to checkout button
     */
    public static WebElement goToCheckoutButton() {
        element = driver.findElement(By.id("go_to_checkout"));
        return element;
    }

    /**
     * Returns the guest login method
     */
    public static WebElement guestLoginCheckbox() {
        element = driver.findElement(By.id("login-method1"));
        return element;
    }

    /**
     * Returns the go to next step button
     */
    public static WebElement nextStepButton() {
        element = driver.findElement(By.id("go_to_next_step"));
        return element;
    }

    /**
     * Returns the title dropdown from My data Tab
     */
    public static WebElement titleDropdown(String title) {
        WebElement titledropdown = driver.findElement(By.className("gender-container"));
        titledropdown.findElement(By.className("jqTransformSelectOpen")).click();
        element = titledropdown.findElement(By.linkText(title));

        return element;
    }

    /**
     * Returns the first name field
     */
    public static WebElement firstName() {
        element = driver.findElement(By.id("first-name"));
        return element;
    }

    /**
     * Returns the last name field
     */
    public static WebElement lastName() {
        element = driver.findElement(By.id("last-name"));
        return element;
    }

    /**
     * Returns the street name field
     */
    public static WebElement streetName() {
        element = driver.findElement(By.id("street"));
        return element;
    }

    /**
     * Returns the street number field
     */
    public static WebElement streetNumber() {
        element = driver.findElement(By.id("street-number"));
        return element;
    }

    /**
     * Returns the zip code field
     */
    public static WebElement zipCode() {
        element = driver.findElement(By.id("zip-code"));
        return element;
    }

    /**
     * Returns the city name field
     */
    public static WebElement cityName() {
        element = driver.findElement(By.id("city"));
        return element;
    }

    /**
     * Returns the email field
     */
    public static WebElement email() {
        element = driver.findElement(By.id("email"));
        return element;
    }

    /**
     * Returns the privacy consent checkbox
     */
    public static WebElement privacyConsentButton() {
        element = driver.findElement(By.id("privacy"));
        return element;
    }

    /**
     * Returns the day dropdown
     */
    public static WebElement dayDropdown(String day) {
        WebElement titledropdown = driver.findElement(By.id("invoice-day-container"));
        titledropdown.findElement(By.className("jqTransformSelectOpen")).click();
        element = titledropdown.findElement(By.linkText(day));

        return element;
    }

    /**
     * Returns the month dropdown
     */
    public static WebElement monthDropdown(String month) {
        WebElement titledropdown = driver.findElement(By.id("invoice-month-container"));
        titledropdown.findElement(By.className("jqTransformSelectOpen")).click();
        element = titledropdown.findElement(By.linkText(month));

        return element;
    }

    /**
     * Returns the year dropdown
     */
    public static WebElement yearDropdown(String year) {
        WebElement titledropdown = driver.findElement(By.id("invoice-year-container"));
        titledropdown.findElement(By.className("jqTransformSelectOpen")).click();
        element = titledropdown.findElement(By.linkText(year));

        return element;
    }

    /**
     * Returns the main title of the Payment method selection page
     */
    public static String getPageTile() {
        String textTitle = driver.findElement(By.id("content")).findElement(By.tagName("h2")).getText();
        return textTitle;
    }

    /**
     * Fills the checkout billing form
     */
    public void fillCheckoutForm() throws Exception {

        titleDropdown(PropertyLoader.getProp("gender")).click();
        firstName().sendKeys(PropertyLoader.getProp("firstname"));
        lastName().sendKeys(PropertyLoader.getProp("lastname"));
        streetName().sendKeys(PropertyLoader.getProp("streetname"));
        streetNumber().sendKeys(PropertyLoader.getProp("streetnumber"));
        zipCode().sendKeys(PropertyLoader.getProp("zipcode"));
        cityName().sendKeys(PropertyLoader.getProp("cityname"));
        email().sendKeys(PropertyLoader.getProp("emailShopCart"));
        dayDropdown(PropertyLoader.getProp("day")).click();
        monthDropdown(PropertyLoader.getProp("month")).click();
        yearDropdown(PropertyLoader.getProp("year")).click();
        privacyConsentButton().click();
    }
}
