package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CheckoutCompletePage extends BasePage {

	public CheckoutCompletePage(WebDriver driver) {
		super(driver);
	}

	private final By completeTitle = By.cssSelector("[data-test='title']");
	private final By completeHeader = By.cssSelector("[data-test='complete-header']");
	private final By backHomeBtn = By.id("back-to-products");

	public boolean isCheckoutCompleteDisplayed() {
		return isDisplayed(driver.findElement(completeTitle));
	}

	public boolean isOrderCompleted() {
		return isDisplayed(driver.findElement(completeHeader));
	}

	public void clickBackHome() {
		click(driver.findElement(backHomeBtn));
	}
}