package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automationCore.Base;
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
		/*WebElement manageNews = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']"));
		manageNews.click();
		WebElement newbutton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newbutton.click();
		WebElement newsInfo =driver.findElement(By.id("news"));
		newsInfo.sendKeys("HI");
		WebElement save =driver.findElement(By.xpath("//button[@type='submit']"));
		save.click();*/
		ManageNewsPage managenews =new ManageNewsPage(driver);
		managenews.clickManageNewsOption();
		managenews.clickNewButton();
		managenews.enterTheNewsOnNewsColumn("HLOO");
		managenews.clickSaveButton();
		
	

	}
}
