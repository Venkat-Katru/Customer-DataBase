package sun.DAO;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import sun.Module.Customer;

	public class  CustomerBOIMP  implements CustomerBo{
		
		private static Connection con=null;
		private static PreparedStatement pt=null;
		private static Statement ct=null;
		private static ResultSet res=null;
		private static final String INSERT_QUERY="insert into `customer`(`First Name`,`Last Name`,`Address`,`City`,`State`,`Email`,`Phone`) values(?,?,?,?,?,?,?)";
		
		private static final String UPDATE_QUERY="update `customer` set `First Name`=?,`Last Name`=?,`Address`=?,`City`=?,`State`=?,`Email`=?,`Phone`=? where `Id`=?" ;
		private static final String DELETE_QUERY="delete from  `customer` where `Id`=?";
		private static final String SELECT_QUERY="select * from `customer`";
		
		public CustomerBOIMP() {
			try {
				//Loading the driver class
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//Establishing the jdbc connection
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunbase","root","root");
			}
			catch(ClassNotFoundException | SQLException e1)
			{
				e1.printStackTrace();
			}
		}

		
		public int save(Customer c) {
			try {
				 pt = con.prepareStatement(INSERT_QUERY);
				pt.setString(1,c.getFirstName());
				pt.setString(2,c.getLastName());
				pt.setString(3,c.getAddress());
				pt.setString(4,c.getCity());
				pt.setString(5, c.getState());
				pt.setString(6,c.getEmail());
				pt.setLong(7,c.getPhone());
				return pt.executeUpdate();
				
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}	
			return 0;
		}

		
		public int update(Customer c) {
			
			 try {
				pt = con.prepareStatement(UPDATE_QUERY);
				pt.setString(1,c.getFirstName());
				pt.setString(2,c.getLastName());
				pt.setString(3,c.getAddress());
				pt.setString(4,c.getCity());
				pt.setString(5, c.getState());
				pt.setString(6, c.getEmail());
				pt.setLong(7,c.getPhone());
				pt.setInt(8, c.getId());
				return pt.executeUpdate();
			
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
				
				
			return 0;
		}
		
		public int delete(int Id) {
			
			try {
				pt=con.prepareStatement(DELETE_QUERY);
				pt.setInt(1,Id);
				return pt.executeUpdate();
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return 0;
		}

		public int delete(Customer c) {
			
			return delete(c.getId());
		}

		@Override
		public Customer get(int id) {
			String SELECT_QUERY1="select * from `customer` where `Id`="+id;
			
			try {
			   ct = con.createStatement();
			   res = ct.executeQuery(SELECT_QUERY1);
				 while(res.next())
				 {
					 int id1 = res.getInt("Id");
					 String fname=res.getString("First Name");
					 String lname=res.getString("Last Name");
					 String address=res.getString("Address");
					 String city=res.getString("City");
					 String state=res.getString("State");
					 String email=res.getString("Email");
					 long phone = res.getLong("Phone");
					 
					 Customer c2 = new Customer(fname,lname,address,city,state,email, phone);
					 c2.setId(id1);
					 return c2;
				 }
			}
				 
				
				
			 catch (SQLException e) {
				
				e.printStackTrace();
			}
			return null;
		}

		
		public List<Customer> getall() {
			
			List<Customer> arrayList1 = new ArrayList<Customer>();
			try {
				 ct = con.createStatement();
				 res = ct.executeQuery(SELECT_QUERY);
				 while(res.next())
				 {
					 int id1 = res.getInt("Id");
					 String fname=res.getString("First Name");
					 String lname=res.getString("Last Name");
					 String address=res.getString("Address");
					 String city=res.getString("City");
					 String state=res.getString("State");
					 String email=res.getString("Email");
					 long phone = res.getLong("Phone");
					 
					 Customer c = new Customer(fname,lname,address,city,state,email, phone);
					 c.setId(id1);
					 arrayList1 .add(c);			 }
			} catch (SQLException e) {
				
				e.printStackTrace();
			}		return arrayList1;
		}
		
		

	}



