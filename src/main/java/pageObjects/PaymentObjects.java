package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentObjects {
    public WebDriver driver;

    public PaymentObjects(WebDriver driver) {
        this.driver = driver;
    }

    By bankwireButton = By.className("bankwire");
    By confirmOrderButton = By.xpath("//*[@id='cart_navigation']/button");
    By confirmationMessage = By.xpath("//strong[contains(text(),'Your order on My Store is complete.')]");

    public WebElement bankwireButton() {
        return driver.findElement(bankwireButton);
    }

    public WebElement confirmOrderButton() {
        return driver.findElement(confirmOrderButton);
    }

    public String confirmationMessage() {
        return driver.findElement(confirmationMessage).getText();

    }
}
