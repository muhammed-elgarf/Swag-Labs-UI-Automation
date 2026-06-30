package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {

	    ChromeOptions options = new ChromeOptions();

	    Map<String, Object> prefs = new HashMap<>();

	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    prefs.put("profile.password_manager_leak_detection", false);

	    options.setExperimentalOption("prefs", prefs);

	    options.addArguments("--disable-notifications");
	    options.addArguments("--disable-popup-blocking");
	    options.addArguments("--disable-save-password-bubble");
	    options.addArguments("--disable-features=PasswordLeakDetection,PasswordCheck");
	    options.addArguments("--disable-first-run-ui");
	    options.addArguments("--disable-default-apps");
	    options.addArguments("--incognito");
	    options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "/chrome-profile");

	    WebDriverManager.chromedriver().setup();

	    driver = new ChromeDriver(options);

	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	    driver.get(ConfigReader.getProperty("baseUrl"));
	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}
}