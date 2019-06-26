package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.emp.DataAccess;
import com.model.emp.Employee;


@WebServlet("/getrecords")
public class RetrieveData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public RetrieveData() {
        super();
     
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		
		DataAccess data = new DataAccess();
		ArrayList<Employee> emp = data.retrieveData();
		
		/*for (int i = 0; i < e.size(); i++) {
			System.out.println(e.get(i));
		}
		*/
		
		// Setting the attribute of the request object 
	    // which will be later fetched by a JSP page
		request.setAttribute("data", emp);
		
		// Creating a RequestDispatcher object 
	         RequestDispatcher rd = request.getRequestDispatcher("employeeRecords.jsp");  
	          rd.forward(request, response); 
	            p.println("</body>"); 
	            p.println("</html>"); 
		
		
	}

}
