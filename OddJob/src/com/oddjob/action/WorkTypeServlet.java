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

import com.oddjob.biz.WorkTypeBiz;
import com.oddjob.ibiz.IWorkTypeBiz;

public class WorkTypeServlet extends HttpServlet {

	//定义分页属性
	private int pageNo = 1;//默认显示第一页
	private int pageSize = 5;//默认每页显示5条数据
	/**
	 * Constructor of the object.
	 */
	public WorkTypeServlet() {
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
		
		//获取查询名称
		String keyword = request.getParameter("keyword");
		
		//判断查询关键字是否为空
		if(keyword == null) {
			keyword = "";
		}
		
		//调用业务层查询
		IWorkTypeBiz wtbiz = new WorkTypeBiz();
		
		//获取页面传递过来的当前页-查询的页数
		String pageNo_tmp = request.getParameter("pageNo");
		//判断
		if(pageNo_tmp != null && !pageNo_tmp.equals("")) {
			pageNo =Integer.valueOf(pageNo_tmp);
		} else {
			pageNo = 1;
		}
		//查询分页数据
		Map map = wtbiz.getWorkTypePages(pageNo, pageSize, keyword);
		//List worktypelist = worktypebiz.getWorkByName(keyword);
		
		//取分页信息
		String totalPages = map.get("totalPages").toString();
		String totalRecords = map.get("totalRecords").toString();
		List worktypelist = (List)map.get("data");
		
		//将查询的结果存入request
		request.setAttribute("worktypelist", worktypelist);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("totalRecords", totalRecords);
		
		
		
		//查询到之后跳转到页面显示
		RequestDispatcher rd = request.getRequestDispatcher("worktype_list.jsp");
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
