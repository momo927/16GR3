package com.qhit.lh.gr3.momo.t2.bean;

/**
 * @author 王倩倩
 *TODO
 *2017年12月12日下午8:06:42
 */

public class Dept {
  private int deptId;
  private String deptName;
  private String password;
 
  //映射关联
  private User user;

public Dept() {
	super();
	// TODO Auto-generated constructor stub
}

public Dept(int deptId, String deptName, String password, User user) {
	super();
	this.deptId = deptId;
	this.deptName = deptName;
	this.password = password;
	
	this.user = user;
}
public Dept(int deptId, String deptName, String password) {
	super();
	this.deptId = deptId;
	this.deptName = deptName;
	this.password = password;
	
}

public int getDeptId() {
	return deptId;
}

public void setDeptId(int deptId) {
	this.deptId = deptId;
}

public String getDeptName() {
	return deptName;
}

public void setDeptName(String deptName) {
	this.deptName = deptName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}



public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

@Override
public String toString() {
	return deptId+" "+deptName+" "+password;
}
  
  
  
}
