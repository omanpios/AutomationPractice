package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPage {
    public ShippingPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public void processCarrier() throws InterruptedException {
        WebElement termsCheck = driver.findElement(By.id("cgv"));
        termsCheck.click();
        WebElement processCarrier = driver.findElement(By.name("processCarrier"));
        processCarrier.click();
        Thread.sleep(1000);
    }

}
