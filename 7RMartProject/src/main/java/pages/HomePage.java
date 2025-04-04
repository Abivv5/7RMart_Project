package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement adminField;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logoutField;

	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement homeText;

	public void clickAdminButton() {
		adminField.click();
	}

	public void clickLogoutButton() {
		logoutField.click();
	}

	public boolean isHomeDisplayed() {
		return homeText.isDisplayed();
	}

	public String getTextFromhomeText() {
		return homeText.getText();
	}

}
