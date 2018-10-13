package com.dao.service.impl;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.Easybuy_order;
import com.dao.dao.Easybuy_orderDao;
import com.dao.dao.UserDao;
import com.dao.dao.impl.Easybuy_orderDaoImpl;
import com.dao.dao.impl.UserDaoImpl;
import com.dao.service.Easybuy_orderService;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Easybuy_orderServiceDao implements Easybuy_orderService {
	
	
	//实例化dao层对象  但是这种方式不可取 是耦合的!
	Easybuy_orderDao easybuy_orderdao = new Easybuy_orderDaoImpl();
	
	
	
	/**
	 * 新增
	 */
	@Override
	public void add(Easybuy_order t) {
		int rowNum =easybuy_orderdao.add(t);
		if (rowNum>0) {
			System.out.println("增加成功");
		}else {
			System.out.println("增加失败");
		}
		
		
		
	}
	
	/**
	 * 删除
	 */
	@Override
	public void delete(Serializable id) {
		int rowNum =easybuy_orderdao.delete(id);
		
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
	public void update(Easybuy_order t) {
		
		int rowNum = easybuy_orderdao.update(t);
		
		if (rowNum>0) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
		
	}
	
	/**
	 * 查询所有
	 */
	@Override
	public List<Easybuy_order> fundAll() {
		
		
		return easybuy_orderdao.fundAll();
	}
	
	/**
	 * 查询指定id
	 */
	@Override
	public Easybuy_order findById(Serializable id) {
		
		return easybuy_orderdao.findById(id);
	}

}
