package com.momo.t1.bean;

/**
 * @author 王倩倩
 *TODO
 *2017年12月20日上午11:44:21
 */
public class User {
   private int uId;
   private String uname;
   private String password;
public User(int uId, String uname, String password) {
	super();
	this.uId = uId;
	this.uname = uname;
	this.password = password;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public int getuId() {
	return uId;
}
public void setuId(int uId) {
	this.uId = uId;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "User [uId=" + uId + ", uname=" + uname + ", password=" + password + "]";
}
   
   
   
   
}
