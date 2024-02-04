package sun.Application;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import sun.DAO.CustomerBOIMP;
import sun.Module.Customer;


@WebServlet("/EditServlet1")  
public class EditServlet1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//retrieving the updated details from user
	        int id = Integer.parseInt(request.getParameter("Id"));
			String fname=request.getParameter("FirstName");
			String lname = request.getParameter("LastName");
			String address = request.getParameter("Address");
			String city = request.getParameter("City");
			String state = request.getParameter("State");
			String email= request.getParameter("Email");
			long phone = Long.parseLong(request.getParameter("Phone"));
			
			PrintWriter out = response.getWriter();
			//Creating new customer object with same customer id
			Customer customer = new Customer( fname,lname,address,city,state, email, phone);
			CustomerBOIMP c = new CustomerBOIMP();
			customer.setId(id);
			response.setContentType("text/html");
			
			//Updating the user records with updated values
			int update = c.update(customer);
			
			if(update >0) {
				response.sendRedirect("view.jsp");  	
			}
			else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	}
}