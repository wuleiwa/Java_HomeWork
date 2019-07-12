package com.zzti.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtils{

	public static final String url = "jdbc:mysql://localhost:3306/business?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";  
    public static final String name = "com.mysql.cj.jdbc.Driver";  
    
    public static final String user = "root";  
    public static final String password = "123456";  
		public static Connection getConnection(){
			Connection conn=null;
				try {
					Class.forName(name);
						conn=DriverManager.getConnection(url, user, password);
					} catch (Exception e) {
						e.printStackTrace();
			}
			return conn;
		}      
		public static void close(ResultSet rs,PreparedStatement stmt,Connection conn)
		{
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
