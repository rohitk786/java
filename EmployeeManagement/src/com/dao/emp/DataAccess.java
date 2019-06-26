package com.dao.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.emp.Employee;

public class DataAccess {

	/*
	 * 1. Establishing JDBC Connection 2. Comparing input from user with DataBase
	 */
	Connection con;

	public void sqlConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // loading driver
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "system", "java@123");    // establishing
																											// connection
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("driver issue or sql connection issue...");
		}
	}

	public boolean adminregistartion(int id, String username, String userpwd) {
		try {
			sqlConnection();

			String str = "insert into admindetails values(?,?,?)";
			PreparedStatement p = con.prepareStatement(str);

			p.setInt(1, id);
			p.setString(2, username);
			p.setString(3, userpwd);

			int result = p.executeUpdate();
			if (result == 1) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	
	public boolean authenticateUser(String username, String userpwd) {

		try {

			sqlConnection();

			String selectQuery = "select *  from admindetails where username=? AND userpassword=?";
			PreparedStatement stmt = con.prepareStatement(selectQuery);
			
			stmt.setString(1, username);
			stmt.setString(2, userpwd);
			
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		System.out.println("......out side the data ........");
		return false;
	}
	
	public boolean empRegistration(int empcode,String empName,String empemail,String empmobile,String empstatus,int empdept) {
		
		try {
			sqlConnection();
			
			//String query = "select deptid from department where value=?";
			String selectQuery = "insert into employee values(?,?,?,?,?,?)";
			PreparedStatement p = con.prepareStatement(selectQuery);
			
			p.setInt(1, empcode);
			p.setString(2, empName);
			p.setString(3, empemail);
			p.setString(4, empmobile);
			p.setString(5, empstatus);
			p.setInt(6, empdept);
			
			int res = p.executeUpdate();
			if (res == 1) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return false;
		
	}
	
	ArrayList<Employee> e = new ArrayList<Employee>(); 
	
	public ArrayList<Employee> retrieveData() {
		try {
			sqlConnection();
			
			String selectQuery = "select empcode,EMPNAME,empemail,empmobile,EMPSTATUS,DEPTNAME from EMPLOYEE "
					+ "inner join department d on EMPDEPT = DEPTID";
			
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery(selectQuery);
			
			
				
			while(r.next()) {
					
			   e.add(new Employee(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6)));
			   System.out.println("retrieved data from table");
				
			   }
			}catch(Exception e) {
				
			System.out.println("unable to retrieve data");
			e.printStackTrace();
		}
		
		for (int i = 0; i < e.size(); i++) {
			System.out.println(e.get(i));
		}
		
		return e;
		
	}

}
