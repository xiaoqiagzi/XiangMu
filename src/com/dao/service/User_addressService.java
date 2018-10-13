package com.dao.service;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.User;
import com.dao.bean.User_address;

/**
	 * 用户地址  逻辑层正删改查接口
	 * -------------------
	 * 
	 * 	 ^-^: 吉祥龙龙
	 * 2018年4月9日下午2:53:38
	 */
public interface User_addressService {

	/**
	 * 新增
	 */
	void add(User_address t);
	/**
	 * 删除
	 */
	void delete(Serializable id);
	/**
	 * 修改
	 */
	void update(User_address t);
	/**
	 * 查询所有 
	 */
	List<User_address> fundAll();
	
	/**
	 * 根据ID查询指定的信息
	 */
	User_address findById(Serializable id);
	
}
