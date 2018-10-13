package com.dao.service;

import com.dao.bean.Shopping_cart;
import com.dao.dao.BaseDao;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
public interface Shopping_cartService extends BaseService<Shopping_cart>{

	Shopping_cart findById(Serializable t, Serializable t1);
	
	//增加
	int save(String a, String b, int c);

	List<Shopping_cart> UID(int id);

}