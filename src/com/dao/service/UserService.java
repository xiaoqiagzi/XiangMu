package com.dao.service;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.User;

/**
 * 用户 逻辑层增删改查接口 -------------------
 * 
 * ^-^: 吉祥龙龙 2018年4月9日上午11:25:26
 */
public interface UserService {
	/**
	 * 用户类独有的 登录功能
	 */
	User login(String loginName, String password);
	
	 /**
	  * 判断登录名是否被存在
	  */
	boolean finbyName(String loginName);
	/**
	 * 新增
	 */
	boolean addUser(User t);

	/**
	 * 删除
	 */
	boolean deleteUser(Serializable id);

	/**
	 * 修改
	 */
	boolean updateUser(User t);

	/**
	 * 查询所有
	 */
	List<User> fundAllUser();

	/**
	 * 根据ID查询指定的信息
	 */
	User findByIdUser(Serializable id);

}
