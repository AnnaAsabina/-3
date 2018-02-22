package mailru.autotests.testtask;

import lib.BaseTestClass;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.KlavaPage;
import static mailru.autotests.model.data.constants.JAVA;
public class ClickKlavaTest extends BaseTestClass {

  public static KlavaPage klavaPage;
  private static final By InputField = By.xpath("//input[@tabindex='2']");
  @BeforeClass
  public static void beforeClassMethod() {
    klavaPage = new KlavaPage(wd);
  }
  @Test
  public static void clickByKlavaTest() throws InterruptedException{
    klavaPage.clickByKlava();
    klavaPage.checkTheKlavaPresent();
    klavaPage.clickByChangeKlava();
    klavaPage.typeByMiniNumKeyboard(InputField,JAVA);
    //klavaPage.typeTheWords();



  }
}