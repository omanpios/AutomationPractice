package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutObjects {
    public WebDriver driver;

    public CheckoutObjects(WebDriver driver) {
        this.driver = driver;
    }

    By checkoutButton = By.partialLinkText("Proceed to checkout");
    By emailField = By.id("email");
    By passwordField = By.id("passwd");
    By submitButton = By.id("SubmitLogin");
    By header = By.className("page-heading");
    By processAdressButton = By.name("processAddress");
    By processCarrier = By.name("processCarrier");
    By termsCheck = By.id("cgv");

    public WebElement checkoutButton() {
        return driver.findElement(checkoutButton);
    }

    public WebElement emailField() {
        return driver.findElement(emailField);
    }

    public WebElement passwordField() {
        return driver.findElement(passwordField);
    }

    public WebElement submitButton() {
        return driver.findElement(submitButton);
    }

    public String header() {
        return driver.findElement(header).getText();
    }

    public WebElement processAdressButton() {
        return driver.findElement(processAdressButton);
    }

    public WebElement processCarrier() {
        return driver.findElement(processCarrier);
    }
    public WebElement termsCheck(){
        return driver.findElement(termsCheck);
    }
}
