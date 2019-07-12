<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品列表</title>
</head>
<body>
<a href="addGoods.jsp">商品详情</a><br>
<table border="1">
	<tr>
		<th>商品id</th>
		<th>商品名称</th>
		<th>商品价格</th>
		<th>商品简介</th>
	</tr>
	<c:forEach items="${list}" var="good">
	 <tr>
          <td>${good.goods_id }</td>
          <td>${good.goods_name }</td>
          <td>${good.goods_price }</td>
          <td>${good.goods_type }</td>
          <td><a href="AdminGoodsServlet?method=add&id=${good.goods_id }">添加到购物车</a></td>
          </tr>
     </c:forEach>
</table>`
</body>
</html>