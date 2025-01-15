package jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud_operation {
	
	public static void main(String[] args)
	{
		StudentDao dao = new StudentDao();
		
//		Student s1 = dao.getStudent(12);
//		System.out.println(s1.sname);
		
//		Student s2 = new Student();
//		s2.rollno = 15;
//		s2.sname = "Harish";
		dao.connect();
//		dao.addStudent(s2);
		
		Student s3 = dao.removeStudent(12);
		
	}

}

class StudentDao
{
	Connection con = null;
	
	public void connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_connectivity","root","root");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Student getStudent(int rollno)
	{
		Student s = new Student();
		s.rollno = rollno;
		try {
			String query = "select sname from student where rollno =" + rollno;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String name=rs.getString(1);
			s.sname = name;
			return s;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
	public void addStudent(Student s)
	{
		String query = "insert into student values (?,?)";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, s.rollno);
			pst.setString(2, s.sname);
			pst.executeUpdate();
			System.out.println("Data has been updated");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Student removeStudent(int rollno)
	{
		Student s= new Student();
		s.rollno = rollno;
		
		String query = "DELETE FROM student WHERE rollno =" + rollno;
		Statement st;
		try {
			st = con.createStatement();
			int rs = st.executeUpdate(query);
			System.out.println("Deleted Successfully!!");
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}

}

class Student
{
	int rollno;
	String sname;
}