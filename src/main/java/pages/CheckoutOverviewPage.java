package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CheckoutOverviewPage extends BasePage {

	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
	}

	private final By overviewTitle = By.cssSelector("[data-test='title']");
	private final By finishBtn = By.id("finish");

	public boolean isCheckoutOverviewDisplayed() {
		return isDisplayed(driver.findElement(overviewTitle));
	}

	public void clickFinish() {
		click(driver.findElement(finishBtn));
	}
}
