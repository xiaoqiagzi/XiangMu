package com.dao.dao;

import com.dao.bean.Shopping_cart;

import java.io.Serializable;
import java.util.*;
import java.util.Date;
public interface Shopping_cartDao extends BaseDao<Shopping_cart>{

	List<Shopping_cart> UID(int uid);


	Shopping_cart findbyid(Serializable t, Serializable t1);

	int save(String a, String b, int c);



	
}	