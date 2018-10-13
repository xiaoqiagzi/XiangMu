package com.dao.service;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.Easybuy_order_detail;
import com.dao.bean.User;
/**
 * 用户消费   逻辑层  增删改查接口
 * -------------------
 * 
 * 	 ^-^: 吉祥龙龙
 * 2018年4月9日下午3:56:59
 */
public interface Easybuy_order_detailService {
	/**
	 * 新增
	 */
	void add(Easybuy_order_detail t);
	/**
	 * 删除
	 */
	void delete(Serializable id);
	/**
	 * 修改
	 */
	void update(Easybuy_order_detail t);
	/**
	 * 查询所有 
	 */
	List<Easybuy_order_detail> fundAll();
	
	/**
	 * 根据ID查询指定的信息
	 */
	Easybuy_order_detail findById(Serializable id);
}
