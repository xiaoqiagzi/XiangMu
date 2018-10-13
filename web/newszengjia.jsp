<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- <div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="images/a_b01.gif" alt="" /></div>
  </div>
</div> -->
<!-- <div id="admin_bar">
  <div id="status">管理员： 登录  &#160;&#160;&#160;&#160;<a href="#">login out</a></div>
  <div id="channel"> </div>
</div> -->
<div id="main">
<%--   <%@include file="console_element/left.html" %> --%>
  <div id="opt_area">
    <h1 id="opt_type"> 添加新闻： </h1>
    <form id="form" action="news?method=addNews" method="post" enctype="multipart/form-data">
   
      <p>
        <label> 标题 </label>
        <input name="title" type="text" class="opt_input" />
      </p>
<!--     	<p>
        <label> 创建时间 </label>
        <input name="createTime" type="text" class="opt_input"  />
        
      </p> 
-->
      <p>
        <label> 内容 </label>
        <textarea name="content" cols="70" rows="10"></textarea>
      </p>
      <p>
        <label> 上传图片 </label>
        <input name="img" type="file" class="opt_input" />
      </p>
      <input name="action" type="hidden" value="addnews"/>
      <input type="submit" value="提交" onclick="firm()" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
  </div>
</div>
<div id="footer">
<%--   <%@include file="console_element/bottom.html" %> --%>
</div>
<script type="text/javascript" ></script>
<script type="text/javascript">
//弹出一个询问框，有确定和取消按钮 
function firm() { 
    //利用对话框返回的值 （true 或者 false） 
    if (confirm("你确定提交吗？")) { 
     	$("#form").submit();

    } 
    else { 
        alert("点击了取消"); 
    } 

} 

</script>
</body>
</html>
