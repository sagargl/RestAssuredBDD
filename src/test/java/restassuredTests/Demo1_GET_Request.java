
package restassuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.apache.http.StatusLine;

/*
 * 
 * Given: All the prequisties used in Given Section
-->Set cookies, add auth, add parameters, set header information etc.....

When: All kinds of requests will comes under When Section
-->Get, Post, Put, Delete.....

Then: All the validations will be captured under Then Section
--> Validate Status code, Extract Response messages from API, Extract Headers, Cookies, Response body....

 * 
 */

public class Demo1_GET_Request {
	@Test
	public void getUserDetails()
	{
		given()
		.when()
				.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.assertThat().body("first_name", equalTo("Janet"))
		.header("Content-Type","application/json");
	}

}
