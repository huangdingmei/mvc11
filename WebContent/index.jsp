<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container" style="width:400px">

	<div id="header" style="background-color:#FFA500;">
	<h1 style="margin-bottom:0;">           欢迎来到商城</h1></div>

	<div id="menu" style="background-color:#FFD700;height:200px;width:100px;float:left;">
	
    <br><a href="<%= request.getContextPath() %>/Register.jsp" >注册页面</a></br>
   	<br><a href="<%= request.getContextPath() %>/01/denglu.jsp" >登陆页面</a></br>
	</div>

<div id="content" style="background-color:#EEEEEE;height:200px;width:400px;float:left;">
</div>

<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
Copyright © 暂无@@@@@@</div>

</div>
</body>
</html>