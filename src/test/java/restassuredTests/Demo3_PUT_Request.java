package restassuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import io.restassured.RestAssured;

public class Demo3_PUT_Request {
	
	public static HashMap map=new HashMap();
	String regemail=RestUtils.getEmail();
	String regfirst=RestUtils.getFirstName();
	String reglast=RestUtils.getLastName();
	int regid=3;
	
  @BeforeClass
  public void putData() {
	  map.put("email", regemail);
	  map.put("first_name", regfirst);
	  map.put("last_name", reglast);
	  
	  RestAssured.baseURI="https://reqres.in/api";
	  RestAssured.basePath="/users/"+regid;
  }
  
  @Test
  public void testput()
  {
	  given()
	  .contentType("application/json")
	  .body(map)
	  
	  .when()
	  .post()
	  
	  .then()
	 // .statusCode(200)
	  .log().all();//To get the log whether the data is updated correct or not
  }
}
