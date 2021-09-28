package googleSearch;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BlousesObjects;
import pageObjects.CheckoutObjects;
import pageObjects.IndexObjects;
import pageObjects.PaymentObjects;
import utils.BrowserManager;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)

public class BuyABlouseTest extends BrowserManager {
    Properties prop = new Properties();

    @BeforeAll
    void openBrowser() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream("src/main/java/utils/data.properties");
        prop.load(fis);
        String baseURL = prop.getProperty("MyStoreURL");
        driver = initializeDriver();
        driver.get(baseURL);
        Thread.sleep(1000);
    }

    @Test
    @Order(1)
    @DisplayName("Go to blouses category test")
    void verifyGoToBlousesCategory() throws InterruptedException {
        Actions actions = new Actions(driver);
        IndexObjects objects = new IndexObjects(driver);
        actions.moveToElement(objects.womenButton()).build().perform();
        Thread.sleep(1000);
        objects.blousesButton().click();
        Assertions.assertTrue(objects.categoryName().equals("Blouses"));
    }

    @Test
    @Order(2)
    @DisplayName("Add item to cart and click checkout")
    void verifyAddItemToCart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        Actions actions = new Actions(driver);
        BlousesObjects objects = new BlousesObjects(driver);
        actions.moveToElement(objects.productContainer());
        objects.addToCartButton().click();
        wait.until(ExpectedConditions.visibilityOf(objects.proceedToCheckOutButton()));
        objects.proceedToCheckOutButton().click();
        Assertions.assertTrue(objects.cartTitle().isDisplayed());
        Thread.sleep(2000);
    }

    @Test
    @Order(3)
    @DisplayName("Checkout process (Summary, Sign in, Address and Shipping)")
    void verifyCheckout() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream("src/main/java/utils/data.properties");
        prop.load(fis);
        String email = prop.getProperty("email");
        String password = prop.getProperty("pass");
        CheckoutObjects cObjects = new CheckoutObjects(driver);
        cObjects.checkoutButton().click();
        cObjects.emailField().click();
        cObjects.emailField().sendKeys(email);
        cObjects.passwordField().click();
        cObjects.passwordField().sendKeys(password);
        cObjects.submitButton().click();
        Thread.sleep(1000);
        cObjects.processAdressButton().click();
        cObjects.termsCheck().click();
        cObjects.processCarrier().click();
        Thread.sleep(1000);
        Assertions.assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", cObjects.header());

    }

    @Test
    @Order(4)
    @DisplayName("Verify if the order is completed")
    void verifyCompletePayment() throws InterruptedException {
        PaymentObjects pObjects = new PaymentObjects(driver);
        pObjects.bankwireButton().click();
        Thread.sleep(2000);
        pObjects.confirmOrderButton().click();
        Thread.sleep(3000);
        Assertions.assertTrue(pObjects.confirmationMessage().equals("Your order on My Store is complete."));
    }

    @AfterAll
    void quitBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
