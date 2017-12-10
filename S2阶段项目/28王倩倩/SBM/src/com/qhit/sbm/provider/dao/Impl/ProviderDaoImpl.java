package com.qhit.sbm.provider.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.dao.ProviderDao;
import com.qhit.sbm.utils.DBManage;

public class ProviderDaoImpl implements ProviderDao {
		private Connection con=null;
		private PreparedStatement ps=null;
	@Override
	public List<Provider> getAllProvider() {
		con=DBManage.getConnection();
		List<Provider> list=new ArrayList<Provider>();
		Provider provider=null;
		String sql="select * from t_provider";
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				provider = new Provider(
						rs.getInt("providerId"), 
						rs.getString("providerName"), 
						rs.getString("providerDetail"), 
						rs.getString("contact"), 
						rs.getString("phone"), 
						rs.getString("facsimile"), 
						rs.getString("address"));
				list.add(provider);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}


	

}
