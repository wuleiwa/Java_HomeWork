package com.zzti.util.dbcp.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBUtil {
	private static String username;
	private static String password;
	private static String url;
	private static String driverName;
	private static DataSource ds;
	public static DataSource getDataSource() {
		return ds;
		
	}
	static {
		try {
			Properties pro = new Properties();
			pro.load(DBUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
			ds = BasicDataSourceFactory.createDataSource(pro);
			System.out.println("连接成功");
		}catch (Exception e) {
			// TODO: handle exception
			throw new ExceptionInInitializerError("初始化连接错误，请检查配置文件");
		}
	}
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}
