package com.dao.service;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.Easybuy_product;
import com.dao.bean.Shopping_cart;

/**
 * 商品   增删改查 接口
 * -------------------
 * 
 * 	 ^-^: 吉祥龙龙
 * 2018年4月9日下午3:05:39
 */

public interface Easybuy_productService extends BaseService<Easybuy_product>{
	
	

	public void addCart(String id, Shopping_cart Shopping_cart);
	
}

