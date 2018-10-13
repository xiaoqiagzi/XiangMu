package com.dao.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 用户地址的实体类
 * 
 * 吉祥龙龙
 * 2018年4月7日下午6:38:48
 */
public class User_address implements Serializable{
	private int id;//用户地址id
	private int userId;// 用户id
	private String address;//用户的地址
	private Date createTime;//创建用户地址时间
	private int isDefault;//是否是默认地址，1是0否
	private String remark;//地址备注信息
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public User_address(int id, int userId, String address, Date createTime, int isDefault, String remark) {
		super();
		this.id = id;
		this.userId = userId;
		this.address = address;
		this.createTime = createTime;
		this.isDefault = isDefault;
		this.remark = remark;
	}
	public User_address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User_address [id=" + id + ", userId=" + userId + ", address=" + address + ", createTime=" + createTime
				+ ", isDefault=" + isDefault + ", remark=" + remark + "]";
	}
	
	
	

}
