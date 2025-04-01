package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	@Test(description="Whether user is successfully able to login with valid credentials",retryAnalyzer=retry.Retry.class,priority=1)
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButton();
		boolean isDashBoardDisplayed = login.isDashBoardDisplayed();
		Assert.assertTrue(isDashBoardDisplayed, Messages.VALIDCREDENTIALERROR);
	}

	@Test(description="Whether user is Not able to login with valid username and invalid password",groups= {"smoke"},priority=2)
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButton();
		String expectedResult = "7rmart supermarket";
		String actualResult = login.getTextFromLoginText();
		Assert.assertEquals(actualResult, expectedResult, Messages.INVALIDPASSWORD);
	}

	@Test(description="Whether user is Not able to login with valid password and invalid username",priority=3)
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButton();
		String expectedResult = "7rmart supermarket";
		String actualResult = login.getTextFromLoginText();
		Assert.assertEquals(actualResult, expectedResult, Messages.INVALIDUSERNAME);
	}

	@Test(description="Whether user is Not able to login with Invalid credentials",priority=4)
	public void verifyUserLoginWithInvalidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButton();
		String expectedResult = "7rmart supermarket";
		String actualResult = login.getTextFromLoginText();
		Assert.assertEquals(actualResult, expectedResult, Messages.INVALIDCREDENTIALS);
	}

}
