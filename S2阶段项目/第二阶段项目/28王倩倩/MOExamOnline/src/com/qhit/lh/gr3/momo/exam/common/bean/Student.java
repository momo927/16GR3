package com.qhit.lh.gr3.momo.exam.common.bean;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private String sid;
	private String sname;
	private String sex;
	private String enterSchool;
	private String ccode;
	private String photo;
	private String brithday;
	private String idCard;
	private String poutlook;
	private String province;
	private String city;
	private String tel;
	private String address;
	private String ptel;
	private String prelation;
	private String hostelBuil;
	private String hostelNo;
	private String baseInfo;
	private String eduBag;
	private String remarks;

	//1-1
	private User user;
	
	// Constructors

	
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Student(String sid, String sname, String sex, String enterSchool, String ccode, String photo,
			String brithday, String idCard, String poutlook, String province, String city, String tel, String address,
			String ptel, String prelation, String hostelBuil, String hostelNo, String baseInfo, String eduBag,
			String remarks) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.enterSchool = enterSchool;
		this.ccode = ccode;
		this.photo = photo;
		this.brithday = brithday;
		this.idCard = idCard;
		this.poutlook = poutlook;
		this.province = province;
		this.city = city;
		this.tel = tel;
		this.address = address;
		this.ptel = ptel;
		this.prelation = prelation;
		this.hostelBuil = hostelBuil;
		this.hostelNo = hostelNo;
		this.baseInfo = baseInfo;
		this.eduBag = eduBag;
		this.remarks = remarks;
	}



	public Student(String sid, String sname, String sex, String enterSchool, String ccode, String photo,
			String brithday, String idCard, String poutlook, String province, String city, String tel, String address,
			String ptel, String prelation, String hostelBuil, String hostelNo, String baseInfo, String eduBag,
			String remarks, User user) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.enterSchool = enterSchool;
		this.ccode = ccode;
		this.photo = photo;
		this.brithday = brithday;
		this.idCard = idCard;
		this.poutlook = poutlook;
		this.province = province;
		this.city = city;
		this.tel = tel;
		this.address = address;
		this.ptel = ptel;
		this.prelation = prelation;
		this.hostelBuil = hostelBuil;
		this.hostelNo = hostelNo;
		this.baseInfo = baseInfo;
		this.eduBag = eduBag;
		this.remarks = remarks;
		this.user = user;
	}



	public String getSid() {
		return sid;
	}



	public void setSid(String sid) {
		this.sid = sid;
	}



	public String getSname() {
		return sname;
	}



	public void setSname(String sname) {
		this.sname = sname;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getEnterSchool() {
		return enterSchool;
	}



	public void setEnterSchool(String enterSchool) {
		this.enterSchool = enterSchool;
	}



	public String getCcode() {
		return ccode;
	}



	public void setCcode(String ccode) {
		this.ccode = ccode;
	}



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public String getBrithday() {
		return brithday;
	}



	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}



	public String getIdCard() {
		return idCard;
	}



	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}



	public String getPoutlook() {
		return poutlook;
	}



	public void setPoutlook(String poutlook) {
		this.poutlook = poutlook;
	}



	public String getProvince() {
		return province;
	}



	public void setProvince(String province) {
		this.province = province;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPtel() {
		return ptel;
	}



	public void setPtel(String ptel) {
		this.ptel = ptel;
	}



	public String getPrelation() {
		return prelation;
	}



	public void setPrelation(String prelation) {
		this.prelation = prelation;
	}



	public String getHostelBuil() {
		return hostelBuil;
	}



	public void setHostelBuil(String hostelBuil) {
		this.hostelBuil = hostelBuil;
	}



	public String getHostelNo() {
		return hostelNo;
	}



	public void setHostelNo(String hostelNo) {
		this.hostelNo = hostelNo;
	}



	public String getBaseInfo() {
		return baseInfo;
	}



	public void setBaseInfo(String baseInfo) {
		this.baseInfo = baseInfo;
	}



	public String getEduBag() {
		return eduBag;
	}



	public void setEduBag(String eduBag) {
		this.eduBag = eduBag;
	}



	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return  sid + "," + sname + ", " + sex + "," + enterSchool + ", "
				+ ccode +"," +photo +"," + brithday + "," + idCard + ", " + poutlook + ","
				+ province + ", " + city + ", " + tel + ", " + address + "," + ptel
				+ "," + prelation + ", " + hostelBuil + ", " + hostelNo + ","
				+ baseInfo + "," + eduBag + ", " + remarks;
	}

}