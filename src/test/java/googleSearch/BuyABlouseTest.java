package googleSearch;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    void buyABlouseTest() throws InterruptedException, IOException {
        FileInputStream fis = new FileInputStream("src/main/java/utils/data.properties");
        prop.load(fis);
        String email = System.getenv("email");
        String password = System.getenv("password");
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        Actions actions = new Actions(driver);

        WebElement womenButton = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));
        actions.moveToElement(womenButton).build().perform();
        Thread.sleep(4000);
        WebElement blousesButton = driver.findElement(By.linkText("Blouses"));
        blousesButton.click();
        Thread.sleep(4000);
        WebElement productContainer = driver.findElement(By.className("product-container"));
        actions.moveToElement(productContainer);
        WebElement addToCartButton = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
        addToCartButton.click();
        WebElement proceedToCheckOutButton = driver.findElement(By
            .xpath("//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]"));
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckOutButton));
        proceedToCheckOutButton.click();
        Thread.sleep(2000);
        WebElement checkoutButton = driver.findElement(By.partialLinkText("Proceed to checkout"));
        checkoutButton.click();
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.click();
        System.out.println(email);
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.click();
        passwordField.sendKeys(password);
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();
        Thread.sleep(1000);
        WebElement processAdressButton = driver.findElement(By.name("processAddress"));
        processAdressButton.click();
        WebElement termsCheck = driver.findElement(By.id("cgv"));
        termsCheck.click();
        WebElement processCarrier = driver.findElement(By.name("processCarrier"));
        processCarrier.click();
        Thread.sleep(1000);
        WebElement bankwireButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a"));
        bankwireButton.click();
        Thread.sleep(2000);
        WebElement confirmOrderButton = driver.findElement(By.xpath("//*[@id='cart_navigation']/button"));
        confirmOrderButton.click();
        Thread.sleep(3000);
        String confirmationMessage = driver.findElement(By.xpath("//strong[contains(text(),'Your order on My Store is complete.')]")).getText();
        Assertions.assertTrue(confirmationMessage.equals("Your order on My Store is complete."));
    }

    @AfterAll
    void quitBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
