package pages;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelsCarsExtras extends BasicPage {

	public TravelsCarsExtras(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[2]/div[2]/div/div/div[1]/div[1]/a[1]/i")
	WebElement addBtnExtras;

	@FindBy(how = How.CSS, using = "a[data-task='save']")
	WebElement saveAndReturn;

	@FindBy(how = How.CSS, using = "input[name='xcrud-attach']")
	WebElement inputImage;

	@FindBy(how = How.CSS, using = "input.xcrud-input.form-control")
	WebElement inputName;

	@FindBy(how = How.CSS, using = "select.xcrud-input.form-control")
	WebElement checkStatus;

	@FindBy(how = How.CSS, using = "input[name='cHRfZXh0cmFzLmV4dHJhc19iYXNpY19wcmljZQ--']")
	WebElement inputPrice;

	@FindBy(how = How.CSS, using = ".xcrud-search-toggle.btn.btn-default")
	WebElement searchButton;

	@FindBy(how = How.CSS, using = "input[name='phrase']")
	WebElement searchField;

	@FindBy(how = How.CSS, using = "[data-search='1']")
	WebElement goButton;

	@FindBy(how = How.CSS, using = ".xcrud-row.xcrud-row-0 > td:nth-of-type(4)")
	WebElement nameInTable;

	public WebElement visibilityOfElementLocated(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void fillExtras() throws InterruptedException {
		addBtnExtras.click();
		Thread.sleep(3000);
		inputImage.sendKeys(new File("images\\fiat.jpg").getAbsolutePath());

		Thread.sleep(10000);

		inputName.sendKeys("Fiat Bravo 2010");
		Select statusExtras = new Select(checkStatus);
		statusExtras.selectByVisibleText("Yes");
		inputPrice.sendKeys("4500");
		removePopUp();
		Thread.sleep(3000);
		saveAndReturn.click();
	}

	public boolean searchCar(String carName) throws Exception {
		Thread.sleep(5000);
		searchButton.click();
		searchField.sendKeys(carName);
		goButton.click();
		System.out.println(nameInTable.getText());
		return nameInTable.getText().contains(carName);
	}

	public void removePopUp() {
		if (driver instanceof JavascriptExecutor) {
			js = (JavascriptExecutor) driver;
		}
		js.executeScript("return document.getElementsByTagName('iframe')[0].remove();");
	}
}