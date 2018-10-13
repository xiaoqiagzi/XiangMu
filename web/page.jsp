<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'page.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="styles.css">
 	<link rel="stylesheet" href="css/bootstrap.css" type="text/css"></link>
	<link rel="stylesheet" href="css/public.css" type="text/css"></link>
	<link rel="stylesheet" href="css/style.css" type="text/css"></link> 
  </head>
  
  <body>
   <table  width="50%" border="1" align="center">
     <caption><h1 style="height: 50px;line-height5:0px;border: 1px">帖子列表</h1></caption>
    <thead>
    <tr>
        <td colspan="5" align="center"><div>帖子标题：<input type="text" name="title"><button type="button" onclick="javascript:load(0)" id="search">搜索</button></div> </td>
    </tr>
    <tr class="t_head">
          <th>新闻编号</th>
		  <th>新闻标题</th>
		  <th>图片位置</th>
		  <th>创建时间</th>
    </tr>
    </thead>
    <tbody id="list-content">

    </tbody>
</table>
<div  class="pagination" id="pagination"></div>





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
               $("#list-content").html('');
               //追加数据  data.list需要遍历的集合  list必须是pageInfo中的属性名
               $.each(data.list, function (i, news) {
              
                   //一个dom就是一个用户对象
                   $("#list-content").append("<tr><td>" + news.id + "</td><td>" + news.title + "</td><td>" + news.img +"<td><a href=/findReplysByInVid/"+news.id+">查看回复</a>"+"||<a href=javascript:del("+news.id+")>删除</a></td> "  +"</tr>");
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
