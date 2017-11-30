package com.jay.t03.action;

import com.jay.t03.bean.UserInfo;
import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
		private String content;
		private UserInfo userinfo;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return Action.SUCCESS;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

}
