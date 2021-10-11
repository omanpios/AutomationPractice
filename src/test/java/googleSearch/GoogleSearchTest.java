package googleSearch;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import page.Objects;
import utils.BrowserManager;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class GoogleSearchTest {
	Properties prop = new Properties();
	private WebDriver driver;
	private BrowserManager browserManager = new BrowserManager();

	@BeforeAll
	void setUp() throws Exception {
		driver = browserManager.initializeDriver();
	}

	@BeforeEach
	void openBrowser() throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("src/main/java/utils/data.properties");
		prop.load(fis);
		String baseURL = prop.getProperty("BaseURL");
		driver.get(baseURL);
		Thread.sleep(1000);
	}

	@Test
	void validateSearchResults() throws InterruptedException {
		Objects objects = new Objects(driver);
		objects.searchBar().click();
		objects.searchBar().sendKeys("Touring motorcycles" + Keys.ENTER);
		Thread.sleep(2000);
		Assertions.assertTrue(objects.resultStats().isDisplayed());
	}

	@AfterEach
	void quitBrowser() {
		driver.quit();
	}
}
