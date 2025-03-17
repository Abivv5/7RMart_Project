package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	@Test
	public void verifyWhetherTheUserIsAbleToUseAdminUserModule() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButton();
		AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickAdminUser();
		admin.clickManageUser();
		admin.clickNewButton();
		String usernamee= ExcelUtility.getStringData(0, 0, "AdminUserPage");
		String passwordd = ExcelUtility.getStringData(0, 1, "AdminUserPage");
		admin.enterTheUserName(usernamee);
		admin.enterThePassWord(passwordd);
		WebElement userType = driver.findElement(By.id("user_type"));
		Select select = new Select(userType);
		select.selectByIndex(1);
		admin.clickSaveButton();
	}

	@Test
	public void verifyWhetherUserIsAbleToSearchTheDetailsOfAdminUsers() {
		WebElement searchButton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
		searchButton.click();
		WebElement usernameSearch = driver.findElement(By.id("un"));
		usernameSearch.sendKeys("Abi");
		WebElement userTypeSearch = driver.findElement(By.id("ut"));
		Select select = new Select(userTypeSearch);
		select.selectByIndex(1);
		WebElement searchButtonSearch = driver.findElement(By.xpath("//button[@value='sr']"));
		searchButtonSearch.click();

	}

}
