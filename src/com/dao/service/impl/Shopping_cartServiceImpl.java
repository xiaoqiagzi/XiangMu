package com.dao.service.impl;

import java.io.Serializable;
import java.util.List;


import com.dao.bean.Shopping_cart;
import com.dao.dao.Shopping_cartDao;
import com.dao.service.Shopping_cartService;
import com.dao.util.PageInfo;
import com.dao.dao.impl.Shopping_cartDaoImpl;
import java.util.Date;
public class Shopping_cartServiceImpl implements Shopping_cartService {

	Shopping_cartDao dao=new Shopping_cartDaoImpl();

	@Override
	public int save(Shopping_cart t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Serializable t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Shopping_cart t) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 查全部
	 */
	@Override
	public List<Shopping_cart> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shopping_cart findById(Serializable t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getToalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<Shopping_cart> findAlls(int pageNum, int pageSize, String seek) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delAll(String[] prem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shopping_cart findById(Serializable t, Serializable t1) {
		Shopping_cart shopping_cart =dao.findbyid(t, t1);
		return shopping_cart;
	}

	@Override
	public int save(String uid, String pid, int num) {
		int save =dao.save(uid, pid, num);
		return save;
	}

	@Override
	public List<Shopping_cart> UID(int uid) {
		List<Shopping_cart> UID = dao.UID(uid);
		return UID;
	}

	



}