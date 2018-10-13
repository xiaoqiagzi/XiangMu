package com.dao.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.bean.Easybuy_product_category;
import com.dao.dao.Easybuy_product_categoryDao;
import com.dao.util.ResultSetUtil;
import com.dao.util.jdbcUtil;

public class Easybuy_product_categoryDaoImpl extends jdbcUtil implements Easybuy_product_categoryDao {
	/**
	 * 增加商品种类
	 */
	@Override
	public int add(Easybuy_product_category t) {
		String sql = "INSERT INTO easybuy_product_category (name,parentId,type,iconClass) VALUES(?,?,?,?)";
		Object[] params = { t.getName(), t.getParentId(), t.getType(), t.getIconClass() };

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
	 * 删除商品种类
	 */
	@Override
	public int delete(Serializable id) {

		String sql = "delect from easybuy_product_category where id=?";
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
	 * 修改商品种类
	 */
	@Override
	public int update(Easybuy_product_category t) {

		String sql = "update easybuy_product_category set name=?,parentId=?,type=?,iconClass=? where id =?";
		Object[] params = { t.getName(), t.getParentId(), t.getType(), t.getIconClass(), t.getId() };
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
	 * 查询商品所有种类
	 */
	@Override
	public List<Easybuy_product_category> fundAll() {

		String sql = "select * from easybuy_product_category";

		// 创建集合保存所有信息
		List<Easybuy_product_category> easybuy_product_category = new ArrayList<>();

		try {
			rs = myExcuteQuery(sql);

			easybuy_product_category = ResultSetUtil.findAll(rs, Easybuy_product_category.class);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			closeConnection();
		}

		return easybuy_product_category;
	}

	/**
	 * 查询指定
	 */
	@Override
	public Easybuy_product_category findById(Serializable id) {

		String sql = "select * from easybuy_product_category where id=?";
		Object[] params = { id };

		Easybuy_product_category easybuy_product_category = null;

		try {
			rs = myExcuteQuery(sql, params);

			easybuy_product_category = ResultSetUtil.finById(rs, Easybuy_product_category.class);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭资源
			closeConnection();
		}

		return easybuy_product_category;
	}

}
