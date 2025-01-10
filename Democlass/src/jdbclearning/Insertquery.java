package jdbclearning;

import java.sql.*;

public class Insertquery {
	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbc_connectivity";
		String uname = "root";
		String pass = "root";
//		int id = 2;
//		String name = "def";
//		String major = "poi";
//		int age = 45;
		String query = "Insert into staffs values (1,'abc','qwe',22)"; //two ways
//		String query = "Insert into staffs values (" + id + ",'" + name + "','" + major + "'," + age + ")";		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		int count = st.executeUpdate(query);
		
		System.out.println(count + " rows affected");
			
		st.close();
		con.close();
		
		
 	}

}
