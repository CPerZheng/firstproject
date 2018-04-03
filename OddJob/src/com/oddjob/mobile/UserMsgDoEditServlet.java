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

import com.oddjob.biz.UsersBiz;
import com.oddjob.entity.Users;
import com.oddjob.ibiz.IUserBiz;

public class UserMsgDoEditServlet extends HttpServlet {

	private Map map = new HashMap();
	private String result;
	/**
	 * Constructor of the object.
	 */
	public UserMsgDoEditServlet() {
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

		// 获取提交的数据
		String id = request.getParameter("uid");
		String zh = request.getParameter("zh");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String specialty = request.getParameter("specialty");
		String profile = request.getParameter("profile");
		
		
		
		//修改
		Users user = new Users();
			
		// 将数据修改到到数据库
		user.setId(Integer.valueOf(id));
		user.setZh(zh);
		user.setName(name);
		user.setPhone(phone);
		user.setSex(sex);
		user.setSpecialty(specialty);
		user.setProfile(profile);
		
		//新建业务类
		IUserBiz iubiz = new UsersBiz();

		// 调用用户修改方法
		int num = iubiz.updateUser(user);
		
		//判断是否修改成功
		if(num > 0) {
			//修改成功
			map.put("user", user);
		} else {
			//修改失败
			map.put("flag", 0);
			map.put("msg", "修改失败");
		}

		//将结果转换成json格式对象
		JsonConfig config = new JsonConfig();
		
		JSONObject json = JSONObject.fromObject(map, config);
		
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
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
