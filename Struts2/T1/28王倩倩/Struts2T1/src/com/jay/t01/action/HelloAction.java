package com.jay.t01.action;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
	private String content;
	private String username;
	@Override
	public String execute() throws Exception {
		content="你好:"+username;
		return Action.SUCCESS;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}
