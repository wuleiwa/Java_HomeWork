package com.bjsxt.dao;

import com.bjsxt.pojo.User;

public interface LoginDao {
	//���ݿ��Ľӿ�
	User checkLoginDao(String uname, String pwd);
}
