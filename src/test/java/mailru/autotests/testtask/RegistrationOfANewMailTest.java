package mailru.autotests.testtask;

import lib.BaseTestClass;
import mailru.autotests.model.data.RegData;
import mailru.autotests.model.data.RegEmailData;
import mailru.autotests.model.data.RegPasswordData;
import mailru.autotests.model.data.RegPhoneData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MessagesPage;
import pages.NewCustomerRegistrationPage;

public class RegistrationOfANewMailTest extends BaseTestClass {

    public static MessagesPage messagesPage;
    public static MainPage mainPage;
    public static NewCustomerRegistrationPage newCustomerRegistrationPage;

    @BeforeClass
    public static void beforeClassMethod() {
        messagesPage = new MessagesPage(wd);
        mainPage = new MainPage(wd);
        newCustomerRegistrationPage = new NewCustomerRegistrationPage(wd);
    }

    @Test
    public void testRegistration() throws InterruptedException {
        mainPage.RegistrationOfaNewMail();
        newCustomerRegistrationPage.checkTheRegistrationForm();
        RegData firstnamelastname = new RegData("Anna","Asabina");
        newCustomerRegistrationPage.fillName(firstnamelastname);
        newCustomerRegistrationPage.chooseDay();
        newCustomerRegistrationPage.chooseMonth();
        newCustomerRegistrationPage.chooseYear();
        newCustomerRegistrationPage.chooseRadioButton();
        RegEmailData email = new RegEmailData("bdgvvccvcghdcvcgvccv");
        newCustomerRegistrationPage.fillEmail(email);
        RegPasswordData passwords = new RegPasswordData("Anna140689","Anna140689");
        newCustomerRegistrationPage.fillPassword(passwords);
        newCustomerRegistrationPage.chooseCountry();
        RegPhoneData phone = new RegPhoneData("+79049043656");
        newCustomerRegistrationPage.typePhone(phone);
        newCustomerRegistrationPage.comfirmReg();
        newCustomerRegistrationPage.checkTheRegistrationForm();

    }

}
