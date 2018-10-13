<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->
<script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
<script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>
<!--导入validate验证需要的js库-->
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<!--导入validate验证需要的js库-->
<script type="text/javascript" src="js/jquery.validate.js"></script>
<!-- <script type="text/javascript" src="js/menu.js"></script> -->

<!-- <script type="text/javascript" src="js/select.js"></script> -->

<!-- <script type="text/javascript" src="js/lrscroll.js"></script> -->

<!-- <script type="text/javascript" src="js/iban.js"></script> -->
<!-- <script type="text/javascript" src="js/fban.js"></script>
<script type="text/javascript" src="js/f_ban.js"></script>
<script type="text/javascript" src="js/mban.js"></script>
<script type="text/javascript" src="js/bban.js"></script>
<script type="text/javascript" src="js/hban.js"></script>
<script type="text/javascript" src="js/tban.js"></script> -->

<!-- <script type="text/javascript" src="js/lrscroll_1.js"></script> -->

<!-- ===========表单验证===== -->
<style>
.error {
	color: red;
}
</style>
<!--  ==========================-->
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
					href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span> <span
				class="fr">|&nbsp;<a href="#">手机版&nbsp;<img
						src="images/s_tel.png" align="absmiddle" /></a></span>
			</span>
		</div>
	</div>
	<!--End Header End-->
	<!--Begin Login Begin-->
	<div class="log_bg">
		<div class="top">
			<div class="logo">
				<a href="Index.jsp"><img src="images/logo.png" /></a>
			</div>
		</div>
		<div class="regist">
			<div class="log_img">
				<img src="images/l_img.png" width="611" height="425" />
			</div>
			<div class="reg_c">
				<form id="myForm" action="loginQD?method=add" method="post">
					<table border="0"
						style="width: 420px; font-size: 14px; margin-top: 20px;"
						cellspacing="0" cellpadding="0">
						<tr height="50" valign="top">
							<td width="95">&nbsp;</td>
							<td><span class="fl" style="font-size: 24px;">注册</span> <span
								class="fr">已有商城账号，<a href="LoginQD.jsp"
									style="color: #ff4e00;">我要登录</a></span></td>
						</tr>
						<tr height="50">
							<td align="right"><font color="#ff4e00">*</font>&nbsp;用户名
								&nbsp;</td>
							<td><input type="text" name="userName" value=""
								class="l_user" placeholder="显示的用户名" /></td>
						</tr>
						<tr height="50">
							<td align="right"><font color="#ff4e00">*</font>&nbsp;登录名
								&nbsp;</td>
							<td><input id="loginName" type="text"  name="loginName" value=""
								class="l_user" placeholder="登陆账号名" /></td>
						</tr>

						<!--               <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;用户名 &nbsp;</td>
                <td><input type="text" name="userName" value="" class="l_user" /></td>
              </tr>	 -->
						<tr height="50">
							<td align="right"><font color="#ff4e00">*</font>&nbsp;密码
								&nbsp;</td>
							<td><input type="password" name="password" value=""
								class="l_pwd" placeholder="最少6位，最多15位" /></td>
						</tr>
						<tr height="50">
							<td align="right"><font color="#ff4e00">*</font>&nbsp;确认密码
								&nbsp;</td>
							<td><input type="password" name="toPwd" value=""
								class="l_pwd" placeholder="最少6位，最多15位" /></td>
						</tr>
						<tr height="50">
							<td align="right"><font color="#ff4e00">*</font>&nbsp;其他邮箱
								&nbsp;</td>
							<td><input type="text" name="email" value="" class="l_user"
								placeholder="其他邮箱" /></td>
						</tr>
						<tr height="50">
							<td align="right"><font color="#ff4e00">*</font>&nbsp;手机号码
								&nbsp;</td>
							<td><input type="text" name="mobile" value="" class="l_user"
								placeholder="手机号码" /></td>
						</tr>

						</tr>
						<tr>
							<td>&nbsp;</td>
							<td style="font-size: 12px; padding-top: 20px;"><span
								style="font-family: '宋体';" class="fl"> <label
									class="r_rad"><input type="checkbox" /></label><label
									class="r_txt">我已阅读并接受《用户协议》</label>
							</span></td>
						</tr>
						<tr height="60">
							<td>&nbsp;</td>
							<td><input type="submit" value="立即注册" class="log_btn" /></td>
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
				src="images/b_1.gif" width="98" height="33" /><img
				src="images/b_2.gif" width="98" height="33" /><img
				src="images/b_3.gif" width="98" height="33" /><img
				src="images/b_4.gif" width="98" height="33" /><img
				src="images/b_5.gif" width="98" height="33" /><img
				src="images/b_6.gif" width="98" height="33" />
		</div>
	</div>
	<!--End Footer End -->
	<!-- ---------------------- -->
	<script>
		$(function() {
			$("#myForm").validate({
				//            验证的规则  需要对form表单中的那些元素做验证
				rules : {//验证规则
					//验证用户名不能为空
					loginName : {
						required : true,
						remote: {//验证用户名是否存在    validate自带
					          type: "post",//提交方式
					          url: "loginQD?method=logincf",//@WebServlet("/loginQD")
					          data: {//传输数据到后台 	@WebServlet("/loginQD")
					        	  loginName: function() {
					              return $("#loginName").val();//获取到表单的值发送过去   去和数据库获取的对比
					            }
					          },
					        }
					      },
					
					//验证密码不能为空，最短6位，最长10位
					password : {
						required : true,
						minlength : 6,
						maxlength : 10,

					},
					//验证二次密码不能为空，最短6位，最长10位，是否和密码一样
					toPwd : {
						required : true,
						minlength : 6,
						maxlength : 10,
						equalTo : "#mypwd"
					},
					//验证邮箱不能为空，验证邮箱格式
					email : {
						required : true,
						email : true,
					},
					mobile : {
						required : true,
						myphone : true,//要自己书写正则表达式
					},
					context : {
						required : true
					}

				},
				messages: {
					loginName : {
						required : "登录名不能为空",
						remote: "登录名已经存在"
					},
					//验证密码不能为空，最短6位，最长10位
					password : {
						required : "请输入密码",
						minlength : "密码长度不能小于6位",
						maxlength : "密码长度不能大于10位",

					},
					//验证二次密码不能为空，最短6位，最长10位，是否和密码一样
					toPwd : {
						required : "请重复输入密码",
						minlength : "密码长度不能小于6位",
						maxlength : "密码长度不能大于10位",
						equalTo : "两次密码必须一致",
					},
					email : {
						required : "请输入邮箱",
						email : "邮箱格式不正确，例如:123@163.com",
					},
					mobile : {
						required : "请输入手机号",

					},
					context : {
						required : "必须要同意协议"
					}

				},

				//文本框失去焦点立即验证
				onfocusout : function(e) {
					$(e).valid();
				}

			});

			//增加手机验证规则
			jQuery.validator.addMethod("myphone", function(value, element) {
				var mobile = /^1[3|4|5|8][0-9]\d{4,8}$/;

				return this.optional(element) || (mobile.test(value));

			}, "手机格式不正确,例如：130,140,150,180等、后面8位")

		});
	</script>


	<!-- -------------------------- -->
</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
