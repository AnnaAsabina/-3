package mailru.autotests.testtask;

import lib.BaseTestClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CloudPage;
import pages.MainPage;
import pages.MessagesPage;
import pages.KalendarPage;



public class CloudKalendarTest extends BaseTestClass {

    public static MessagesPage messagesPage;
    public static MainPage mainPage;
    public static KalendarPage kalendarPage;



    @BeforeClass
    public static void beforeClassMethod() {
        messagesPage = new MessagesPage(wd);
        mainPage = new MainPage(wd);
        kalendarPage = new KalendarPage(wd);

    }

    @Test
    public void testCalendarClick() throws InterruptedException {
        mainPage.clickKalendar();
        kalendarPage.waitForKalendarButtonLoaded();
    }

}