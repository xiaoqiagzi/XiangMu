package com.dao.service.impl;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.Easybuy_product_category;
import com.dao.dao.Easybuy_product_categoryDao;
import com.dao.dao.UserDao;
import com.dao.dao.impl.Easybuy_product_categoryDaoImpl;
import com.dao.dao.impl.UserDaoImpl;
import com.dao.service.Easybuy_product_categoryService;
/**
 * 商品种类  逻辑层
 * -------------------
 * 
 * 	 ^-^: 吉祥龙龙
 * 2018年4月9日下午3:37:23
 */
public class Easybuy_product_categoryServiceImpl implements Easybuy_product_categoryService {
		
	
	//实例化dao层对象  但是这种方式不可取 是耦合的!
	 Easybuy_product_categoryDao easybuy_product_categorydao  = new  Easybuy_product_categoryDaoImpl();
	
	
	/**
	 * 新增
	 */
	@Override
	public void add(Easybuy_product_category t) {
		int rowNum=easybuy_product_categorydao.add(t);
		
		if (rowNum>0) {
			System.out.println("新增成功");
		}else {
			System.out.println("新增失败");
		}
		
	}
	/**
	 * 删除
	 */
	@Override
	public void delete(Serializable id) {
			
		int rowNum=easybuy_product_categorydao.delete(id);
		if (rowNum>0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
		
	}	
	/**
	 * 修改
	 */
	@Override
	public void update(Easybuy_product_category t) {
		int rowNum =easybuy_product_categorydao.update(t);
		if (rowNum>0) {
			System.err.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
		
		
		
	}
	/**
	 * 查询所有
	 */
	@Override
	public List<Easybuy_product_category> fundAll() {
		
		
		return easybuy_product_categorydao.fundAll();
	}
	
	
	
	/**
	 * 查询指定id
	 */
	@Override
	public Easybuy_product_category findById(Serializable id) {
		// TODO Auto-generated method stub
		return easybuy_product_categorydao.findById(id);
	}

}
