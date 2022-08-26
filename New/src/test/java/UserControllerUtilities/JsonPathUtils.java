package UserControllerUtilities;

import io.restassured.path.json.JsonPath;

public class JsonPathUtils {
	public static String jsonData(String response, String userid) {
		JsonPath jp=new JsonPath( response);
		String id = jp.getString(userid);
		return id;
	}

}
