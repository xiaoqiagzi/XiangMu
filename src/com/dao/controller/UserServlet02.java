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
 * 后端用户servlet -------------------
 * 
 * ^-^: 吉祥龙龙 2018年4月27日下午4:30:13
 */
@WebServlet("/login")
public class UserServlet02 extends HttpServlet {
	// log4j
	public static Logger logger = Logger.getLogger(UserServiceImpl.class);
	// 实例化用户的servlet
	private UserService service = new UserServiceImpl();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String method = req.getParameter("method");

		switch (method) {
		case "login":
			// 登录方法
			Login(req, resp);
			break;
		case "add":
			// 注册方法
			Add(req, resp);
			break;
		case "logincf":
			//判断登录名是否重复
			logincf(req, resp);
			break;
		case "getAllUser":
			// 查询所有用户方法
			getAllUser(req, resp);
			break;
		case "delUser":
			// 删除用户方法
			delUser(req, resp);
			break;
		case "updateUser":
			// 修改用户方法
			updateUser(req, resp);
			break;
		case "findById":
			// 查询id
			findById(req, resp);
			break;
		}

	}
	private void logincf(HttpServletRequest req, HttpServletResponse resp) {
		try {
			if (service.finbyName(req.getParameter("loginName"))) {
				System.out.println(req.getParameter("loginName"));
				resp.getWriter().print(false);
			
		}else {
				resp.getWriter().print(true);
		}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 查询指定用户id
	 */
	private void findById(HttpServletRequest req, HttpServletResponse resp) {

		String id =req.getParameter("id");
		//根据id查询这个用户的详情
		User user=service.findByIdUser(id);
		//保存在request作用域
		req.setAttribute("user", user);
		
		try {
			//跳转到查询指定用户详情
			logger.debug("查询=用户=id方法");
			req.getRequestDispatcher("update.jsp").forward(req, resp);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 修改用户密码
	 */
	private void updateUser(HttpServletRequest req, HttpServletResponse resp) {
		logger.debug("进入修改方法");
		User user = new User();

		//用户名
		user.setUserName(req.getParameter("userName"));
	
		//密码
		user.setPassword(req.getParameter("password"));
	
		//id是int型  要强制转换成String类型
		user.setId(Integer.valueOf(req.getParameter("id")));
		
		try {
		//获取修改的属性值
		boolean flag = service.updateUser(user);
		if (flag) {
			logger.debug("修改账号密码成功");
			
				resp.sendRedirect("login?method=getAllUser");
			
		}else {
			logger.debug("修改账号密码失败");
			resp.sendRedirect("login?method=findById");
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 删除用户方法
	 */
	private void delUser(HttpServletRequest req, HttpServletResponse resp) {
		logger.debug("进入删除方法111111");
		
		boolean flag = service.deleteUser(req.getParameter("id"));
		if (flag) {
			System.err.println("删除成功");
		} else {
			System.err.println("删除失败");
		}
		try {
			//不管是否删除都会再次查询所有
			resp.sendRedirect("login?method=getAllUser");
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}

	/**
	 * 注册方法
	 */
	private void Add(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException, IOException {
		User user = new User();

		logger.debug("进入注册方法");
		// 获取用户输入
		user.setLoginName(req.getParameter("loginName"));
		user.setUserName(req.getParameter("userName"));
		user.setPassword(req.getParameter("password"));
		user.setToPwd(req.getParameter("toPwd"));

		user.setIdentityCode(req.getParameter("identityCode"));
		user.setEmail(req.getParameter("email"));

		user.setMobile(req.getParameter("mobile"));
		// sex是int类型 需要转换成String
		user.setSex(Integer.valueOf(req.getParameter("sex")));
		// type是int类型 需要转换成String
		user.setType(Integer.valueOf(req.getParameter("type")));
		UserDao userservice = new UserDaoImpl();

		if (userservice.add(user) != 0) {
			
			// System.out.println(user+"1================");
			req.getSession().setAttribute("user", user);
			logger.debug("注册成功");
			// 注册成功刷新注册页面。
			resp.sendRedirect("zhuce.jsp");
		} else {
			// System.out.println(user+"2================");
			// 注册失败再次进入注册界面
			logger.debug("注册失败");
			resp.sendRedirect("zhuce.jsp");

		}

	}

	/**
	 * 登录方法
	 */
	private void Login(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException, IOException {

		// 获取用户输入
		String loginName = req.getParameter("loginName");
		String password = req.getParameter("password");

		Cookie c1 = new Cookie("loginName", URLEncoder.encode(loginName, "utf-8"));
		Cookie c2 = new Cookie("password", password);

		// 设置cookie时效
		c1.setMaxAge(10); // 60*60 是1小时
		c2.setMaxAge(10);
		resp.addCookie(c1);
		resp.addCookie(c2);

		// 调用servlrt层代码
		UserService userservice = new UserServiceImpl();
		User user = userservice.login(loginName, password);

		if (user != null) {
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("index.jsp");

		} else {
			resp.sendRedirect("Login.jsp");
		}
	}

	/**
	 * 查询所有方法
	 */
	private void getAllUser(HttpServletRequest req, HttpServletResponse resp) {
		logger.debug("进入了查询所有用户方法");
		List<User> findAll = service.fundAllUser();

		// 把集合保存在request作用域
		req.setAttribute("findAll", findAll);
		try {
			System.out.println("111");
			// 转发到主页面
			req.getRequestDispatcher("member-list.jsp").forward(req, resp);

		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
