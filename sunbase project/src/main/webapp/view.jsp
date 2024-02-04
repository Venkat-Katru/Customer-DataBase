<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  
import="java.util.List,sun.DAO.CustomerBOIMP, sun.Module.Customer"  %>
<!DOCTYPE html>
<html>
<head>
    <title>View Customers</title>
    <link rel="stylesheet" type="text/css" href="table22.css">
    
</head>
<body>
    
    <%
    CustomerBOIMP em = new CustomerBOIMP();
        List<Customer> list = em.getall();
    %>
    
    <table border=2 >
        <tr>
            <th>Customer_Id</th>
            <th>First_Name</th>
            <th>Last_Name</th>
            <th>Address</th>
            <th>Current_City </th>
            <th>State_Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <%
            for (Customer c : list) {
        %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getFirstName() %></td>
            <td><%= c.getLastName() %></td>
            <td><%= c.getAddress() %></td>
            <td><%= c.getCity() %></td>
            <td><%= c.getState() %></td>
            <td><%= c.getEmail() %></td>
            <td><%= c.getPhone() %></td>
            <td>
                <a href='edit.jsp?id=<%= c.getId() %>'>
                    <button id="bt1" type="button">EDIT</button>
                </a>
            </td>
            <td>
                <a href='DeleteServlet1?id=<%= c.getId() %>'>
                    <button id="bt2" type="button">DELETE</button>
                </a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
   	<a href='insert.html'>
        <button type="button" id="bt3">Add New Customer</button>
    </a>
    <a  href='login1.html'>
   		<button  type="button" value="logout" id="sub1">Log Out</button>
   	</a>
    
</body>
</html>