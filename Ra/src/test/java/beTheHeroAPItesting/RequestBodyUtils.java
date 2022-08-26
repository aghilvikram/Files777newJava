package beTheHeroAPItesting;

public class RequestBodyUtils {
	

	public static String postBodyFromDP(String name,String email, String whatsapp,String city, String uf) {
		return "{\r\n" + 
				"    \"name\":\""+name+"\",\r\n" + 
				"    \"email\":\""+email+"\",\r\n" + 
				"    \"whatsapp\":\""+whatsapp+"\",\r\n" + 
				"    \"city\":\""+city+"\",\r\n" + 
				"    \"uf\":\""+uf+"\"\r\n" + 
				"}";
	}
	
	public static String updateBodyFromDP(String name,String email, String whatsapp,String city, String uf) {
		return "{\r\n" + 
				"    \"name\":\""+name+"\",\r\n" + 
				"    \"email\":\""+email+"\",\r\n" + 
				"    \"whatsapp\":\""+whatsapp+"\",\r\n" + 
				"    \"city\":\""+city+"\",\r\n" + 
				"    \"uf\":\""+uf+"\"\r\n" + 
				"}";
	}
	public static String registernewBodyFromDP(String title,String description, String value) {
		return "{\r\n" + 
				"   \"title\":\""+title+"\",\r\n" + 
				"   \"description\":\""+description+"\",\r\n" + 
				"   \"value\":\""+value+"\" \r\n" + 
				"}";
	}
	
	
	
	
	
	
	
	
	
	public static String postBody() {
		return "{\r\n" + 
				"    \"name\":\"vikram\",\r\n" + 
				"    \"email\":\"vikramaghil@gmail.com\",\r\n" + 
				"    \"whatsapp\":\"6380455178\",\r\n" + 
				"    \"city\":\"Salem\",\r\n" + 
				"    \"uf\":\"12\"\r\n" + 
				"}";
	}
	
	public static String updateBody() {
		return "{\r\n" + 
				"    \"name\":\"VIKRAM\",\r\n" + 
				"    \"email\":\"vikramaghil@gmail.com\",\r\n" + 
				"    \"whatsapp\":\"6380455178\",\r\n" + 
				"    \"city\":\"SALEM\",\r\n" + 
				"    \"uf\":\"12\"\r\n" + 
				"}";
	}
	public static String registernewBody1() {
		return "{\r\n" + 
				"   \"title\":\"book\",\r\n" + 
				"   \"description\":\"bookapitesting\",\r\n" + 
				"   \"value\":\"1000\" \r\n" + 
				"}";
	}
	public static String registernewBody2() {
		return "{\r\n" + 
				"   \"title\":\"novel\",\r\n" + 
				"   \"description\":\"novelapitesting\",\r\n" + 
				"   \"value\":\"2000\" \r\n" + 
				"}";
	}
	
	public static String login(String value) {
		return "{\r\n" + 
				"   \"id\": \""+value+"\"\r\n" + 
				"}";
	}

}
