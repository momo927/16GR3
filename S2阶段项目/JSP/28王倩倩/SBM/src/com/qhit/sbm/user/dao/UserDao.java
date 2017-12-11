package com.qhit.sbm.user.dao;

import com.qhit.sbm.user.bean.User;

public interface UserDao {
	 //查找登录名和密码
	public User doLogin(String userName,String passWord);
	/**
	 * 
	 * @param user
	 * @return
	 * 添加用户
	 */
	public int addUser(User user);
}
