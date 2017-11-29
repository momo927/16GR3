package com.jay.t4.action;

import com.jay.t4.bean.UserInfo;
import com.jay.t4.service.UserService;
import com.jay.t4.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
	private UserInfo user;
	private UserService service=new UserServiceImpl();
	@Override
	public String execute() throws Exception {
		// TODO 注册
		int row=service.addUser(user);
		if(row > 0){
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	

}
