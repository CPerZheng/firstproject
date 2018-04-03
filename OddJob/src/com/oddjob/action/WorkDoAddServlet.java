package com.oddjob.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.oddjob.biz.WorkBiz;
import com.oddjob.entity.Work;
import com.oddjob.ibiz.IWorkBiz;

public class WorkDoAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public WorkDoAddServlet() {
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

		// 上传文件的代码
		// 建立上传对象
		SmartUpload su = new SmartUpload();
		// 初始化SmartUpload对象
		su.initialize(getServletConfig(), request, response);

		String allowList = "jpg,gif,png,JPG,GIF,PNG";
		// 不允许上传的文件类型
		String denyList = "jsp,asp,html,php,exe,bat";

		// 设置上传大小
		int fileSize = 5 * 1024 * 1024;

		try {
			// 设置控制参数
			su.setAllowedFilesList(allowList);
			su.setDeniedFilesList(denyList);
			su.setMaxFileSize(fileSize);
			su.setTotalMaxFileSize(fileSize * 10);

			// 执行上传功能
			su.setCharset("utf-8");
			su.upload();

			// 获取参数
			com.jspsmart.upload.Request rq = su.getRequest();

			// 设置文件保存到服务器的路径
			String path = "upload/";

			// 循环上传多个文件
			int size = su.getFiles().getCount();// 获取上传文件的个数

			for (int i = 0; i < size; i++) {
				// 循环取出要上传的文件
				// 获取第一个上传文件
				File file = su.getFiles().getFile(i);
				// 判断文件是否上传
				if (!file.isMissing()) {
					// 设置文件保存到服务器的路径
					path = "upload/";
					// 获取文件名
					String fileName = file.getFileName();
					// 构建文件上传的路径及文件名
					path += fileName;
					System.out.println("path" + path);
					// 另存上传文件

					file.setCharset("utf-8");
					file.saveAs(path, SmartUpload.SAVE_VIRTUAL);

				}

			}

			//上传图片完成后，增加商品到数据库
			String name = rq.getParameter("name");
			String price = rq.getParameter("price");
			String bossId = rq.getParameter("bossId");
			String phone = rq.getParameter("phone");
			String pe_num = rq.getParameter("pe_num");
			String address = rq.getParameter("address");
			String ty_id = rq.getParameter("ty_id");
			//String type_name = rq.getParameter("type_name");
			String content = rq.getParameter("content");
			String img = path;
			
			//获取当前时间
			Date now = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strnow = format.format(now);
			
			Work work = new Work();
			
			work.setName(name);
			work.setPrice(Double.valueOf(price));
			work.setBossId(Integer.valueOf(bossId));
			work.setPhone(phone);
			work.setPe_num(Integer.valueOf(pe_num));
			work.setAddress(address);
			//work.setType_name(type_name);
			work.setTy_id(Integer.valueOf(ty_id));
			work.setContent(content);
			work.setImg(img);
			work.setsTime(strnow);
			work.setdTime(strnow);
			
			//新建业务类
			IWorkBiz iwbiz = new WorkBiz();
			
			//增加
			int num_tmp = iwbiz.addWork(work);
			
			//判断
			if(num_tmp>0){
				//增加成功
				response.sendRedirect("work_list");
			}else{
				//增加失败
				response.sendRedirect("error.jsp");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//response.sendRedirect("error.jsp");
		}

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
