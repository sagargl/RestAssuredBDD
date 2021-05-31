package restassuredTests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

/*
	 * 1) Test Status code
	 * 2) Log Response
	 * 3) Verify Single Content in Response Body
	 * 4) Verifying Multiple Contents in Response Body
	 * 5) Setting Paramaters and Headers
	 */
public class Demo5_BasicValidations_JSONResponse {

	//1) Test status code
	@Test(priority=1)
	public void teststatuscode()
	{
		//Given-Spedify the prequisties
		//When-Specify the requests
		//Then-Specify the validations
		
		given()
		
		.when()
			.get("http://jsonplaceholdeer.typicode.com/posts/5")
		
		.then()
			.statusCode(200);//Test status code
		}
	
	
	//2) Log Response
	@Test(priority=2)
	public void testLogging()
	{
		given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		
		.then()
			.statusCode(200)//Test status code
			.log().all();//Log Response-Gets all the response and prints in the console window
	}
	
	//3) Verifying Multiple Content in Response Body
		@Test(priority=3)
		public void testSingleContent()
		{
			given()
			
			.when()
				.get("http://services.groupkt.com/country/get/iso2code/IN")
				
			.then()
				.statusCode(200)
				.body("RestResponse.result.name", equalTo("India"));
		}
		
	
	//4) Verifying Multiple Content in Response Body
	@Test(priority=4)
	public void testMulitple()
	{
		given()
		
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
			
		.then()
			.statusCode(200)
			.body("RestResponse.result.name", hasItems("India","Australia"));
	}
	
	//5) Setting Paramaters and Headers
	@Test(priority=5)
	public void testParamatersandHeaders()
	{
		given()
			.param("MyName", "Sagar")
			.header("MyHeader","Indian")
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
			
		.then()
			.statusCode(200)
			.body("RestResponse.result.name", hasItems("India","Australia"));

	}
}
