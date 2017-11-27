package com.jay.t03.bean;

import java.util.Date;

public class User {
 private String name;
 private String sex;
 private String age;
 private Date birthday;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(String name, String sex, String age, Date birthday) {
	super();
	this.name = name;
	this.sex = sex;
	this.age = age;
	this.birthday = birthday;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public String getInfo(){
	return name +"|" + sex + "|" + age +"|" + birthday;
}
}

 
 
