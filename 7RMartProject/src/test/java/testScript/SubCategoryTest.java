package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constants;
import constants.Messages;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	@Test(description="Whether user is able to add a new category list")
	public void verifyWhetherUserIsAbleToAddNewCategoryList() throws IOException {
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
		subcategory.selectCategory();
		String subCategoryInNew = ExcelUtility.getStringData(0, 0, "SubCategoryPage");
		subcategory.enterTheNewsOnSubCategory(subCategoryInNew);
		WebElement chooseFile = driver.findElement(By.id("main_img"));
		chooseFile.sendKeys(Constants.SUBCATFILEUPLOAD);
		subcategory.saveTheDetailsOfSubCategory();
		boolean subCategoryDisplayed = subcategory.isSubCategoryDisplayed();
		Assert.assertTrue(subCategoryDisplayed, Messages.SUBCATEGORYADDERROR);
	}

	@Test(description="Whether user is able to search the details of subcategory")
	public void verifyWhetherUserIsAbleToSearchTheDetailsOfSubCategory() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButton();
		SubCategoryPage subcategory = new SubCategoryPage(driver);
		subcategory.clickManageCategory();
		subcategory.clickSubCategory();
		subcategory.clickSearchButton();
		subcategory.selectCategoryForSearch();
		WebElement searchSubCategory = driver.findElement(By.xpath("//input[@class='form-control']"));
		searchSubCategory.sendKeys(Constants.SUBCATSEARCH);
		subcategory.clickSearchButtonForSearch();
		boolean isSubCategorySearchDisplayed = subcategory.isSubCategorySearchDisplayed();
		Assert.assertTrue(isSubCategorySearchDisplayed, Messages.SUBCATEGORYSEARCHERROR);
	}
}
