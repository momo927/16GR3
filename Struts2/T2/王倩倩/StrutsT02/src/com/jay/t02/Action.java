package com.jay.t02;

public class Action implements com.opensymphony.xwork2.Action {
		private String content;
		private String uname;
		private String upwd;
	@Override
	public String execute() throws Exception {
		content="你好："+uname+"......"+"你的密码是："+upwd;
		return SUCCESS;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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

}
