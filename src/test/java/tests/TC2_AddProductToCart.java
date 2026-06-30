package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.JsonDataReader;

public class TC2_AddProductToCart extends BaseTest {

	@Test
	public void addProductToCart() {

		JsonObject data = JsonDataReader.readJsonFromResource("testdata/LoginData.json");

		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(
				data.getAsJsonObject("validUser").get("username").getAsString(),
				data.getAsJsonObject("validUser").get("password").getAsString());

		InventoryPage inventoryPage = new InventoryPage(driver);
		Assert.assertTrue(inventoryPage.isProductsPageDisplayed());

		inventoryPage.addBackpackToCart();
		Assert.assertTrue(inventoryPage.isBackpackAddedToCart());	}
}
