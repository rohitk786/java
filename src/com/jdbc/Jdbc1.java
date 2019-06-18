package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc1 {

	public static void main(String[] args) {
			
	        try {
	        	
	        	Class.forName("oracle.jdbc.driver.OracleDriver");
	        	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "system", "java@123");

				/*
				//table creation
				String str ="create table students(sid int,sname varchar(50),Semail varchar(50),ssub varchar(50))";
				Statement s = con.createStatement();
				int i =s.executeUpdate(str);
				System.out.println(i + " table created.....");
				*/
				  
		
		
				/*
				//inserting record 1
				String str ="insert into students values(?,?,?,?)";
				PreparedStatement s = con.prepareStatement(str);
				s.setInt(1, 1);
				s.setString(2, "rohit");  s.setString(3, "rohit@gmail.com"); s.setString(4, "jdbc");

	                  int i = s.executeUpdate();
	                  System.out.println("records inserted successfully....");
				*/
				
		
		
				/*
				//inserting record 2
				String str ="insert into students values(?,?,?,?)";
				PreparedStatement s = con.prepareStatement(str);
				s.setInt(1, 2);
				s.setString(2, "rahul");  s.setString(3, "rahul@gmail.com"); s.setString(4, "servlets");

	                  int i = s.executeUpdate();
	                  System.out.println("records inserted successfully....");
	              */
		
		
				
				/*
				//inserting record 2
				String str ="insert into students values(?,?,?,?)";
				PreparedStatement s = con.prepareStatement(str);
				s.setInt(1, 3);
				s.setString(2, "umang");  s.setString(3, "umang@gmail.com"); s.setString(4, "core java");

	                  int i = s.executeUpdate();
	                  System.out.println("records inserted successfully....");
	             */
		
		
				
				/*
				//Retrieving data from table
				String str = "select * from students";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(str);
				while(rs.next())
				{
					System.out.println(".......printing...........");
	                System.out.println("student id :"+rs.getInt(1));
	                System.out.println("student name :"+rs.getString(2));
	                System.out.println("student email :"+rs.getString(3));
	                System.out.println("student subject :"+rs.getString(4));
				
				}
				*/
		
		
				
				/*
				//updating record in table
				String str = "update students set ssub=? where sid=?";
				PreparedStatement s = con.prepareStatement(str);
				s.setString(1, "collections");   s.setInt(2, 3);
				int i = s.executeUpdate();
				System.out.println("....records updated successfully.....");
				*/
		
		
				
				/*
				//deleting record in a table
				String str="delete from students where sid=?";
				PreparedStatement s = con.prepareStatement(str);
				s.setInt(1, 3);
				int i = s.executeUpdate();
				System.out.println(".....record deleted successfully.....");
	            */
				
		
		        /*
				//batch processing with Statement
				Statement s = con.createStatement();
				String str1 = "insert into students values(3,'umang','umang@gmail.com','core java')";
				String str2 = "insert into students values(4,'naveen','naveen@gmail.com','threads')";
				s.addBatch(str1);   s.addBatch(str2);
				int[] i = s.executeBatch();
				System.out.println("........batch executed successfully..........");
	             */
				
				
		        /*
				//BATCH with prepared Statement
				String str ="insert into students values(?,?,?,?)";
				PreparedStatement s = con.prepareStatement(str);
				int[] id = {5,6};
				String[] name = {"santosh","rohan"};
				String[] email = {"santosh@gmail.com","rohan@gmail.com"};
				String[] sub = {"collections","javascript"};
				
				for(int i = 0;i<id.length;i++)
				{
					s.setInt(1, id[i]);
					s.setString(2, name[i]);
					s.setString(3, email[i]);
					s.setString(4, sub[i]);
					s.addBatch();
				}
				int[] count = s.executeBatch();
				System.out.println("....batch executed with prepared statement....");
				*/
				con.close();
			} 
			catch (Exception e) {
				System.out.println("driver not found");
				e.printStackTrace();
			}
	
	}

}
