package mailru.autotests.testtask;

import lib.BaseTestClass;
import mailru.autotests.model.MessageData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CloudPage;
import pages.MainPage;
import pages.MessagesPage;

import static java.lang.Thread.sleep;

public class CloudClickTest extends BaseTestClass {

    public static MessagesPage messagesPage;
    public static MainPage mainPage;
    public static CloudPage cloudPage;

    @BeforeClass
    public static void beforeClassMethod() {
        messagesPage = new MessagesPage(wd);
        cloudPage = new CloudPage(wd);
        mainPage = new MainPage(wd);
    }

    @Test
    public void testClickCloud() throws InterruptedException {
        mainPage.clickCloud();
        cloudPage.waitForCloudPageLoaded();
        cloudPage.clickCloudButton();
        cloudPage.waitForCloudPopupLoaded();
    }

}
