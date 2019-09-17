package pageobjects;

import driverbase.DriverBase;

public class BasePageClass extends DriverBase {
    /**
     * Navigates to home page
     */
    public static void NavigateToHomePage() throws Exception {
        // Gets the constructed URL and navigates to home page
        String baseUrl = PropertyLoader.getProp("protocol") + "//" + PropertyLoader.getProp("host") + PropertyLoader.getProp("domain");
        driver.get(baseUrl);
    }
}