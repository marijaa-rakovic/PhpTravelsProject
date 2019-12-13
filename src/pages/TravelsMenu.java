package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TravelsMenu extends BasicPage {

	public TravelsMenu(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js;

	@FindBy(how = How.LINK_TEXT, using = "DASHBOARD")
	WebElement dashBoard;

	@FindBy(how = How.XPATH, using = "//ul[@id='social-sidebar-menu']//a[@href='https://www.phptravels.net/admin/updates/']/span[.='Updates']")
	WebElement upDates;

	@FindBy(how = How.LINK_TEXT, using = "MODULES")
	WebElement modules;

	@FindBy(how = How.LINK_TEXT, using = "TOURS")
	WebElement tours;

	@FindBy(how = How.LINK_TEXT, using = "COUPONS")
	WebElement coupons;

	@FindBy(how = How.LINK_TEXT, using = "NEWSLETTER")
	WebElement newsLetter;

	@FindBy(how = How.LINK_TEXT, using = "BOOKINGS")
	WebElement bookings;

	@FindBy(how = How.LINK_TEXT, using = "ADD NEW")
	WebElement addNew;

	@FindBy(how = How.LINK_TEXT, using = "CARS")
	WebElement cars;

	@FindBy(how = How.CSS, using = "ul#Cars > li")
	WebElement carsInCarDashBoard;

	@FindBy(how = How.CSS, using = "ul#Cars > li:nth-of-type(2) > a")
	WebElement carExtras;

	@FindBy(how = How.CSS, using = "ul#social-sidebar-menu > li:nth-of-type(5) > a")
	WebElement accounts;

	@FindBy(how = How.LINK_TEXT, using = "CUSTOMERS")
	WebElement customerInAccountsMenu;

	public void removePopUp() {
		if (driver instanceof JavascriptExecutor) {
			js = (JavascriptExecutor) driver;
		}
		js.executeScript("return document.getElementsByTagName('iframe')[0].remove();");
	}

	public void checkAllTheElements() throws InterruptedException {
		Thread.sleep(4000);
		removePopUp(); // remove Pop-Up
		dashBoard.click();
		Thread.sleep(3000);

		removePopUp();
		upDates.click();
		Thread.sleep(3000);
		driver.navigate().back();

		removePopUp();
		modules.click();
		Thread.sleep(3000);
		driver.navigate().back();

		removePopUp();
		coupons.click();
		Thread.sleep(3000);
		driver.navigate().back();

		removePopUp();
		newsLetter.click();
		Thread.sleep(3000);
		driver.navigate().back();

		removePopUp();
		bookings.click();
		Thread.sleep(3000);
		driver.navigate().back();
	}

	public void toursAndCarClick() throws InterruptedException {
		tours.click();
		addNew.click();
		driver.navigate().back();

		Thread.sleep(5000);
		cars.click();
		carsInCarDashBoard.click();
	}

	public void carMenuClick() {
		cars.click();
		carsInCarDashBoard.click();
	}

	public void carExtrasClick() {
		cars.click();
		carExtras.click();
	}

	public void customersClick() {
		accounts.click();
		customerInAccountsMenu.click();
	}
}