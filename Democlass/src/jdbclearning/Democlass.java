package jdbclearning;

import java.sql.*;

public class Democlass {
	
	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbc_connectivity";
		String uname = "root";
		String pass = "root";
		String query = "select * from student";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st= con.createStatement(); 
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
		String name = rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3);
		
		System.out.println(name);
		}
		st.close();
		con.close();
	}

}
