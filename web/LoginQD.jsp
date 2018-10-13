<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder"%>
<!DOCTYPE >
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link href="css/slide-unlock.css" rel="stylesheet" type="text/css">
<!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->
<script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
<script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>

<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>

<script type="text/javascript" src="js/select.js"></script>

<script type="text/javascript" src="js/lrscroll.js"></script>

<script type="text/javascript" src="js/iban.js"></script>
<script type="text/javascript" src="js/fban.js"></script>
<script type="text/javascript" src="js/f_ban.js"></script>
<script type="text/javascript" src="js/mban.js"></script>
<script type="text/javascript" src="js/bban.js"></script>
<script type="text/javascript" src="js/hban.js"></script>
<script type="text/javascript" src="js/tban.js"></script>

<script type="text/javascript" src="js/lrscroll_1.js"></script>

<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="js/jquery.slideunlock.js"></script>

<title>商城网</title>
</head>
<body>
	<!--Begin Header Begin-->
	<div class="soubg">
		<div class="sou">
			<span class="fr"> <span class="fl">你好，请<a
					href="LoginQD.jsp">登录</a>&nbsp; <a href="Regist.jsp"
					style="color: #ff4e00;">免费注册</a>&nbsp;
			</span> <span class="fl">|&nbsp;关注我们：</span> <span class="s_sh"><a
					href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a> </span> <span
				class="fr">|&nbsp;<a href="#">手机版&nbsp;<img
						src="images/s_tel.png" align="absmiddle" />
				</a>
			</span>
			</span>
		</div>
	</div>
	<!--End Header End-->
	<!--Begin Login Begin-->
	<div class="log_bg">
		<div class="top">
			<div class="logo">
				<a href="IndexQD.jsp"><img src="images/logo.png" /> </a>
			</div>
		</div>
		<div class="login">
			<div class="log_img">
				<img src="images/l_img.png" width="611" height="425" />
			</div>
			<div class="log_c">
				<form id="myForm" action="loginQD?method=login" method="post">
					<table border="0"
						style="width: 370px; font-size: 14px; margin-top: 30px;"
						cellspacing="0" cellpadding="0">
						<tr height="50" valign="top">
							<td width="55">&nbsp;</td>
							<td><span class="fl" style="font-size: 24px;">登录</span> <span
								class="fr">还没有商城账号，<a href="Regist.jsp"
									style="color: #ff4e00;">立即注册</a>
							</span></td>
						</tr>

						<%
							//Cookie
							String loginName = "";
							String password = "";
							//获取当前站点的所有Cookie  
							//导入响应的包！！！！！！
							Cookie[] cookies = request.getCookies();
							if (cookies != null) {
								for (int i = 0; i < cookies.length; i++) {
									if (cookies[i].getName().equals("loginName")) {
										loginName = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
									}
									if (cookies[i].getName().equals("password")) {
										password = cookies[i].getValue();
									}
								}
							}
						%>

						<tr height="70">
						<!-- pattern="^1[358]\d{9}"placeholder="以13、15、18开头的11位数字" -->
							<td>登陆名</td>
							<td><input type="text" name="loginName"
								value="<%=loginName%>" class="l_user" /></td>
						</tr>
						<tr height="70">
							<td>密&nbsp; &nbsp; 码</td>
							<td><input type="password" name="password"
								value="<%=password%>" class="l_pwd" /></td>
							<tr>
								<td>验&nbsp; &nbsp;证</td>
								<td>
									<div id="slider">
										<div id="slider_bg"></div>
										<span id="label">>></span> <span id="labelTip">拖动滑块验证</span>
									</div> <input type="hidden" id="slider_block" value="0"
									name="slider_block" />
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td style="font-size: 12px; padding-top: 20px;"><span
									style="font-family: '宋体';" class="fl"> <label
										class="r_rad"> <input type="checkbox" id="rmbuser" /></label>
										<!-- checked="true" 默认勾选 --> <label class="r_txt">记住账号</label>
								</span> <span class="fr"><a href="#" style="color: #ff4e00;">忘记密码</a></span>
								</td>
							</tr>
							<tr height="60">
								<td>&nbsp;</td>
								<td><input type="submit" value="登录" class="log_btn" /></td>
							</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<!--End Login End-->
	<!--Begin Footer Begin-->
	<div class="btmbg">
		<div class="btm">
			备案/许可证编号：蜀ICP备12009302号-1- Copyright © 2015-2018 商城网 All Rights
			Reserved. 复制必究 , Technical Support: Group <br /> <img
				src="images/b_1.gif" width="98" height="33" /> <img
				src="images/b_2.gif" width="98" height="33" /> <img
				src="images/b_3.gif" width="98" height="33" /> <img
				src="images/b_4.gif" width="98" height="33" /> <img
				src="images/b_5.gif" width="98" height="33" /> <img
				src="images/b_6.gif" width="98" height="33" />
		</div>
	</div>
	<!--End Footer End -->

</body>
<script>
	$(function() {
		var slider = new SliderUnlock("#slider", {
			successLabelTip : "验证成功"
		}, function() {
			document.getElementById("#slider_block")
					.setAttribute("value", "100");
		});
		slider.init();
	})
</script>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->



</html>
