package com.dao.service;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.Easybuy_product_category;
import com.dao.bean.User;

/**
	 * 商品种类  逻辑层增删改查接口
	 * -------------------
	 * 
	 * 	 ^-^: 吉祥龙龙
	 * 2018年4月9日下午3:35:22
	 */
public interface Easybuy_product_categoryService {
	
	
	
	/**
	 * 新增
	 */
	void add(Easybuy_product_category t);
	/**
	 * 删除
	 */
	void delete(Serializable id);
	/**
	 * 修改
	 */
	void update(Easybuy_product_category t);
	/**
	 * 查询所有 
	 */
	List<Easybuy_product_category> fundAll();
	
	/**
	 * 根据ID查询指定的信息
	 */
	Easybuy_product_category findById(Serializable id);
	
	
}
