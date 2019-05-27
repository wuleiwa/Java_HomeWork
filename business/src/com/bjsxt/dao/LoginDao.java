package com.bjsxt.dao;

import com.bjsxt.pojo.User;

public interface LoginDao {
	//数据库层的接口
	User checkLoginDao(String uname, String pwd);
}
