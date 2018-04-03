package com.oddjob.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.oddjob.biz.UsersBiz;
import com.oddjob.ibiz.IUserBiz;

public class AllUsersServlet extends HttpServlet {

	private Map map = new HashMap();
	private List list = new ArrayList();
	private String result;

	/**
	 * Constructor of the object.
	 */
	public AllUsersServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置编码方式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 调用业务层
		IUserBiz iubiz = new UsersBiz();
		// 查询所有用户
		list = iubiz.getUserByZh("");

		if (list != null) {
			map.put("list", list);
		} else {
			map.put("flag", 0);
			map.put("msg", "查询失败");
		}

		// 将处理结果转为json格式数据,并输出到客户端
		JsonConfig config = new JsonConfig();

		JSONObject json = JSONObject.fromObject(map, config);

		result = json.toString();

		PrintWriter out = response.getWriter();

		out.println(result);
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
