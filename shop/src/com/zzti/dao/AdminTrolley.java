package com.zzti.dao;

import java.util.ArrayList;

import com.zzti.entity.Trolley;



public interface AdminTrolley {
	ArrayList<Trolley> findAllTrolley();
	Trolley findTrolley(String id);
	void deleteTrolley(String id);
	void addTrolley(Trolley goods);
}
