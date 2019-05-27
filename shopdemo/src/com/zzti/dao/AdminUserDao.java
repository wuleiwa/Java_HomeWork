package com.zzti.dao;

import com.zzti.entity.User;

public interface AdminUserDao {
	User checkUser(String username,String password);
	void addUser(User user);
	void updateUser(User user);
}
