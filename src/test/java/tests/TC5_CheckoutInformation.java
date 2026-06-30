package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import base.BaseTest;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.JsonDataReader;

public class TC5_CheckoutInformation extends BaseTest {

	@Test
	public void checkoutInformation() {

		JsonObject loginData = JsonDataReader.readJsonFromResource("testdata/LoginData.json");
		JsonObject checkoutData = JsonDataReader.readJsonFromResource("testdata/CheckoutData.json");

		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(
				loginData.getAsJsonObject("validUser").get("username").getAsString(),
				loginData.getAsJsonObject("validUser").get("password").getAsString());

		InventoryPage inventoryPage = new InventoryPage(driver);
		inventoryPage.addBackpackToCart();
		inventoryPage.clickCart();

		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.clickCheckout();

		Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());

		checkoutPage.checkoutInformation(
				checkoutData.getAsJsonObject("checkout").get("firstName").getAsString(),
				checkoutData.getAsJsonObject("checkout").get("lastName").getAsString(),
				checkoutData.getAsJsonObject("checkout").get("postalCode").getAsString());
		
		CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
		Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewDisplayed());
	}
}
