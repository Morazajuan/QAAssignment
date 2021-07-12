package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPage extends Base {

	public LandingPage(WebDriver driver) {
		driver = new ChromeDriver(this.options);
		driver.get(url);
		this.driver = driver;

	}
	public String navigateToSpendAndSave() {
		//clicks on Spend & Save nav Tab
		driver.findElement(By.xpath(xPathSpendSaveBtn)).click();
		return driver.getTitle();
	}
	public void quitDriver() {
		this.driver.quit();
	}
}
