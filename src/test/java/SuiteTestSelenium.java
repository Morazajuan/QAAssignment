import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LandingPage;
import Pages.SpendAndSave;

public class SuiteTestSelenium {

	public WebDriver driver;
	public ChromeOptions options;

	SuiteTestSelenium(){
		System.setProperty("webdriver.chrome.driver",
				"src/main/resources/drivers/chromedriver.exe");//chrome driver (91.0.4), located in resource folder
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
	}
	
	@Test
	public void testLandingPage() {
		driver = new ChromeDriver(options);

		LandingPage landingpage = new LandingPage( driver );

		String originalTitle = landingpage.navigateToSpendAndSave();
		String expectedTitle = "Cash Management Services - Investing & Retirement Planning | Aspiration";

		Assert.assertEquals(originalTitle, expectedTitle);

		driver.quit();

	}

	@Test
	public void verifyNumCards() {
		//create driver object for Chrome 
		driver = new ChromeDriver(options);

		SpendAndSave spendAndSavePage = new SpendAndSave( driver );

		int originalnumOfCards = spendAndSavePage.numOfCardsAvaiable();
		int excpectednumOfCards = 2;

		//num of Cards
		Assert.assertEquals(originalnumOfCards, excpectednumOfCards);
		driver.quit();

	}

	@Test
	public void verifyCardNames() {
		driver = new ChromeDriver(options);

		SpendAndSave spendAndSavePage = new SpendAndSave( driver );

		List<WebElement> plans  = spendAndSavePage.returnPlans();

		//num of Cards
		Assert.assertEquals( spendAndSavePage.getPlanTitle(plans.get(0)), "Aspiration");
		Assert.assertEquals( spendAndSavePage.getPlanTitle(plans.get(1)), "Aspiration Plus");
		driver.quit();

	}
	
	@Test
	public void verifyCardprices() {
		driver = new ChromeDriver(options);

		SpendAndSave spendAndSavePage = new SpendAndSave( driver );

		List<WebElement> plans  = spendAndSavePage.returnPlans();

		Assert.assertEquals( spendAndSavePage.getPlanPrice(plans.get(0)), "Pay What Is Fair(even if it's $0)");
		Assert.assertEquals( spendAndSavePage.getPlanPrice(plans.get(1)), "$5.99/mo.(billed annually)");
		driver.quit();

	}
	
	
	@Test
	public void aspirationModalAppeared() {
		driver = new ChromeDriver(options);

		SpendAndSave spendAndSavePage = new SpendAndSave( driver );

		List<WebElement> plans  = spendAndSavePage.returnPlans();

		Assert.assertEquals( spendAndSavePage.modalAppear(plans.get(0)) , true );
 		driver.quit();

	}
	@Test
	public void aspirationModalEmailInputAppeared() {
		driver = new ChromeDriver(options);

		SpendAndSave spendAndSavePage = new SpendAndSave( driver );

		List<WebElement> plans  = spendAndSavePage.returnPlans();

		Assert.assertEquals( spendAndSavePage.emailFieldAppear(plans.get(0)) , true );
 		driver.quit();

	}
	
	@Test
	public void aspirationPlusModalAppeared() {
		driver = new ChromeDriver(options);

		SpendAndSave spendAndSavePage = new SpendAndSave( driver );

		List<WebElement> plans  = spendAndSavePage.returnPlans();

		Assert.assertEquals( spendAndSavePage.modalAppear(plans.get(1)) , true );
 		driver.quit();

	}
	@Test
	public void aspirationPlusModalRadioOptions() {
		driver = new ChromeDriver(options);

		SpendAndSave spendAndSavePage = new SpendAndSave( driver );

		//gets plans from cards
		List<WebElement> plans  = spendAndSavePage.returnPlans();
		//get options from Plus card
		List<WebElement> radioOptions  = spendAndSavePage.radioOptionsAppeared(plans.get(1));

		//get price description from each option 
		String annualRadioOption = spendAndSavePage.getRadioOptionText(radioOptions.get(0));
		String monthlyRadioOption = spendAndSavePage.getRadioOptionText(radioOptions.get(1));
		
 		Assert.assertEquals( annualRadioOption  , "$71.88 paid once yearly" );
		Assert.assertEquals( monthlyRadioOption  , "$7.99 paid monthly" );
 		driver.quit();

	}

}
