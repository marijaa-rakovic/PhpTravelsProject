package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.TravelsLogIn;
import utils.UsingExcelFiles;

public class TravelsLogInUsingApachePoi extends BasicTest {

	private String baseUrl = "https://www.phptravels.net/admin";

	@Test
	public void logInTest() throws Exception {

		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TravelsLogIn trLogIn = PageFactory.initElements(driver, TravelsLogIn.class);

		UsingExcelFiles useExcelClass = new UsingExcelFiles();
		useExcelClass.setUsernameAndPassword();

		trLogIn.logIn(useExcelClass.getUsername(), useExcelClass.getPassword());
	}
}