package com.zzti.daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zzti.dao.AdminGoodsDao;
import com.zzti.entity.Goods;
import com.zzti.util.DBUtils;

public class AdminGoodsImpl implements AdminGoodsDao {
	private Connection coon=null;
	private PreparedStatement p=null;
	private ResultSet rs=null;
	@Override
	public ArrayList<Goods> findAllGoods() {
		ArrayList<Goods> list=new ArrayList<>();
		coon=DBUtils.getConnection();
		String sql="select * from busi";
		try {
			p=coon.prepareStatement(sql);
			rs=p.executeQuery();
			while(rs.next()) {
				Goods good=new Goods();
				good.setGoods_id(rs.getString(1));
				good.setGoods_name(rs.getString(2));
				
				good.setGoods_type(rs.getString(3));
				good.setGoods_price(rs.getDouble(4));
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
	public Goods findGoods(String id) {
		coon=DBUtils.getConnection();
		String sql="select * from busi where busiNum=?";
		Goods good=new Goods();
		try {
			p=coon.prepareStatement(sql);
			p.setString(1, id);
			rs=p.executeQuery();
			if(rs.next()) {
				good.setGoods_id(rs.getString(1));
				good.setGoods_name(rs.getString(2));
				good.setGoods_type(rs.getString(3));
				good.setGoods_price(rs.getDouble(4));
				
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
	public void deleteGoods(String id) {
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
	public void addGoods(Goods goods) {
		coon=DBUtils.getConnection();
		String sql="insert  into busi values(?,?,?,?,?)";
		try {
			p=coon.prepareStatement(sql);
			p.setString(1, goods.getGoods_id());
			p.setString(2, goods.getGoods_name());
			p.setDouble(3, goods.getGoods_price());
			p.setString(4, goods.getGoods_type());
//			p.setInt(5, goods.getGoods_count());
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, p, coon);
		}
	}
}
