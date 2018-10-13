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

</head>
<body>
<h1>${user.id}</h1>
	<div class="container">

		<h1 class="page-header">
			<span class="glyphicon glyphicon-user"></span>修改用户名和密码
		</h1>
		</div>
		<form id="myForm" action="login?method=updateUser" method="post"
			class="form-horizontal">
			<div class="form-group">
				<div class="col-md-5">
					<input id="id" type="text" name="id" value="${user.id}" placeholder="id"
						class="form-control" readonly="readonly"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-5">
					<input type="text" name="userName" placeholder="用户名"
					value="${user.userName}" class="form-control" />

				</div>
			</div>
			<div class="form-group">
				<div class="col-md-5">
					<input id="mypwd" type="password" name="password" value="${user.password}" placeholder="密码"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-5">

					<input  type="password" name="toPwd" ${user.toPwd} placeholder="确认密码"
						class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-md-5">
					<input type="submit" onclick="yes()" value="提交"
						class="btn btn-primary btn-block" />
				</div>
			</div>
		</form>


		<script type="text/javascript">
			//弹出一个询问框，有确定和取消按钮 
			function yes() {
				//利用对话框返回的值 （true 或者 false） 
				if (confirm("确认修改吗？")) {
					alert("修改密码成功");
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
						}
					
					},
					messages : {
						
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
						}
						
					},

					//文本框失去焦点立即验证
					onfocusout : function(e) {
						$(e).valid();
					}

				});

				
			})
		</script>
</body>
</html>