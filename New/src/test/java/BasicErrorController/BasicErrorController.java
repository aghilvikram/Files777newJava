package BasicErrorController;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class BasicErrorController {
	@Test
	public void errorPatchtRequest() {
		RestAssured.baseURI = "http://13.234.202.14:8088";
		Response response = given().log().all().when().options("/error").then().assertThat().statusCode(200).extract().response();
		//System.out.println("response: "+response);
		Headers headers = response.getHeaders();
		System.out.println(headers);
	}

	@Test
	public void errorPostRequest() {
		RestAssured.baseURI = "http://13.234.202.14:8088";
		Response response = given().log().all().headers("accept","*/*").body("").when().post("/error").then().assertThat().statusCode(201).extract().response();
		//System.out.println("response: "+response);
		Headers headers = response.getHeaders();
		System.out.println(headers);
	}
	
	
	
	@Test
	public void errorgetRequest() {
		RestAssured.baseURI = "http://13.234.202.14:8088";
		Response response = given().log().all().headers("accept","*/*").when().get("/error").then().assertThat().statusCode(200).extract().response();
		//System.out.println("response: "+response);
		Headers headers = response.getHeaders();
		System.out.println(headers);
	}
	@Test
	public void errorputRequest() {
		RestAssured.baseURI = "http://13.234.202.14:8088";
		Response response = given().log().all().headers("accept","*/*").when().put("/error").then().assertThat().statusCode(200).extract().response();
		//System.out.println("response: "+response);
		Headers headers = response.getHeaders();
		System.out.println(headers);}
	@Test
	public void errorheadRequest() {
		RestAssured.baseURI = "http://13.234.202.14:8088";
		Response response = given().log().all().headers("accept","*/*").when().head("/error").then().assertThat().statusCode(200).extract().response();
		//System.out.println("response: "+response);
		Headers headers = response.getHeaders();
		System.out.println(headers);}
}
