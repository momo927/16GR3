package com.qhit.sbm.goods.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qhit.sbm.goods.bean.Goods;
import com.qhit.sbm.goods.dao.GoodsDao;
import com.qhit.sbm.utils.DBManage;

public class GoodsDaoImpl implements GoodsDao {
		private Connection con=null;
		private PreparedStatement ps=null;
		
	@Override
	public Goods getGoodsInfoByName(String goodsName) {
		con=DBManage.getConnection();
		Goods goods=null;
		String sql="select * from t_goods where goodsName = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, goodsName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				goods = new Goods(
						rs.getInt("goodsId"), 
						goodsName, 
						rs.getInt("goodsNum"), 
						rs.getFloat("goodsPrice"),
						rs.getString("goodsNnit"),
						rs.getString("goodsIntro"));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}

	@Override
	public int updateStore(int num, int goodsId) {
		con=DBManage.getConnection();
		String sql="update t_goods set goodsNum = ? where goodsId = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setInt(2, goodsId);
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
