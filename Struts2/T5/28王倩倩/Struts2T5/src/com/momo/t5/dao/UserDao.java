package com.momo.t5.dao;

import java.sql.SQLException;
import java.util.List;

import com.momo.t5.bean.User;

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
		 * @param user
		 * @return
		 * 删除用户
		 * @throws SQLException 
		 */
		public int delectUser(User user) throws SQLException;
		/**
		 * 
		 * @param user
		 * @return
		 * 添加用户
		 * @throws SQLException 
		 */
		public int updateUser(User user) throws SQLException;
		/**
		 * 
		 * @return
		 * 查询所有用户
		 * @throws SQLException 
		 */
		public List<User> getAallUser() throws SQLException;
		/**
		 * 
		 * @param user
		 * @return
		 * 根据id查询
		 * @throws SQLException 
		 */
		public User getUserByid(User user) throws SQLException;
		
}
