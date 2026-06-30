package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import base.BaseTest;
import pages.LoginPage;
import utilities.JsonDataReader;

public class TC1_ValidLogin extends BaseTest {

	@Test
	public void validLogin() {
		JsonObject data = JsonDataReader.readJsonFromResource("testdata/LoginData.json");

		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(
				data.getAsJsonObject("validUser").get("username").getAsString(),
				data.getAsJsonObject("validUser").get("password").getAsString());

		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
	}
}