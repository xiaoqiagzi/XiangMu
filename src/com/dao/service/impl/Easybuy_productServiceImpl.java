package com.dao.service.impl;

import java.io.Serializable;
import java.util.List;


import com.dao.bean.Easybuy_product;
import com.dao.bean.Shopping_cart;
import com.dao.dao.Easybuy_productDao;

import com.dao.dao.impl.Easybuy_productDaoImpl;
import com.dao.service.Easybuy_productService;
import com.dao.util.PageInfo;


	/**
	 * 商品的逻辑层   service
	 * -------------------
	 * 
	 * 	 ^-^: 吉祥龙龙
	 * 2018年4月9日下午3:05:06
	 */
public class Easybuy_productServiceImpl implements Easybuy_productService {
	
	//实例化dao层对象  但是这种方式不可取 是耦合的!
	private Easybuy_productDao epd = new Easybuy_productDaoImpl();
	Shopping_cart aa = new Shopping_cart();
	@Override
	public int save(Easybuy_product t) {
		int rowNum = epd.add(t);
		return rowNum;
	}

	@Override
	public void delete(Serializable t) {
		
		int rowNum = epd.delete(t);
		
		if (rowNum>0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
		
	}

	@Override
	public void update(Easybuy_product t) {
		int rowNum = epd.delete(t);
		if (rowNum>0) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
		
		
	}
	
	
	
	/**
	 * 缓存查询
	 */
	@Override
	public List<Easybuy_product> findAll() {
	/*	System.out.println("进入缓存查询！！！");
		List<Easybuy_product> list=epd.fundAll();*/
		
		
		return epd.fundAll();
	}
	/**
	 * 数据库查询
	 */
	@Override
	public Easybuy_product findById(Serializable t) {
		System.out.println("进入数据库中查询");
		Easybuy_product id =epd.findById(t);
		
		
		return id;
	}

	@Override
	public int getToalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<Easybuy_product> findAlls(int pageNum, int pageSize, String seek) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delAll(String[] prem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCart(String id, Shopping_cart Shopping_cart) {
		//从数据库中获取商品
		Easybuy_product ep = epd.findById(id);
		System.out.println(ep);
		//把商品放进购物车
		Shopping_cart.addProduct(ep);
		
		
	}



	
	
	
}
