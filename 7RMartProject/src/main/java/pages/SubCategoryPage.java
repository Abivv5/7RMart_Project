package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoryPage {
	public WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage Category']")
	private WebElement manageCategory;
	@FindBy(xpath = "//p[text()='Sub Category']")
	private WebElement subCategory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(id = "cat_id")
	private WebElement categorySelect;
	@FindBy(id = "subcategory")
	private WebElement subCategoryInNew;
	@FindBy(id = "main_img")
	private WebElement chooseFile;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;

public void clickManageCategory() {
	manageCategory.click();
}
public void clickSubCategory() {
	subCategory.click();
}
public void clickNewButton() {
	newButton.click();
}
public void enterTheNewsOnSubCategory(String messageColumn) {
	subCategoryInNew.sendKeys(messageColumn);
}
//public void fileUploadingInSubCategory() {
	//chooseFile.
//}
public void saveTheDetailsOfSubCategory() {
	saveButton.click();
}

}











