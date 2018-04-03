package com.oddjob.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.oddjob.biz.UsersBiz;
import com.oddjob.entity.Users;
import com.oddjob.ibiz.IUserBiz;

public class AddUserServlet extends HttpServlet {

	//生成Json格式数据对象
	Map map = new HashMap();
	private String result;
	/**
	 * Constructor of the object.
	 */
	public AddUserServlet() {
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
		
		PrintWriter out = response.getWriter();
		
		//产生随机数作为bossId值
		Random ran = new Random();
		int bossId = ran.nextInt(1000);
		
		//获取提交的数据
		String name = request.getParameter("name");
		String zh = request.getParameter("zh");
		String pwd = request.getParameter("pwd");
		String img = request.getParameter("img");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String specialy = request.getParameter("specialy");
		String profile = request.getParameter("profile");

		// 获取当前时间
//		Date now = new Date();
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String regtime = format.format(now);
		
		//构建用户对象
		Users u = new Users();
		
		u.setBossId(bossId);
		u.setName(name);
		u.setZh(zh);
		u.setPwd(pwd);
		u.setPwd(pwd);
		u.setImg(img);
		u.setSex(sex);
		u.setPhone(phone);
		u.setSpecialty(specialy);
		u.setProfile(profile);
		
		// 构造返回数据
		map = new HashMap();
		map.put("flag", "1");
		map.put("msg", "注册成功");
		
		//调用业务逻辑层,进行的判断
		IUserBiz iubiz = new UsersBiz();
		
		//调用方法
		int num = iubiz.addUser(u);
		
		// 判断是否成功
		if (num <= 0) {
			// 失败
			map.put("flag", 0);
			map.put("msg", "注册失败");
		}
		
		// 将处理结果转换成json格式数据,并输出至客户端
		JsonConfig config = new JsonConfig();

		JSONObject json = JSONObject.fromObject(map, config);

		result = json.toString();// 转换后的json格式数据

		// 输出至客户端
		out.print(result);

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
