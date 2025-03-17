package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	@Test
	public void verifyWhetherUserIsAbleToDoSubCategoryModule() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButton();
		SubCategoryPage subcategory = new SubCategoryPage(driver);
		subcategory.clickManageCategory();
		subcategory.clickSubCategory();
		subcategory.clickNewButton();
		WebElement categorySelect = driver.findElement(By.id("cat_id"));
		Select select = new Select(categorySelect);
		select.selectByIndex(3);
		String subCategoryInNew = ExcelUtility.getStringData(0, 0, "SubCategoryPage");
		subcategory.enterTheNewsOnSubCategory(subCategoryInNew);
		WebElement chooseFile = driver.findElement(By.id("main_img"));
		chooseFile.sendKeys(
				"C:\\Users\\Abishika V V\\git\\7RMart_Project\\7RMartProject\\src\\test\\resources\\fruits.jpg");
		subcategory.saveTheDetailsOfSubCategory();
	}

	@Test
	public void verifyWhetherUserIsAbleToSearchTheDetailsOfSubCategory() {
		WebElement search = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
		search.click();
		WebElement searchCategory = driver.findElement(By.id("un"));
		Select select1 = new Select(searchCategory);
		select1.selectByIndex(13);
		WebElement searchSubCategory = driver.findElement(By.xpath("//input[@class='form-control']"));
		searchSubCategory.sendKeys("fresh vegetables");
		WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-danger btn-fix']"));
		searchButton.click();
	}
}
