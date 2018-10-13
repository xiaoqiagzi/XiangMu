package com.dao.bean;

import java.io.Serializable;

/**
 * 商品的实体类
 * -------------------
 * 
 * 	 ^-^: 吉祥龙龙
 * 2018年4月8日下午2:40:30
 */
public class Easybuy_product implements Serializable{
	private int id;//商品的编号
	private String name;//商品的名称
	private String description;//商品的描述
	private float price;//商品的价格
	private int stock;//商品库存
	private int categoryLevel1Id;//商品的分类1
	private int categoryLevel2Id;//商品的分类2
	private int categoryLevel3Id;//商品的分类3
	private String fileName;//文件名称
	private int isDelete;//记录商品是否删除(1删除2未删除)
	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategoryLevel1Id() {
		return categoryLevel1Id;
	}
	public void setCategoryLevel1Id(int categoryLevel1Id) {
		this.categoryLevel1Id = categoryLevel1Id;
	}
	public int getCategoryLevel2Id() {
		return categoryLevel2Id;
	}
	public void setCategoryLevel2Id(int categoryLevel2Id) {
		this.categoryLevel2Id = categoryLevel2Id;
	}
	public int getCategoryLevel3Id() {
		return categoryLevel3Id;
	}
	public void setCategoryLevel3Id(int categoryLevel3Id) {
		this.categoryLevel3Id = categoryLevel3Id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public Easybuy_product(int id, String name, String description, float price, int stock, int categoryLevel1Id,
			int categoryLevel2Id, int categoryLevel3Id, String fileName, int isDelete) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.categoryLevel1Id = categoryLevel1Id;
		this.categoryLevel2Id = categoryLevel2Id;
		this.categoryLevel3Id = categoryLevel3Id;
		this.fileName = fileName;
		this.isDelete = isDelete;
	}
	public Easybuy_product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Easybuy_product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", stock=" + stock + ", categoryLevel1Id=" + categoryLevel1Id + ", categoryLevel2Id="
				+ categoryLevel2Id + ", categoryLevel3Id=" + categoryLevel3Id + ", fileName=" + fileName + ", isDelete="
				+ isDelete + "]";
	}
	
	


}
