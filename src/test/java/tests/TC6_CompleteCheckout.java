package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import base.BaseTest;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.JsonDataReader;

public class TC6_CompleteCheckout extends BaseTest {

	@Test
	public void completeCheckout() {

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

		checkoutPage.checkoutInformation(
				checkoutData.getAsJsonObject("checkout").get("firstName").getAsString(),
				checkoutData.getAsJsonObject("checkout").get("lastName").getAsString(),
				checkoutData.getAsJsonObject("checkout").get("postalCode").getAsString());

		CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
		Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewDisplayed());
		checkoutOverviewPage.clickFinish();
		CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
		Assert.assertTrue(checkoutCompletePage.isCheckoutCompleteDisplayed());
		Assert.assertTrue(checkoutCompletePage.isOrderCompleted());
		checkoutCompletePage.clickBackHome();
		Assert.assertTrue(inventoryPage.isProductsPageDisplayed());
	}
}
