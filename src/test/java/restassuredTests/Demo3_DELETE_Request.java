package restassuredTests;

import org.apache.http.StatusLine;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo3_DELETE_Request {

	@Test
	public void Delete()
	{
		RestAssured.baseURI="https://reqres.in/api";
		 RestAssured.basePath="/users/2";
		 
		 
		 //If you want to store all the responses into the single variable(i.e, response)
		 //we need to call .extract().response(); at the end 
		 //Note the response will be stored in a json format
		 //It will used to verify the json body
		 Response response=
		 given()
		 .when()
		 	.delete()
		 .then()
		 	.statusCode(200)
		 	.statusLine("HTTP/1.1 200 OK")
		 .log().all()
		 .extract().response();
		//Contains the complte json string as it converted from response
		 String jsonAsString=response.asString();
		 Assert.assertEquals(jsonAsString.contains("SuccessfullyDeletedMessage"), true);

	}
}
