package com.dao.bean;
/**
 * 购物项（购物车中的内容）
 */
public class CartItem<T> {
	
	private Easybuy_product product;//商品
	private int num;//数量
	private double price;//商品的总价
	
	
	@Override
	public String toString() {
		return "CartItem [product=" + product + ", num=" + num + ", price=" + price + "]";
	}
	public Easybuy_product getProduct() {
		return product;
	}
	public void setProduct(Easybuy_product product2) {
		this.product = product2;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	// 商品总金额计算
	public double getPrice() {
		return product.getPrice()*num;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CartItem(Easybuy_product product, int num, double price) {
		super();
		this.product = product;
		this.num = num;
		this.price = price;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
