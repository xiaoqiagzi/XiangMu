package com.dao.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.bean.Easybuy_product;
import com.dao.dao.Easybuy_productDao;
import com.dao.util.ResultSetUtil;
import com.dao.util.jdbcUtil;

public class Easybuy_productDaoImpl extends jdbcUtil implements Easybuy_productDao {
	/**
	 * 增加商品
	 */
	@Override
	public int add(Easybuy_product t) {
		String sql = "INSERT INTO easybuy_product (name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName,isDelete) VALUES(?,?,?,?,?,?,?,?,?)";
		Object[] params = { t.getName(), t.getDescription(), t.getPrice(), t.getCategoryLevel1Id(),
				t.getCategoryLevel2Id(), t.getCategoryLevel3Id(), t.getFileName(), t.getIsDelete() };

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
	 * 删除商品
	 */
	@Override
	public int delete(Serializable id) {
		String sql = "delete from easybuy_product where id=?";

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
	 * 更改商品详情
	 */
	@Override
	public int update(Easybuy_product t) {

		String sql = "update easybuy_product set name=?,description=?,pric=?,stock=?,categoryLevel1Id=?,categoryLevel2Id=?,categoryLevel3Id=?,fileName=?,isDelete where id=?";

		Object[] params = { t.getName(), t.getDescription(), t.getPrice(), t.getStock(), t.getCategoryLevel1Id(),
				t.getCategoryLevel2Id(), t.getCategoryLevel3Id(), t.getFileName(), t.getIsDelete(), t.getId() };
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
	 * 查询所有商品
	 */
	@Override
	public List<Easybuy_product> fundAll() {

		String sql = "select * from easybuy_product";
		// 创建集合保存所有
		List<Easybuy_product> easybuy_product = null;

		try {
			rs = myExcuteQuery(sql);
			//通过反射获取Easybuy_product类里面所有 放入结果集
			 easybuy_product = ResultSetUtil.findAll(rs, Easybuy_product.class);
	
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 关闭资源
			closeConnection();
			
		}

		return easybuy_product;
	}

	/**
	 * 查询指定商品  以Id为查询条件
	 */
	@Override
	public Easybuy_product findById(Serializable id) {
	
		String sql ="select * from easybuy_product where id =?";
		
		//给参数赋值，保存到集合中
		
		Object [] params = {id};
		Easybuy_product easybuy_product=null;
		
		try {
			rs =myExcuteQuery(sql, params);
			
			//通过反射获取Easybuy_product类里面所有 放入结果集
			easybuy_product=ResultSetUtil.finById(rs, Easybuy_product.class);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭资源
			closeConnection();
		}
		
		return easybuy_product;

	}

}
