package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public WebDriver driver;
	public int IMPLICITWAIT = 5;
	public int EXPLICITWAIT = 5;

	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait1.until(ExpectedConditions.elementSelectionStateToBe(element, true));

	}

	public void waitForElementToBeSelectedByElement(WebDriver driver, WebElement element) {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait2.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitForElementToBeSelectedByInvisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait3.until(ExpectedConditions.invisibilityOf(element));

	}

	public void waitForElementToBeSelectedByVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait4.until(ExpectedConditions.visibilityOf(element));

	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITWAIT));

	}

	public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue,

			int total) {

		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))

				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));

	}
}
