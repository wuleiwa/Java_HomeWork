package com.bjsxt.dao.impl;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import com.bjsxt.pojo.User;
import com.bjsxt.dao.LoginDao;



public class LoginDaoImpl implements LoginDao{


	@Override
	public User checkLoginDao(String uname, String pwd) {
		//定义数据库 驱动程序
				public static final String dbDriver="org.gjt.mm.mysql.Driver";
				//数据库连接地址
				public static final String dbUrl="jdbc:mysql://localhost:3306/loginmanage";
				public static final String dbUser="root";
				public static final String dbPass="1111";
				Connection conn=null;	//数据库连接对象
				PreparedStatement pstmt=null;	//声明数据库操作
				ResultSet rs=null;	//声明数据结果集
			 	String prePath=request.getHeader("Referer");
				String fileName="";
				String nick=request.getParameter("nick");
				String password=request.getParameter("pass");
				if(prePath!=null){
					fileName=prePath.substring(27);//这里是获取发送请求的页面的文件名
				}
		//根据文件名，我们进行不同的处理
		if(fileName.equals("login.jsp")){//校验登录昵称与密码
		    //这里填写的是针对登录的相关数据校验
			try{
				Class.forName(dbDriver);//加载驱动程序
				conn=DriverManager.getConnection(dbUrl,dbUser,dbPass);//取得数据库连接
				String sql="select password,userId from user where nick='"+nick+"'";
				pstmt=conn.prepareStatement(sql); //实例化数据库操作对象
				rs=pstmt.executeQuery();	//执行查询
				String isAuto=request.getParameter("isAuto");//获取是否下次自动登录
				if(rs.next()){
					if(isAuto!=null&&isAuto.equals("autoLogin")){//如果登录框中勾选了下次自动登录，那么我们就要进行相关信息的cookie存储
						Cookie c1=new Cookie("user",nick);
						Cookie c2=new Cookie("userId",""+rs.getInt("userId"));
						c1.setMaxAge(60);//设置cookie储存时间，过了时间之后，cookie失效
						c2.setMaxAge(60);
						response.setCharacterEncoding("UTF-8");
						response.addCookie(c1);
						response.addCookie(c2);
					}
					if(rs.getString(1).equals(password)){//判断是否验证成功，若成功，则跳转到主页，然后用session保存登录状态信息
						response.sendRedirect("index.jsp");
						session.setAttribute("isLogin", "ok");//登录状态
						session.setAttribute("user", nick);//用户名
						session.setAttribute("userId", ""+rs.getInt("userId"));//用户id,通过这个实现从数据库中读取数据
					}
				}
				else{//校验失败，则返回登录页
					response.sendRedirect("login.jsp");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{//别忘了将相应的操作close()
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}

		}
		if(fileName.equals("reg.jsp")){//校验登录昵称与密码
		    //这里填写的是针对注册的相关数据校验
			try{
				Class.forName(dbDriver);//加载驱动程序
				conn=DriverManager.getConnection(dbUrl,dbUser,dbPass);//取得数据库连接
				String sql="insert into user (nick,password) values('"+nick+"','"+password+"')";
				pstmt=conn.prepareStatement(sql); //实例化数据库操作对象
				int flag=pstmt.executeUpdate();	//执行数据 插入
				out.println(flag);
				if(flag==1){
					response.sendRedirect("index.jsp");
					session.setAttribute("isLogin", "ok");
					session.setAttribute("user", nick);
					rs=pstmt.getGeneratedKeys();//获取插入数据库的相应id以便将其存储到session中
					int id=0;
					if(rs.next()){
						id=rs.getInt("userId");
						session.setAttribute("userId", ""+id);
					}
				}
				else{
					response.sendRedirect("reg.jsp");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}
			
		}
		if(session.getAttribute("isLogin")!=null&&session.getAttribute("isLogin").equals("ok")){
			response.sendRedirect("index.jsp");
		}
	}
	
}
