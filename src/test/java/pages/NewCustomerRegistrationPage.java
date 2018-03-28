package pages;

import mailru.autotests.model.data.RegData;
import mailru.autotests.model.data.RegEmailData;
import mailru.autotests.model.data.RegPasswordData;
import mailru.autotests.model.data.RegPhoneData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.Thread.sleep;

public class NewCustomerRegistrationPage extends BasePage {
  private static final By CheckTheRegistrationForm = By.xpath("//span[@class='b-panel__header__text']");
  private static final By ConfirmButton = By.xpath("//span[@class='btn__text']");
  private static final By RegigistrationComfirm = By.xpath("//span[@class='b-panel__header__text']");
  public NewCustomerRegistrationPage(WebDriver wd) {
    super(wd);
  }


  public void checkTheRegistrationForm() {

    //fifteenSecondsWait.until(ExpectedConditions.visibilityOf((WebElement) CheckTheRegistrationForm));
    Assert.assertEquals(isRegformPresent(), true);
    Assert.assertEquals("Регистрация", getElement(CheckTheRegistrationForm).getText());


    if (isRegformPresent() == false) {
      System.out.println("Формы регистрации нет");
    } else {
      System.out.println("Форма регистрации есть");
    }
  }

  private boolean isRegformPresent() {
    try {
      wd.findElement(By.xpath("//span[@class='b-panel__header__text']"));
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public void fillName(RegData objectData) {
    type(By.name("firstname"), objectData.getFirstname());
    type(By.name("lastname"), objectData.getLastname());
  }

  public void chooseDay() {
    click(By.xpath("//span[contains(text(),'День')]"));

    List<WebElement> elements = wd.findElements(By.xpath(" //a[contains(@class,'day')]//span[@class='b-dropdown__list__item__text']"));
    System.out.println(elements.size());
    elements.get(30).click();


  }

  public void chooseMonth() {
    click(By.xpath("//span[contains(text(),'Месяц')]"));
    List<WebElement> elements = wd.findElements(By.xpath("//div[contains(@class,'b-date__month')]//span[@class='b-dropdown__list__item__text']"));
    System.out.println(elements.size());
    elements.get(11).click();
  }


  public void chooseYear() {
    click(By.xpath("//span[contains(text(),'Год')]"));
    List<WebElement> elements = wd.findElements(By.xpath("//div[contains(@class,'b-date__year')]//span[@class='b-dropdown__list__item__text']"));
    System.out.println(elements.size());
    elements.get(101).click();
  }

  public void chooseRadioButton() {
    click(By.xpath("//span[contains(text(),'Мужской')]"));
  }

  public void fillEmail(RegEmailData regEmailData) {
    type(By.xpath("//input[@data-blockid='email_name']"), regEmailData.getEmail());
  }
  public void fillPassword(RegPasswordData regPasswordData){
    type(By.name("password"),regPasswordData.getPassword());
    type(By.xpath("//input[@name='password_retry']"),regPasswordData.getPasswordretry());
  }

  public void chooseCountry() throws InterruptedException {
    click(By.xpath("//span[contains(text(),'Россия')]"));
    sleep(500);
   List<WebElement> elements = wd.findElements(By.xpath("//div[contains(@data-blockid,'countries')]//span[@class='b-dropdown__list__item__text']"));
    System.out.println(elements.size());
    sleep(500);
    elements.get(2).click();
    sleep(500);
  }
  public void typePhone(RegPhoneData regPhoneData) {
   type(By.xpath("//input[@data-blockid='number']"), regPhoneData.getPhone());
  }

  public void comfirmReg(){
    click(ConfirmButton);
  }

  public void checkPhoneCodeForm(){
    Assert.assertEquals("Регистрация", getElement(CheckTheRegistrationForm).getText());
    System.out.println("Переход осуществлен");
  }
}
















