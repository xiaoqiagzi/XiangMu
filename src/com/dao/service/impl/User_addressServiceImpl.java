package com.dao.service.impl;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.User_address;
import com.dao.dao.UserDao;
import com.dao.dao.User_addressDao;
import com.dao.dao.impl.UserDaoImpl;
import com.dao.dao.impl.User_addressDaoImpl;
import com.dao.service.User_addressService;

public class User_addressServiceImpl implements User_addressService {
	//实例化dao层对象  但是这种方式不可取 是耦合的!
	User_addressDao user_addressdao = new User_addressDaoImpl();
	
	/**
	 * 新增
	 */
	@Override
	public void add(User_address t) {
		int rowNum=user_addressdao.add(t);
		
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
		int rowNum=user_addressdao.delete(id);
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
	public void update(User_address t) {
		int rowNum=user_addressdao.update(t);
		if (rowNum>0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
	/**
	 * 查询所有
	 */
	@Override
	public List<User_address> fundAll() {
		
		return user_addressdao.fundAll();
	}
	/**
	 * 查询指定
	 */
	@Override
	public User_address findById(Serializable id) {
		
		return user_addressdao.findById(id);
	}

}
