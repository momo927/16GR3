package com.qhit.lh.gr3.momo.exam.common.dao;

import com.qhit.lh.gr3.momo.exam.common.bean.User;

/**
 * 
 * @author 王倩倩
 *TODO
 *2017年12月27日下午9:00:09
 */
public interface UserDao {
	/**
	 * 
	 * @return
	 * 登录
	 */
      public User login(User user);
}
