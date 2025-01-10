package jdbclearning;

import java.sql.*;

public class Insertquery {
	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbc_connectivity";
		String uname = "root";
		String pass = "root";
		
//		int id = 3;
//		String name = "ghi";
//		String major = "lkj";
//		int age = 32;

		String query = "Insert into staffs values (1,'abc','qwe',22)"; //two ways
		
//		String query = "Insert into staffs values (" + id + ",'" + name + "','" + major + "'," + age + ")";		
// 	    String query = "Insert into staffs values (?,?,?,?)"; //two ways
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		
//		PreparedStatement st = con.prepareStatement(query);
//		st.setInt(1, id);
//		st.setString(2, name);
//		st.setString(3, major);
//		st.setInt(4, age);
		
		int count = st.executeUpdate(query);
		
//		int count = st.executeUpdate();
		
		System.out.println(count + " rows affected");
	
		st.close();
		con.close();
		
		
 	}

}
