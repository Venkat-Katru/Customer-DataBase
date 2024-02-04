package sun.Application;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sun.DAO.CustomerBOIMP;
import sun.Module.Customer;

import java.io.IOException;
import java.io.PrintWriter;

import sun.DAO.CustomerBOIMP;
import sun.Module.Customer;


@WebServlet("/SaveServlet1")
public class SaveServlet1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieving values from the customer registration form
		
		String fname=request.getParameter("FirstName");
		String lname = request.getParameter("LastName");
		String address = request.getParameter("Address");
		String city = request.getParameter("City");
		String state = request.getParameter("State");
		String email= request.getParameter("Email");
		long phone = Long.parseLong(request.getParameter("Phone"));
		
		PrintWriter out = response.getWriter();	
		
		//creating the customer object by storing all user given values
		
		Customer customer = new Customer(fname,lname,address,city,state, email, phone);
		CustomerBOIMP c = new CustomerBOIMP();
		
		response.setContentType("text/html");
		
		//saving the customer details into database
		
		int save = c.save(customer);
		
		//checking the records whether they  stored successful or not
		if(save==1) { 
	            request.getRequestDispatcher("saved.html").include(request, response);
		}
		else {
			out.println("Sorry! unable to save record");  
		}

}
}
