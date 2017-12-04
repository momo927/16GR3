package com.momo.t5.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.momo.t5.bean.User;
import com.momo.t5.dao.UserDao;
import com.momo.t5.util.DBManage;

public class UserDaoImpl implements UserDao {
	private Connection con;
	private PreparedStatement ps;
	
	@Override
	public int addUser(User user) throws SQLException {
		// TODO 
		con=DBManage.getConnection();
		String sql="insert into users values(?,?,?,?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getUpwd());
		ps.setString(3, user.getBirthday());
		ps.setString(4, user.getPhone());
		ps.setInt(5, user.getSex());
		ps.setInt(6, user.getActive());
		int row=ps.executeUpdate();
		DBManage.close(ps, con);
		return row;
	}

	@Override
	public int delectUser(User user) throws SQLException {
		con=DBManage.getConnection();
		String sql="delete from users where id = ? ";
		ps=con.prepareStatement(sql);
		ps.setInt(1, user.getId());
		int row = ps.executeUpdate();
		DBManage.close(ps, con);
		return row;
	}

	@Override
	public int updateUser(User user) throws SQLException {
		con=DBManage.getConnection();
		String sql = "update users set uname = ?, upwd = ?, birthday = ?, phone = ?, sex = ?, active = ? ";
		ps=con.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getUpwd());
		ps.setString(3, user.getBirthday());
		ps.setString(4, user.getPhone());
		ps.setInt(5, user.getSex());
		ps.setInt(6, user.getActive());
		int row = ps.executeUpdate();
		DBManage.close(ps, con);
		return row;
	}

	@Override
	public List<User> getAallUser() throws SQLException {
		List<User> userlist = new ArrayList<User>();
		con=DBManage.getConnection();
		String sql = "select * from users";
		ps=con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			User user = new User(
					rs.getInt("id"),
					rs.getString("uname"), 
					rs.getString("upwd"),
					rs.getString("birthday"),
					rs.getString("phone"),
					rs.getInt("sex"),
					rs.getInt("active"));
			userlist.add(user);
		}
		DBManage.close(ps, con);
		return userlist;
	}

	@Override
	public User getUserByid(User user) throws SQLException {
		con=DBManage.getConnection();
		User users=null;
		String sql = "select * from users where id = ? ";
		ps=con.prepareStatement(sql);
		ps.setInt(1, user.getId());
		ResultSet rs =ps.executeQuery();
		while(rs.next()){
			users = new User(
					rs.getInt("id"),
					rs.getString("uname"), 
					rs.getString("upwd"),
					rs.getString("birthday"),
					rs.getString("phone"),
					rs.getInt("sex"),
					rs.getInt("active"));
			
		}
		DBManage.close(ps, con);
		return users;
	}

}
