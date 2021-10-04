package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutProcessPage {
    public CheckoutProcessPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public void addBlouseToCart() throws InterruptedException, IOException {

        WebElement productContainer = driver.findElement(By.className("product-container"));
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5000);

        actions.moveToElement(productContainer);
        WebElement addToCartButton = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
        addToCartButton.click();
        Thread.sleep(2000);
        WebElement proceedToCheckOutButton = driver.findElement(By.xpath(
                "//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]"));
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckOutButton));
        proceedToCheckOutButton.click();
        Thread.sleep(2000);
        WebElement checkoutButton = driver.findElement(By.partialLinkText("Proceed to checkout"));
        checkoutButton.click();
    }
}
