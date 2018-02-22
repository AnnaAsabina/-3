package lib;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.BasePage;
import pages.MainPage;
import pages.MessagesPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTestClass {

	public static WebDriver wd;
	public static MainPage mainPage;
	public static MessagesPage messagesPage;
	public static String browser = BrowserType.FIREFOX;
	public static User user1;
	public static String baseUrl;
	protected static Properties properties;

	@BeforeClass
	public void setUp() throws Exception {
		init();
	}

	@AfterMethod
	public void tearDown() {
		stop();
	}

	public static void init() throws IOException {
		setProperties();
		wd = startNewDriver();
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		wd.get("https:" + baseUrl + "/");
		BasePage page = new BasePage(wd);
		page.setDriver(wd);
		wd.manage().window().maximize();
	}

	public void stop() {
		wd.quit();
	}

	public static WebDriver startNewDriver() {
		if (wd != null) {
			return wd;
		}
		ChromeDriverManager.getInstance().setup();
		wd = new ChromeDriver(getChromeOptions());
		System.out.println("ChromeDriver started!!!");
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
		return wd;
	}

	private static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		return options;
	}

	public static synchronized void setProperties() throws IOException {
			        /* Set logger */
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
	        /* Load config.properties file */
		properties = new Properties();
		try {
			properties.load(BaseTestClass.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			System.out.println("Can't load 'config.properties'");
		}

		baseUrl = properties.getProperty("url");

	        /* Initialize user 1 */
		user1 = new User(properties.getProperty("login"),
				properties.getProperty("pass"));
	}

	public MessagesPage getMessagesPage() {
		return messagesPage;
	}

}
