package sun.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sun.Module.Customer;
import sun.Module.Login;
public class LoginBOIMP{
	private static Connection con=null;
	private static PreparedStatement pt=null;
	private static Statement ct=null;
	private static ResultSet res=null;
		
	public LoginBOIMP() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunbase","root","root");
		}
		catch(ClassNotFoundException | SQLException e1)
		{
			e1.printStackTrace();
		}
	}
		public Login get() {
			String SELECT_QUERY1="select * from `login` ";
			
			try {
			   ct = con.createStatement();
			   res = ct.executeQuery(SELECT_QUERY1);
				 while(res.next())
				 {
					 
					 String username=res.getString("username");
					 String password=res.getString("password");
					 
					 
					 Login c2 = new Login(username,password);
					 
					 return c2;
				 }
				
			}	
			 catch (SQLException e) {
					
					e.printStackTrace();
				}
				return null;
		
	}


}
