package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MainPage extends BasePage {

	private static final By userLogin = By.xpath("//input[contains(@id,'login')]");
	private static final By userPassword = By.xpath("//input[contains(@id,'password')]");
	private static final By loginSubmitButton = By.xpath("//input[@value='Войти']");
	private static final By CheckboxRememberMe = By.xpath ("//input[@id='mailbox:saveauth']");
	private static final By cloudSymbol = By.xpath("//a[contains(@class, 'mailbox__icon_cloud')]");
	private static final By calendarSymbol = By.xpath("//a[contains(@class,' mailbox__icon_calendar')]");
	private static final By initTheRegistrationOfaNewMail =By.xpath("//a[@class='mailbox__footer']");
	public MainPage(WebDriver wd) {
		super(wd);
	}

	public void login(String username, String password) {
		type((userLogin),username);
		type((userPassword),password);
		fifteenSecondsWait.until(ExpectedConditions.elementToBeClickable(CheckboxRememberMe));
		click((CheckboxRememberMe));
		fifteenSecondsWait.until(ExpectedConditions.elementToBeClickable(CheckboxRememberMe));
		click((CheckboxRememberMe));
		click(loginSubmitButton);
	}

	public void clickCloud(){
		click(cloudSymbol);
	}

	public void clickKalendar() {click(calendarSymbol);}

	public  void RegistrationOfaNewMail(){
		click(initTheRegistrationOfaNewMail);

	}
}