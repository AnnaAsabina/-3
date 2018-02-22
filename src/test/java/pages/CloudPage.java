package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.awt.SystemColor.text;
import static org.testng.Assert.assertEquals;


public class CloudPage extends BasePage {
    private static final By cloudButton = By.xpath("//input[@class='nav-inner-col-try__bt']");
    private static final By cloudPopup = By.xpath("//div[contains(@class,'x-ph__popup__title')]");
    private static final By cloudPopupTitle = By.xpath("//div[contains(text(),'Вход')]");

    public CloudPage(WebDriver wd) {
        super(wd);
    }

    public void waitForCloudPageLoaded() {
        fifteenSecondsWait.until(ExpectedConditions.elementToBeClickable(cloudButton));
        String text = getElement(cloudButton).getAttribute("value");
        System.out.println("Текст кнопки: " + text);
        assertEquals(text, "Войти в Облако", "Строки должны быть равны");
    }

    public void clickCloudButton(){
        click((cloudButton));
    }

    public void waitForCloudPopupLoaded() {
        fifteenSecondsWait.until(ExpectedConditions.visibilityOfElementLocated(cloudPopupTitle));
    }
}
