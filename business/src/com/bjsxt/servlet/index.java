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
			+"<title>һ�����</title>"
			+"<link rel=\"stylesheet\" href=\"css/shop.css\">"
			+"<script src=\"js/shop.js\"></script>"
		+"</head>"
		+"<body>"
			+"<header id=\"header\">"
				+"<p id=\"logo\">������</p>"
				+"<p>"
					+"<span id=\"login\">��¼</span>"
					+"<span id=\"register\">ע��</span>"
				+"</p>"
			+"</header>"
			+"<div id=\"content\">"
				+"<section id=\"lists\">"
					+"<p class=\"title\">��Ʒ�б�</p>"
					+"<div class=\"listItem\">"
						+"<p class=\"name\">ʱ�а�Ь</p>"
						+"<div class=\"detail\">"
							+"<div class=\"pContent\">"
								+"<img class=\"pImg\" src=\"img/shoe.jpg\" alt=\"\">"	
								+"<p class=\"desc\">New Balance �� J.Crew �������ȫ�µ�����Ь�ѡ�� New Balance 997 �Ĵ������Σ�����ţ���ǰ�Ľ���ɫ��������ɫ���Լ��ᴩ����ɫ������ɫϵ����������Σ��Ը߹�������ˮ׼����ţ�͸��Ƥ��Ƥ����ϳ˲�����ΪЬ�����ϣ��ʸ�������"
										+ "</p>"
							+"</div>"				
							+"<div class=\"list-side\">"
								+"<button class=\"goCart\">���빺�ﳵ</button>"
								+"<div class=\"pInfo\">"
									+"<p><span class=\"pPrice\">400</span>Ԫ</p>"
									+"<p>ʣ����<span class=\"pCount\">300</span>��</p>"
								+"</div>"
							+"</div>"	
						+"</div>"
					+"</div>"
					+"<div class=\"pageDiv\">"
						+"<span class=\"pre go\" onclick=\"pre()\">��һҳ</span>"
					+"<span id=\"page\">1</span>ҳ"
					+ "<span class=\"next go\" onclick=\"next()\">��һҳ</span>"
					+"</div>"
				+"</section>"
				+"<aside id=\"shopCart\">"
					+"<p class=\"title\">���ﳵ</p>"
					+"<div class=\"listItem\">"
						+"<p class=\"name\">ʱ�а�Ь</p>"
						+"<div class=\"cartCon\">"
							+"<p><img class=\"cartImg\" src=\"img/shoe.jpg\" alt=\"\">"
							+ "</p>"
							+"<div class=\"op\">"
								+"<p><input class=\"count\" id=\"count\" type=\"number\" value=\"1\">"
								+ "<span class=\"unit\">��</span>"
								+ "<button class=\"del\">ɾ��</button>"
								+ "</p>"
								+"<p class=\"price\">���:210Ԫ</p>"
							+"</div>"
						+"</div>"
					+"</div>"
					+"<p class=\"allCount\">�ܽ��:210Ԫ</p>"
					+"<p class=\"finalOp\">"
					+ "<button class=\"clearCart\">��չ��ﳵ</button>"
					+ "<button class=\"pay\">֧��</button>"
					+ "</p>"
				+"</aside>"
			+"</div>"
			+"<footer id=\"footer\">"
				+"<p>�˽⹺���� | ��������Ѷ | �������� | ��ϵ���� | �������</p>"
				+"<p>������ ��ICP��18002046��</p>"
			+"</footer>"
		+"</body>"
		+"</html>"
		);
	}

}
