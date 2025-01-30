package demo1;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PostTest {

	@Test
	public void test1() {
		String Root_URI = "https://petstore.swagger.io/v2";
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body("{\r\n"
					+ "  \"id\": 0,\r\n"
					+ "  \"category\": {\r\n"
					+ "    \"id\": 0,\r\n"
					+ "    \"name\": \"string\"\r\n"
					+ "  },\r\n"
					+ "  \"name\": \"doggie\",\r\n"
					+ "  \"photoUrls\": [\r\n"
					+ "    \"string\"\r\n"
					+ "  ],\r\n"
					+ "  \"tags\": [\r\n"
					+ "    {\r\n"
					+ "      \"id\": 0,\r\n"
					+ "      \"name\": \"string\"\r\n"
					+ "    }\r\n"
					+ "  ],\r\n"
					+ "  \"status\": \"available\"\r\n"
					+ "}")
		.when()
			.post(Root_URI+"/pet")
		.then()
			.statusCode(200)
			.log().all();
	}
}
