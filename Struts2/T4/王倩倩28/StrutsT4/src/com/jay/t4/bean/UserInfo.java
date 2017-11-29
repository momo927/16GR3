package com.jay.t4.bean;

public class UserInfo {
	private String uname;
	private String upwd;
	private String[] like;
	private String aducation;
	private int sex;
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(String uname, String upwd, String[] like, String aducation, int sex) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.like = like;
		this.aducation = aducation;
		this.sex = sex;
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
	public String[] getLike() {
		return like;
	}
	public void setLike(String[] like) {
		this.like = like;
	}
	public String getAducation() {
		return aducation;
	}
	public void setAducation(String aducation) {
		this.aducation = aducation;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
}
