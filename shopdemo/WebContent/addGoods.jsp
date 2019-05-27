<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加商品</title>
</head>
<body>
<form action="AdminGoodsServlet?method=add" method="post">
商品名称：<input type="text" name="goods_name">
商品价格：<input type="text" name="goods_price">
商品信息：<input type="text" name="goods_info">
商品数量：<input type="text" name="goods_count">
<input type="submit" value="提交">
</form>
</body>
</html>