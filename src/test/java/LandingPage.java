import java.util.List;
import SelleniumProject.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LandingPage  {

	Base base;
	LandingPage() {

		//Variables 
		String url = "https://www.aspiration.com/";
		String xPathSpendSaveBtn = "//*[@id=\"__next\"]/div/header/ul[1]/li[1]/a";
		String cardClassName = "plan";

		//checks landing page
		driver.get(url);
		//clicks on Spend & Save nav Tab
		driver.findElement(By.xpath(xPathSpendSaveBtn)).click();
		//Counts the number of Cards avaible
		System.out.println("Number of cards: "+driver.findElements(By.className(cardClassName)).size());

		//plans store in List
		List<WebElement>  plans = driver.findElements( By.className( cardClassName ) );
		//will iterate through both elements
		for( WebElement  plan : plans ) {
			//get name of plan
			System.out.println("Card title: "+ plan.findElement( By.tagName("h2") ).getText() );

			//check price description
			System.out.println("Price description: "+ plan.findElement( By.tagName("h3") ).getText() );

		}

		//click "Get Aspiration" button from first plan (first element from plans)
		plans.get(0).findElement( By.className( "btn" ) ).click();

		//Checking for modal appearance
		if( driver.findElement( By.className( "modal" ) ) != null ) {
			System.out.println("Sign Up popup shown!");

		}else {
			System.out.println("Sign Up popup not shown");
		}

		//close popup
		driver.findElement( By.className( "close" ) ).click();


		//click "Get Aspiration Plus" button from first plan (second element from plans)
		plans.get(1).findElement( By.className( "btn" ) ).click();

		// 		//wait for option-text to load
		// 		WebDriverWait wait = new WebDriverWait(driver, 20);
		// 		wait.until(ExpectedConditions.elementToBeClickable( By.className( "option" )));


		//store ratio options elements from Aspirtation Plus popup
		List<WebElement>  radioOptions = driver.findElements( By.className( "option" ) );

		//get text from first radio opiton

		//Yearly option
		String radioOption = radioOptions.get(0).findElement( By.tagName( "p" ) ).getText();
		if( radioOption.equals("$71.88 paid once yearly") ) {
			System.out.println( "Text Match" );
		}else {
			System.out.println("Text Does NOT Match");
		}
		System.out.println(radioOption);


		//monthly option
		radioOption = radioOptions.get(1).findElement( By.tagName( "p" ) ).getText();
		if( radioOption.equals("$7.99 paid monthly") ) {
			System.out.println( "Text Match" );
		}else {
			System.out.println("Text Does NOT Match");
		}
		System.out.println(radioOption);

	}
}
