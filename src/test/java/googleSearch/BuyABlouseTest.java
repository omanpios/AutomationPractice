package googleSearch;

import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import page.AddressPage;
import page.CheckoutProcessPage;
import page.IndexPage;
import page.LoginPage;
import page.PaymentPage;
import page.ShippingPage;
import utils.BrowserManager;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)

public class BuyABlouseTest {

    Properties prop = new Properties();
    private WebDriver driver;
    private BrowserManager browserManager = new BrowserManager();
    private IndexPage indexPage;
    private CheckoutProcessPage addElementToCartPage;
    private LoginPage loginPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;

    @BeforeAll
    void setUp() throws Exception {
        driver = browserManager.initializeDriver();
        indexPage = new IndexPage(driver);
        addElementToCartPage = new CheckoutProcessPage(driver);
        loginPage = new LoginPage(driver);
        addressPage = new AddressPage(driver);
        shippingPage = new ShippingPage(driver);
        paymentPage = new PaymentPage(driver);
    }

    @Test
    void buyABlouseTest() throws InterruptedException, IOException {
        String email = System.getenv("email");
        String password = System.getenv("password");

        indexPage.goToBlouses();
        addElementToCartPage.addBlouseToCart();
        loginPage.loginProcess(email, password);
        addressPage.confirmAddress();
        shippingPage.processCarrier();
        paymentPage.confirmPayment();
        Assertions.assertEquals("Your order on My Store is complete.", paymentPage.confirmationMessage());
                
    }

    @AfterAll
    void quitBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
