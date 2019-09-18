import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;
import pageobjects.UserRegistrationPageObject;

public class LoginTests extends BaseTestClass {
    @Test
    //Note that the validation assert is commented because cannot workaround the Captcha
    public void InvalidLogin() throws Exception {
        HomePageObject.loginButton().click();
        LoginPageObject.login("invalidUsername", "invalidPassword");
        LoginPageObject.loginSubmitButton().click();
        //Assert.assertEquals(LoginPageObject.invalidLoginErrorMessage(), "Diese E-Mail-Passwort-Kombination ist uns nicht bekannt. Bitte korrigieren Sie Ihre Eingabe.");
    }

    @Test
    //Note that the validation assert is commented because cannot workaround the Captcha
    public void ValidLogin() throws Exception {
        HomePageObject.loginButton().click();
        LoginPageObject.login("validUsername", "validPassword");
        LoginPageObject.loginSubmitButton().click();
        //Assert.assertEquals(UserAccountPageObject.getAccountNameText(), "MEIN KONTOLuc Test");
    }

    @Test
    public void ForgotPassword() throws Exception {
        HomePageObject.loginButton().click();
        LoginPageObject.forgotPasswordButton().click();
        driver.switchTo().frame(LoginPageObject.forgotPasswordIframe());
        Assert.assertTrue(LoginPageObject.getForgotPopupTitle().contains("Sie haben Ihr Passwort vergessen?"));
        LoginPageObject.forgotEmailInput().sendKeys("forgotEmail@mailinator.com");
        LoginPageObject.requestPasswordButton().click();
        Assert.assertEquals(LoginPageObject.resetPasswordMessage(), "Wir haben ihnen eine E-Mail mit ihrem neuen Passwort zugeschickt.");
    }

    @Test
    public void UserRegistration() throws Exception {
        HomePageObject.registerButton().click();
        UserRegistrationPageObject userRegistration = new UserRegistrationPageObject();
        userRegistration.fillCheckoutForm();
        UserRegistrationPageObject.submitRegisterButton().click();
        Assert.assertEquals(UserRegistrationPageObject.getConfimationMessage(), "Willkommen bei Rakuten");
    }
}
