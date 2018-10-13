<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/bootstrap.css" />

<!--导入validate验证需要的js库-->
<script src="js/jquery-1.8.3.js"></script>
<!--导入validate验证需要的js库-->

<script src="js/jquery.validate.js"></script>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<div class="container">

		<h1 class="page-header">
			<span class="glyphicon glyphicon-user"></span>用户注册
		</h1>
		</div>
		<form id="myForm" action="login?method=add" method="post"
class="form-horizontal">
			<div class="form-group">
				<div class="col-md-5">
					<input id="loginName" type="text" name="loginName" placeholder="登录名"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-5">
					<input type="text" name="userName" placeholder="用户名"
						class="form-control" />

				</div>
			</div>
			<div class="form-group">
				<div class="col-md-5">
					<input id="mypwd" type="password" name="password" placeholder="密码"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-5">

					<input  type="password" name="toPwd" placeholder="确认密码"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-5">
					<input type="text" name="sex" placeholder="性别(1:男 0：女)"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-5">
					<input type="text" name="identityCode" placeholder="身份证号"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-5">
					<input type="text" name="email" placeholder="邮箱"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-5">
					<input type="text" name="mobile" placeholder="手机号"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-5">
					<input type="text" name="type" placeholder="账户类型（1：后台 0:前台）"
						class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-5">
					<input type="checkbox" name="checkbox" class="form-control" />我已阅读并接受《用户协议》
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-5">
					<input type="submit" onclick="yes()" value="立即注册"
						class="btn btn-primary btn-block" />
				</div>
			</div>
		</form>


		<script type="text/javascript">
			//弹出一个询问框，有确定和取消按钮 
			function yes() {
				//利用对话框返回的值 （true 或者 false） 
				if (confirm("确认注册吗？")) {
					alert("注册成功");
					$("#myForm").submit();

				} else {
					alert("取消");
				}

			}
		</script>
		<script type="text/javascript">
			$(function() {
				$("#myForm").validate({
					//            验证的规则  需要对form表单中的那些元素做验证
					rules : {
						//验证用户名不能为空
						loginName : {

							required : true,
							remote: {//验证用户名是否存在    validate自带
						          type: "post",//提交方式
						          url: "login?method=logincf",//@WebServlet("/loginQD")
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
							maxlength : 10
						},
						//验证二次密码不能为空，最短6位，最长10位，是否和密码一样
						toPwd : {
							required : true,
							minlength : 6,
							maxlength : 10,
							equalTo : "#mypwd"
						},
						//验证身份证不能为空，验证身份证格式
						identityCode : {
							required : true,
							
						},
						//验证邮箱不能为空，验证邮箱格式
						email : {
							required : true,
							email : true
						},
						//验证手机号不能为空，验证手机号格式在下面
						mobile : {
							required : true,
							myphone : true,//要自己书写正则表达式
						},
						context : {
							required : true
						}

					},
					messages : {
						loginName : {
							required : "用户名不能为空",
							remote: "用户名已经存在"
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
						identityCode : {
							required : "请输入身份证号"
							
						},
						email : {
							required : "请输入邮箱",
							email : "邮箱格式不正确",
						},
						mobile : {
							required : "请输入手机号"

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

				}, "手机格式不正确")

			})
		</script>
</body>
</html>