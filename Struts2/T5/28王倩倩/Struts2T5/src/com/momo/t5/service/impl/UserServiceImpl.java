package com.momo.t5.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.momo.t5.bean.User;
import com.momo.t5.dao.UserDao;
import com.momo.t5.dao.impl.UserDaoImpl;
import com.momo.t5.service.UserService;

public class UserServiceImpl implements UserService {
		private UserDao userdao = new UserDaoImpl();
	@Override
	public int addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.addUser(user);
	}

	@Override
	public int delectUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.delectUser(user);
	}

	@Override
	public int updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.updateUser(user);
	}

	@Override
	public List<User> getAallUser() throws SQLException {
		// TODO Auto-generated method stub
		return userdao.getAallUser();
	}

	@Override
	public User getUserByid(User user) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.getUserByid(user);
	}

}
