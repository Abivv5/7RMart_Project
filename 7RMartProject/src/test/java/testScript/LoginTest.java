package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);// constructor invoking, parameterized
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButton();
		boolean isDashBoardDisplayed = login.isDashBoardDisplayed();
		Assert.assertTrue(isDashBoardDisplayed,"User is unable to login with valid credentials");
	}

	@Test
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);// constructor invoking, parameterized
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButton();
		String expectedResult = "7rmart supermarket";
		String actualResult = login.getTextFromLoginText();
		Assert.assertEquals(actualResult, expectedResult,"User is able to login invalid password");
	}

	@Test
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);// constructor invoking, parameterized
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButton();
		String expectedResult = "7rmart supermarket";
		String actualResult = login.getTextFromLoginText();
		Assert.assertEquals(actualResult, expectedResult,"User is able to login invalid username");
	}

	@Test
	public void verifyUserLoginWithInvalidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);// constructor invoking, parameterized
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButton();
		String expectedResult = "7rmart supermarket";
		String actualResult = login.getTextFromLoginText();
		Assert.assertEquals(actualResult, expectedResult,"User is able to login invalid credentiuals");
	}

}
