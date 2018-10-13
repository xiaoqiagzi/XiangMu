package com.dao.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 吉祥龙龙
 * 2018年4月7日下午4:21:07
 * 01.我们从数据库中获取的结果集就是ResultSet
 * 02.结果集中的类型我们确定吗？？？ 不确定==》T
 * 03.sql语句一旦执行T的类型就确定了
 * 04.通过反射机制向实体类中的属性赋值
 */
public class ResultSetUtil {
	/**
	 * 01.务必需要一个结果集ResultSet ，才能获取T的类型
	 * 02.反射务必需要Class<T>
	 */
	public static <T> T finById(ResultSet rs,Class<T> c) {
		//定义个T类型的object ,T我们不知道是什么类型。
		
		T object =null;
		try {
			if (rs.next()) {
				//实例化对象
				object=c.newInstance();
				//获取实体类中所有属性
				Field[] fields = c.getDeclaredFields();
				for (Field field : fields) {
					//打开权限
					field.setAccessible(true);
					field.set(object,rs.getObject(field.getName()));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
		return object;
	}
	
	public static <T> List<T> findAll(ResultSet rs,Class<T> c) {
		//定义个T类型的object ,T我们不知道是什么类型。
		T object =null;
		//创建集合  保存每一个对象
		List<T> list =new ArrayList<>();
		
		try {
			while (rs.next()) {
				//通过反射机制实例化对象
				object=c.newInstance();
				Field[] fields = c.getDeclaredFields();
				for (Field field : fields) {
					field.setAccessible(true);//打开权限
					field.set(object, rs.getObject(field.getName()));
				}
				//将对象加入到集合
				list.add(object);
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
}
