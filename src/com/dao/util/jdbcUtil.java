package com.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



/**
 * 所有JDBC操作数据库的工具类
 * 01.数据库四要素的获取
 * 02.开启连接
 * 03.关闭连接
 * 04.公共的增删改
 * 05.公共的查询
 */
public class jdbcUtil {
	public static Connection conn = null;//便于我们释放资源
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;//查询数据返回的结果集
	
/**
 * 连接数据库
 */
		public static boolean getConnection() throws ClassNotFoundException,
		SQLException {
		try {
			//通过反射机制获取数据库驱动包
			Class.forName(ConfigManager.getInstance().getValue("jdbc.driver"));
			//通过DriverManager获取Conncetion连接对象
			conn=DriverManager.getConnection(ConfigManager.getInstance().getValue("jdbc.url"),
					ConfigManager.getInstance().getValue("jdbc.loginName"),
					ConfigManager.getInstance().getValue("jdbc.passWord"));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	     
	/**
	 * 1.用数据源连接数据库
	 * 2.配置tomcat数据源
	 * 
	 * 之后会使用Spring 整合数据源 ali c3p0 dbcp
	 * 
	 **/
/*	public static boolean getConnection() {


		try {
			//初始化上下文对象Tomcat容器
			Context context = new InitialContext();
			//通过数据源中的name属性获取指定的数据源
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/qianduan");
			//从连接池中获取连接conn pool
			conn=ds.getConnection();

			return true;
		} catch (NamingException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}*/
		
	/**
	 * 释放资源
	 */
		public static void closeConnection() {
				if (ps!=null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (conn!=null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
				if (rs!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		
	/**
	 * 公共的增删改
	 * 
	 * 我们可以确定的是有sql语句！因为只有sql语句才能操作数据库！
	 * 但是我们无法确定的是：
	 * 	01.参数的个数
	 * 	02.参数的类型
	 * 
	 * 我们应该是考虑有参数  还是 没有参数 ？ 有参数的！
	 * 考虑有1个参数还是有N个参数？  有N个参数的！
	 * 
	 * 用户需要传递一个执行的sql语句
	 * 		再擦混地一个参数列表
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static int myExcuteUpdate(String sql,Object...param) throws ClassNotFoundException, SQLException {
		int rowNum = 0;
		if (getConnection()) {//证明有连接
			ps=conn.prepareStatement(sql);
			//给sql语句中的 ？ 一个一个赋值
			for (int i= 0;  i< param.length; i++) {
				ps.setObject(i+1, param[i]);
			}
			rowNum = ps.executeUpdate();
		}
		closeConnection();//释放资源
		return rowNum;
		
	}
	/**
	 * 公共的查询
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static ResultSet myExcuteQuery(String sql,Object...param) 
			throws ClassNotFoundException, SQLException {
		if (getConnection()) {//证明有连接
			ps=conn.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i+1, param[i]);
			}
			rs=ps.executeQuery();
		}
		/**
		 * 在这里不能实现关闭资源，因为子类中有rs的具体使用  还需要用到连接
		 * 子类使用完毕，自行了断！
		 */
		return rs;
		
	}
	
	
	
}
