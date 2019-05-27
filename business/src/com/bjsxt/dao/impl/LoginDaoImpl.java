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
		//�������ݿ� ��������
				public static final String dbDriver="org.gjt.mm.mysql.Driver";
				//���ݿ����ӵ�ַ
				public static final String dbUrl="jdbc:mysql://localhost:3306/loginmanage";
				public static final String dbUser="root";
				public static final String dbPass="1111";
				Connection conn=null;	//���ݿ����Ӷ���
				PreparedStatement pstmt=null;	//�������ݿ����
				ResultSet rs=null;	//�������ݽ����
			 	String prePath=request.getHeader("Referer");
				String fileName="";
				String nick=request.getParameter("nick");
				String password=request.getParameter("pass");
				if(prePath!=null){
					fileName=prePath.substring(27);//�����ǻ�ȡ���������ҳ����ļ���
				}
		//�����ļ��������ǽ��в�ͬ�Ĵ���
		if(fileName.equals("login.jsp")){//У���¼�ǳ�������
		    //������д������Ե�¼���������У��
			try{
				Class.forName(dbDriver);//������������
				conn=DriverManager.getConnection(dbUrl,dbUser,dbPass);//ȡ�����ݿ�����
				String sql="select password,userId from user where nick='"+nick+"'";
				pstmt=conn.prepareStatement(sql); //ʵ�������ݿ��������
				rs=pstmt.executeQuery();	//ִ�в�ѯ
				String isAuto=request.getParameter("isAuto");//��ȡ�Ƿ��´��Զ���¼
				if(rs.next()){
					if(isAuto!=null&&isAuto.equals("autoLogin")){//�����¼���й�ѡ���´��Զ���¼����ô���Ǿ�Ҫ���������Ϣ��cookie�洢
						Cookie c1=new Cookie("user",nick);
						Cookie c2=new Cookie("userId",""+rs.getInt("userId"));
						c1.setMaxAge(60);//����cookie����ʱ�䣬����ʱ��֮��cookieʧЧ
						c2.setMaxAge(60);
						response.setCharacterEncoding("UTF-8");
						response.addCookie(c1);
						response.addCookie(c2);
					}
					if(rs.getString(1).equals(password)){//�ж��Ƿ���֤�ɹ������ɹ�������ת����ҳ��Ȼ����session�����¼״̬��Ϣ
						response.sendRedirect("index.jsp");
						session.setAttribute("isLogin", "ok");//��¼״̬
						session.setAttribute("user", nick);//�û���
						session.setAttribute("userId", ""+rs.getInt("userId"));//�û�id,ͨ�����ʵ�ִ����ݿ��ж�ȡ����
					}
				}
				else{//У��ʧ�ܣ��򷵻ص�¼ҳ
					response.sendRedirect("login.jsp");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{//�����˽���Ӧ�Ĳ���close()
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
		if(fileName.equals("reg.jsp")){//У���¼�ǳ�������
		    //������д�������ע����������У��
			try{
				Class.forName(dbDriver);//������������
				conn=DriverManager.getConnection(dbUrl,dbUser,dbPass);//ȡ�����ݿ�����
				String sql="insert into user (nick,password) values('"+nick+"','"+password+"')";
				pstmt=conn.prepareStatement(sql); //ʵ�������ݿ��������
				int flag=pstmt.executeUpdate();	//ִ������ ����
				out.println(flag);
				if(flag==1){
					response.sendRedirect("index.jsp");
					session.setAttribute("isLogin", "ok");
					session.setAttribute("user", nick);
					rs=pstmt.getGeneratedKeys();//��ȡ�������ݿ����Ӧid�Ա㽫��洢��session��
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
