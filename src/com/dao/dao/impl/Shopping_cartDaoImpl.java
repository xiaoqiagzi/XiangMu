package com.dao.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.dao.bean.Shopping_cart;
import com.dao.dao.Shopping_cartDao;

import com.dao.util.ResultSetUtil;
import com.dao.util.jdbcUtil;
import com.google.gson.Gson;

import java.util.Date;
public class Shopping_cartDaoImpl extends jdbcUtil implements Shopping_cartDao {
	Gson gs = new Gson();
	
	@Override 
	 public int save(String uid,String pid,int num) {
		int rowNom=0;
		
		String sql = "insert into shopping_cart(userId,orderId,orderNum) values (?,?,?)";
		
		Object [] permas = {uid,pid,num};
		
		try {
			rowNom = myExcuteUpdate(sql,permas);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return rowNom;
		
	}	
	
	@Override 
	 public int delete(Serializable id) {
		 String sql = "delete from shopping_cart where id=?";
		 Object[] params={id};
		 int reNum=0;
		 try {
			 reNum=myExcuteUpdate(sql, params);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return reNum;
	}	
	

	 
	 
	 @Override 
	 public Shopping_cart findbyid(Serializable t,Serializable t1) {
		 String sql = "select userId,orderId,orderNum from  shopping_cart where userId=? and orderId=?";
		   Object[] params = {t,t1};
		 Shopping_cart  shopping_cart=new Shopping_cart();
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql, params);
			 if (rs.next()) {
				 shopping_cart.setUserId(rs.getInt("userId"));
				 shopping_cart.setOrderId(rs.getInt("orderId"));
				 shopping_cart.setOrderNum(rs.getInt("orderNum"));
			}
			 
			 
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } finally{
			 closeConnection();
			}
		 return shopping_cart;
	}	
	
	
	@Override 
	 public int update(Shopping_cart t) {
		 String sql = "update shopping_cart set userId=?,orderId=?,orderNum=?  where id=?";
		 Object[] params={t.getUserId(),t.getOrderId(),t.getOrderNum()};
		 int reNum=0;
		 try {
			 reNum=myExcuteUpdate(sql, params);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return reNum;
	}

	@Override
	public int add(Shopping_cart t) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<Shopping_cart> UID(int uid) {
		String sql ="select userId,orderId,orderNum from shopping_cart where userId=?";
		Object[]premas={uid};
		List<Shopping_cart> list = new ArrayList<Shopping_cart>(); 
		
		try {
			ResultSet rs =myExcuteQuery(sql, premas);
			while(rs.next()) {
				Shopping_cart shopping_cart =new Shopping_cart(rs.getInt("userId"),rs.getInt("orderId"),rs.getInt("orderNum"));
				list.add(shopping_cart);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public List<Shopping_cart> fundAll() {
		 String sql = "select * from  shopping_cart ";
		 List<Shopping_cart> shopping_cart=new ArrayList<Shopping_cart>();
		   ResultSet rs;
		 try {
			 rs=myExcuteQuery(sql);
			 shopping_cart=ResultSetUtil.findAll(rs, Shopping_cart.class);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		} catch (SQLException e) {
			  e.printStackTrace();
		 } 
		 return shopping_cart;
	
	}

	@Override
	public Shopping_cart findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}





}