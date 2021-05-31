package restassuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo2_POST_Request {
	
	public static HashMap map=new HashMap();
  @BeforeClass
  public void postdata()
  {
	  map.put("email", RestUtils.getEmail());
	  map.put("firstname", RestUtils.getFirstName());
	  map.put("lastname", RestUtils.getLastName());
	  
	  RestAssured.baseURI="https://reqres.in/api";
	  RestAssured.basePath="/users";
  }
  
  
  
  @Test
  public void testPost()
  {
	  given()
	  .contentType("application/json")
	  .body(map)
	  
	  .when()
	  .post()
	  
	  .then()
	  .statusCode(201);
	  
  }
}
  