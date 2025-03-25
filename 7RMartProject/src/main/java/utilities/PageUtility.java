package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class PageUtility {
	public void dropDownSelectionIndexValue(WebDriver driver, int index, WebElement element) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void dropDownSelectionByValue(WebDriver driver, String value, WebElement element1) {

		Select select1 = new Select(element1);
		select1.selectByValue(value);
	}

	public void dropDownSelectionByVisibleText(WebDriver driver, String value, WebElement element2) {
		Select select2 = new Select(element2);
		select2.selectByVisibleText(value);
	}

	public void handlingCheckbox(WebDriver driver, WebElement firstbox) {

		firstbox.click();
	}

	public void handlingRadioButton(WebDriver driver, WebElement radiobutton) {

		radiobutton.click();
	}

	public void rightClickAction(WebDriver driver, WebElement rightClick) {
		Actions action = new Actions(driver);
		action.contextClick(rightClick).build().perform();
	}

	public void mouseHoverAction(WebDriver driver, WebElement hover) {

		Actions action = new Actions(driver);
		action.moveToElement(hover).build().perform();
	}

	public void scrollDownAndScrollUp(WebDriver driver, WebElement button) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		js.executeScript("window.scrollBy(0,350)", "");
		js.executeScript("window.scrollBy(0,-350)", "");
	}
}