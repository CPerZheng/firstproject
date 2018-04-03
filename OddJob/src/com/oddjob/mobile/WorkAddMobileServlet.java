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
import com.oddjob.biz.WorkBiz;
import com.oddjob.entity.Users;
import com.oddjob.entity.Work;
import com.oddjob.ibiz.IUserBiz;
import com.oddjob.ibiz.IWorkBiz;

public class WorkAddMobileServlet extends HttpServlet {
	
	private Map map = new HashMap();
	private String result;

	/**
	 * Constructor of the object.
	 */
	public WorkAddMobileServlet() {
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
		
		//接收传递过来的数据
		String name = request.getParameter("wname");
		String ty_id = request.getParameter("wtype");
		String sTime = request.getParameter("sTime");
		String dTime = request.getParameter("dTime");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String pe_num = request.getParameter("pe_num");
		String price = request.getParameter("price");
		String content = request.getParameter("content");
		String user_name = request.getParameter("user_name");
		String id = request.getParameter("u_id");
		
		//增加零工
		Work work = new Work();
		
		work.setName(name);
		work.setTy_id(Integer.valueOf(ty_id));
		work.setsTime(sTime);
		work.setdTime(dTime);
		work.setPhone(phone);
		work.setAddress(address);
		work.setPe_num(Integer.valueOf(pe_num));
		work.setPrice(Double.valueOf(price));
		work.setContent(content);
		work.setUser_name(user_name);
		work.setBossId(Integer.valueOf(id));;
		
		//调用业务逻辑层
		IUserBiz iubiz = new UsersBiz();
		//进行登录的用户查询
		Users user = iubiz.getUserByNameId(user_name, id);
		
		//进行判断
		if(user != null) {
			//调用业务逻辑层
			IWorkBiz iwbiz = new WorkBiz();
			//调用增加方法
			int num = iwbiz.addWork(work);
			
			//判断
			if(num > 0) {
				map.put("flag", 1);
			} else {
				map.put("flag", 0);
			}
		} else {
			map.put("flag", 0);
			map.put("msg", "添加失败");
		}
		
		//将数据转换成json对象
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
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
