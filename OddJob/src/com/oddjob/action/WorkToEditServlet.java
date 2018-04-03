package com.oddjob.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oddjob.biz.WorkBiz;
import com.oddjob.biz.WorkTypeBiz;
import com.oddjob.entity.Work;
import com.oddjob.ibiz.IWorkBiz;
import com.oddjob.ibiz.IWorkTypeBiz;

public class WorkToEditServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public WorkToEditServlet() {
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

		//设置编码方式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取编号
		String id = request.getParameter("id");
		
		//查询出类目
		IWorkBiz iwbiz = new WorkBiz();
		IWorkTypeBiz iwtbiz = new WorkTypeBiz();
		Work work = iwbiz.getWorkById(id);
		
		//初始化查询页面的零工类目
		List wtlist = iwtbiz.getWorkByName("");
		
		// 将查询的结果存入request
		request.setAttribute("wtlist", wtlist);
		
		// 将查询的结果存入request
		request.setAttribute("work", work);
		
		// 转发至显示页面
		RequestDispatcher rd = request.getRequestDispatcher("work_edit.jsp");
		rd.forward(request, response);
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
