package beTheHeroAPItesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JDBCConnection {
	
	/*String url="jdbc:mysql://192.168.3.230:3306/be_the_hero";
	String username="root";
	String password="root";*/
	String querry="select * from users where id=3121";
	Connection con=null;
	String url="jdbc:mysql://192.168.3.230:3306/be_the_hero";
	String username="root";
	String password="root";
	
	
	@BeforeTest
	public void JDBCConnection() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
	    con=DriverManager.getConnection(url,username,password);
		
	}
	
	
		

	@Test
	public void JDBCgetvalue() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
	    con=DriverManager.getConnection(url,username,password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(querry);
		rs.next();		
		String value = rs.getString("name");
		System.out.println(value);
		/*while(rs.next()) {
			String values = rs.getString();
			System.out.println(values);
		}*/
		st.close();
		con.close();
	}
	
	
	

}
