package com.jay.t4.service.impl;

import com.jay.t4.bean.UserInfo;
import com.jay.t4.dao.impl.UserDaoImpl;
import com.jay.t4.service.UserService;

public class UserServiceImpl implements UserService {
	
	
	@Override
	public int addUser(UserInfo user) {
		
		return new UserDaoImpl().addUser(user);
	}

}
