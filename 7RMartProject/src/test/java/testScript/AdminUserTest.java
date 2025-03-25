package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base {
	
	@Test
	public void verifyWhetherTheUserIsAbleToAddNewUserToTheUsersList() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButton();
		AdminUserPage adminUsers = new AdminUserPage(driver);
		adminUsers.clickAdminUser();
		adminUsers.clickManageUser();
		adminUsers.clickNewButton();
		RandomDataUtility faker=new RandomDataUtility();
		String usernamee = faker.createRandomUsername();
		adminUsers.enterUserName(usernamee);
		String passwordd = faker.createRandomPassword();
		adminUsers.enterPassword(passwordd);
		adminUsers.selectUserType();
		adminUsers.clickOnSaveButton();
		boolean adminUserDisplayed = adminUsers.isAdminUserSearchDisplayed();
		Assert.assertTrue(adminUserDisplayed, Messages.ADMINUSERERROR);
	}

	@Test
	public void verifyWhetherUserIsAbleToSearchAdminUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButton();
		AdminUserPage adminUsers = new AdminUserPage(driver);
		adminUsers.clickAdminUser();
		adminUsers.clickManageUser();
		adminUsers.searchBySearchOption();
		RandomDataUtility faker=new RandomDataUtility();
		String username2 = faker.createRandomUsername();
		adminUsers.enterUserNameForSearch(username2);
		WebElement userTypee = driver.findElement(By.id("ut"));
		Select select = new Select(userTypee);
		select.selectByIndex(2);
		adminUsers.clickSearch();
		boolean adminUserSearchDisplayed = adminUsers.isAdminUserSearchDisplayed();
		Assert.assertTrue(adminUserSearchDisplayed, Messages.ADMINUSERSEARCHERROR);
	}

}
