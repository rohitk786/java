package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */

public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet2() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletConfig config = getServletConfig();
		String company = config.getInitParameter("company");
		String servname = config.getServletName();            //returns servlet name
		
		
		ServletContext x = config.getServletContext();
		String cpath = x.getContextPath();
		String serverinfo = x.getServerInfo();    
		
		
		String username = request.getParameter("username");
		String email = request.getParameter("useremail");
		
		out.println("<pre>user : "+username);
		out.println("email :"+email);
		out.println("Company is : "+company);
		out.println("Servlet name : "+servname);
		out.println("context path : "+cpath);
		out.println("server info : "+serverinfo);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		
	}

}
