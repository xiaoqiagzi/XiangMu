package com.dao.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.dao.bean.News;
import com.dao.bean.User;
import com.dao.dao.UserDao;
import com.dao.dao.impl.UserDaoImpl;
import com.dao.service.NewsService;
import com.dao.service.UserService;
import com.dao.service.impl.NewsServiceImpl;
import com.dao.service.impl.UserServiceImpl;

/**
 * 前端用户servlet
 * -------------------
 * 
 * 	 ^-^: 吉祥龙龙
 * 2018年4月27日下午4:29:52
 */
@WebServlet("/loginQD")
public class UserServlet extends HttpServlet {
	//log4j
		public static Logger logger=Logger.getLogger(UserServiceImpl.class);
	
		private UserService service = new UserServiceImpl();
		 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				//防止请求乱码
				req.setCharacterEncoding("utf-8");
				String method=req.getParameter("method");
				
				switch (method) {
				case "login":
					//登录方法
					Login(req, resp);
					break;
				case "add":
					//注册方法
					Add(req, resp);
					break;
				case "logincf":
					//判断登录名是否重复
					logincf(req, resp);
					break; 	

				}

	}
	
	/**
	 * 判断登录名是否被存在
	 */
	private void logincf(HttpServletRequest req, HttpServletResponse resp) {
		try {
			//获取前台form输入的用户名    //判断是否存在
			if (service.finbyName(req.getParameter("loginName"))) {
				
				//System.out.println(req.getParameter("loginName"));
				//存在返回false
				resp.getWriter().print(false);
			
		}else {
			//不存在返回true
				resp.getWriter().print(true);
		}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 注册方法
	 */
	private void Add(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, IOException {
				User user= new User();
				//获取用户输入
				user.setLoginName(req.getParameter("loginName"));
				user.setUserName(req.getParameter("userName"));
				user.setPassword(req.getParameter("password"));
				user.setEmail(req.getParameter("email"));
				user.setMobile(req.getParameter("mobile"));
				
				UserDao userservice =new UserDaoImpl();
				
				if (userservice.add(user)!=0) {
					System.out.println(user+"1================");
					req.getSession().setAttribute("user", user);
					
					resp.sendRedirect("RegistYes.jsp");
				}else {
					System.out.println(user+"2================");
					resp.sendRedirect("Regist.jsp");
					
				}

		
		
	}
	/**
	 * 登录方法
	 */
	private void Login(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException, IOException {
		
		//获取用户输入
		String loginName = req.getParameter("loginName");
		String password = req.getParameter("password");
		
		Cookie c1 = new Cookie("loginName",URLEncoder.encode(loginName,"utf-8"));
		Cookie c2 = new Cookie("password",password);
		
		//设置cookie时效
		c1.setMaxAge(10);  //60*60是1小时
		c2.setMaxAge(10);  
		resp.addCookie(c1);
		resp.addCookie(c2);	
		
		//调用servlrt层代码
		UserService userservice =new UserServiceImpl();
		User user = userservice.login(loginName, password);
		
		
		if (user!=null) {
			req.getSession().setAttribute("user",user);
			resp.sendRedirect("IndexQD.jsp");
			
		}else {
			resp.sendRedirect("LoginQD.jsp");
		}
	}
	
}
