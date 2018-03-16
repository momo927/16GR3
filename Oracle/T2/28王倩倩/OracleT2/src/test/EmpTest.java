package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.momo.t2.bean.Emp;
import com.momo.t2.utlis.DBUtil;
/**
 * 
 * @author MOMO
 *2018年3月16日上午9:26:41
 * EmpTest
 */
public class EmpTest {
	private String sql = "select * from emp";
	private Emp emp;
	@Test
	public void test() {
		   //创建连接对象
		   Connection con = DBUtil.getConnection();
		
		try {
			//创建预编译对象
			PreparedStatement ps = con.prepareStatement(sql);
			//执行
			ResultSet rs = ps.executeQuery();
			//
			if(rs.next()){
				emp = new Emp(
						rs.getInt("eid"),
						rs.getString("ename"), 
						rs.getInt("age"), 
						rs.getString("loc")
						);
				System.out.println(emp+",,,,,,");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
