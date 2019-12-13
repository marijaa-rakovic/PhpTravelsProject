package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.TravelCustomer;
import pages.TravelsLogIn;
import pages.TravelsMenu;

public class TravelsCustomerEditTest extends BasicTest {

	private String baseUrl = "https://www.phptravels.net/admin";

	@BeforeTest
	public void logInForMainTest() throws InterruptedException {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TravelsLogIn trLogIn = PageFactory.initElements(driver, TravelsLogIn.class);
		trLogIn.logIn("admin@phptravels.com", "demoadmin");
		TravelsMenu travelsMenu = PageFactory.initElements(driver, TravelsMenu.class);
		travelsMenu.customersClick();
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	public void editDetailsInCarExtras() throws InterruptedException {

		TravelCustomer customerEdit = PageFactory.initElements(driver, TravelCustomer.class);
		customerEdit.editCustomer();
	}

	@Test(priority = 6)
	public void isCustomerAdded() throws Exception {
		TravelCustomer customerEdit = PageFactory.initElements(driver, TravelCustomer.class);
		Assert.assertTrue(customerEdit.searchCustomer("Jabba"));
	}
}