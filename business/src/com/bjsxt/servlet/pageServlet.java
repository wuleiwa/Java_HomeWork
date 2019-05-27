package com.bjsxt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//设置相应编码格式
		resp.setContentType("text/html;charset = utf-8");
		//获取请求信息
		//处理请求
		//相应处理结果
		resp.getWriter().write("<html lang=\"en\">"
		
		+"<head>"
			+"<meta charset=\"UTF-8\">"
			+"<title>登录</title>"
			+"<style>"
				+"body{"
					+"background:#baf404;"
				+"}"
				+".head{"
					+"text-align:center;"
				+"}"
				+".login{"
					+"width:300px;"
					+"display:flex;"
					+"flex-direction:column;"
					+"margin:100px auto;"
					+"padding:20px;"
				+"}"
			+"</style>"
			+"<script type=\"text/javascript\">"
		 
			+"</script>"
		+"</head>"
		+"<body>"
			+"<form action=\"check.jsp\""+" method=\"post\""+" class=\"login\""+" id=\"login\">"
				+"<h1 class=\"head\">购购乐</h1>"
				+"<p>用户名：<input name=\"nick\" type=\"text\" id=\"user\"></p>"
				+"<p>密 码：<input name=\"pass\" type=\"password\" id=\"psw\"></p>"
				+"<p style=\"height:20px;line-height:20px;\">"
						+ "<input type=\"checkbox\" name=\"isAuto\" value=\"autoLogin\">"
						+ "<span style=\"font-size:12px;vertical-align:top;\">下次自动登录"
						+ "</span></p>"
				+"<input type=\"submit\" value=\"登录\">"
			+"</form>"
		+"</body>"
		+"</html>"
		);
	
	}
  
}
