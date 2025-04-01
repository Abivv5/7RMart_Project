package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	@Test(description="Whether user is successfully able to logout from the Homepage", retryAnalyzer=retry.Retry.class )
	public void verifyWhetherUserIsAbleToLogoutAfterSuccessfulLogin() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButton();
		HomePage home = new HomePage(driver);
		home.clickAdminButton();
		home.clickLogoutButton();
		boolean HomeDisplayed = home.isHomeDisplayed();
		Assert.assertTrue(HomeDisplayed, Messages.LOGOUTERROR);

	}

}
