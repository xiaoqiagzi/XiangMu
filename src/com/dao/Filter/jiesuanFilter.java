package com.dao.Filter;

import com.dao.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/BuyCar_Two.jsp")
public class jiesuanFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain chain) throws ServletException, IOException {
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
            resp.sendRedirect("LoginQD.jsp");

        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
