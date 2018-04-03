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

public class WorkTypeDoEdit extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public WorkTypeDoEdit() {
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
		
		//获取要修改的id和name
		String id = request.getParameter("tid");
		String name = request.getParameter("tname");
		
		//将修改的结果存入数据库
		WorkType wtype = new WorkType();
		//获取id的整型值
		wtype.setId(Integer.valueOf(id).intValue());
		wtype.setName(name);
		
		//新建业务类
		IWorkTypeBiz wtypebiz = new WorkTypeBiz();
		
		//返回值:num(受影响函数)
		int num = wtypebiz.updateWork(wtype);
		
		//判断num是否大于0,大于0则修改成功
		if(num > 0) {
			//修改成功
			response.sendRedirect("success.jsp");
		} else {
			//修改失败
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
