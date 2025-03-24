package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// Initialze the elements.
	}

	@FindBy(xpath = "//input[@type='text']")
	private WebElement userNameField; // finding element by using pageFactory.
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signIn;

	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashBoard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement loginText;

	public void enterUsernameOnUsernameField(String username) {
		userNameField.sendKeys(username);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnSignInButton() {
		signIn.click();
	}

	public boolean isDashBoardDisplayed() {

		return dashBoard.isDisplayed();
	}

	public String getTextFromLoginText() {

		return loginText.getText();
	}
}
