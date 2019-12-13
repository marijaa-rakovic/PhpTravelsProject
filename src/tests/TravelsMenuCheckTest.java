package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.TravelsLogIn;
import pages.TravelsMenu;

public class TravelsMenuCheckTest extends BasicTest {

	private String baseUrl = "https://www.phptravels.net/admin";

	@BeforeTest
	public void logInForMainTest() {
		driver.get(baseUrl);
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TravelsLogIn trLogIn = PageFactory.initElements(driver, TravelsLogIn.class);
		trLogIn.logIn("admin@phptravels.com", "demoadmin");
	}

	@Test
	public void checkFunctionality() {
		TravelsMenu travelsMenuCheck = PageFactory.initElements(driver, TravelsMenu.class);
		try {
			travelsMenuCheck.checkAllTheElements();
			travelsMenuCheck.toursAndCarClick();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.navigate().to(baseUrl);
	}
}