package com.dao.bean;
	/**
	 * 
	 * 商品的种类
	 * -------------------
	 * 
	 * 	 ^-^: 吉祥龙龙
	 * 2018年4月8日下午3:15:46
	 */
public class Easybuy_product_category {
	
	private int id ;//商品种类id
	private String name;//商品名称
	private int parentId; //商品目录ID(父级目录)
	private int type ; //商品种类级别(1 2 3 级别)
	private String iconClass;//图标
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getIconClass() {
		return iconClass;
	}
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}
	public Easybuy_product_category(int id, String name, int parentId, int type, String iconClass) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.type = type;
		this.iconClass = iconClass;
	}
	public Easybuy_product_category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
