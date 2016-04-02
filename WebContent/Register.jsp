<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<center>
  <h1>注册新用户</h1>
  <form action="<%= request.getContextPath() %>/registerServlet" method=post>
  <table border="1" bgcolor="#0099CC">
    <tr>
      <td>用户名:
        <input type="text" name="userid">
      </td>
    </tr>
    <tr valign="middle">
      <td>密码：
        <input type="password" name="password" >
      </td>
    </tr>
    <tr>
      <td>
        <input type=submit value=提交>
      </td>
    </tr>
  </table>
  </form>
</center>
</body>
</html>