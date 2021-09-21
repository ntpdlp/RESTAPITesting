package basic;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.greaterThan;
import static io.restassured.RestAssured.*;

public class methodPOST {
	private String uri = "https://reqres.in/";
	
	@Test
	public void TC_01_post() {
		JSONObject jsonin = new JSONObject();
		jsonin.put("name", "Margie");
		jsonin.put("job", "Project Owner");
		
		baseURI = uri;
		given().body(jsonin.toJSONString())
		.when().post("api/users")
		.then().log().all()
		.statusCode(201);

	}
	
	
	@Test
	public void TC_02_post() {
		JSONObject jsonin = new JSONObject();
		jsonin.put("name", "Margie");
		jsonin.put("job", "Project Owner");
		
		baseURI = uri;
		given().body(jsonin.toJSONString())
		.when().post("api/users")
		.then().log().all()
		.statusCode(201)
		.body("id",greaterThan("0"));

	}
}
