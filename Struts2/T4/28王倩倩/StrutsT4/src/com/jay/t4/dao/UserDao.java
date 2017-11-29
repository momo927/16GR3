package com.jay.t4.dao;

import com.jay.t4.bean.UserInfo;

public interface UserDao {
	/**
	 * 
	 * @param user
	 * @return
	 * 注册
	 */
	public int addUser(UserInfo user);
}
