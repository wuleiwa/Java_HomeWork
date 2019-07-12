package com.zzti.daoimpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.zzti.dao.PersonalDAO;
import com.zzti.entity.PersonalInfoDO;
import com.zzti.util.dbcp.DBUtil.DBUtil;

public class PersonalDAOImpl implements PersonalDAO{

	@Override
	public PersonalInfoDO getPersonalInfo(String username) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryrunner = new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from personalInfo where username = ?";
		PersonalInfoDO p = queryrunner.query(sql, new BeanHandler<PersonalInfoDO>(PersonalInfoDO.class),username);
		return p;
	}

	@Override
	public void setPersonalInfo(String username, PersonalInfoDO p) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryrunner = new QueryRunner(DBUtil.getDataSource());
		String sql = "insert info personalInfo values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] {
				username,
				p.getAge(),
				p.getGender(),
				p.getAddress(),
				p.getTel(),
				p.getEmail(),
				p.getGraduateSchool(),
				p.getHighestEducation(),
				p.getMajor(),
				p.getRealName()
				
		};
		queryrunner.update(sql,params);
		
	}
	

}
