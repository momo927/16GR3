package com.qhit.sbm.user.service;

import com.qhit.sbm.user.bean.User;

public interface UserService {
	/**查找登录名和密码
	 * 
	 * @param userName
	 * @param passWord
	 * @return
	 */
		public User doLogin(String userName,String passWord);
		
		/**
		 * 
		 * @param user
		 * @return
		 */
		public int addUser(User user);
}
