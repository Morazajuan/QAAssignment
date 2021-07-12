package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpendAndSave extends Base {

	public SpendAndSave(WebDriver driver){
		driver = new ChromeDriver(this.options);
		driver.get( "https://www.aspiration.com/our-products/" );
		this.driver = driver;
	}
	public int numOfCardsAvaiable() {
		return driver.findElements(By.className(cardClassName)).size();
	}
	public String getPlanTitle(WebElement plan) {
		return plan.findElement( By.tagName("h2") ).getText();
	}
	public String getPlanPrice(WebElement plan) {
		return plan.findElement( By.tagName("h3") ).getText();
	}
	public List<WebElement> returnPlans () {
		return  driver.findElements( By.className( cardClassName ) );
	}
	public boolean modalAppear (WebElement plan) {
		plan.findElement( By.className( "btn" ) ).click();
		return  ( driver.findElement( By.className( "modal" ) ) != null );
	}
	public boolean emailFieldAppear (WebElement plan) {
		plan.findElement( By.className( "btn" ) ).click();
		return  ( driver.findElement( By.name( "email" ) ) != null );
	}
	public List<WebElement> radioOptionsAppeared(WebElement plan) {
		plan.findElement( By.className( "btn" ) ).click();
		return   driver.findElements( By.className( "option" ) );
	}
	public String getRadioOptionText (WebElement option) {
		return option.findElement( By.tagName( "p" ) ).getText();
	}
	public void quitDriver() {
		this.driver.quit();
	}

}
