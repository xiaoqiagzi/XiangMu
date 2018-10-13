package com.dao.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
public class Shopping_cart implements Serializable {

	private int userId;
	private int orderId;
	private int orderNum;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
	
	
	

		@Override
	public String toString() {
		return "Shopping_cart [userId=" + userId + ", orderId=" + orderId + ", orderNum=" + orderNum + "]";
	}

	public Shopping_cart() {
		super();
		// TODO Auto-generated constructor stub
	}

		public Shopping_cart(int userId, int orderId, int orderNum) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.orderNum = orderNum;

	}


		//必须有一个集合来保存所有的商品
		private Map<Integer,CartItem>map = new LinkedHashMap();
		//所有商品的总价
		private double price;
		
		/**
		 * 新增商品
		 * @param product
		 */
		public void addProduct(Easybuy_product product) {
			//第一次购物项  肯定  为null
			
			CartItem cartItem = map.get(product.getId());
			
			if (cartItem==null) {//证明购物城中什么都没有
				cartItem=new CartItem();//实例化购物项
				//将用户传递来的商品放进购物项中
				cartItem.setProduct(product);
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+product);
				cartItem.setNum(1);
				//把购物项放进购物车
				map.put(product.getId(),cartItem );
			}else {
				//如果存在商品  该商品数量加1
				cartItem.setNum(cartItem.getNum()+1);
			}
		}
		
		/**
		 * 所有商品的总价
		 */
		
		public double getPrice() {
			int totalPrice=0;//保存总价
			for (Entry<Integer,CartItem> product : map.entrySet()) {
				CartItem cartItem =product.getValue();
				totalPrice+=cartItem.getPrice();
			}
			
			return totalPrice;
		
		}
		
		public Map<Integer,CartItem> getMap(){
			return map;
			
		}
		
		public void setMap(Map<Integer,CartItem>map) {
			
			this.map=map;
		}
		
		public void setPrice(double pice) {
			this.price=price;
		}

	
	
}