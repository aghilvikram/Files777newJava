package beTheHeroAPItesting;

public class RequestBodyUtilsNegativeCaseDatas {
	
	public static String postBody() {
		return "{\r\n" + 
				"    \"FirstName\":\"vikram\",\r\n" + 
				"    \"Email-id\":\"vikramaghil@gmail.com\",\r\n" + 
				"    \"Whatsapp-no\":\"6380455178\",\r\n" + 
				"    \"City\":\"Salem\",\r\n" + 
				"    \"Uf\":\"1234\"\r\n" + 
				"}";
	}
	
	public static String updateBody() {
		return "{\r\n" + 
				"    \"firstname\":\"VIKRAM\",\r\n" + 
				"    \"email-id\":\"vikramaghil@gmail.com\",\r\n" + 
				"    \"whatsapp-no\":\"6380455178\",\r\n" + 
				"    \"city\":\"SALEM\",\r\n" + 
				"    \"uf\":\"1234\"\r\n" + 
				"}";
	}
	public static String registernewBody1() {
		return "{\r\n" + 
				"   \"Title\":\"book\",\r\n" + 
				"   \"Description\":\"bookapitesting\",\r\n" + 
				"   \"rate\":\"1000\" \r\n" + 
				"}";
	}
	public static String registernewBody2() {
		return "{\r\n" + 
				"   \"title\":\"novel\",\r\n" + 
				"   \"description\":\"novelapitesting\",\r\n" + 
				"   \"rate\":\"2000\" \r\n" + 
				"}";
	}
	
	public static String login(String value) {
		return "{\r\n" + 
				"   \"id\": \""+value+"\"\r\n" + 
				"}";
	}

}
