package com.dao.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.bean.News;
import com.dao.bean.User;
import com.dao.dao.UserDao;
import com.dao.dao.impl.UserDaoImpl;
import com.dao.service.UserService;

/**
 * service 逻辑层 -------------------
 * 
 * ^-^: 吉祥龙龙 2018年4月9日上午10:45:37
 */

public class UserServiceImpl implements UserService {
	// log4j
	public static Logger logger = Logger.getLogger(UserServiceImpl.class);

	// 实例化dao层对象 但是这种方式不可取 是耦合的!
	UserDao userdao = new UserDaoImpl();

	/**
	 * 登录
	 */
	@Override
	public User login(String loginName, String password) {
		User login = userdao.login(loginName, password);
		if (login == null) {

			return null;
		} else {
			return login;
		}

	}

	/**
	 * 新增用户
	 */
	@Override
	public boolean addUser(User user) {
		int add = userdao.add(user);
		if (add > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 查询所有的用户信息
	 */
	@Override
	public List<User> fundAllUser() {
		return userdao.fundAll();
	}

	// 查询指定的用户信息
	@Override
	public User findByIdUser(Serializable id) {
		return userdao.findById(id);
	}

	/**
	 * 修改
	 */
	@Override
	public boolean updateUser(User user) {
		if (userdao.update(user) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 删除
	 */
	@Override
	public boolean deleteUser(Serializable id) {
		if (userdao.delete(id) > 0) {

			return true;
		}

		return false;
	}
	/**
	 *  判断登录名是否被存在
	 */
	@Override
	public boolean finbyName(String loginName) {
		
		return userdao.finbyName(loginName);
	}

}
