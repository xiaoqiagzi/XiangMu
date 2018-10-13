package com.dao.service.impl;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.Easybuy_order_detail;
import com.dao.dao.Easybuy_order_detailDao;
import com.dao.dao.UserDao;
import com.dao.dao.impl.Easybuy_order_detailDaoImpl;
import com.dao.dao.impl.UserDaoImpl;
import com.dao.service.Easybuy_order_detailService;
/**
 * 用户消费   逻辑层  增删改查
 * -------------------
 * 
 * 	 ^-^: 吉祥龙龙
 * 2018年4月9日下午3:57:49
 */
public class Easybuy_order_detailServiceImpl implements Easybuy_order_detailService {
	//实例化dao层对象  但是这种方式不可取 是耦合的!
	Easybuy_order_detailDao easybuy_order_detaildao = new Easybuy_order_detailDaoImpl();
		
	
	/**
	 * 新增
	 */
	@Override
	public void add(Easybuy_order_detail t) {
		int rowNum=easybuy_order_detaildao.add(t);
		
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
		int rowNum=easybuy_order_detaildao.delete(id);
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
	public void update(Easybuy_order_detail t) {
		int rowNum =easybuy_order_detaildao.update(t);
		if (rowNum>0) {
			System.err.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
		
	}
	/**
	 * 查询所有
	 */
	@Override
	public List<Easybuy_order_detail> fundAll() {
		
		
		return easybuy_order_detaildao.fundAll();
	}
	/**
	 * 查询指定
	 */
	@Override
	public Easybuy_order_detail findById(Serializable id) {
		
		
		return easybuy_order_detaildao.findById(id);
	}

}
