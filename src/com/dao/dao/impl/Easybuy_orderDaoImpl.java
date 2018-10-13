package com.dao.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.bean.Easybuy_order;
import com.dao.dao.Easybuy_orderDao;
import com.dao.util.ResultSetUtil;
import com.dao.util.jdbcUtil;

/**
 * 实现用户订单的实体类 -------------------
 * 
 * ^-^: 吉祥龙龙 2018年4月8日下午4:45:42
 */
public class Easybuy_orderDaoImpl extends jdbcUtil implements Easybuy_orderDao {
	/**
	 * 增加订单
	 */
	@Override
	public int add(Easybuy_order t) {
		String sql = "INSERT INTO easybuy_order (userId,loginName,userAddress,createTime,cost,serialNumber)VALUES(?,?,?,?,?,?)";

		Object[] params = { t.getUserId(), t.getLoginName(), t.getUserAddress(), t.getCreateTime(), t.getCost(),
				t.getSerialNumber() };

		int rowNum = 0;

		try {

			rowNum = myExcuteUpdate(sql, params);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowNum;
	}

	/**
	 * 删除订单
	 */
	@Override
	public int delete(Serializable id) {

		String sql = "DELETE FROM easybuy_order WHERE id =?";
		Object[] params = { id };

		int rowNum = 0;

		try {
			rowNum = myExcuteUpdate(sql, params);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowNum;
	}

	/**
	 * 修改订单
	 */
	@Override
	public int update(Easybuy_order t) {
		String sql = "UPDATE easybuy_order SET loginName=?,userAddress=?,createTime?,cost=?,serialNumber=? WHERE id=?";

		Object []paeams= {t.getLoginName(),t.getUserAddress(),t.getCreateTime(),t.getCost(),t.getSerialNumber()};
		
		int rowNum=0;
		
		try {
			
			
			rowNum=myExcuteUpdate(sql, paeams);
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rowNum;
	}

	/**
	 * 查询所有订单
	 */
	@Override
	public List<Easybuy_order> fundAll() {
		String sql ="seelct * from easybuy_order";
		//创建个List集合保存所有
		List<Easybuy_order>easybuy_order =new ArrayList<>();
		
		try {
			rs=myExcuteQuery(sql);
			easybuy_order=ResultSetUtil.findAll(rs, Easybuy_order.class);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 关闭资源
			closeConnection();
		}
		
		return easybuy_order;
	}

	/**
	 * 查询指定用户订单
	 * 
	 */
	@Override
	public Easybuy_order findById(Serializable userId) {
		String sql ="select * from easybuy_order where userId =? ";
		
		//给参数赋值
		Object [] params= {userId};
		Easybuy_order easybuy_order =null;
		
		try {
			rs=myExcuteQuery(sql, params);
			easybuy_order =ResultSetUtil.finById(rs, Easybuy_order.class);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 关闭资源
			closeConnection();
		}
		
		return easybuy_order;
	}

}
