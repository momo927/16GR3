package com.qhit.lh.gr3.momo.t7.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 王倩倩
 *TODO
 *2017年12月22日上午8:27:33
 */
public class Emp {
	 private int empId;
     private String empName;
     private String empSex;
     private String brithday;
     private String phone;
     private int deptId;
     
     private User user;
     private Dept dept;
     private Set<Dept> depts = new HashSet<Dept>();
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Emp(int empId, String empName, String empSex, String brithday, String phone, int deptId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSex = empSex;
		this.brithday = brithday;
		this.phone = phone;
		this.deptId = deptId;
	}


	public Emp(int empId, String empName, String empSex, String brithday, String phone, int deptId, User user,
			Dept dept, Set<Dept> depts) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSex = empSex;
		this.brithday = brithday;
		this.phone = phone;
		this.deptId = deptId;
		this.user = user;
		this.dept = dept;
		this.depts = depts;
	}


	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSex() {
		return empSex;
	}
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	public String getBrithday() {
		return brithday;
	}
	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Set<Dept> getDepts() {
		return depts;
	}
	public void setDepts(Set<Dept> depts) {
		this.depts = depts;
	}
	@Override
	public String toString() {
		return  empId +  empName +  empSex  + brithday
				+  phone;
	}
     
     
     
     
}
