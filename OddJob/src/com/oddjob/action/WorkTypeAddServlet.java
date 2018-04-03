package com.oddjob.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oddjob.biz.WorkTypeBiz;
import com.oddjob.entity.WorkType;
import com.oddjob.ibiz.IWorkTypeBiz;

public class WorkTypeAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public WorkTypeAddServlet() {
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

		//设置编码信息
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取增加的类目信息
		String name = request.getParameter("tname");
		
		//增加类目到数据库
		WorkType wtype = new WorkType();
		wtype.setName(name);
		
		//新建业务类
		IWorkTypeBiz wtbiz = new WorkTypeBiz();
		
		//增加操作
		int num = wtbiz.addWork(wtype);
		
		//判断
		if(num > 0) {
			//增加操作
			response.sendRedirect("success.jsp");
		} else {
			//增加失败
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
