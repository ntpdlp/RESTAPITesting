package basic;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class methodGET {
	private String uri = "https://reqres.in/";
	
	@Test
	public void TC_01_GetSingleRecord() {
		baseURI=uri;
		given()
		.when().get("api/users/2")
		.then().log().all()
		.statusCode(200);
	}
	
	// https://reqres.in/api/users?page=2
	@Test
	public void TC_02_GetListUsers() {
		baseURI=uri;
		given().queryParam("page", 2)
		.when().get("api/users")
		.then().log().all()
		.statusCode(200)
		.body("page",equalTo(2))
		.body("data.first_name",hasItems("Michael","Lindsay","Tobias"));
	}
	
	@Test
	public void TC_03_GetUsers() {
		baseURI=uri;
		Response response = given().queryParam("page", 2)
		.when().get("api/users")
		.then()
		.statusCode(200)
		.extract().response();
		
		JsonPath json = response.jsonPath();
		List<String> firstNames =  json.get("data.first_name");
		for(String s:firstNames) {
			System.out.println(s);
		}
	}
}
