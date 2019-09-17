package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject extends BasePageClass {
    public static WebElement element = null;

    /**
     * Returns the login button
     */
    public static WebElement loginButton() {
        element = driver.findElement(By.linkText("Einloggen"));
        return element;
    }

    /**
     * Returns the login email input
     */
    public static WebElement emailInput() {
        element = driver.findElement(By.name("loginEmail"));
        return element;
    }

    /**
     * Returns the login password input
     */
    public static WebElement passwordInput() {
        element = driver.findElement(By.name("loginPassword"));
        return element;
    }

    /**
     * Returns the login submit button
     */
    public static WebElement loginSubmitButton() {
        element = driver.findElement(By.id("recaptcha-submit"));
        return element;
    }

    /**
     * Returns the forgot password button
     */
    public static WebElement forgotPasswordButton() {
        element = driver.findElement(By.className("fancybox-login"));
        return element;
    }

    /**
     * Gets the text of the main title
     */
    public static String getForgotPopupTitle() {
        String textPopup = driver.findElement(By.className("address-form")).getText();
        return textPopup;
    }

    /**
     * Returns the forgot email address input
     */
    public static WebElement forgotEmailInput() {
        element = driver.findElement(By.className("jqtranformdone"));
        return element;
    }

    /**
     * Returns the request password button
     */
    public static WebElement requestPasswordButton() {
        element = driver.findElement(By.name("submit"));
        return element;
    }

    /**
     * Gets the success message after reseting password
     */
    public static String resetPasswordMessage() {
        String resetPasswordMessage = driver.findElement(By.className("message-success")).getText();
        return resetPasswordMessage;
    }

    /**
     * Gets the error message after inserting invalid credentials
     */
    public static String invalidLoginErrorMessage() {
        String invalidMessage = driver.findElement(By.className("message-error")).getText();
        return invalidMessage;
    }

    /**
     * Returns the forgot password iFrame
     */
    public static WebElement forgotPasswordIframe() {
        element = driver.findElement(By.className("fancybox-iframe"));
        return element;
    }

    /**
     * Login to application using the data from properties file
     */
    public static void login(String email, String password) throws Exception {

        // waits until the login button is visible on the page before inserting text inside the fields
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(loginSubmitButton()));

        // fills the email and password fields with the wanted strings
        emailInput().sendKeys(PropertyLoader.getProp(email));
        passwordInput().sendKeys(PropertyLoader.getProp(password));
    }
}
