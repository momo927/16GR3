package com.qhit.lh.gr3.momo.sbm.user.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.qhit.lh.gr3.momo.sbm.user.bean.User;
import com.qhit.lh.gr3.momo.sbm.user.dao.UserDao;
import com.qhit.lh.gr3.momo.sbm.user.dao.impl.UserDaoImpl;
import com.qhit.lh.gr3.momo.sbm.user.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userdao = new UserDaoImpl();
	@Override
	public int addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.addUser(user);
	}

	@Override
	public List<User> getAllUser() throws SQLException {
		// TODO Auto-generated method stub
		return userdao.getAllUser();
	}

	@Override
	public User doLogin(String userName, String userPassword) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.doLogin(userName, userPassword);
	}

}
