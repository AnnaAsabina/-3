package pages;

import mailru.autotests.model.MessageData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MessagesPage extends BasePage{

	private static final By writeNewMessageButton = By.xpath("//a[@data-name='compose']");
	private static final By writeNewMessagePageBox = By.xpath("//form[@name='Compose']");
	private static final By addresseeInputField = By.xpath("//div[@data-blockid='compose_to']//textarea[@data-original-name='To']");
	private static final By themeInputField = By.xpath("//input[@data-bem='b-input'][@name='Subject']");
	private static final By messageBoxFrame = By.xpath("//div[@class='compose__editor__frame']//iframe");
	private static final By messageInputField = By.xpath("//body[@id='tinymce']");
	private static final By messageSubmit = By.xpath("//div[@data-name='send']//span[text()='Отправить']");
	private static final By succesfullMessageCaution = By.xpath("//div[@class='message-sent__title']");
	private static final By sentMessagesButton = By.xpath("//a[@href='/messages/sent/']//span[text()='Отправленные']");
	private static final By sentMessagesPage = By.xpath("//div[@id='b-letters']");
	private static final By lastMessageInListAddress = By.xpath("//div[@id='b-letters']//div[@data-bem='b-datalist__item'][1]//div[@class='b-datalist__item__addr']");
	private static final By lastMessageInListTheme = By.xpath("//div[@id='b-letters']//div[@data-bem='b-datalist__item'][1]//div[@class='b-datalist__item__subj']");

	public MessagesPage(WebDriver wd) {
		super(wd);
	}

	public void initNewMail(){
		fifteenSecondsWait.until(ExpectedConditions.elementToBeClickable(writeNewMessageButton));
		click(writeNewMessageButton);
		isNewMessagePageBoxPresent();
	}

	public void isNewMessagePageBoxPresent(){
		isElementPresent(writeNewMessagePageBox);
	}

	public void fillMessageForms(MessageData messageData) {
		fiveSecondsWait.until(ExpectedConditions.elementToBeClickable(addresseeInputField));
		type((addresseeInputField), messageData.getAddressee());
		type((themeInputField), messageData.getTheme());
		wd.switchTo().frame(getElement(messageBoxFrame));
		type((messageInputField), messageData.getMessage());
		wd.switchTo().defaultContent();
	}

	public void submitNewMessage(MessageData messageData) {
		click(messageSubmit);
		fiveSecondsWait.until(ExpectedConditions.visibilityOfElementLocated(succesfullMessageCaution));
		Assert.assertEquals("Ваше письмо отправлено. Перейти во Входящие",getElement(succesfullMessageCaution).getText());
		checkSentMessages(messageData);
	}

	private void checkSentMessages(MessageData messageData) {
		click(sentMessagesButton);
		fiveSecondsWait.until(ExpectedConditions.visibilityOfElementLocated(sentMessagesPage));
		System.out.println("Shit" + getElement(lastMessageInListAddress).getText());
		Assert.assertEquals(messageData.getAddressee(), getElement(lastMessageInListAddress).getText());
		Assert.assertTrue(getElement(lastMessageInListTheme).getText().startsWith(messageData.getTheme()));
	}
}
