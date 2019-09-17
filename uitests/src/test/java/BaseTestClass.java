import driverbase.DriverBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.BasePageClass;
import pageobjects.PrivacyPopupPageObject;

import java.util.concurrent.TimeUnit;

public class BaseTestClass extends DriverBase {

    // This method is called before each test is run and starts the browser and navigates to Home page
    @BeforeMethod
    public void beforeSuite() throws Exception {
        StartWebDriver();
        BasePageClass.NavigateToHomePage();
        PrivacyPopupPageObject.closesPrivacyBox().click();
    }

    // This method is called after each test is run and closes the driver and the browser
    @AfterMethod
    public void afterSuite() {
        driver.quit();
        Reporter.log("=====Browser Session End=====", true);
    }

    // Initiates the driver, the browser is opened and validates the state of the browser
    public void StartWebDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
                .executeScript("return document.readyState").equals("complete"));
    }
}
