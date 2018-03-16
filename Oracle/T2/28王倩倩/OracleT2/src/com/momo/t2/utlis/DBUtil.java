package com.momo.t2.utlis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.DefaultButtonModel;

/**
 * 
 * @author MOMO
 *2018年3月16日上午9:03:06
 * DBUtil
 */
public class DBUtil {
private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
private static String DriverName = "oracle.jdbc.driver.OracleDriver";
private static String name = "sys as sysdba";
private static String password = "123456";
private static Connection con;
public static Connection getConnection(){
	try {
		//驱动链接
		con = DriverManager.getConnection(url, name, password);
		
		Class.forName(DriverName);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return con;
	
}
}
