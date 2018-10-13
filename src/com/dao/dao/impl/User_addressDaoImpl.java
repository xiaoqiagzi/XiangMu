package com.dao.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.bean.User_address;
import com.dao.dao.User_addressDao;
import com.dao.util.ResultSetUtil;
import com.dao.util.jdbcUtil;

public class User_addressDaoImpl extends jdbcUtil implements User_addressDao {
	/**
	 * 用户地址增加
	 */
	@Override
	public int add(User_address t) {
		String sql = "INSERT INTO easybuy_user_address (userId,address,createTime,isDefault,remark) VALUES(?,?,?,?,?)";
		Object[] params = { t.getUserId(), t.getAddress(), t.getCreateTime(), t.getIsDefault(), t.getRemark() };
		
		int rowNum = 0;
		
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
	 * 用户地址删除
	 */
	@Override
	public int delete(Serializable id) {
		
		String sql = "DELETE FROM `easybuy_user_address` WHERE id =?";
		Object [] params= {id};
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
	 * 用户地址修改
	 */
	@Override
	public int update(User_address t) {
		String sql ="UPDATE easybuy_user_address SET address=? where id=?";
		Object [] parms= {t.getAddress(),t.getId()};
		int rowNum = 0;
		try {
			
			rowNum =myExcuteUpdate(sql, parms);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rowNum;
	}

	/**
	 * 用户地址查询所有
	 */
	@Override
	public List<User_address> fundAll() {

		String sql ="select * from easybuy_user_address";
		
		//创建集合来保存所有的用户
		List<User_address>user_address =new ArrayList<>();
		
		try {
			
			rs=myExcuteQuery(sql);
			
			user_address=ResultSetUtil.findAll(rs, User_address.class);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 关闭资源
			closeConnection();
		}
		return user_address;
	}

	/**
	 * 查询指定用户地址==》id
	 */
	@Override
	public User_address findById(Serializable userID) {
		
		String sql ="SELECT * FROM `easybuy_user_address` WHERE userId=?;";
		//给参数赋值
		Object [] params={userID};
		User_address user_address=null;
		
		
		try {
			rs=myExcuteQuery(sql, params);
			
			user_address=ResultSetUtil.finById(rs, User_address.class);

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			// 关闭资源
			closeConnection();
		}
				
		
		return user_address;
	}

}
