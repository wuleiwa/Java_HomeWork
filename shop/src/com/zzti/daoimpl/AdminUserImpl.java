package com.zzti.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzti.dao.AdminUserDao;
import com.zzti.entity.User;
import com.zzti.util.DBUtils;

public class AdminUserImpl implements AdminUserDao {
	private Connection coon=null;
	private PreparedStatement p=null;
	private ResultSet rs=null;
	@Override
	public User checkUser(String username, String password) {
		coon=DBUtils.getConnection();
		User user=new User();
		String sql="select * from t_user where uname=? and pwd=?";
		try {
			p=coon.prepareStatement(sql);
			p.setString(1, username);
			p.setString(2, password);
			rs=p.executeQuery();
			if(rs.next()) {
				user.setId(rs.getString(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setGender(rs.getString(4));
				user.setTel(rs.getString(5));
				user.setInfo(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, p, coon);
		}
		return user;
	}
	@Override
	public void addUser(User user) {
		coon=DBUtils.getConnection();
		String sql="insert into users values(?,?,?,?,?,?)";
		try {
			p=coon.prepareStatement(sql);
			p.setString(1, user.getId());
			p.setString(2, user.getUsername());
			p.setString(3, user.getPassword());
			p.setString(4, user.getGender());
			p.setString(5, user.getTel());
			p.setString(6, user.getInfo());
			p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, p, coon);
		}
	}
	@Override
	public void updateUser(User user) {
		coon=DBUtils.getConnection();
		String sql="update t_user set username=?,password=?,gender=?,tel=?,info=? where id=?";
		try {
			p=coon.prepareStatement(sql);
			p.setString(1, user.getUsername());
			p.setString(2, user.getPassword());
			p.setString(3, user.getGender());
			p.setString(4, user.getTel());
			p.setString(5,user.getInfo());
			p.setString(6, user.getId());
			p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, p, coon);
		}
	}

}
