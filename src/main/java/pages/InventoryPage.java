package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class InventoryPage extends BasePage {

	public InventoryPage(WebDriver driver) {
		super(driver);
	}

	private final By productsTitle = By.cssSelector("[data-test='title']");
	private final By addBackpackToCartBtn = By.id("add-to-cart-sauce-labs-backpack");

	public boolean isProductsPageDisplayed() {
		return isDisplayed(driver.findElement(productsTitle));
	}

	public void addBackpackToCart() {
		click(driver.findElement(addBackpackToCartBtn));
	}
	
	private final By removeBackpackBtn = By.id("remove-sauce-labs-backpack");

	public boolean isBackpackAddedToCart() {
		return isDisplayed(driver.findElement(removeBackpackBtn));
	}
	
	private final By cartIcon = By.cssSelector("[data-test='shopping-cart-link']");

	public void clickCart() {
		click(driver.findElement(cartIcon));
	}
}