package mailru.autotests.testtask;

import lib.BaseTestClass;
import mailru.autotests.model.MessageData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MessagesPage;

public class MessageSentTest extends BaseTestClass {

    public static MessagesPage messagesPage;
    public static MainPage mainPage;

    @BeforeClass
    public static void beforeClassMethod() {
        messagesPage = new MessagesPage(wd);
        mainPage = new MainPage(wd);
    }

    @Test
    public void testMailSend(){
        mainPage.login(user1.getLogin(), user1.getPassword());
        messagesPage.initNewMail();
        MessageData message = new MessageData("pleh4nov@gmail.com","Тестовое письмо","Проверка, раз, два!" );
        messagesPage.fillMessageForms(message);
        messagesPage.submitNewMessage(message);
    }

}
