package pages;


import lib.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver wd;
	protected WebDriverWait fiveSecondsWait;
	protected WebDriverWait fifteenSecondsWait;

	public BasePage(WebDriver wd) {
		this.wd = wd;
		this.fiveSecondsWait = new WebDriverWait(wd, Timeout.fiveSecondsTimeout);
		this.fifteenSecondsWait = new WebDriverWait(wd, Timeout.fifteenSecondsTimeout);
	}

	protected void click(By locator) {
		wd.findElement(locator).click();
	}

	protected void type(By locator, String text) {
		click(locator);
		if(text != null){
			wd.findElement(locator).clear();
			wd.findElement(locator).sendKeys(text);
		}
	}

	public boolean isElementPresent(By locator){
		try{
			wd.findElement(locator);
			return true;
		} catch(NoSuchElementException ex){
			return false;
		}
	}

	public WebElement getElement(By locator) {
		return wd.findElement(locator);
	}

	public void setDriver(WebDriver wd) {
		this.wd = wd;
	}
}
