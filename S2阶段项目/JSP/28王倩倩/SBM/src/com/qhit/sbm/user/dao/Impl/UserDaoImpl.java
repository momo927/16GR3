package com.qhit.sbm.user.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.dao.UserDao;
import com.qhit.sbm.utils.DBManage;

public class UserDaoImpl implements UserDao {
	private  Connection con=null;
	private PreparedStatement ps=null;
	private User user=null;
	/**
	 * 查找用户名和密码
	 */
	@Override
	public User doLogin(String userName, String passWord) {
		String sql="select * from t_user where userName = ? and userPassWord = ?";
		//创建连接对象
		con=DBManage.getConnection();
		//创建预编译对象
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			//执行
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				user=new User(
						rs.getInt("userid"),
						rs.getString("userName"),
						rs.getString("userPassWord"),
						rs.getString("userSex"),
						rs.getInt("userAge"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getString("pic"),
						rs.getInt("type"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManage.close(ps, con);
		}
		
		return user;
	}
	/**
	 * 添加用户
	 */
	@Override
	public int addUser(User user) {
		con=DBManage.getConnection();
		String sql="insert into t_user values (?,?,?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassWord());
			ps.setString(3, user.getUserSex());
			ps.setInt(4, user.getUserAge());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getPic());
			ps.setInt(8, user.getType());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
}
