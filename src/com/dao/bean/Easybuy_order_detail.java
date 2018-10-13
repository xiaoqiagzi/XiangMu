package com.dao.bean;

import java.io.Serializable;

/**
 * 用户消费详情
 * -------------------
 * 
 * 	 ^-^: 吉祥龙龙
 * 2018年4月8日下午5:04:35
 */
public class Easybuy_order_detail implements Serializable{
	
	private int id;//消费详情主键id
	private int orderId;//订单主键
	private int productId;//商品主键
	private int quantity;//数量
	private float cost;//消费总金额
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Easybuy_order_detail(int id, int orderId, int productId, int quantity, float cost) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.cost = cost;
	}
	public Easybuy_order_detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Easybuy_order_detail [id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", quantity="
				+ quantity + ", cost=" + cost + "]";
	}

	

}
