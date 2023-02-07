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
     //String token = "50d0ef874afc97ef12ba5fefc02514505b90544de3248e6c93de95b6ca58b32e";
     
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

	RestAssured.given()
	 .header("authorization", "bearer " + token)
	 .header("Content-type", "application/json; charset=UTF-8")
     .body("{\"name\": \"Teste NOS\", \"gender\": \"male\", \"email\": \"teste.nos@nos.com\", \"staus\": \"active\"}")
          
     .contentType(ContentType.JSON)
        .when()
     .post("/public/v2/users")
        .then()
     .statusCode(201)

     .body("name", Matchers.is("Teste NOS"))
     .body("gender", Matchers.is("male"))
     .body("email", Matchers.is("teste.nos@nos.com.pt"))     
     .body("status", Matchers.is("active"));
	}
	
	@Test
	public void mustUpdateACustomer() {
		
		String token = "50d0ef874afc97ef12ba5fefc02514505b90544de3248e6c93de95b6ca58b32e";

	RestAssured.given().header("authorization", "bearer " + token)
     .body("{\"name\": \"Deepan Kaur\",\"email\": \"deepan_kaur@oconnell.biz\",\"staus\": \"active\"}")
          		
     .contentType(ContentType.JSON)
        .when()
     .put("/public/v2/users/308793")
        .then()
     .statusCode(200)

     .body("name", Matchers.is("Deepan Kaur"))
     .body("email", Matchers.is("deepan_kaur@oconnell.biz"))
     .body("status", Matchers.is("active"));
	}
	
	@Test
	public void mustDeleteACustomer() {
		
		String token = "50d0ef874afc97ef12ba5fefc02514505b90544de3248e6c93de95b6ca58b32e";

	RestAssured.given().header("authorization", "bearer " + token)
        		
     .contentType(ContentType.JSON)
        .when()
     .delete("/public/v2/users/305363")
        .then()
     .statusCode(204);
	}
	
}
