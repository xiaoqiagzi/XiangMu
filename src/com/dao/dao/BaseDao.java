	package com.dao.dao;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.News;
import com.dao.bean.Shopping_cart;

/**
 *	所有接口的公共接口
 */
public interface BaseDao<T> {
	/**
	 * 新增
	 */
	int add(T t);
	/**
	 * 删除
	 */
	int delete(Serializable id);
	/**
	 * 修改
	 */
	int update(T t);
	/**
	 * 查询所有 
	 */
	List<T> fundAll();
	
	/**
	 * 根据ID查询指定的信息
	 */
	T findById(Serializable id);
	
}
