<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
<form action="LoginServlet" method="post">
用户名：<input type="text" name="username"><br>
密码：<input type="password" name="password"><br>
<input type="submit" value="提交"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</form>
<a href="register.jsp">注册</a>
</body>
</html>