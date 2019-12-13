package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.TravelsCarsExtras;
import pages.TravelsLogIn;
import pages.TravelsMenu;

public class TravelCarsExtrasAddTest extends BasicTest {

	private String baseUrl = "https://www.phptravels.net/admin";

	@BeforeTest
	public void logInForMainTest() throws InterruptedException {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TravelsLogIn trLogIn = PageFactory.initElements(driver, TravelsLogIn.class);
		trLogIn.logIn("admin@phptravels.com", "demoadmin");
		TravelsMenu travelsMenu = PageFactory.initElements(driver, TravelsMenu.class);
		travelsMenu.carExtrasClick();
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void editDetailsInCarExtras() throws InterruptedException {

		TravelsCarsExtras inputExtras = PageFactory.initElements(driver, TravelsCarsExtras.class);
		inputExtras.fillExtras();
	}

	@Test(priority = 2)
	public void isCarAdded() throws Exception {
		TravelsCarsExtras inputExtras = PageFactory.initElements(driver, TravelsCarsExtras.class);
		Assert.assertTrue(inputExtras.searchCar("Fiat Bravo 2010"));
	}
}