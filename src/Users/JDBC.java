package Users;

import java.sql.*;
public class JDBC {
	public static void main(String[] args) throws Exception 
	 {
		
		 }
	public static void addStudent(int id,String name) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/kefay";
		String uname="root";
		String pass="";
		Connection con=DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();
		
		
		
		//String theQuery="insert into student(id,name) values("+id +", "+ name+")";
		String theQuery="insert into users(id,name) values ("+id + ", '"+name+"')";
		int rs=st.executeUpdate(theQuery);
		
		System.out.println(rs);
		st.close();
		con.close();
		
	}
	public static void showUsers() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/kefay";
		String uname="root";
		String pass="";
		Connection con=DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();
		String showQuery="select * from users";
		ResultSet rs=st.executeQuery(showQuery);
		
		
		while(rs.next())
		{
			String userData=rs.getString("name")+" "+rs.getInt("id");
			System.out.println(userData);
		}
		}
	}
	
	 

