
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class SuiteTestRestAssured {

	@Test
	void peopleEsndPointCodeStatusResponse() {
		Response response = RestAssured.get("https://swapi.dev/api/people");
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	void peopleHeightGreaterThan200() {
		System.out.println("Running Test peopleHeightGreaterThan200()");
		RestAssured.baseURI = "https://swapi.dev/api";
		Response response = null;
		//counter for people greater of 200
		int greaterThan200 = 0;
		//ten pages
		for(int i = 1; i < 10; i++) {
			response = RestAssured.given()
					.when()
					.get("/people/?page=" + i);//change next page
			JsonPath jsonPathValidator = response.jsonPath();

			List< Map<String,String>> results = jsonPathValidator.getList("results"); 
			//iterate and check for height greater than 200
			for(Map<String, String> result : results ) {
				//DEBUG
				//				System.out.print( result.get("name") + ": " );
				//				System.out.println( result.get("height") )
				try {
					if( Integer.parseInt( result.get("height") ) > 200 ) {
						greaterThan200++;
					}
				}catch( Exception e) {
//					System.out.println("Unknown height");
				}
			}
		}
		Assert.assertEquals(greaterThan200, 10);
 
	}
	
	
	@Test
	void peoplesNameWithHeightGreaterThan200() {
		System.out.println("Running Test peoplesNameWithHeightGreaterThan200()");
		RestAssured.baseURI = "https://swapi.dev/api";
		Response response = null;
		List <String> expectedTallPeople = new ArrayList<>();
		expectedTallPeople.add("Darth Vader");
		expectedTallPeople.add("Chewbacca");
		expectedTallPeople.add("Roos Tarpals");
		expectedTallPeople.add("Rugor Nass");
		expectedTallPeople.add("Lama Su");
		expectedTallPeople.add("Taun We");
		expectedTallPeople.add("Grievous");
		expectedTallPeople.add("Tarfful");
		expectedTallPeople.add("Tion Medon");
		//ten pages
		for(int i = 1; i < 10; i++) {
			response = RestAssured.given()
					.when()
					.get("/people/?page=" + i);//change next page
			JsonPath jsonPathValidator = response.jsonPath();

			List< Map<String,String>> results = jsonPathValidator.getList("results"); 
			//iterate and check for height greater than 200
			for(Map<String, String> result : results ) {
				try {
					if( Integer.parseInt( result.get("height") ) > 200 ) {
						expectedTallPeople.remove(result.get("name"));//remove from list if found
					}
				}catch( Exception e) {
//					System.out.println("Unknown height");
				}
			}
		}
		Assert.assertEquals( expectedTallPeople.size(),  0);
 
	}
	
	@Test
	void totalNumberOfPeople() {
		System.out.println("Running Test totalNumberOfPeople()");
		RestAssured.baseURI = "https://swapi.dev/api";
		Response response = null;
		int peopleCounter = 0;
		//ten pages
		for(int i = 1; i < 10; i++) {
			response = RestAssured.given()
					.when()
					.get("/people/?page=" + i);//change next page
			JsonPath jsonPathValidator = response.jsonPath();
			List< Map<String,String>> results = jsonPathValidator.getList("results"); 
			for(Map<String, String> result : results ) {
				peopleCounter++;
			}
		}
		Assert.assertEquals( peopleCounter,  82);
	}
}
