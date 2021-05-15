package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import tests.TestBase;

public class SeFoundationSiteOpeningUp extends TestBase {

	static int time = 3;
	static int executedCount; // how many times code executed
	static boolean noIssue = true;

	TestBase util = new TestBase();
	WebDriver driver;
	WebElements elements = new WebElements();

	@Test(invocationCount = 100)
	public void initialize() {

		try {
			if (noIssue) {
				util.displayMessage("instantiating driver");
				driver = util.instantiateDriver();

				util.displayMessage("maximizing browser window");
				driver.manage().window().maximize();

				util.displayMessage("waiting to window maximize");
				util.simply(time);

				util.displayMessage("navigating to google url");
				driver.get("https://google.com");

				util.displayMessage("waiting for load google page");
				util.simply(time);

				util.displayMessage("entering 'se-foundation' text in search place");
				driver.findElements(elements.googleSearchBar).get(0).sendKeys("se-foundation.com");

				util.displayMessage("hitting 'Enter' button after giving 'se-foundation' text");
				driver.findElements(elements.googleSearchBar).get(0).sendKeys(Keys.ENTER);
				util.simply(time);

				util.displayMessage("clicking on satya educare from shown results");
				driver.findElement(elements.satyaEducareText).click();

				util.displayMessage("getting current url and storing in 'url' named variable");
				String url = driver.getCurrentUrl();

				util.displayMessage("Asserting page is navigated to the 'se-foundation' or not");
				Assert.assertTrue(url.contains("se-foundation.com"));
				util.simply(time - 1);

				util.displayMessage("Below Line display How many times successfully completed");
				System.out.println(executedCount = executedCount + 1);

				util.displayMessage("wait for 1 minutes, for next invocation");
				try {
					driver.close();
					util.waitTime();
				} catch (InterruptedException e) {

				}

			}
			if (!noIssue) {
				Assert.fail();
			}
		} catch (Exception e) {
			util.displayMessage("Found Issue");
			noIssue = false;
			Assert.fail();

		} catch (AssertionError er) {
			util.displayMessage("Found Issue");
			noIssue = false;
			Assert.fail();

		}
	}

	public static void main(String[] args) {
		SeFoundationSiteOpeningUp obj = new SeFoundationSiteOpeningUp();
		obj.initialize();
	}

	@AfterTest
	public void closeDriver() {
		try {
			util.displayMessage("closing driver");
			driver.close();
		} catch (Exception e) {
			util.displayMessage("driver is already closed");
		}
	}
}
