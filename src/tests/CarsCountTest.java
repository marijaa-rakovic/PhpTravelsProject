package tests;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.TravelsCars;
import pages.TravelsLogIn;
import pages.TravelsMenu;

public class CarsCountTest extends BasicTest {

	private String baseUrl = "https://www.phptravels.net/admin";

	@BeforeTest
	public void logInForMainTest() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TravelsLogIn trLogIn = PageFactory.initElements(driver, TravelsLogIn.class);
		trLogIn.logIn("admin@phptravels.com", "demoadmin");

		TravelsMenu travelsMenuCheck = PageFactory.initElements(driver, TravelsMenu.class);
		travelsMenuCheck.carMenuClick();
	}

	@Test(priority = 2)
	public void countCars() throws ParseException {
		TravelsCars tc = PageFactory.initElements(driver, TravelsCars.class);
		tc.carListCount();
		System.out.println("Broja auta u tabeli >Cars< je: " + tc.carListCount());
		Assert.assertTrue(tc.findTen());
		System.out.println("Da li je broj modela koji rentiramo jednak 10? Answer is: " + tc.findTen());
	}

	@Test(priority = 3)
	public void countTotalOrders() throws ParseException {
		TravelsCars tc = PageFactory.initElements(driver, TravelsCars.class);
		boolean bb = tc.countOrders() < 50 ? true : false;
		Assert.assertTrue(bb);
		System.out.println(
				"Ukupni broj porudzbina je: " + tc.countOrders() + ", odnosno, ukupan broj narudbina je manji od 50 ");
	}
}