package com.dao.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.dao.bean.User;
import com.dao.service.impl.UserServiceImpl;
import com.sun.net.httpserver.Filter.Chain;

@WebFilter("/index.jsp")
public class UserLoginFilter implements Filter {
	// log4j 记录
	public static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.debug("初始化========init");

	}

	@Override
	public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain chain)
			throws IOException, ServletException {

		// 强制类型转换成HttpServletRequest 向上转型，才能调用session
		HttpServletRequest req = (HttpServletRequest) Request;
		// 强制类型转换成HttpServletRequest 向上转型，才能调用session
		HttpServletResponse resp = (HttpServletResponse) Response;

		// 从根本上解决乱码问题
		req.setCharacterEncoding("utf-8");
		// 向session传入用户信息
		User user = (User) req.getSession().getAttribute("user");

		// 获取到uri地址
		String requestURI = req.getRequestURI();

		// 如果user不为空就放行，或者包含login放行

		// 放行
		// chain.doFilter(req, resp);

		if (user != null) {

			// 放行
			chain.doFilter(req, resp);
		} else {
			resp.sendRedirect("Login.jsp");

		}

	}

	@Override
	public void destroy() {
		logger.debug("销毁========destroy");

	}

}
