package com.dao.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.bean.News;
import com.dao.bean.User;
import com.dao.dao.NewsDao;
import com.dao.util.ResultSetUtil;
import com.dao.util.jdbcUtil;

/**
 * 
 * 吉祥龙龙 2018年4月6日下午5:53:12
 * 
 * 实现新闻的实体类
 */
public class NewsDaoImpl extends jdbcUtil implements NewsDao {

	/**
	 * 增加新闻
	 */
	@Override
	public int add(News t) {
		String sql = "INSERT INTO `easybuy_news`(title,content,img)VALUES(?,?,?);";
		Object[] params = { t.getTitle(), t.getContent(), t.getImg() };

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
	 * 删除新闻
	 */
	@Override
	public int delete(Serializable id) {
		String sql = "DELETE FROM easybuy_news WHERE id=?";
		Object[] parmas = { id };

		int rowNum = 0;

		try {
			rowNum = myExcuteUpdate(sql, parmas);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowNum;
	}

	/**
	 * 修改新闻
	 */
	@Override
	public int update(News t) {

		String sql = "UPDATE easybuy_news SET title=?,content=? WHERE id=?";
		Object[] params = { t.getTitle(), t.getContent(), t.getId()};
		System.out.println(t);
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
	 * 查询所有新闻
	 */
	@Override
	public List<News> fundAll() {

		String sql = "select * from easybuy_news";
		//创建一个集合保存所有新闻信息
		List<News> newss = new ArrayList<>();

		try {
			rs = myExcuteQuery(sql);
			
			newss=ResultSetUtil.findAll(rs, News.class);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}

		return newss;
	}

	/**
	 * 查询指定的新闻信息
	 */
	@Override
	public News findById(Serializable newId) {
		String sql = "select * from easybuy_news where id=?";
		News news = null;
		try {
			Object[] params = { newId };
			rs = myExcuteQuery(sql, params);
			news=ResultSetUtil.finById(rs, News.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}

		return news;

	}
	/**
	 * 查询新闻的总行数，用于分页s
	 */
	
	@Override
	public int getTotalCount() {
		String sql = "select count(*) as count from easybuy_News";
		int count = 0;
		try {
			rs = myExcuteQuery(sql);
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return count;
	}

	@Override
	public List<News> findAlls(int pageNum, int pageSize) {
		String sql = "select * from easybuy_News limit ?,?";
		// 创建一个集合来保存所有的用户
		List<News> newss = new ArrayList<>();
		Object[] params = { pageNum*pageSize, pageSize };
		try {
			rs = myExcuteQuery(sql, params);
			newss = ResultSetUtil.findAll(rs, News.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return newss;
	}

}
