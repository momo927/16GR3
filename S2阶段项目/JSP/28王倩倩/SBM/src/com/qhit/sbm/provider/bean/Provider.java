package com.qhit.sbm.provider.bean;

public class Provider {
	 
	private int providerId;  		//供应商id	
	private String providerName; 	//供应商名字		
	private String providerDetail; 	//供应商描述				
	private String contact; 		//联系人
	private String phone; 			//供应商电话
	private String facsimile; 		//供应商传真
	private String address; 		//供应商地址
	public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Provider(int providerId, String providerName, String providerDetail, String contact, String phone,
			String facsimile, String address) {
		super();
		this.providerId = providerId;
		this.providerName = providerName;
		this.providerDetail = providerDetail;
		this.contact = contact;
		this.phone = phone;
		this.facsimile = facsimile;
		this.address = address;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getProviderDetail() {
		return providerDetail;
	}
	public void setProviderDetail(String providerDetail) {
		this.providerDetail = providerDetail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFacsimile() {
		return facsimile;
	}
	public void setFacsimile(String facsimile) {
		this.facsimile = facsimile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
