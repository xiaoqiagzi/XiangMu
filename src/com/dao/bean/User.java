package com.dao.bean;

import java.io.Serializable;

/**
 * 用户的实体类
 */
public class User implements Serializable{
	
	private int id;//用户的编号
	private String loginName;//用户的登录名
	private String userName;//用户的用户名
	private String password;//用户的密码
	private String toPwd;//再次输入的密码
	private int sex;//用户的性别（1：男，2：女）
	private String identityCode;//用户的身份证号
	private String email;//用户邮箱
	private String mobile;//用户手机号
	private int type;//用户的类型1：管理员0：普通用户
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToPwd() {
		return toPwd;
	}
	public void setToPwd(String toPwd) {
		this.toPwd = toPwd;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", userName=" + userName + ", password=" + password
				+ ", toPwd=" + toPwd + ", sex=" + sex + ", identityCode=" + identityCode + ", email=" + email
				+ ", mobile=" + mobile + ", type=" + type + "]";
	}
	public User(int id, String loginName, String userName, String password, String toPwd, int sex, String identityCode,
			String email, String mobile, int type) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.userName = userName;
		this.password = password;
		this.toPwd = toPwd;
		this.sex = sex;
		this.identityCode = identityCode;
		this.email = email;
		this.mobile = mobile;
		this.type = type;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
}
 