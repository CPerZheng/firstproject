package com.oddjob.action;

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

public class JsonTestServlet extends HttpServlet {

	// 生成Json数据对象,将json数据存入map
	private Map map = new HashMap();
	// 新建一个字符串,用于输出json数据
	private String result;

	/**
	 * Constructor of the object.
	 */
	public JsonTestServlet() {
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

		// 设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		//
		PrintWriter out = response.getWriter();

		// 生成json数据
		map.put("测试:", "输出json数据到客户端");
		map.put("flag", 1);
		map.put("msg", "输出成功");
		map.put("简言", "never forget,fight for yourself");

		// 将处理结果转换成json格式数据并输出至客户端
		JsonConfig config = new JsonConfig();
		// 将相关对象转换成json格式
		JSONObject json = JSONObject.fromObject(map, config);

		// 将转换好的json数据转成字符串
		result = json.toString();
		// 输出至客户端
		out.print(result);

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
