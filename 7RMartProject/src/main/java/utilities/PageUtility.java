package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class PageUtility {
	public void dropDownSelectionIndexValue(WebDriver driver, int index) {
		WebElement dropDown1 = driver.findElement(By.xpath("//select[@id='dropdowm-menu-1']"));
		Select select = new Select(dropDown1);
		select.selectByIndex(index);
	}

	public void dropDownSelectionByValue(WebDriver driver, String value) {
		WebElement dropDown2 = driver.findElement(By.xpath("//select[@id='dropdowm-menu-2']"));
		Select select1 = new Select(dropDown2);
		select1.selectByValue(value);
	}

	public void dropDownSelectionByVisibleText(WebDriver driver, String value) {
		WebElement dropDown3 = driver.findElement(By.xpath("//select[@id='dropdowm-menu-3']"));
		Select select2 = new Select(dropDown3);
		select2.selectByVisibleText(value);
	}

	public void handlingCheckbox(WebDriver driver) {
		WebElement firstbox = driver.findElement(By.xpath("//input[@value='option-1']"));
		firstbox.click();
	}

	public void handlingRadioButton(WebDriver driver) {
		WebElement radiobutton = driver.findElement(By.xpath("//input[@value='green']"));
		radiobutton.click();
	}

	public void rightClickAction(WebDriver driver) {
		WebElement rightClick = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions action = new Actions(driver);
		action.contextClick(rightClick).build().perform();
	}

	public void mouseHoverAction(WebDriver driver) {
		WebElement hover = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
		Actions action = new Actions(driver);
		action.moveToElement(hover).build().perform();
	}

}
