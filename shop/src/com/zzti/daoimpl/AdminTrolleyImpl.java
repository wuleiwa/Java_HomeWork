package com.zzti.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zzti.entity.Trolley;
import com.zzti.util.DBUtils;

public class AdminTrolleyImpl implements com.zzti.dao.AdminTrolley{
	private Connection coon=null;
	private PreparedStatement p=null;
	private ResultSet rs=null;
	public ArrayList<Trolley> findAllTrolley() {
		ArrayList<Trolley> list=new ArrayList<>();
		coon=DBUtils.getConnection();
		String sql="select * from trolley";
		try {
			p=coon.prepareStatement(sql);
			rs=p.executeQuery();
			while(rs.next()) {
				Trolley good=new Trolley();
				good.setBusiNum(rs.getInt(1));
				good.setBusiName(rs.getString(2));
				good.setBusiType(rs.getString(3));
				good.setBusiValue(rs.getInt(4));
//				good.setGoods_count(rs.getInt(5));
				list.add(good);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, p, coon);
		}
		return list;
	}
	
	@Override
	public void deleteTrolley(String id) {
		coon=DBUtils.getConnection();
		String sql="delete from busi where busiNum=?";
		try {
			p=coon.prepareStatement(sql);
			p.setString(1, id);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, p, coon);
		}
	}

	@Override
	public Trolley findTrolley(String id) {
		// TODO Auto-generated method stub
		coon=DBUtils.getConnection();
		String sql="select * from torlley where busiNum=?";
		Trolley good=new Trolley();
		try {
			p=coon.prepareStatement(sql);
			p.setString(1, id);
			rs=p.executeQuery();
			if(rs.next()) {
				
				good.setBusiNum(rs.getInt(1));
				good.setBusiName(rs.getString(2));
				good.setBusiType(rs.getString(3));
				good.setBusiValue(rs.getInt(4));
//				good.setGoods_count(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, p, coon);
		}
		return good;
	}
	@Override
	public void addTrolley(Trolley goods) {
		// TODO Auto-generated method stub
		coon=DBUtils.getConnection();
		String sql="insert  into trolley values(?,?,?,?,?)";
		try {
			p=coon.prepareStatement(sql);
			p.setInt(1, goods.getBusiNum());
			p.setString(2, goods.getBusiName());
			p.setString(3, goods.getBusiType());
			p.setInt(4, goods.getBusiValue());
//			p.setInt(5, goods.getGoods_count());
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, p, coon);
		}
	}
}
