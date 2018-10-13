package com.dao.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.bean.Easybuy_order_detail;
import com.dao.dao.Easybuy_order_detailDao;
import com.dao.util.ResultSetUtil;
import com.dao.util.jdbcUtil;
import com.mysql.fabric.xmlrpc.base.Array;
/**
 * 实现详单增删改查的实体类
 * -------------------
 * 
 * 	 ^-^: 吉祥龙龙
 * 2018年4月8日下午5:11:24
 */
public class Easybuy_order_detailDaoImpl extends jdbcUtil implements Easybuy_order_detailDao {
	/**
	 * 详单增加
	 */
	@Override
	public int add(Easybuy_order_detail t) {
		
		String sql="INSERT INTO easybuy_order_detail (orderId,productId,quantity,cost) VALUES (?,?,?,?)";
		Object [] params= {t.getOrderId(),t.getProductId(),t.getQuantity(),t.getCost()};
		
		int rowNum = 0;
		
		try {
			rowNum= myExcuteUpdate(sql, params);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rowNum;
	}
	/**
	 * 详单删除
	 */
	@Override
	public int delete(Serializable id) {
		String sql ="DELETE FROM easybuy_order_detail WHERE id =?";
		
		Object [] params={id};
		
		int rowNum=0;
		
		try {
			rowNum=myExcuteUpdate(sql, params);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowNum;
	}
	/**
	 * 详单修改
	 */
	@Override
	public int update(Easybuy_order_detail t) {
		String sql ="UPDATE easybuy_order_detail SET quantity =?,cost=? WHERE id = ?";
		
		Object [] params = {t.getQuantity(),t.getCost(),t.getId()};
		
		int rowNum=0;
		
		try {
			rowNum=myExcuteUpdate(sql, params);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowNum;
	}
	/**
	 * 查询所有详单
	 */
	@Override
	public List<Easybuy_order_detail> fundAll() {

		String sql = "select * from easybuy_order_detail";
		
		//创建List集合保存
		List<Easybuy_order_detail> easybuy_order_detail =new ArrayList<>();
		
		try {
			rs=myExcuteQuery(sql);
			
			//利用反射机制获取
			easybuy_order_detail=ResultSetUtil.findAll(rs, Easybuy_order_detail.class);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 关闭资源
			closeConnection();
		}

		return easybuy_order_detail;
	}
	/**
	 * 查询指定用户详单
	 */
	@Override
	public Easybuy_order_detail findById(Serializable id) {
		String sql ="select *from easybuy_order_detail where id =?";
		Object [] params= {id};
		
		Easybuy_order_detail easybuy_order_detail =null;
		
		try {
			rs=myExcuteQuery(sql, params);
			
			easybuy_order_detail=ResultSetUtil.finById(rs, Easybuy_order_detail.class);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return easybuy_order_detail;
	}

}
