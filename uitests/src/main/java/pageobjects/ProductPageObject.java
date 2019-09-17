package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPageObject extends BasePageClass {
    public static WebElement element = null;

    /**
     * Returns the product quantity input
     */
    public static WebElement productQuantityInput() {
        element = driver.findElement(By.id("product-quantity"));
        return element;
    }

    /**
     * Returns the add to cart button
     */
    public static WebElement addCartButton() {
        element = driver.findElement(By.className("popup-container")).findElement(By.className("add-cart"));
        return element;
    }

    /**
     * Returns the modal (continue or to cart) after adding a product to Shop Cart
     */
    public static WebElement modalAddToCart() {
        element = driver.findElement(By.className("vw-modalAddToShopCart"));
        return element;
    }

    /**
     * Return the To Cart button from the modal Add To Shop Cart
     */
    public static WebElement toCartModalButton() {
        element = modalAddToCart().findElement(By.className("-back"));
        return element;
    }

    /**
     * Return the Continue Shopping Go button from the modal Add To Shop Cart
     */
    public static WebElement continueToShopModalButton() {
        element = modalAddToCart().findElement(By.className("-add"));
        return element;
    }
}
