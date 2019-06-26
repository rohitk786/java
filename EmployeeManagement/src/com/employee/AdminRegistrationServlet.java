package com.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.emp.DataAccess;

/**
 * Servlet implementation class AdminRegistrationServlet
 */

public class AdminRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String adminid = request.getParameter("adminid");
		int adminId = Integer.parseInt(adminid);
		String adminUname = request.getParameter("adminuname");
		String adminPwd = request.getParameter("adminpwd");
		
		DataAccess d2 = new DataAccess();
		boolean result = d2.adminregistartion(adminId, adminUname, adminPwd);
		
		if(result) {
			pw.println("PLease login now.....");
			RequestDispatcher req = request.getRequestDispatcher("index.html");
			req.forward(request, response);
			
		}else {
			pw.println("OOPS!....unable to add records for admin....Please try again!");
			RequestDispatcher req1 = request.getRequestDispatcher("registerAdmin.jsp");
			req1.include(request, response);
		}
		
	}

}
