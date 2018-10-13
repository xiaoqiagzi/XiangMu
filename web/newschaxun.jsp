<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>欢迎页面-X-admin2.0</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
	<!-- <link rel="stylesheet" href="css/public.css" type="text/css"></link> -->
	<link rel="stylesheet" href="css/style.css" type="text/css"></link>
	
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="./lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">新闻</a>
			<a> <cite>新闻展示</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form id="form" class="layui-form layui-col-md12 x-so">
				<input class="layui-input" placeholder="修改日期" name="start"
					id="start">
		</div>
		<xblock> <span class="x-right" style="line-height: 40px">共有数据：N
			条</span> </xblock>
		<table class="layui-table">
			<thead >
				<tr>
					<th>
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th>新闻编号</th>
					<th>新闻标题</th>
					<th>修改时间</th>
					<th>图片</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="list-content">

			</tbody>
		</table>
		<div  class="pagination" id="pagination"></div>
		</form>
		
	</div>

	<script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
	<script type="text/javascript">
    //弹出一个询问框，有确定和取消按钮 
      function dal() { 
          //利用对话框返回的值 （true 或者 false） 
          if (confirm("你确定删除吗？")) { 
          	alert("删除成功"); 
           	$("#form").submit();
          } 
          else { 
              alert("取消删除"); 
          } 

      } 
      

      </script>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/jquery.pagination.js"></script>
	<script type="text/javascript">
  load(0);  //默认初始化
    /*点击查询的触发事件*/
   function  load(pageNum) {
       $.ajax({ 
           url: "test",  //需要提交的服务器地址
           type: "post",  //请求的方式
           data: {"pageNum": pageNum},  //传递给服务器的参数
           success: function (data) {  //回调函数
             var data=$.parseJSON(data);
               //清空数据
               $("#list-content").html("");
               //追加数据  data.list需要遍历的集合  list必须是pageInfo中的属性名
               $.each(data.list, function (i, news) {
              
                   //一个dom就是一个用户对象
$("#list-content").append(
"<tr><td><div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='2'><i class=\"layui-icon\">&#xe605;</i></div></td><td>"
+news.id+
"</td><td>"
+news.title+
"</td><td>"
+news.createTime+
"</td><td>"
+news.img+
"</td><td class=\"td-manage\"><a class=\"btn btn-info\" title=\"查看\" href=\"news?id="
+news.id+
"&method=findById\"><i class=\"icon-edit icon-white\">&#xe660;</i></a><a title=\"删除\" onclick=\"dal()\" href=\"news?id="
+news.id+
"&method=delNews\"><i class=\"layui-icon\">&#xe640;</i></a></td></tr>"

);
                   
});

               //渲染分页  总记录数  当前页码  每页数据量
               $('#pagination').pagination(data.total, {
                   current_page:pageNum,//当前第几页
                   items_per_page: data.pageSize,
                   callback: load,  //回调函数
                   num_edge_entries: 2,
                   load_first_page: true,
                   prev_show_always:false,
                   next_show_always:false,
                   prevCls:'prev',		//上一页class
                   nextCls:'next',		//下一页class
                   prev_text: '上一页',
                   next_text: '下一页'
               });
           }
       });
   };



</script>
</body>

</html>