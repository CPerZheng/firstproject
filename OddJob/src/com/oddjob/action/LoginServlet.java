package com.oddjob.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oddjob.biz.AdminBiz;
import com.oddjob.entity.Admin;
import com.oddjob.ibiz.IAdminBiz;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//编码方式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取提交的账号
		String zh = request.getParameter("zh");
		String pwd = request.getParameter("pwd");
		
		//调用登录逻辑层
		IAdminBiz adminbiz = new AdminBiz();
		
		//调用登录方法
		Admin admin = adminbiz.login(zh, pwd);
		
		//判断是否登录成功
		if(admin != null) {
			//登录成功
			//获取会话
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			//转到登录页面
			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);
		} else {
			//登录失败
			//重新定向
			response.sendRedirect("error.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
