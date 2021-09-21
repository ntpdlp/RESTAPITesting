package basic;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.greaterThan;
import static io.restassured.RestAssured.*;

public class methodPUT {
	private String uri = "https://reqres.in/";
	
	@Test
	public void TC_01_put() {
		JSONObject jsonin = new JSONObject();
		jsonin.put("name", "Margie");
		jsonin.put("job", "Project Owner");
		
		baseURI = uri;
		given().body(jsonin.toJSONString())
		.when().put("api/users/2")
		.then().log().all()
		.statusCode(200);

		System.out.println("PUT update entirely <> PATCH update partially");
	}
	
	
	
}
