package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUsersPage {
	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement adminUser;
	@FindBy(xpath = "//p[text()='Manage Users']")
	private WebElement manageUser;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(id = "username")
	private WebElement userName;
	@FindBy(id = "password")
	private WebElement passWord;
	@FindBy(id = "user_type")
	private WebElement userType;
	@FindBy(xpath = "//i[@class='fa fa-save']")
	private WebElement saveButton;

	public void clickAdminUser() {
		adminUser.click();
	}

	public void clickManageUser() {
		manageUser.click();
	}

	public void clickNewButton() {
		newButton.click();
	}

	public void enterTheUserName(String usernamee) {
		userName.sendKeys(usernamee);
	}

	public void enterThePassWord(String passwordd) {
		passWord.sendKeys(passwordd);
	}

	public void clickSaveButton() {
		saveButton.click();
	}

}
