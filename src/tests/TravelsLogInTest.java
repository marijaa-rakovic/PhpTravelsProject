package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.TravelsLogIn;

public class TravelsLogInTest extends BasicTest {

	private String baseUrl = "https://www.phptravels.net/admin";

	@Test
	public void logInTest() {

		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TravelsLogIn trLogIn = PageFactory.initElements(driver, TravelsLogIn.class);

		trLogIn.logIn("admin@phptravels.com", "demoadmin");

	}

}
