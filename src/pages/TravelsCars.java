package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.text.ParseException;

public class TravelsCars extends BasicPage {

	public TravelsCars(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CLASS_NAME, using = "xcrud-row")
	List<WebElement> carList;

	@FindBy(how = How.CSS, using = ".form-control.input-sm")
	List<WebElement> inputOrder;

	public int carListCount() {
		return carList.size();
	}

	public boolean findTen() {
		boolean found = false;
		for (int i = 1; i < carList.size(); i++) {
			String s = "//*[@id=\"content\"]/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[" + (i + 1) + "]/td[5]";
			String text = driver.findElement(By.xpath(s)).getText();
			if (text.contains("10")) {
				found = true;
			}
		}
		return found;
	}

	public int countOrders() throws ParseException {
		int order = 0;
		for (int i = 0; i < inputOrder.size(); i++) {
			WebElement element = inputOrder.get(i);
			String numOrder = element.getAttribute("value");
			order += Integer.parseInt(numOrder);
		}
		return order;
	}
}