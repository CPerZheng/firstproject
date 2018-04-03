package com.oddjob.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oddjob.biz.UsersBiz;
import com.oddjob.entity.Users;
import com.oddjob.ibiz.IUserBiz;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class LoginJsonServlet extends HttpServlet {

	// 生成JSON格式数据的对象
	private Map map = new HashMap();
	private String result;

	/**
	 * Constructor of the object.
	 */
	public LoginJsonServlet() {
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

		PrintWriter out = response.getWriter();

		// 获取提交的数据
		String zh = request.getParameter("zh");
		String pwd = request.getParameter("pwd");

		//处理编码方式
		if(request.getMethod().equalsIgnoreCase("get")) {
			//设置编码方式
			request.setCharacterEncoding("utf-8");
			//强制转码
			zh = new String(zh.getBytes("ISO-8859-1"),"utf-8");
			pwd = new String(pwd.getBytes("ISO-8859-1"),"utf-8");
		}
		
		//构造返回数据
		map.put("flag", 1);
		map.put("msg", "登录成功");
		
		//调用业务逻辑层
		IUserBiz iubiz = new UsersBiz();
		//调用登录方法
		Users users = iubiz.login(zh, pwd);
		
		//判断登录是否成功
		if(users != null) {
			//登录成功
			//查询出此用户的基本资料
			users = iubiz.getUserByOnlyZh(zh);
			map.put("users", users);
		} else {
			//登录失败
			map.put("flag", 0);
			map.put("msg", "登录失败");
		}

		// 讲处理结果转换成JSON格式数据，并输出至客户端
		JsonConfig config = new JsonConfig();
		// 屏蔽不生成json的数据
		// config.setExcludes(new String[] { "type_id", "content", "delflag",
		// "imgs" });

		JSONObject json = JSONObject.fromObject(map, config);

		result = json.toString();// 转换后的json数据

		// 输出至客户端
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
