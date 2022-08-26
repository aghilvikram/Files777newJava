package userController;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import UserControllerUtilities.JsonPathUtils;
import UserControllerUtilities.UserControllerRequestBodyUtils;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserControllerCRUDRequests {
	private String userid;

	@BeforeTest
	public void utilities() {
		RestAssured.baseURI = "http://13.234.202.14:8088";
	}

	

	@Test(dataProvider = "PostData", dataProviderClass = DataProviderClass.class, priority = 1)
	public void postNewUser(String emailAddress, String firstName, String lastName, String userId)
			throws JsonMappingException, JsonProcessingException {
		String responsePost = 
			given()
				.log().all()
				.headers("Content-Type", "application/json")
				.body(UserControllerRequestBodyUtils.requestBody(emailAddress, firstName, lastName, userId))
			.when()
				.post("api/users")
			.then()
				.log().all()
				.assertThat()
				.statusCode(201)
				.extract().response()
				.asString();
		System.out.println(responsePost);

		ObjectMapper mapper = new ObjectMapper();
		UserControllerPOJOClass value = mapper.readValue(responsePost, UserControllerPOJOClass.class);
		
		String responseValue = mapper.writeValueAsString(value);
		userid = value.getUserId();
		System.out.println(userid);
	}

	@Test(dataProvider = "UpdateData", dataProviderClass = DataProviderClass.class, priority = 2)
	public void updateNewUser(String userId, String firstName, String lastName, String emailAddress)
			throws JsonMappingException, JsonProcessingException {
		String responsePut = 
			given()
				.log().all()
				.headers("Content-Type", "application/json")
				.pathParam("userId", userid)
				.body(UserControllerRequestBodyUtils.requestBody(userId, firstName, lastName, emailAddress))
			.when()
				.put("api/users/{userId}")
			.then()
				.log().all()
				.assertThat()
				.statusCode(200)
				.extract().response()
				.asString();
		System.out.println(responsePut);
		ObjectMapper mapper = new ObjectMapper();
		UserControllerPOJOClass readValue = mapper.readValue(responsePut, UserControllerPOJOClass.class);
		System.out.println(readValue);
		String updatedUserDetails = mapper.writeValueAsString(readValue);
		System.out.println(updatedUserDetails);
	}

	@Test(priority = 3)
	public void getUpdatedNewUser() throws JsonProcessingException {
		String res = 
			given()
				.log().all().pathParam("userId", userid)
			.when()
				.get("api/users/{userId}")
			.then()
				.log().all()
				.assertThat().statusCode(200)
				.extract().response()
				.asString();
		System.out.println(res);
		ObjectMapper mapper = new ObjectMapper();
		UserControllerPOJOClass readValue = mapper.readValue(res, UserControllerPOJOClass.class);
		System.out.println(readValue);
		String responseValue = mapper.writeValueAsString(readValue);
		System.out.println(responseValue);
		String userId = readValue.getUserId();
		System.out.println(userId);
		String ActualfirstName = readValue.getFirstName();
		String ExpectedFirstName="Vikram";
		Assert.assertEquals(ActualfirstName, ExpectedFirstName);

	}
	

	@Test(priority = 4)
	public void deleteUpdatedNewUser() {
		         given()
		          .log().all()
		          .pathParam("userId", userid)
		          .when()
		          .delete("api/users/{userId}")
		          .then()
		          .assertThat()
				  .statusCode(204);
	}
	@Test(priority = 5)
	public void getAllUsers() throws JsonMappingException, JsonProcessingException {

		String response = 
			given()
				.log().all()
				.headers("Content-Type", "application/json")
			.when()
				.get("api/users")
			.then()
				.assertThat()
				.statusCode(200)
				.extract().response()
				.asString();
		System.out.println(response);
		/*ObjectMapper mapper = new ObjectMapper();
		UserControllerPOJOClass readValue = mapper.readValue(response, UserControllerPOJOClass.class);
		System.out.println(readValue);
		String resp = mapper.writeValueAsString(readValue);
		System.out.println(resp);*/

	}
}
