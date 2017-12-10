package com.qhit.lh.gr3.momo.sbm.user.dao.impl;

import java.util.List;

import com.qhit.lh.gr3.momo.sbm.user.bean.User;
import com.qhit.lh.gr3.momo.sbm.user.dao.UserDao;



	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import com.opensymphony.xwork2.Result;
	import com.qhit.lh.gr3.momo.sbm.user.bean.User;
	import com.qhit.lh.gr3.momo.sbm.user.service.UserService;
	import com.qhit.lh.gr3.momo.sbm.utils.DBManage;

	/**
	 * @author 王倩倩
	 *TODO
	 *2017年12月10日上午9:51:08
	 */
	public class UserDaoImpl implements UserDao {
		private User user;
		private Connection con;
		private PreparedStatement ps;
		
		@Override
		public int addUser(User user) throws SQLException {
			con=DBManage.getConnection();
			String sql="insert into t_user values(?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getUserSex());
			ps.setInt(4, user.getUserAge());;
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getPic());
			ps.setInt(8, user.getType());
			int row = ps.executeUpdate();
			DBManage.close(ps, con);
			return row;

			
		}

		@Override
		public List<User> getAllUser() throws SQLException {
			List<User> users = new ArrayList<User>();
			con=DBManage.getConnection();
			String sql = "select * from t_user";
			ps=con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user = new User(
						rs.getInt("userId"), 
						rs.getString("userName"),
						rs.getString("userPassword"), 
						rs.getString("userSex"), 
						rs.getInt("userAge"), 
						rs.getString("phone"), 
						rs.getString("address"),
						rs.getString("pic"), 
						rs.getInt("type"));
				users.add(user);
			}
			DBManage.close(ps, con);
			return users;
		}

		@Override
		public User doLogin(String userName, String userPassword) throws SQLException {
			con=DBManage.getConnection();
			String sql = "select * from t_user where userName = ? and userPassword = ?";
			ps=con.prepareStatement(sql);
			ps.setString(1,userName );
			ps.setString(2, userPassword);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User(
						rs.getInt("userId"), 
						rs.getString("userName"),
						rs.getString("userPassword"), 
						rs.getString("userSex"), 
						rs.getInt("userAge"), 
						rs.getString("phone"), 
						rs.getString("address"),
						rs.getString("pic"), 
						rs.getInt("type"));
			}
			DBManage.close(ps, con);
			
			return user;
		}
}
