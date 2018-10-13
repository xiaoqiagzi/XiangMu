package com.dao.service;

import java.io.Serializable;
import java.util.List;

import com.dao.util.PageInfo;

public interface BaseService<T> {
	/**
	 * 增加方法
	 * @return 
	 */
	int save(T t);

	/**
	 * 删除方法
	 */
	void delete(Serializable t);

	/**
	 * 修改方法
	 */
	void update(T t);

	/**
	 * 查看全部方法
	 */
	List<T> findAll();
	/**
	 * 返回单条
	 */
	T findById(Serializable t);
	/**
	 * 查寻总记录数
	 * 
	 */
	int getToalCount();
	/**
	 * 查询所有分页的集合
	 */
	PageInfo<T> findAlls(int pageNum, int pageSize, String seek);
	/**
	 * 删除方法
	 */
	void delAll(String[] prem);
	
	
	
	
}
