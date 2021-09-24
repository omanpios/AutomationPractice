package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Objects {
	public WebDriver driver;

	public Objects(WebDriver driver) {
		this.driver = driver;
	}

	By searchBar = By.name("q");
	By resultStats = By.id("result-stats");

	public WebElement searchBar() {
		return driver.findElement(searchBar);
	}

	public WebElement resultStats() {
		return driver.findElement(resultStats);
	}
}
