package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class UserRegistrationPageObject extends BasePageClass {
    public static WebElement element = null;

    /**
     * Returns the gender Sir checboxe
     */
    public static WebElement genderSir() {
        element = driver.findElement(By.id("gender-m"));
        return element;
    }

    /**
     * Returns the gender Woman checboxe
     */
    public static WebElement genderWoman() {
        element = driver.findElement(By.id("gender-f"));
        return element;
    }

    /**
     * Returns the first name field
     */
    public static WebElement firstName() {
        element = driver.findElement(By.name("firstName"));
        return element;
    }

    /**
     * Returns the last name field
     */
    public static WebElement lastName() {
        element = driver.findElement(By.name("lastName"));
        return element;
    }

    /**
     * Returns the email name field
     */
    public static WebElement emailAdress() {
        element = driver.findElement(By.className("email-input"));
        return element;
    }

    /**
     * Returns the street number field
     */
    public static WebElement emailAdressConfirmation() {
        element = driver.findElement(By.className("email-input-re"));
        return element;
    }

    /**
     * Returns the street number field
     */
    public static WebElement password() {
        element = driver.findElement(By.className("password"));
        return element;
    }

    /**
     * Returns the street number field
     */
    public static WebElement passwordConfirmation() {
        element = driver.findElement(By.className("password-repeat"));
        return element;
    }

    /**
     * Returns the submit register button
     */
    public static WebElement submitRegisterButton() {
        element = driver.findElement(By.className("change-pass-ca")).findElement(By.name("secure-submit"));
        return element;
    }

    /**
     * Gets the Confimation Message text after registration
     */
    public static String getConfimationMessage() {
        WebElement confirmationMessage = driver.findElement(By.className("header-confirmation")).findElement(By.tagName("h2"));
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("header-confirmation")));
        String textTitle = confirmationMessage.getText();
        return textTitle;
    }

    /**
     * Fills the user registration form
     */
    public void fillCheckoutForm() throws Exception {
        Random random = new Random(System.currentTimeMillis());
        int randomInt = random.nextInt();

        genderSir().click();
        firstName().sendKeys(PropertyLoader.getProp("firstname"));
        lastName().sendKeys(PropertyLoader.getProp("lastname"));
        emailAdress().sendKeys(PropertyLoader.getProp("email") + randomInt + "@mailinator.com");
        emailAdress().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        emailAdress().sendKeys(Keys.chord(Keys.CONTROL, "c"));
        emailAdressConfirmation().sendKeys(Keys.chord(Keys.CONTROL, "v"));
        password().sendKeys(PropertyLoader.getProp("password"));
        passwordConfirmation().sendKeys(PropertyLoader.getProp("password"));
    }
}
