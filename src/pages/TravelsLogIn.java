package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TravelsLogIn extends BasicPage {

	public TravelsLogIn(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "email")
	WebElement emailAdress;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(how = How.CLASS_NAME, using = "checkbox")
	WebElement rememberMe;

	@FindBy(id = "link-forgot")
	WebElement forgetPassword;

	@FindBy(how = How.CLASS_NAME, using = "ladda-label")
	WebElement logInBtn;

	public void logIn(String email, String pass) {
		emailAdress.sendKeys(email);
		password.sendKeys(pass);
		// logInBtn.click();
		password.sendKeys(Keys.ENTER);
	}
}