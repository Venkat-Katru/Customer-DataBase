package sun.Application;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import sun.DAO.CustomerBOIMP;
@WebServlet("/DeleteServlet1")
public class DeleteServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Deleting the customer details by using user given id
		int id = Integer.parseInt(request.getParameter("id"));
		CustomerBOIMP em = new CustomerBOIMP();
		em.delete(id);
		response.sendRedirect("view.jsp"); 
	}
}
		
