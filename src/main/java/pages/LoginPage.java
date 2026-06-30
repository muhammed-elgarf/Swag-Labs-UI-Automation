package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private final By usernameField = By.id("user-name");
	private final By passwordField = By.id("password");
	private final By loginButton = By.id("login-button");

	public void enterUsername(String username) {
		type(driver.findElement(usernameField), username);
	}

	public void enterPassword(String password) {
		type(driver.findElement(passwordField), password);
	}

	public void clickLogin() {
		click(driver.findElement(loginButton));
	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}
}