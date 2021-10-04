package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage{
    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    public void confirmAddress(){
        WebElement processAdressButton = driver.findElement(By.name("processAddress"));
        processAdressButton.click();
    }
}
