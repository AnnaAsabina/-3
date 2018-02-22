package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;


public class KalendarPage extends BasePage {
    private static final By calendarButton = By.xpath("//div[@class='b-button-try-img__top']");
    private static final By calendarButtonText = By.xpath("//span[contains(text(),'Попробовать Календарь')]");

    public KalendarPage(WebDriver wd) {
        super(wd);
    }

    public void waitForKalendarButtonLoaded() {
        fifteenSecondsWait.until(ExpectedConditions.elementToBeClickable(calendarButton));
        String text = getElement(calendarButtonText).getText();
        System.out.println("Текст кнопки: " + text);
        assertEquals(text, "Попробовать Календарь", "Строки должны быть равны");
    }


}