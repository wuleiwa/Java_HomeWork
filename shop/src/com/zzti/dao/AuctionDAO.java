package com.zzti.dao;

import java.sql.SQLException;
import java.util.List;

import com.zzti.entity.AuctionDO;

public interface AuctionDAO {
	
	
	AuctionDO getAuction(String id) throws SQLException;
	void addAuction(AuctionDO auc) throws SQLException;
	List<AuctionDO> getAll() throws SQLException;
	void deleteAuction(String id) throws SQLException;
	void updateAuction(AuctionDO auc) throws SQLException;
	
}
