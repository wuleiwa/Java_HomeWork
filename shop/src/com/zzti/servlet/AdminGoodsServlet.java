package com.zzti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzti.daoimpl.AdminGoodsImpl;
import com.zzti.entity.Goods;
@WebServlet("/AdminGoodsServlet")
public class AdminGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminGoodsImpl admin=new AdminGoodsImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String method=request.getParameter("method");
		String path=null;
		if("list".equals(method)) {
			request.setAttribute("list", admin.findAllGoods());
			path="goodsList.jsp";
		}else if("delete".equals(method)) {
			String id=request.getParameter("id");
			admin.deleteGoods(id);
			path="AdminGoodsServlet?method=list";
		}else if("add".equals(method)) {
			String goods_id="";
	        for(int i=0;i<5;i++)
	        	goods_id+=String.valueOf((int)(Math.random()*10));
			String goods_name=request.getParameter("busiName"); 
			double goods_price=Double.parseDouble(request.getParameter("busiValue")); 
			String goods_type=request.getParameter("busiType"); 
			int goods_count=Integer.parseInt(request.getParameter("busiNum")); 
			Goods goods=new Goods(goods_id,goods_name,goods_price,goods_type,goods_count);
			admin.addGoods(goods);
			path="AdminGoodsServlet?method=list";
		}else if("addbusi".equals(method)) {
			String goods_id="";
	        for(int i=0;i<5;i++)
	        	goods_id+=String.valueOf((int)(Math.random()*10));
			String goods_name=request.getParameter("busiName"); 
			double goods_price=Double.parseDouble(request.getParameter("busiValue")); 
			String goods_type=request.getParameter("busiType"); 
			int goods_count=Integer.parseInt(request.getParameter("busiNum")); 
			Goods goods=new Goods(goods_id,goods_name,goods_price,goods_type,goods_count);
			admin.addGoods(goods);
			path="AdminGoodsServlet?method=list";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
