package automationCore;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenShotUtility;
import utilities.WaitUtility;

public class Base {
	public WebDriver driver;

	@BeforeMethod
	public void initializeBrowser() {
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		// driver = new EdgeDriver();
		driver.get(" https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		WaitUtility wait = new WaitUtility();
		wait.implicitWait();

	}

	@AfterMethod
	public void driverQuit(ITestResult iTestResult) throws IOException

	{

		if (iTestResult.getStatus() == ITestResult.FAILURE)

		{

			ScreenShotUtility screenShot = new ScreenShotUtility();

			screenShot.getScreenshot(driver, iTestResult.getName());

		}

		driver.quit();

	}

}
