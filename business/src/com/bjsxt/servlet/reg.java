package com.bjsxt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class reg
 */
@WebServlet("/reg")
public class reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
   @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   resp.getWriter().write("<html lang=\"en\">"
	   +"<head>"
	   	+"<meta charset=\"UTF-8\">"
	   
	   +"<title>注册</title>"
	   	+"<style>"
	   		+"body{"
	   			+"background:#baf404;"
	   		+"}"
	   		+".head{"
	   			+"text-align:center;"
	   		+"}"
	   		+".reg{"
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
	    
	   	+"<form action=\"check.jsp\" method=\"post\" class=\"reg\" id=\"reg\">"
	   		+"<h1 class=\"head\">注册购购乐</h1>"
	   		+"<p>用户名：<input name=\"nick\" type=\"text\" id=\"user\"></p>"
	   		+"<p>密 码：<input name=\"pass\" type=\"password\" id=\"psw\"></p>"
	   		+"<input type=\"submit\" value=\"注册\">"
	   	+"</form>"
	   +"</body>"
	   +"</html>"
	   );
	   
	}

}
