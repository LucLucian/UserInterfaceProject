import driverbase.DriverBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.BasePageClass;
import pageobjects.PrivacyPopupPageObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    public void screenShot(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
                // Creates reference of TakesScreenshot
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                // Captures screenshot
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                // Copy files to specific location with the same name as the failed test case
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/test-output/screenshots";
                File destFile = new File((String) reportDirectory + "/failure_screenshots/" + result.getName() + "_" + formatter.format(calendar.getTime()) + ".png");
                FileUtils.copyFile(src, destFile);
                Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
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