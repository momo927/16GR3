package com.qhit.lh.gr3.momo.t1.bean;

/**
 * @author 王倩倩
 *TODO
 *2017年12月11日下午3:31:31
 */
public class User {
	private int uid;
	private String uname;
	private String upwd;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String uname, String upwd) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	@Override
	public String toString() {
		return uid + "," + uname + "," + upwd ;
	}
	
}
