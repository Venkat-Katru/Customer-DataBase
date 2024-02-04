package sun.Application;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import sun.DAO.LoginBOIMP;
import sun.Module.Login;
@WebServlet("/Login1")
public class LoginServlet1 extends HttpServlet {
	static int  count=3;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Getting the login credentials(username,password) from the user
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        //Retrieving the existing ,login credentials from the database
        LoginBOIMP lo = new LoginBOIMP();
        Login l = lo.get();
        
        //Validating the user credentials and database credentials
		if((name.equals(l.getUsername()))&& (password.equals(l.getPassword())))
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", name);
			
			//Redirecting to the customer registration form
			RequestDispatcher rd1 = request.getRequestDispatcher("/insert.html");
		    rd1.forward(request, response);
		    count=3;
		}
		else
		{
			//For invalid credentials , it will redirect to same login page and shows remaining attempts 
			if(count-->1)
			{
				 request.setAttribute("message", count);
				RequestDispatcher rd2 = request.getRequestDispatcher("/login2.jsp");
				
				rd2.forward(request, response);
			}
			else
			{
				RequestDispatcher rd3 = request.getRequestDispatcher("/blocked1.html");
				rd3.forward(request, response);
			}
			
		}
		
		
	}

}
