package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class TravelCustomer extends BasicPage {

	public TravelCustomer(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "button[type='submit']")
	WebElement addBtn;

	@FindBy(how = How.CSS, using = "input[name='fname']")
	WebElement firstName;

	@FindBy(how = How.CSS, using = "input[name='lname']")
	WebElement lastName;

	@FindBy(how = How.CSS, using = "input[name='email']")
	WebElement email;

	@FindBy(how = How.CSS, using = "input[name='mobile']")
	WebElement mobileNumber;

	@FindBy(how = How.CSS, using = "select.chosen-select.select2-offscreen")
	WebElement country;

	@FindBy(how = How.CSS, using = "input[name='address1']")
	WebElement adressOne;

	@FindBy(how = How.CSS, using = "select[name='status']")
	WebElement status;

	@FindBy(how = How.CSS, using = "[type='password']")
	WebElement password;

	@FindBy(how = How.CSS, using = ".panel-body strong")
	WebElement emailNewsLetterCheck;

	@FindBy(how = How.CSS, using = ".panel-footer.btn-primary")
	WebElement submitBtn;

	@FindBy(how = How.CSS, using = ".btn.btn-default.xcrud-search-toggle")
	WebElement searchBtn;

	@FindBy(how = How.CSS, using = ".form-inline.xcrud-search > input[name='phrase']")
	WebElement searchFld;

	@FindBy(how = How.CSS, using = ".xcrud-row.xcrud-row-0 > td:nth-of-type(3)")
	WebElement nameInTable;

	public void editCustomer() throws InterruptedException {
		addBtn.click();
		Thread.sleep(3000);
		firstName.clear();
		lastName.clear();
		email.clear();
		mobileNumber.clear();
		adressOne.clear();
		Thread.sleep(3000);

		firstName.sendKeys("Jabba");
		lastName.sendKeys("Hutt");
		email.sendKeys("TheHat@space.com");
		password.sendKeys("123df466");
		mobileNumber.sendKeys("5555333");

		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText("Mexico");

		adressOne.sendKeys("Tatooine");
		Select selectStatus = new Select(status);
		// selectStatus.getFirstSelectedOption().click();
		selectStatus.selectByVisibleText("Enabled");

		emailNewsLetterCheck.click();
		adressOne.sendKeys(Keys.ENTER);
	}

	public boolean searchCustomer(String customerName) throws InterruptedException {
		Thread.sleep(10000);
		searchBtn.click();
		searchFld.sendKeys(customerName);
		searchFld.sendKeys(Keys.ENTER);
		System.out.println(nameInTable.getText());
		return nameInTable.getText().contains(customerName);
	}

}