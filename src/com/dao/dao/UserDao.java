package com.dao.dao;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.User;

/**
 * 用户的增删改查 接口
 * loginName 用户名
 * password 密码
 */
public interface UserDao extends BaseDao<User>{
	//用户类独有的  登录功能
	User login(String loginName, String password);
	// 判断登录名是否被存在
	boolean finbyName(String loginName);
}
