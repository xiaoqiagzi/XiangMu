package com.dao.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户订单的实体类 -------------------
 * 
 * ^-^: 吉祥龙龙 2018年4月8日下午4:01:43
 */
public class Easybuy_order implements Serializable{
	private int id;// 订单主键
	private int userId;// 用户的主键
	private String loginName;// 用户的用户名
	private String userAddress;// 用户的地址
	private Date createTime; //创建订单的时间
	private float cost ;//用户的总消费
	private String serialNumber;//用户消费的订单号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Easybuy_order(int id, int userId, String loginName, String userAddress, Date createTime, float cost,
			String serialNumber) {
		super();
		this.id = id;
		this.userId = userId;
		this.loginName = loginName;
		this.userAddress = userAddress;
		this.createTime = createTime;
		this.cost = cost;
		this.serialNumber = serialNumber;
	}
	public Easybuy_order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Easybuy_order [id=" + id + ", userId=" + userId + ", loginName=" + loginName + ", userAddress="
				+ userAddress + ", createTime=" + createTime + ", cost=" + cost + ", serialNumber=" + serialNumber
				+ "]";
	}

	
	
}
