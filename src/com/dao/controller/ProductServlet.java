package com.dao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.dao.bean.CartItem;
import com.dao.bean.Easybuy_product;
import com.dao.bean.News;
import com.dao.bean.Shopping_cart;
import com.dao.bean.User;
import com.dao.dao.Shopping_cartDao;
import com.dao.dao.impl.Shopping_cartDaoImpl;
import com.dao.service.Easybuy_productService;
import com.dao.service.Shopping_cartService;
import com.dao.service.impl.Easybuy_productServiceImpl;
import com.dao.service.impl.NewsServiceImpl;
import com.dao.service.impl.Shopping_cartServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class productServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//log4j
		public static Logger logger=Logger.getLogger(NewsServiceImpl.class);

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String method = req.getParameter("method");
			switch (method) {
			case "shows":
				shows(req,resp);
				break;
			}
		}
		
		private void shows(HttpServletRequest req, HttpServletResponse resp) {
			Easybuy_productService eps =new Easybuy_productServiceImpl();
			
			List<Easybuy_product> productServlet =eps.findAll();
			Gson gson =new Gson();
			String json =gson.toJson(productServlet);
			
			PrintWriter writer;
			try {
				writer=resp.getWriter();
				writer.println(json);
				writer.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}

		
		
		
}		
		
		
		
		