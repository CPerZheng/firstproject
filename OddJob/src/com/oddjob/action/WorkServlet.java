package com.oddjob.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oddjob.biz.WorkBiz;
import com.oddjob.biz.WorkTypeBiz;
import com.oddjob.ibiz.IWorkBiz;
import com.oddjob.ibiz.IWorkTypeBiz;

public class WorkServlet extends HttpServlet {

	//定义分页属性
	private int pageNo = 1;
	private int pageSize = 5;
	/**
	 * Constructor of the object.
	 */
	public WorkServlet() {
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
		
		//进行登录判断,是否已登录
		//未登录则跳转
		
		//获取提交的查询名称
		String keyword1 = request.getParameter("keyword1");
		String keyword2 = request.getParameter("keyword2");
		
		//判断关键字是否为空
		if(keyword1 == null) {
			keyword1 = "";
		}
		
		//判断查询的零工类目
		if(keyword2 == null || keyword2.equals("") || keyword2.equals("0")) {
			keyword2 = "";
		}
		
		//调用业务层查询
		IWorkBiz iwbiz = new WorkBiz();
		
		//获取页面传递过来的当前页-查询的页数
		String pageNo_tmp = request.getParameter("pageNo");
		//判断
		if(pageNo_tmp != null && !pageNo_tmp.equals("")) {
			pageNo = Integer.valueOf(pageNo_tmp);
		} else {
			pageNo = 1;
		}
		
		// 查询分页数据
		Map map = iwbiz.getWorkTyesByPages(pageNo, pageSize, keyword1, keyword2);

		// 取分页信息
		String totalPages = map.get("totalPages").toString();
		String totalRecords = map.get("totalRecords").toString();
		List worklist = (List) map.get("data");

		// 将查询的结果存入request
		request.setAttribute("worklist", worklist);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("totalRecords", totalRecords);
		
		//初始化查询页面的商品类目
		// 新建业务类
		IWorkTypeBiz wtbiz = new WorkTypeBiz();
		
		List wtlist = wtbiz.getWorkByName("");
		
		//将结果存入request
		request.setAttribute("wtlist", wtlist);
		
		//转发到显示页面
		RequestDispatcher rd = request.getRequestDispatcher("work_list.jsp");
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
