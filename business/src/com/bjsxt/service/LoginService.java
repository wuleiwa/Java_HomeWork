package com.bjsxt.service;

import com.bjsxt.pojo.User;

public interface LoginService {
	//把用户名提供过来
	User checkLoginService(String uname, String pwd);
}
