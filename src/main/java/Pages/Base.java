package Pages;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {
	public WebDriver driver;
	//Variables 
	String url = "https://www.aspiration.com/";
	String xPathSpendSaveBtn = "//*[@id=\"__next\"]/div/header/ul[1]/li[1]/a";
	String cardClassName = "plan";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

				//create driver object for Chrome 
				System.setProperty("webdriver.chrome.driver",
						"src/test/resources/drivers/chromedriver.exe");//chrome driver (91.0.4), located in resource folder
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				WebDriver driver = new ChromeDriver(options);
				
	}


}