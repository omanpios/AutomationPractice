package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexObjects {
    public WebDriver driver;

    public IndexObjects(WebDriver driver) {
        this.driver = driver;
    }

    By womenButton = By.xpath("//*[@id='block_top_menu']/ul/li[1]/a");
    By blousesButton = By.linkText("Blouses");
    By categoryName = By.className("category-name");

    public WebElement womenButton() {
        return driver.findElement(womenButton);
    }

    public WebElement blousesButton() {
        return driver.findElement(blousesButton);
    }

    public String categoryName() {
        return driver.findElement(categoryName).getText();
    }

}
