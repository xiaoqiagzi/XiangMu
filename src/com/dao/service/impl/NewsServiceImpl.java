package com.dao.service.impl;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.News;
import com.dao.bean.User;
import com.dao.dao.NewsDao;
import com.dao.dao.UserDao;
import com.dao.dao.impl.NewsDaoImpl;
import com.dao.dao.impl.UserDaoImpl;
import com.dao.service.NewsService;
import com.dao.util.PageInfo;
	/**
	 * 新闻  逻辑层增删改查接口
	 * -------------------
	 * 
	 * 	 ^-^: 吉祥龙龙
	 * 2018年4月9日上午11:27:07
	 */
public class NewsServiceImpl implements NewsService {
	
	//实例化dao层对象  但是这种方式不可取 是耦合的!
	NewsDao Newsdao = new NewsDaoImpl();
	
	/**
	 * 新增新闻  文件上传
	 */
	@Override
	public boolean addNews(News news) {
		int add = Newsdao.add(news);
		if (add > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 查询所有的新闻信息
	 */
	@Override
	public List<News> findAll() {
		return Newsdao.fundAll();
	}

	// 查询指定的新闻信息
	@Override
	public News findNewsById(Serializable id) {
		return Newsdao.findById(id);
	}
/**
 * 修改
 */
	@Override
	public boolean updateNews(News news) {
		if (Newsdao.update(news) > 0) {
			return true;
		}
		return false;
	}
/**
 * 删除
 */
	@Override
	public boolean deleteNews(Serializable id) {
		if (Newsdao.delete(id) > 0) {
			return true;
		}
		return false;
	}
/**
 * 获取新闻的总记录数
 */
@Override
public int getTotalCount() {
	
	return Newsdao.getTotalCount();
	
}

@Override
public PageInfo<News> findAlls(int pageNum, int pageSize) {	
	PageInfo<News> pageInfo = new PageInfo<>();
	// 给pageInfo对象的list集合赋值
	pageInfo.setList(Newsdao.findAlls(pageNum, pageSize));
	return pageInfo;
}

}
