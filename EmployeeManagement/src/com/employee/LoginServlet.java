package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.emp.DataAccess;
import com.model.emp.Employee;


/**
 * Programmer: Rohit
 * Servlet : LoginServlet
 */
             
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String username = request.getParameter(ConstantsUtil.USERNAME);   //getting dynamic input from user
		String userpwd = request.getParameter(ConstantsUtil.PASSWORD);
		
		DataAccess data = new DataAccess();
		boolean result = data.authenticateUser(username, userpwd);
		
		ArrayList<Employee> emp = data.retrieveData();
		request.setAttribute("data", emp);
		
		if(result) {
			 RequestDispatcher rd = request.getRequestDispatcher("employeeRecords.jsp");  
	          rd.forward(request, response); 
	            pw.println("</body>"); 
	            pw.println("</html>"); 
		}
		else {
			pw.print("Sorry! UserName or Password Error!!!");
			RequestDispatcher req = request.getRequestDispatcher("index.html");
			req.include(request, response);
			
		}
		
		
		
	}

}
