package beTheHeroAPItesting;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class BetheHero {
	String userid;
	Integer usecaseid1;
	Integer usecaseid2;
	Integer profileUseCaseID1;
	//String filePath="/Ra/config.properties";
	//String baseUri="http://192.168.3.230:3333";
	/*
	@BeforeTest
	public void baseUriutility()  {
		/*Properties prop=new Properties();
		FileInputStream fi=new FileInputStream(filePath);
		prop.load(fi);
		String baseUri = prop.getProperty("baseURI");
		System.out.println(baseUri);*/
		
	//	RestAssured.baseURI="http://192.168.3.230:3333";
		
	//}
	
	
	@Test(priority=1,dataProvider="PostData", dataProviderClass=DataProviderClass.class)
	public void RegisterRequest(String name,String email, String whatsapp, String city, String uf) {
		RestAssured.baseURI="http://192.168.3.230:3333";
		String response =
				given().log().ifValidationFails()
				.headers("Content-Type", "application/json")
				.body(RequestBodyUtils.postBodyFromDP(name, email, whatsapp, city, uf))
		        .when().post("/ongs")
		        .then()
		        .log().ifValidationFails().assertThat()
		        .statusCode(200)
		        .extract().response().asString();
		
	     userid = JsonPathUtils.jsonPath(response, "id");
		System.out.println(userid);
		
		
	}
	/*
	@Test(priority=2)
	public void sessions() {
		String name = given().log().all().body(RequestBodyUtils.login(id)).when().post("/sessions").then().log().all().assertThat()
        .statusCode(200)
        .extract().response().asString();
		System.out.println(name);
	}
	
	
	
	@Test(priority=3, dataProvider="updateData",dataProviderClass=DataProviderClass.class)
	public void updateDetails(String name,String email, String whatsapp, String city, String uf) {
		String response = 
				 given()
				.headers("Content-Type","application/json")
				.body(RequestBodyUtils.updateBodyFromDP(name, email, whatsapp, city, uf)).auth().basic("id", userid)
		        .when().put("/ongs/"+userid+"")
		        .then()
		        .assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
	}
	
	@Test(priority=4)
	public void ApplicationDetails() {
		String response =
				given()
		       .when().get("/ongs/"+userid+"")
		       .then()
		       .assertThat()
		       .statusCode(200)
		       .extract().response().asString();
		System.out.println(response);
	}
	
	@Test(priority=5, dataProvider="postCaseData", dataProviderClass=DataProviderClass.class)
	public void registerNewRequest1(String title, String description, String value) {
		String response = 
				given()
				.headers("Content-Type", "application/json")
				.body(RequestBodyUtils.registernewBodyFromDP(title, description, value))
				.headers("authorization",userid)
		        .when().post("/incidents")
		        .then()
		        .assertThat().statusCode(200).extract().response().asString();
		      usecaseid1 = JsonPathUtils.jsonPathUseCase(response, "id");
		 System.out.println(usecaseid1);
		
	  
		
		
	}
	@Test(priority=6, dataProvider="updateCaseData",dataProviderClass=DataProviderClass.class)
	public void registerNewRequest2(String title, String description, String value) {
		String response = 
				given()
				.headers("Content-Type", "application/json")
				.body(RequestBodyUtils.registernewBodyFromDP(title, description, value))
				.headers("authorization",userid)
		        .when().post("/incidents")
		        .then()
		        .assertThat().statusCode(200).extract().response().asString();
		  usecaseid2 = JsonPathUtils.jsonPathUseCase(response, "id");
		 System.out.println(usecaseid2);
	}
	@Test(priority=7)
	public void profileDetails() {
		String response = 
				given()
				.headers("authorization",userid)
		        .when().get("/profile")
		        .then()
		        .log().all().assertThat()
		        .statusCode(200).extract()
		        .response().asString();
		System.out.println(response);
		// int profileUseCaseID1 = JsonPathUtils.profileJsonPath(response, 0, "id");
		//System.out.println(profileUseCaseID);
		JsonPath jp=new JsonPath(response);
		 profileUseCaseID1 = jp.getInt("id[0]");
		System.out.println(profileUseCaseID1);
		
		
		Assert.assertEquals(usecaseid1, profileUseCaseID1);
	}
	@Test(priority=8)
	public void deleteUseCase() {
		given().log().all().headers("authorization",userid)
        .when().delete("/incidents/"+""+usecaseid1+"").then().assertThat().statusCode(204);
	}*/
	
}
