package beTheHeroAPItesting;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class NegativeTestCases {
	String userid;
	Integer usecaseid1;
	Integer usecaseid2;
	Integer profileUseCaseID1;
	String filePath="C:\\Users\\QQA0431\\eclipse-workspace\\Ra\\src\\test\\resources\\config.properties";
	//String baseUri="http://192.168.3.230:3333";
	
	@BeforeTest
	public void baseUriutility() throws IOException  {
		Properties prop=new Properties();
		FileInputStream fi=new FileInputStream(filePath);
		prop.load(fi);
		String baseUri = prop.getProperty("baseURI2");
		System.out.println(baseUri);
		
		RestAssured.baseURI=baseUri;
		
	}
	
	
	@Test(priority=1)
	public void RegisterRequest() {
		//RestAssured.baseURI="http://192.168.3.230:3333";
		String response =
				given().log().ifValidationFails()
				.headers("Content-Type", "application/json")
				.body(RequestBodyUtilsNegativeCaseDatas.postBody())
		        .when().post("/ongs")
		        .then()
		        .log().ifValidationFails().assertThat()
		        .statusCode(400)
		        .extract().response().asString();
		
	    
		
		
	}
	@Test(priority=2)
	public void RegisterRequestp() {
		//RestAssured.baseURI="http://192.168.3.230:3333";
		String response =
				given().log().ifValidationFails()
				.headers("Content-Type", "application/json")
				.body(RequestBodyUtilsNegativeCaseDatas.postBodyp())
		        .when().post("/ongs")
		        .then()
		        .log().ifValidationFails().assertThat()
		        .statusCode(200)
		        .extract().response().asString();
		userid = JsonPathUtils.jsonPath(response, "id");
		System.out.println(userid);
			
		
	}
	

	@Test(priority=3)
	public void updateDetails() {
		String response = 
				 given()
				.headers("Content-Type","application/json")
				.body(RequestBodyUtilsNegativeCaseDatas.updateBody()).auth().basic("id", userid)
		        .when().put("/ongs/"+userid+"")
		        .then()
		        .assertThat().statusCode(400).extract().response().asString();
		System.out.println(response);
	}
	
	@Test(priority=4)
	public void ApplicationDetails() {
		String response =
				given()
		       .when().get("/ong/"+userid+"")
		       .then()
		       .assertThat()
		       .statusCode(404)
		       .extract().response().asString();
		System.out.println(response);
	}
	
	@Test(priority=5)
	public void registerNewRequest1() {
		String response = 
				given()
				.headers("Content-Type", "application/json")
				.body(RequestBodyUtilsNegativeCaseDatas.registernewBody1())
				.headers("authorization",userid)
		        .when().post("/incidents")
		        .then()
		        .assertThat().statusCode(400).extract().response().asString();
		    //  usecaseid1 = JsonPathUtils.jsonPathUseCase(response, "id");
		 //System.out.println(usecaseid1);
		
	  
		
		
	}
	
	@Test(priority=6)
	public void registerNewRequest2() {
		String response = 
				given()
				.headers("Content-Type", "application/json")
				.body(RequestBodyUtilsNegativeCaseDatas.registernewBody2())
				.headers("authorization",userid)
		        .when().post("/incidents")
		        .then()
		        .assertThat().statusCode(400).extract().response().asString();
		
	}
	@Test(priority=7)
	public void profileDetails() {
		//get=post
		String response = 
				given()
				.headers("authorization",userid)
		        .when().post("/profile")
		        .then()
		        .log().all().assertThat()
		        .statusCode(400).extract()
		        .response().asString();
		System.out.println(response);
		
		
		
	
	}
	@Test(priority=8)
	public void deleteUseCase() {
		//incidents=incident
		 Response response=given().log().all().headers("authorization","123")
        .when().delete("/incident/"+""+usecaseid1+"").then().assertThat().statusCode(400).extract().response();
		Assert.assertEquals(response.statusCode(),404);
	} 
	

}
