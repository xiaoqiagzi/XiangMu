package com.dao.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.bean.User;
import com.dao.dao.UserDao;
import com.dao.util.ResultSetUtil;
import com.dao.util.jdbcUtil;

/**
 * 
 * 吉祥龙龙
 * 2018年4月6日下午5:50:45
 * 
 * 实现用户的实体类
 */
public class UserDaoImpl extends jdbcUtil implements UserDao {
	/**
	 * 用户登录
	 */
	@Override
	public User login(String loginName, String password) {
		String sql = "SELECT loginName,PASSWORD FROM users WHERE loginName=? AND PASSWORD=?";
		// SELECT loginName,PASSWORD FROM easybuy_user WHERE loginName='admin' AND PASSWORD=123456
		Object[] params = { loginName, password };
		User user = null;
		try {

			rs = myExcuteQuery(sql, params);
			user=ResultSetUtil.finById(rs, User.class);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			closeConnection();
		}

		return user;
	}

	/**
	 * 用户注册（增加用户）一般都是用户名 密码+邮箱/手机号 之后用户的详细信息 可以自行完善
	 */
	@Override
	public int add(User t) {
		String sql = "insert into easybuy_user(loginName, userName, `password`,toPwd, sex, identityCode, email, mobile, `type`) values(?,?,?,?,?,?,?,?,?)";
		Object[] params = { t.getLoginName(), t.getUserName(), t.getPassword(),t.getToPwd(), t.getSex(), t.getIdentityCode(),
				t.getEmail(), t.getMobile(), t.getType() };
		
	/*	String sql = "insert into easybuy_user(userName, `password`) values(?,?)";
		Object[] params = { t.getUserName(), t.getPassword() };*/

		int rowNum = 0;
		try {
			rowNum=myExcuteUpdate(sql, params);
			System.out.println(rowNum);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowNum;
	}

	/**
	 * 删除用户
	 * 
	 * 用户有可能根据ID删除对象 也有可能根据其他选择
	 * 
	 * 我们不确定类型 所以把参数类型设置为Serializable
	 * 
	 * 遗留问题 id为空 根据name删除 name为空 根据id删除
	 */
	@Override
	public int delete(Serializable id) {

		String sql = "delete from easybuy_user where id=?";

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
	 * 修改用户用户名和密码
	 */
	@Override
	public int update(User t) {

		String sql = "update easybuy_user set userName=?,password=? where id=?";
		Object[] params = { t.getUserName(), t.getPassword(), t.getId() };
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
	 * 查询所有
	 */
	@Override
	public List<User> fundAll() {

		String sql = "select * from easybuy_user";

		// 创建集合来保存所有的用户
		List<User> users = new ArrayList<>();
		try {
			rs = myExcuteQuery(sql);
			
			users=ResultSetUtil.findAll(rs, User.class);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			closeConnection();
		}

		return users;
	}
	/**
	 * 查询指定的用户信息
	 */
	@Override
	public User findById(Serializable userID) {
		String sql = "select * from easybuy_user where id=?";
		// 给参数赋值
		Object[] params = { userID };
		User user = null;
		try {

			rs = myExcuteQuery(sql, params);
			user=ResultSetUtil.finById(rs, User.class);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			closeConnection();
		}

		return user;
		
		
	
	}
	
	/**
	 * 判断用户名是否存在
	 */
	@Override
	public boolean finbyName(String loginName) {
		String sql = "select * from easybuy_user where loginName=?";
		
		// 给参数赋值
		Object[] params = { loginName };
		User user = null;
		try {

			rs = myExcuteQuery(sql, params);
			if (rs.next()) {
				
				return true;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			closeConnection();
		}
	
		
		return false;
	}

	

}
