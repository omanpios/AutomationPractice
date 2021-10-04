package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public void loginProcess(String email, String password) throws InterruptedException {

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.click();
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.click();
        passwordField.sendKeys(password);
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();
        Thread.sleep(1000);
    }

}
