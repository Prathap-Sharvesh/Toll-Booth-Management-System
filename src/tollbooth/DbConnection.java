package tollbooth;

import java.sql.*;

public class DbConnection {
	
	private static final String url = "jdbc:mysql://localhost:3306/toll";
	private static final String user = "root";
	private static final String password = "12345";
	
	public static Connection getConnection () throws Exception{
		Connection con = DriverManager.getConnection(url,user,password);
		return con;
	}
	
	
}
