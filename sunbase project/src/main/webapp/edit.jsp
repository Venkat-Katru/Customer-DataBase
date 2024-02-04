<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 

import="sun.DAO.CustomerBOIMP, sun.Module.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Customer</title>
    <link rel='stylesheet' type='text/css' href='style22.css'>
    
</head>
<body>
    <%
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id"));
        CustomerBOIMP CustomerBOIMP = new CustomerBOIMP();
        Customer c1 = CustomerBOIMP.get(id);
    %>
    <div class="main">
        <div class="reg">
            <h1 style='text-align:center;'>Update Employee</h1>
            <form action='EditServlet1' method='post' id="in">
                <br>
                <br>
                <label>ID:</label><br>
                <input readonly="readonly" type="number" name="Id" id="na1" value="<%= c1.getId() %>" ><br><br>

                <label>FIRSTNAME:</label><br>
                <input type="text" name="FirstName" id="na2" value="<%= c1.getFirstName() %>" placeholder="Enter First name"><br><br>
                
                 <label>LASTNAME:</label><br>
                <input type="text" name="LastName" id="na3" value="<%= c1.getLastName() %>" placeholder="Enter Last name"><br><br>
                
                 <label>ADDRESS:</label><br>
                <input type="text" name="Address" id="na4" value="<%= c1.getAddress() %>" placeholder="Enter Address"><br><br>
                
                 <label>CITY:</label><br>
                <input type="text" name="City" id="na5" value="<%= c1.getCity() %>" placeholder="Enter City"><br><br>
                
                 <label>STATE:</label><br>
                <input type="text" name="State"  id="na6" value="<%= c1.getState() %>" placeholder="Enter State"><br><br>

                <label>EMAIL:</label><br>
                <input type="email" name="Email" id="na7" value="<%= c1.getEmail() %>" placeholder="Enter Email"><br><br>

                
                <label>PHONE:</label><br>
                <input type="number" name="Phone"  id="na8" value="<%= c1.getPhone() %>" placeholder="Enter Mobile Number"><br><br>

                <button type="submit" value="Save Employee" id="sub">Update</button>
                <a  href='login1.html'>
   					<button  type="button" value="logout" id="sub1">Log Out</button>
   				</a>
            </form>
        </div>
    </div>
    
</body>
</html>                   