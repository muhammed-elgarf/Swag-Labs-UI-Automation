package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import base.BaseTest;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.JsonDataReader;

public class TC3_VerifyProductInCart extends BaseTest {

	@Test
	public void verifyProductInCart() {

		JsonObject data = JsonDataReader.readJsonFromResource("testdata/LoginData.json");

		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(
				data.getAsJsonObject("validUser").get("username").getAsString(),
				data.getAsJsonObject("validUser").get("password").getAsString());

		InventoryPage inventoryPage = new InventoryPage(driver);

		inventoryPage.addBackpackToCart();
		inventoryPage.clickCart();

		CartPage cartPage = new CartPage(driver);

		Assert.assertTrue(cartPage.isCartPageDisplayed());
		Assert.assertTrue(cartPage.isBackpackDisplayed());
	}
}