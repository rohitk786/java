package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("hello from get method");
		String name = request.getParameter("username");
		pw.println("request parameter has username.... : "+name);
		
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if(name !=" " && name !=null) {
		session.setAttribute("SavedUser", name);
		context.setAttribute("SavedUser", name);
		
		}
		pw.println("session parameter has username :"+ (String)session.getAttribute("SavedUser"));
		pw.println("context parameter has username :"+(String)context.getAttribute("SavedUser"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("hello from get method");
		String name = request.getParameter("username");
		String password = request.getParameter("userpwd");
		pw.println("entered username : "+name);
		pw.println("entered password : "+password);
		
		String profession = request.getParameter("profession");
		pw.println("selected profession :  "+profession);
		
		String[] location = request.getParameterValues("location");
		pw.println("your at "+location.length+" places");
		for(int i = 0; i<location.length;i++) {
		pw.println("location : "+ location[i]);
		}
	}

}
