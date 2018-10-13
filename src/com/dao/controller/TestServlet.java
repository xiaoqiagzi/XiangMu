package com.dao.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.dao.bean.News;
import com.dao.service.NewsService;
import com.dao.service.impl.NewsServiceImpl;
import com.dao.util.PageInfo;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		NewsService service = new NewsServiceImpl();
		PageInfo<News> news = service.findAlls(
				Integer.parseInt(req.getParameter("pageNum")), 10);
		news.setTotal(service.getTotalCount());
		System.out.println("pageNum=====>" + req.getParameter("pageNum"));
		news.setPageNum(Integer.parseInt(req.getParameter("pageNum")));
		System.out.println("总记录数===》" + news.getTotal());
		Gson gson = new Gson();
		String json = gson.toJson(news);
		System.out.println(json);
		// 获取输出流对象
		PrintWriter writer = resp.getWriter();
		writer.print(json); // 返回数据给前台
		writer.close();
	}

}
