package page;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;

public class IndexPage {
    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public void goToBlouses() throws IOException, InterruptedException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/utils/data.properties");
        prop.load(fis);
        String baseURL = prop.getProperty("MyStoreURL");
        driver.get(baseURL);
        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        WebElement womenButton = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));
        actions.moveToElement(womenButton).build().perform();
        Thread.sleep(4000);
        WebElement blousesButton = driver.findElement(By.linkText("Blouses"));
        blousesButton.click();
        Thread.sleep(4000);
    }

 

}
