<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
</head>
<body>
<table border="1">
	<tr>
		<th>商品id</th>
		<th>商品名称</th>
		<th>商品价格</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${list}" var="good">
	 <tr>
          <td>${good.goods_id }</td>
          <td>${good.goods_name }</td>
          <td>${good.goods_price}</td>
          <td><a href="AdminGoodsServlet?method=delete&id=${good.goods_id }">删除</a></td>
          </tr>
     </c:forEach>
</table>`
</body>
</html>