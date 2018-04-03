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

import com.oddjob.biz.OrderBiz;
import com.oddjob.ibiz.IOrderBiz;

public class SelOrderServlet extends HttpServlet {

	private Map map = new HashMap();
	private String result;
	private List list = new ArrayList();

	/**
	 * Constructor of the object.
	 */
	public SelOrderServlet() {
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

		// 获取提交的用户编号
		String u_staffId = request.getParameter("uid");

		// 调用业务层查询
		IOrderBiz iobiz = new OrderBiz();

		// 调用查询
		list = iobiz.getOrderByuId(u_staffId);

		// 判断
		if (list != null) {
			map.put("list", list);
		} else {
			map.put("flag", 0);
			map.put("msg", "查询失败!");
		}

		// 将结果转换成json格式对象
		JsonConfig config = new JsonConfig();
		JSONObject json = JSONObject.fromObject(map, config);
		
		PrintWriter out = response.getWriter();

		// 输出到客户端
		result = json.toString();
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
