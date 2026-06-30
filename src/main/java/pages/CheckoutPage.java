package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	private final By checkoutBtn = By.id("checkout");
	private final By firstNameField = By.id("first-name");
	private final By lastNameField = By.id("last-name");
	private final By postalCodeField = By.id("postal-code");
	private final By continueBtn = By.id("continue");
	private final By checkoutTitle = By.cssSelector("[data-test='title']");

	public void clickCheckout() {
		click(driver.findElement(checkoutBtn));
	}

	public boolean isCheckoutPageDisplayed() {
		return isDisplayed(driver.findElement(checkoutTitle));
	}

	public void enterFirstName(String firstName) {
		type(driver.findElement(firstNameField), firstName);
	}

	public void enterLastName(String lastName) {
		type(driver.findElement(lastNameField), lastName);
	}

	public void enterPostalCode(String postalCode) {
		type(driver.findElement(postalCodeField), postalCode);
	}

	public void clickContinue() {
		click(driver.findElement(continueBtn));
	}

	public void checkoutInformation(String firstName, String lastName, String postalCode) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPostalCode(postalCode);
		clickContinue();
	}
}