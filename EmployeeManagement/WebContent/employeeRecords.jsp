<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="com.model.emp.Employee"%>
    <%@page import="com.dao.emp.DataAccess"%>
     <%@page import="com.employee.RetrieveData"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta  charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	      <jsp:include page="mainheader.jsp"/>  
	      
	<div>
			<h1><center>Employee Details</center></h1> 
      <table border ="1" width="500" align="center"> 
         <tr bgcolor="00ffff"> 
          <th><b>Employee_Code</b></th> 
          <th><b>Employee_Name</b></th> 
          <th><b>Employee_Email</b></th>
          <th><b>Employee_Mobile</b></th>
          <th><b>Employee_Status</b></th>
          <th><b>Employee_Department</b></th> 
          <th><b>Action</b></th> 
         </tr> 
         
        <%-- Fetching the attributes of the request object 
             which was previously set by the servlet  
              "StudentServlet.java" 
        --%> 
         
        <%ArrayList<Employee> emp = (ArrayList<Employee>)request.getAttribute("data");
             for(Employee e1:emp){
             %>
         
             <%-- Arranging data in tabular form --%> 
        
             <tr> 
                <td><%=e1.getEmpcode()%></td> 
                <td><%=e1.getEmpname()%></td> 
                <td><%=e1.getEmpemail()%></td>
                <td><%=e1.getEmpmobile()%></td>
                <td><%=e1.getEmpstatus()%></td>
                <td><%=e1.getDeptname()%></td> 
                <td>
                	<select name="action">
                			<option>Select Action</option>
                			<option value="edit">EDIT</option>
                			<option value="delete">DELETE</option>
                	</select>
                </td>
             </tr> 
             <% } %> 
            
        </table>
        </div>
</body>
</html>