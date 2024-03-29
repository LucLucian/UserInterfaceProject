package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ProductPageObject;
import pageobjects.SearchPageObject;
import pageobjects.SearchResultsPageObject;
import pageobjects.ShopCartPageObject;
import utils.ExtentTestManager;

import java.lang.reflect.Method;

public class ProductCheckoutTest extends BaseTestClass {

    @Test
    public void ProductCheckout(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(), "Product purchase flow from adding to cart to payment methods");
        SearchPageObject.searchInput().sendKeys("mobile");
        SearchPageObject.searchButton().click();
        SearchResultsPageObject.firstResult().click();
        ProductPageObject.productQuantityInput().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        ProductPageObject.productQuantityInput().sendKeys("2");
        ProductPageObject.addCartButton().click();
        ProductPageObject.toCartModalButton().click();
        ShopCartPageObject.goToCheckoutButton().click();
        ShopCartPageObject.guestLoginCheckbox().click();
        ShopCartPageObject.nextStepButton().click();

        ShopCartPageObject shopCartPage = new ShopCartPageObject();
        shopCartPage.fillCheckoutForm();
        ShopCartPageObject.nextStepButton().click();
        Assert.assertEquals(ShopCartPageObject.getPageTile(), "Wie möchten Sie bezahlen?");
    }
}
