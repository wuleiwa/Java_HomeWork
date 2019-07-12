package com.zzti.daoimpl;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zzti.dao.AuctionDAO;
import com.zzti.entity.AuctionDO;
import com.zzti.util.dbcp.DBUtil.DBUtil;

public class AuctionDAOImpl implements AuctionDAO{

	@Override
	public AuctionDO getAuction(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryrunner = new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from auction where id = ?";
		AuctionDO auctionDO = queryrunner.query(sql, new BeanHandler<AuctionDO>(AuctionDO.class),id);
		return auctionDO;
	}

	@Override
	public void addAuction(AuctionDO auc) throws SQLException{
		// TODO Auto-generated method stub
		QueryRunner queryrunner = new QueryRunner(DBUtil.getDataSource());
		String sql = "insert into auction values(?,?,?,?)";
		Object[] params = new Object[] {UUID.randomUUID().toString(),auc.getTitle(),auc.getDescription(),auc.getPrice()};
		queryrunner.update(sql,params);
	}

	@Override
	public List<AuctionDO> getAll() throws SQLException{
		// TODO Auto-generated method stub
		QueryRunner queryrunner = new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from auction ";
		List<AuctionDO> list = queryrunner.query(sql, new BeanListHandler<AuctionDO>(AuctionDO.class));
		
		return list;
	}

	@Override
	public void deleteAuction(String id) throws SQLException{
		// TODO Auto-generated method stub
		QueryRunner queryrunner = new QueryRunner(DBUtil.getDataSource());
		String sql = "delete from auction where if = ?";
		queryrunner.update(sql, id);
		
	}

	@Override
	public void updateAuction(AuctionDO auc) throws SQLException{
		// TODO Auto-generated method stub
		QueryRunner queryrunner = new QueryRunner(DBUtil.getDataSource());
		String sql = "update auction set title  = ?,description = ?,price = ?, where id = ?";
		Object[] params  = new Object[] {auc.getTitle(),auc.getDescription(),auc.getPrice()};
		queryrunner.update(sql, params);
	}
	
	
}
