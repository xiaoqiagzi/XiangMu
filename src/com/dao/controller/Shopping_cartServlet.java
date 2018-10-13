package com.dao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.bean.CartItem;
import com.dao.bean.Easybuy_product;
import com.dao.bean.Shopping_cart;
import com.dao.bean.User;
import com.dao.service.Easybuy_productService;
import com.dao.service.Shopping_cartService;
import com.dao.service.impl.Easybuy_productServiceImpl;
import com.dao.service.impl.Shopping_cartServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
@WebServlet("/Shopping_cart")
public class Shopping_cartServlet extends HttpServlet{
	
	private Easybuy_productService eps = new Easybuy_productServiceImpl();
	private Shopping_cartService scs = new Shopping_cartServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		switch (method) {
		case "shopping":
			shopping(req,resp);
			break;
		case "addCart":
			addCart(req,resp);
			break;
		case "UIDShopping_cart":
			UIDShopping_cart(req,resp);
			break;

		}
		
		
	}
	
	/**
	 *	向购物车添加商品
	 * @param req
	 * @param resp
	 */
	private void addCart(HttpServletRequest req, HttpServletResponse resp) {
		String uid = req.getParameter("uid");
		System.out.println("5555555"+uid);
		String pid = req.getParameter("pid");
		System.out.println("商品：===>"+pid);
		Cookie[] cookies = req.getCookies();
		Shopping_cart shopping_cart =null;
		
		Gson gson = new Gson();
		
		if (null!=cookies) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("shopping_cart")) {
					
					try {
						shopping_cart=gson.fromJson(URLDecoder.decode(cookie.getValue(),"UTF-8"),Shopping_cart.class);
						
						
					} catch (JsonSyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
			}
		}
		if (null==shopping_cart) {
			System.out.println("第一次购买添加");
			shopping_cart = new Shopping_cart();
		}
		
		
		eps.addCart(pid, shopping_cart);

		if (uid!=null) {
			huiyuan(uid,pid,shopping_cart,0,resp);
			Cookie cookie = new Cookie("shopping_cart",null);
			cookie.setPath("/");
			cookie.setMaxAge(-0);
			resp.addCookie(cookie);
		}else {
			String json =gson.toJson(shopping_cart);
	
			System.out.println("存入cookie中==》"+json);
			Cookie cookie ;
			
			try {
				cookie=new Cookie("shopping_cart",URLEncoder.encode(json, "UTF-8"));
				cookie.setPath("/");
				cookie.setMaxAge(60*60);
			resp.addCookie(cookie);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
	}
	/**
	 * 会员登录
	 * @param uid
	 * @param pid
	 * @param shopping_cart
	 * @param i
	 * @param resp
	 */
	private void huiyuan(String uid, String pid, Shopping_cart shopping_cart, int num, HttpServletResponse resp) {
		Shopping_cart sc =scs.findById(uid, pid);
		
		if (sc!=null && sc.getUserId()==Integer.parseInt(uid)&&sc.getOrderId()==Integer.parseInt(pid)) {
			if (0>num) {
				sc.setOrderNum(sc.getOrderNum()+num);
			}else {
				sc.setOrderNum(sc.getOrderNum()+1);
			}
			scs.delete(sc);
		}else {
			shopping_cart.setUserId(Integer.parseInt(uid));
			
			int numbb=0;
			if (num==0) {
				numbb=scs.save(uid, pid, 1);
			}else {
				numbb=scs.save(uid, pid, num);
			}
			
			if (numbb>0) {
				System.out.println("成功");
			}
		}
		
		
		
	}

	private void UIDShopping_cart(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("我进来了");
		User user=(User)req.getSession().getAttribute("user");
		Cookie[]cookies =req.getCookies();
		List<Shopping_cart> UID = null;
		
		String json = null;
		Gson gson = new Gson();
		
		Map<Integer, CartItem> map = new LinkedHashMap<>();
		if (user!=null) {
			
			System.out.println("有用户的时候进入");
			if (cookies!=null) {
				System.out.println("有用户的时候从ccookie");
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("shopping_cart")) {
						try {
							json = URLDecoder.decode(cookie.getValue(),"utf-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						System.out.println("ttttttttttt"+json);
		
						Shopping_cart shopping_cart = gson.fromJson(json, Shopping_cart.class);
						Map<Integer,CartItem> maps =shopping_cart.getMap();
						Set<Entry<Integer,CartItem>> entrySet = maps.entrySet();
						Iterator<Entry<Integer,CartItem>> meIt = entrySet.iterator();
						
						while (meIt.hasNext()) {
							Entry<Integer ,CartItem> entry = meIt.next();
							
							huiyuan(user.getId()+"",entry.getKey().toString(),shopping_cart,entry.getValue().getNum(),resp);
							
						}
						System.out.println("清除Cookie");
						cookie = new Cookie ("shopping_cart",null);
						cookie.setPath("/");
						cookie.setMaxAge(-0);
						resp.addCookie(cookie);

					}
				
				}

			}
			Shopping_cart shopping_cart = new Shopping_cart();
			List<Shopping_cart> uid2 = scs.UID(user.getId());
			for (int i = 0; i < uid2.size(); i++) {
				int orderId = Integer.valueOf(uid2.get(i).getOrderId());
				int userId = Integer.valueOf(uid2.get(i).getUserId());
				int orderNum = uid2.get(i).getOrderNum();
				if (userId==user.getId()) {
					CartItem ct = new CartItem();
					ct.setNum(orderNum);
					ct.setProduct(eps.findById(orderId));
					map.put(orderId, ct);
					
					uid2.get(i).setMap(map);
					shopping_cart.setUserId(userId);
					shopping_cart.setMap(map);
				}
				
			}
			
			
			
			json = gson.toJson(shopping_cart);
			
			try {
				PrintWriter Writer  = resp.getWriter();
				Writer.print(json);
				Writer.close();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}else {
			
			Shopping_cart shopping_cart = null;
			if (cookies!=null) {
				System.out.println(">>>>>>>");
				
				for(Cookie cookie: cookies) {
					System.out.println("1111"+cookie);
					
					if (cookie.getName().equals("shopping_cart")) {
						System.out.println(22222);
						try {
							json=URLDecoder.decode(cookie.getValue(),"utf-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						System.out.println(">>>json:"+json);

					}
				}
			}
		}
		PrintWriter writer;
		try {
			writer = resp.getWriter();
			writer.print(json);
			System.out.println("88888"+json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	
	
	}

	private void shopping(HttpServletRequest req, HttpServletResponse resp) {
		
		String id =req.getParameter("id");
		Easybuy_product findById = eps.findById(id);
		
		req.getSession().setAttribute("product", findById);
		
		try {
			resp.sendRedirect("Product.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
