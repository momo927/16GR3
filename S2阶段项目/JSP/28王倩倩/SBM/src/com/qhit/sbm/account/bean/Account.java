package com.qhit.sbm.account.bean;

public class Account {
	private int accountId; 		//账单id
	private int providerId; 	//供应商id
	private Float totalprice; 	//账单总价格
	private int intisPayed ; 	//交易总金额
	private String accountDate; //交易时间
	private int goodsId; 		//商品id
	private int businessNum; 	//交易数量
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountId, int providerId, Float totalprice, int intisPayed, String accountDate, int goodsId,
			int businessNum) {
		super();
		this.accountId = accountId;
		this.providerId = providerId;
		this.totalprice = totalprice;
		this.intisPayed = intisPayed;
		this.accountDate = accountDate;
		this.goodsId = goodsId;
		this.businessNum = businessNum;
	}
	public int getAccountid() {
		return accountId;
	}
	public void setAccountid(int accountId) {
		this.accountId = accountId;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public Float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Float totalprice) {
		this.totalprice = totalprice;
	}
	public int getIntisPayed() {
		return intisPayed;
	}
	public void setIntisPayed(int intisPayed) {
		this.intisPayed = intisPayed;
	}
	public String getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(String accountDate) {
		this.accountDate = accountDate;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getBusinessNum() {
		return businessNum;
	}
	public void setBusinessNum(int businessNum) {
		this.businessNum = businessNum;
	}
	
}
