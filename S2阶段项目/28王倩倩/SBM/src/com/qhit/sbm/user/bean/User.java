package com.qhit.sbm.user.bean;

public class User {
	private int userid; 			//用户id
	private String userName; 		//用户名
	private String userPassWord;	//用户密码
	private String userSex; 		//用户性别
	private int userAge; 			//用户年龄
	private String phone; 			//用户电话
	private String address; 		//用户地址
	private String pic; 			//头像地址
	private int type; 				//用户类型
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userid, String userName, String userPassWord, String userSex, int userAge, String phone,
			String address, String pic, int type) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.userPassWord = userPassWord;
		this.userSex = userSex;
		this.userAge = userAge;
		this.phone = phone;
		this.address = address;
		this.pic = pic;
		this.type = type;
	}
	
	public User(String userName, String userPassWord, String userSex, int userAge, String phone, String address,
			String pic, int type) {
		super();
		this.userName = userName;
		this.userPassWord = userPassWord;
		this.userSex = userSex;
		this.userAge = userAge;
		this.phone = phone;
		this.address = address;
		this.pic = pic;
		this.type = type;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassWord() {
		return userPassWord;
	}
	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
