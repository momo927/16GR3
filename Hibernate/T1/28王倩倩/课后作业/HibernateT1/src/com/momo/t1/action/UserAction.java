package com.momo.t1.action;

import com.momo.t1.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
    private User user;
    private String content;
	@Override
	public String execute() throws Exception {
		content = "hello"+user; 
		return SUCCESS;
	}
    
    
    
    
}
