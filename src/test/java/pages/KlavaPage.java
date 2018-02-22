package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.NoSuchElementException;
import static mailru.autotests.model.data.constants.JAVA;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;

public class KlavaPage extends BasePage {
  private static final By KlavaButton = By.xpath("//i[contains(@class,' keyboard-loader__icon')]");
  private static final By ChangeLanguageKlavaClick = By.xpath("//div[contains(@class,'b-keyboard__lang')]");
  private static final By EnglishKlavaButton = By.xpath("//ul//li[contains(@class,' b-keyboard__lang-en')]");
  private static final By EnglishKlavaButtonJ = By.xpath("//td[@class ='b-keyboard__row__cell']//span[text()='j']");
  private static final By EnglishKlavaButtonA = By.xpath("//td[@class ='b-keyboard__row__cell']//span[text()='a']");
  private static final By EnglishKlavaButtonV = By.xpath("//td[@class ='b-keyboard__row__cell']//span[text()='v']");
  private static final By InputField = By.xpath("//input[@tabindex='2']");
  protected static final String keyButtonMini = "//td[@class='b-keyboard__row__cell']//span[text()='%s']";
  protected static final By keyboardNumMini = By.xpath("//div[@class='b-keyboard-popup']");
  public KlavaPage(WebDriver wd) {
    super(wd);
  }

  public void clickByKlava() {

    fifteenSecondsWait.until(ExpectedConditions.visibilityOfElementLocated(KlavaButton));
    click((KlavaButton));
  }

  public void clickByChangeKlava() {
    fifteenSecondsWait.until(ExpectedConditions.visibilityOfElementLocated(ChangeLanguageKlavaClick));
    click((ChangeLanguageKlavaClick));
  }

  public void typeTheWords() {
    /*click((EnglishKlavaButton));
    click((EnglishKlavaButtonJ));
    click((EnglishKlavaButtonA));
    click((EnglishKlavaButtonV));
    click((EnglishKlavaButtonA));*/

    String text = getElement(InputField).getAttribute("value");
    System.out.println("Текст в поле: " + text);
    assertEquals(text, "java", "java");
  }

  public void typeByMiniNumKeyboard(By InputField, String value) throws InterruptedException {
    WebElement inputElem = getElement(InputField);
    inputElem.clear();
   // WebElement keyboard = wd.findElement(keyButtonMini);
    for (char v : value.toCharArray()) {
      sleep(100);
      sleep(100);
      wd.findElement(By.xpath(String.format(keyButtonMini, v))).click();
    }
  }

  public void checkTheKlavaPresent() {
    fifteenSecondsWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='b-keyboard-popup']")));
    Assert.assertEquals(isCloseButtonPresent(), true);

    if (isCloseButtonPresent() == false) {
      System.out.println("Экранной клавиатуры нет");
    } else {
      System.out.println("Экранная клавиатура есть");
    }
  }

  public boolean isCloseButtonPresent(){
    try{wd.findElement(By.xpath("//div[@class='b-keyboard-popup']"));
      return true;
    }
    catch (NoSuchElementException ex){
      return false;}
  }

  }







