package com.jay.t4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jay.t4.bean.UserInfo;
import com.jay.t4.dao.UserDao;
import com.jay.t4.utils.DBManage;

public class UserDaoImpl implements UserDao {
	private Connection con;
	private PreparedStatement ps;
	
	@Override
	public int addUser(UserInfo user) {
		con=DBManage.getConnection();
		String sql="insert into suser values(?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			ps.setString(3, user.getAducation());
			ps.setInt(4, user.getSex());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
