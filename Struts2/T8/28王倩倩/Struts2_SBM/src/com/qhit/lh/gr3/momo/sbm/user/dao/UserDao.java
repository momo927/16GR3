package com.qhit.lh.gr3.momo.sbm.user.dao;

import java.sql.SQLException;
import java.util.List;

import com.qhit.lh.gr3.momo.sbm.user.bean.User;

/**
 * @author 王倩倩
 *TODO
 *2017年12月10日上午9:41:56
 */

public interface UserDao {
    
	/**
	 * 
	 * @param user
	 * @return
	 * 添加用户
	 * @throws SQLException 
	 */
	public int addUser(User user) throws SQLException;
	/**
	 * 
	 * @return
	 * 查询全部用户
	 * @throws SQLException 
	 */
	public List<User> getAllUser() throws SQLException;
	/**
	 * 
	 * @param userName
	 * @param userPassword
	 * @return
	 * 登录的数据访问
	 * @throws SQLException 
	 */
	public User doLogin(String userName,String userPassword) throws SQLException;
	
	
}
