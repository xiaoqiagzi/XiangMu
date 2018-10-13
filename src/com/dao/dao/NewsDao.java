package com.dao.dao;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.News;
import com.dao.bean.User;
/**
 *	新闻操作接口
 */
public interface NewsDao extends BaseDao<News> {
	/**
	 * 获取新闻的总记录数
	 */
	int getTotalCount();

	List<News> findAlls(int pageNum, int pageSize);
	
}
