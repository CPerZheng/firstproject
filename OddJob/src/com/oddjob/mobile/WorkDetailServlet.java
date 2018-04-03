package com.oddjob.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.oddjob.biz.WorkBiz;
import com.oddjob.entity.Work;
import com.oddjob.ibiz.IWorkBiz;

public class WorkDetailServlet extends HttpServlet {

	private Map map = new HashMap();
	private String result;
	
	/**
	 * Constructor of the object.
	 */
	public WorkDetailServlet() {
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
		
		//获取传递过来的数据
		String id = request.getParameter("workid");
		
		//调用业务层
		IWorkBiz  iwbiz = new WorkBiz();
		//查询
		Work work = iwbiz.getWorkById(id);
		
		//判断
		if(work != null) {
			map.put("work", work);
		} else {
			map.put("falg", 0);
			map.put("msg", "数据传输失败!");
		}
		
		//将结果转换成json格式对象
		JsonConfig config = new JsonConfig();
		
		JSONObject json = JSONObject.fromObject(map, config);
		
		//将json数据转换成String
		result = json.toString();
		
		PrintWriter out = response.getWriter();
		//输出到客户端
		out.println(result);
		out.flush();
		out.close();
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
