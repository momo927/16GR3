package com.qhit.sbm.user.service.Impl;

import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.dao.UserDao;
import com.qhit.sbm.user.dao.Impl.UserDaoImpl;
import com.qhit.sbm.user.service.UserService;

public class UserServiceImpl implements UserService {
	//查找登录名和密码
	
	@Override
	public User doLogin(String userName, String passWord) {
		
		return new UserDaoImpl().doLogin(userName, passWord);
	}

	@Override
	public int addUser(User user) {
		
		return new UserDaoImpl().addUser(user);
	}
		
		
}
