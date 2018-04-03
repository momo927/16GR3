package com.qhit.lh.gr3.momo.exam.common.service;

import com.qhit.lh.gr3.momo.exam.common.bean.User;
import com.qhit.lh.gr3.momo.exam.common.dao.UserDao;
import com.qhit.lh.gr3.momo.exam.common.dao.UserDaoImpl;

/**
 * 
 * @author 王倩倩
 *TODO
 *2017年12月27日下午9:01:17
 */
public class UserServiceImpl implements UserService {
private UserDao userDao =new UserDaoImpl();
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

}
