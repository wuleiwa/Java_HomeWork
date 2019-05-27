package com.bjsxt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<html>"
		+"<head>"
			+"<meta charset=\"UTF-8\">"
			+"<title>一起购物吧</title>"
			+"<link rel=\"stylesheet\" href=\"css/shop.css\">"
			+"<script src=\"js/shop.js\"></script>"
		+"</head>"
		+"<body>"
			+"<header id=\"header\">"
				+"<p id=\"logo\">购购乐</p>"
				+"<p>"
					+"<span id=\"login\">登录</span>"
					+"<span id=\"register\">注册</span>"
				+"</p>"
			+"</header>"
			+"<div id=\"content\">"
				+"<section id=\"lists\">"
					+"<p class=\"title\">商品列表</p>"
					+"<div class=\"listItem\">"
						+"<p class=\"name\">时尚板鞋</p>"
						+"<div class=\"detail\">"
							+"<div class=\"pContent\">"
								+"<img class=\"pImg\" src=\"img/shoe.jpg\" alt=\"\">"	
								+"<p class=\"desc\">New Balance 和 J.Crew 带来这款全新的联名鞋款，选用 New Balance 997 的创作雏形，宛如牛奶糖般的焦糖色泽作主配色，以及贯穿深棕色和奶油色系添增分明层次，以高规格的美制水准搭配牛巴革、麂皮和皮革等上乘材质作为鞋身用料，质感满满。"
										+ "</p>"
							+"</div>"				
							+"<div class=\"list-side\">"
								+"<button class=\"goCart\">加入购物车</button>"
								+"<div class=\"pInfo\">"
									+"<p><span class=\"pPrice\">400</span>元</p>"
									+"<p>剩余库存<span class=\"pCount\">300</span>件</p>"
								+"</div>"
							+"</div>"	
						+"</div>"
					+"</div>"
					+"<div class=\"pageDiv\">"
						+"<span class=\"pre go\" onclick=\"pre()\">上一页</span>"
					+"<span id=\"page\">1</span>页"
					+ "<span class=\"next go\" onclick=\"next()\">下一页</span>"
					+"</div>"
				+"</section>"
				+"<aside id=\"shopCart\">"
					+"<p class=\"title\">购物车</p>"
					+"<div class=\"listItem\">"
						+"<p class=\"name\">时尚板鞋</p>"
						+"<div class=\"cartCon\">"
							+"<p><img class=\"cartImg\" src=\"img/shoe.jpg\" alt=\"\">"
							+ "</p>"
							+"<div class=\"op\">"
								+"<p><input class=\"count\" id=\"count\" type=\"number\" value=\"1\">"
								+ "<span class=\"unit\">件</span>"
								+ "<button class=\"del\">删除</button>"
								+ "</p>"
								+"<p class=\"price\">金额:210元</p>"
							+"</div>"
						+"</div>"
					+"</div>"
					+"<p class=\"allCount\">总金额:210元</p>"
					+"<p class=\"finalOp\">"
					+ "<button class=\"clearCart\">清空购物车</button>"
					+ "<button class=\"pay\">支付</button>"
					+ "</p>"
				+"</aside>"
			+"</div>"
			+"<footer id=\"footer\">"
				+"<p>了解购购乐 | 购购乐资讯 | 帮助中心 | 联系我们 | 合作伙伴</p>"
				+"<p>购购乐 赣ICP备18002046号</p>"
			+"</footer>"
		+"</body>"
		+"</html>"
		);
	}

}
