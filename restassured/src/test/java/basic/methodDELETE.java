package basic;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class methodDELETE {
	private String uri = "https://reqres.in/";
	
	@Test
	public void TC_01_Delete() {
		baseURI=uri;
		given()
		.when().delete("api/users/2")
		.then().log().all()
		.statusCode(204);
	}
	

}
