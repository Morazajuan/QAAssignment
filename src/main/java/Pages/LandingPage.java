package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends Base {

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		driver.get(url);
	}
	public String navigateToSpendAndSave() {
		//clicks on Spend & Save nav Tab
		driver.findElement(By.xpath(xPathSpendSaveBtn)).click();
		return driver.getTitle();
	}
}
