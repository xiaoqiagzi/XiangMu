<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
</head>
<body>
	注册成功：<a href="LoginQD.jsp">跳转登录界面</a><br/>
	登录名：${user.loginName}<br/>
	用户名：${user.userName}<br/>
	密码：${user.password}<br/>
	邮箱：${user.email}<br/>
	手机号：${user.mobile}<br/>
	
</body>
</html>