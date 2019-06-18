package com.srs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		   String username = request.getParameter("userName");
		   String userid = request.getParameter("userId");
		 out.println("hello!!! from the get method..."+ username+ " "+ userid);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		   String username = request.getParameter("userName");
		   String fullname = request.getParameter("fullName");
		 out.println("hello!!! from post method "+ username);
		 out.println("this is your fullname "+ fullname);
		 
		 String profession = request.getParameter("prof");
		 out.println("you are a  "+profession);
		 
		 
		 
	}


}
