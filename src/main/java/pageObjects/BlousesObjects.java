package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlousesObjects {
    public WebDriver driver;

    public BlousesObjects(WebDriver driver) {
        this.driver = driver;
    }

    By productContainer = By.className("product-container");
    By addToCartButton = By.xpath("//span[contains(text(),'Add to cart')]");
    By proceedToCheckOutButton = By
            .xpath("//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]");
    By cartTitle = By.id("cart_title");

    public WebElement productContainer() {
        return driver.findElement(productContainer);
    }

    public WebElement addToCartButton() {
        return driver.findElement(addToCartButton);
    }

    public WebElement proceedToCheckOutButton() {
        return driver.findElement(proceedToCheckOutButton);
    }

    public WebElement cartTitle() {
        return driver.findElement(cartTitle);
    }
}
