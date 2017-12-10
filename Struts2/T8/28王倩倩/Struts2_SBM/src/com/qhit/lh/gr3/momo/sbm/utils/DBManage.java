package com.qhit.lh.gr3.momo.sbm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManage {
	 private static String DriverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 private static String url="jdbc:sqlserver://localhost:1433;databaseName=SBM";
	 private static String userName="sa";
	 private static String userPassWord="123456";
	 private static  Connection con=null; 
	 public static Connection getConnection(){
		 //驱动链接
		 try {
			Class.forName(DriverName);
			con=DriverManager.getConnection(url,userName, userPassWord);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return con; 
	 }
	 public static void close(Statement statement, Connection con) {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	 }
}
