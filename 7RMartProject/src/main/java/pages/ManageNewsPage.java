package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement manageNews;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(id = "news")
	private WebElement newsInfo;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save;

	@FindBy(xpath = "//h3[text()='Enter News Informations']")
	private WebElement manageNewsText;

	public void clickManageNewsOption() {
		manageNews.click();
	}

	public void clickNewButton() {
		newButton.click();
	}

	public void enterTheNewsOnNewsColumn(String newscloumn) {
		newsInfo.sendKeys(newscloumn);
	}

	public void clickSaveButton() {
		save.click();
	}

	public boolean isManageNewsDisplayed() {
		return manageNewsText.isDisplayed();
	}

	public String getTextFromManageNewsText() {
		return manageNewsText.getText();
	}

}
