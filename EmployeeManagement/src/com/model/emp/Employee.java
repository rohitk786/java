package com.model.emp;

public class Employee {
	
	private int empcode;
	private String empname;
	private String empemail;
	private String empmobile;
	private String empstatus;
	private String deptname;
	
	public Employee(int empcode, String empname, String empemail, String empmobile, String empstatus, String deptname) {
		super();
		this.empcode = empcode;
		this.empname = empname;
		this.empemail = empemail;
		this.empmobile = empmobile;
		this.empstatus = empstatus;
		this.deptname = deptname;
	}

	public int getEmpcode() {
		return empcode;
	}

	public void setEmpcode(int empcode) {
		this.empcode = empcode;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpemail() {
		return empemail;
	}

	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}

	public String getEmpmobile() {
		return empmobile;
	}

	public void setEmpmobile(String empmobile) {
		this.empmobile = empmobile;
	}

	public String getEmpstatus() {
		return empstatus;
	}

	public void setEmpstatus(String empstatus) {
		this.empstatus = empstatus;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	@Override
	public String toString() {
		return "Employee [empcode=" + empcode + ", empname=" + empname + ", empemail=" + empemail + ", empmobile="
				+ empmobile + ", empstatus=" + empstatus + ", deptname=" + deptname + "]";
	}
	
	
	

}
