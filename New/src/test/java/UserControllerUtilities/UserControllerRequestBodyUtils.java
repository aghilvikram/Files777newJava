package UserControllerUtilities;

public class UserControllerRequestBodyUtils {
	
	public static String requestBody( String emailAddress,String firstName, String lastName, String userId) {
		return"{\r\n"
				+ "  \"emailAddress\": \""+emailAddress+"\",\r\n"
				+ "  \"firstName\": \""+firstName+"\",\r\n"
				+ "  \"lastName\": \""+lastName+"\",\r\n"
				+ "  \"userId\": \""+userId+"\"\r\n"
				+ "}";
	}
	public static String reqbody(String emailAddress, String firstName, String lastName ) {
		return "{\r\n"
				+ "  \"emailAddress\": \""+emailAddress+"\",\r\n"
				+ "  \"firstName\": \""+firstName+"\",\r\n"
				+ "  \"lastName\": \""+lastName+"\"\r\n"
				+"}";
		
	}

}
