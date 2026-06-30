package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
	}

	private final By yourCartTitle = By.cssSelector("[data-test='title']");
	private final By backpackProduct = By.id("item_4_title_link");
	private final By removeBackpackBtn = By.id("remove-sauce-labs-backpack");
	private final By cartItem = By.className("cart_item");

	public boolean isCartPageDisplayed() {
		return isDisplayed(driver.findElement(yourCartTitle));
	}

	public boolean isBackpackDisplayed() {
		return isDisplayed(driver.findElement(backpackProduct));
	}

	public void removeBackpack() {
		click(driver.findElement(removeBackpackBtn));
	}

	public boolean isCartEmpty() {
		return driver.findElements(cartItem).isEmpty();
	}
}