package com.zzti.dao;

import java.sql.SQLException;

import com.zzti.entity.PersonalInfoDO;

public interface PersonalDAO {
	PersonalInfoDO getPersonalInfo(String username)throws SQLException;
	void setPersonalInfo(String username,PersonalInfoDO p) throws SQLException;
}
