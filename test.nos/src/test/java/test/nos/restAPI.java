package test.nos;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class restAPI {
	
	@BeforeClass
	public static void setup() {

     RestAssured.baseURI = "https://gorest.co.in";     
	}
	
	@Test
	public void mustListTitle(){
		String token = "50d0ef874afc97ef12ba5fefc02514505b90544de3248e6c93de95b6ca58b32e";

	  RestAssured.given().header("authorization", "bearer " + token)
	    .when()
	      .get("/public/v2/users")
	    .then()
	      .statusCode(200);
	}
	
	@Test
	public void mustRegisterANewCustomer() {
		
		String token = "50d0ef874afc97ef12ba5fefc02514505b90544de3248e6c93de95b6ca58b32e";

	RestAssured.given().header("Authorization", "Bearer " + token)
     .body("{\"name\": \"Teste Nos\", \"gender\": \"male\", \"email\": \"testenos@nos.com\", \"status\": \"active\"}")
          
     .contentType(ContentType.JSON)
        .when()
     .post("/public/v2/users")
        .then()
     .statusCode(201)

     .body("name", Matchers.is("Teste Nos"))
     .body("gender", Matchers.is("male"))
     .body("email", Matchers.is("testenos@nos.com"))     
     .body("status", Matchers.is("active"));
	}
	
	@Test
	public void mustUpdateACustomer() {
		
		String token = "50d0ef874afc97ef12ba5fefc02514505b90544de3248e6c93de95b6ca58b32e";

	RestAssured.given().header("Authorization", "Bearer " + token)
     .body("{\"name\": \"Trilochana Marar\",\"email\": \"marar_trilochana@effertz-jast.biz\",\"status\": \"active\"}")
          		
     .contentType(ContentType.JSON)
        .when()
     .put("/public/v2/users/309559")
        .then()
     .statusCode(200)

     .body("name", Matchers.is("Trilochana Marar"))
     .body("email", Matchers.is("marar_trilochana@effertz-jast.biz"))
     .body("status", Matchers.is("active"));
	}
	
	@Test
	public void mustDeleteACustomer() {
		
		String token = "50d0ef874afc97ef12ba5fefc02514505b90544de3248e6c93de95b6ca58b32e";

	RestAssured.given().header("Authorization", "Bearer " + token)
        		
     .contentType(ContentType.JSON)
        .when()
     .delete("/public/v2/users/305363")
        .then()
     .statusCode(204);
	}
	
}
