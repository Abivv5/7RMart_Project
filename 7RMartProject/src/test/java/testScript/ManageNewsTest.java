package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test
	public void verifyWhetherUserIsAbleToAccessManageNewsTest() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButton();
		ManageNewsPage managenews = new ManageNewsPage(driver);
		managenews.clickManageNewsOption();
		managenews.clickNewButton();
		String newscloumn = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenews.enterTheNewsOnNewsColumn(newscloumn);
		managenews.clickSaveButton();
		boolean manageNewsDisplayed = managenews.isManageNewsDisplayed();
		Assert.assertTrue(manageNewsDisplayed,Messages.MANAGENEWSERROR);
	}
}
