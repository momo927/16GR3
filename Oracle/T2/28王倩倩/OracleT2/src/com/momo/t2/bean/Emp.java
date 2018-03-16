package com.momo.t2.bean;
/**
 * 
 * @author MOMO
 *2018年3月16日上午8:58:39
 * Emp
 */
public class Emp {
private int eid;
private String ename;
private int age;
private String loc;



public Emp() {
	super();
	// TODO Auto-generated constructor stub
}



public Emp(int eid, String ename, int age, String loc) {
	super();
	this.eid = eid;
	this.ename = ename;
	this.age = age;
	this.loc = loc;
}



public int getEid() {
	return eid;
}



public void setEid(int eid) {
	this.eid = eid;
}



public String getEname() {
	return ename;
}



public void setEname(String ename) {
	this.ename = ename;
}



public int getAge() {
	return age;
}



public void setAge(int age) {
	this.age = age;
}



public String getLoc() {
	return loc;
}



public void setLoc(String loc) {
	this.loc = loc;
}



@Override
public String toString() {
	return "Emp ----eid=" + eid + ", ename=" + ename + ", age=" + age + ", loc=" + loc + "---";
}


}
