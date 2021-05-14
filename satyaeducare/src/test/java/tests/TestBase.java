package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	WebDriver driver;

	public WebDriver instantiateDriver() {

		displayMessage("setting system property");
		// setting property
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");

		displayMessage("instantiating chrome driver");
		// instantiating driver
		driver = new ChromeDriver();
		return driver;
	}

	// displayMessage method for displaying message on console.
	public void displayMessage(String message) {
		System.out.println(message);
	}

	// wait method for wait time
	public void simply(int waitTime) {
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}

	public void waitTime() throws InterruptedException {
		Thread.sleep(60000);

	}
}
