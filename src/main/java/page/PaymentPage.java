package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public void confirmPayment() throws InterruptedException {
        WebElement bankwireButton = driver
                .findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a"));
        bankwireButton.click();
        Thread.sleep(2000);
        WebElement confirmOrderButton = driver.findElement(By.xpath("//*[@id='cart_navigation']/button"));
        confirmOrderButton.click();
        Thread.sleep(3000);

    }

    public String confirmationMessage() {
        String confirmationMessage = driver
                .findElement(By.xpath("//strong[contains(text(),'Your order on My Store is complete.')]")).getText();

        return confirmationMessage;
    }

}
