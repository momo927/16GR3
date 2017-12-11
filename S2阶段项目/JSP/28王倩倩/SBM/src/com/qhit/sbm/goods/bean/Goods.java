package com.qhit.sbm.goods.bean;

public class Goods {
	private int goodsId; 		//商品id
	private String goodsName; 	//商品名称
	private int goodsNum; 		//商品数量
	private Float goodsPrice;	//商品价格
	private String goodsNnit; 	//商品单位
	private String goodsIntro; 	//商品描述
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(int goodsId, String goodsName, int goodsNum, Float goodsPrice, String goodsNnit, String goodsIntro) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsNum = goodsNum;
		this.goodsPrice = goodsPrice;
		this.goodsNnit = goodsNnit;
		this.goodsIntro = goodsIntro;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public Float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsNnit() {
		return goodsNnit;
	}
	public void setGoodsNnit(String goodsNnit) {
		this.goodsNnit = goodsNnit;
	}
	public String getGoodsIntro() {
		return goodsIntro;
	}
	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
	}
	
}
