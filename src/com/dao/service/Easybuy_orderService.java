package com.dao.service;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.Easybuy_order;
import com.dao.bean.User;

public interface Easybuy_orderService {
	/**
	 * 新增
	 */
	void add(Easybuy_order t);
	/**
	 * 删除
	 */
	void delete(Serializable id);
	/**
	 * 修改
	 */
	void update(Easybuy_order t);
	/**
	 * 查询所有 
	 */
	List<Easybuy_order> fundAll();
	
	/**
	 * 根据ID查询指定的信息
	 */
	Easybuy_order findById(Serializable id);
	
}
