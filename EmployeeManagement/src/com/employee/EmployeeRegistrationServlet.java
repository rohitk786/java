package com.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.emp.DataAccess;

/**
 * Servlet implementation class EmployeeRegistrationServlet
 */
@WebServlet("/empServlet")
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String Code = request.getParameter("empcode");
		int empcode = Integer.parseInt(Code);
		String empName = request.getParameter("empname");
		String empmobile = request.getParameter("empmobile");
		String empstatus = request.getParameter("empstatus");
		String empemail = request.getParameter("empemail");
		
		
		String dept = request.getParameter("empdept");
		int empdept = Integer.parseInt(dept);
		
		
		DataAccess d3 = new DataAccess();
		boolean result = d3.empRegistration(empcode, empName, empemail, empmobile, empstatus, empdept);
		
		if(result) {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}
		else {
			pw.println("unable to add records.....please try again");
			RequestDispatcher rd2 = request.getRequestDispatcher("employeeRegistration.jsp");
			rd2.include(request, response);
		}
		
	}

}
