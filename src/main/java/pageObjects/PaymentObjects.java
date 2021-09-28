package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentObjects {
    public WebDriver driver;

    public PaymentObjects(WebDriver driver) {
        this.driver = driver;
    }

    By bankwireButton = By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a");
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
