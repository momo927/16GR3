package com.qhit.lh.gr3.momo.t2.bean;

/**
 * @author 王倩倩
 *TODO
 *2017年12月12日下午8:06:33
 */
public class User {
   private int userId;
   private String userName;
   private String userSex;
   private String brithday;
   private String address;
   private String phone;
   private int deptId;
   
   //
   private Dept dept;



public User() {
	super();
	// TODO Auto-generated constructor stub
}



public User(int userId, String userName, String userSex, String brithday, String address, String phone, int deptId,
		Dept dept) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.userSex = userSex;
	this.brithday = brithday;
	this.address = address;
	this.phone = phone;
	this.deptId = deptId;
	this.dept = dept;
}



public User(int userId, String userName, String userSex, String brithday, String address, String phone, int deptId) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.userSex = userSex;
	this.brithday = brithday;
	this.address = address;
	this.phone = phone;
	this.deptId = deptId;
}



public int getUserId() {
	return userId;
}



public void setUserId(int userId) {
	this.userId = userId;
}



public String getUserName() {
	return userName;
}



public void setUserName(String userName) {
	this.userName = userName;
}



public String getUserSex() {
	return userSex;
}



public void setUserSex(String userSex) {
	this.userSex = userSex;
}



public String getBrithday() {
	return brithday;
}



public void setBrithday(String brithday) {
	this.brithday = brithday;
}



public String getAddress() {
	return address;
}



public void setAddress(String address) {
	this.address = address;
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



public Dept getDept() {
	return dept;
}



public void setDept(Dept dept) {
	this.dept = dept;
}



@Override
public String toString() {
	return  userId + "," + userName + ", " + userSex + ", " + brithday
			+ ", " + address + "," + phone + ", " + dept;
}
   
   
   
}
