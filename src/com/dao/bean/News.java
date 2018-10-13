package com.dao.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻的实体类
 */
public class News implements Serializable{
	private int id ;//新闻编号
	private String title;//新闻标题
	private String content;//新闻内容
	private Date createTime;//创建时间
	private String img;//新闻图片
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public News(int id, String title, String content, Date createTime, String img) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.img = img;
	}
	
	public News(String title, String content, Date createTime, String img) {
		super();
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.img = img;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content + ", createTime=" + createTime + ", img="
				+ img + "]";
	}
	
	
	
	
	
}


