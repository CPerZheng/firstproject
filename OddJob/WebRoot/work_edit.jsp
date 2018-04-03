<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>修改零工信息</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="js/plugins/charCount.js"></script>
<script type="text/javascript" src="js/plugins/ui.spinner.min.js"></script>
<script type="text/javascript" src="js/plugins/chosen.jquery.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/forms.js"></script>

<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body class=" ">

			<div class="pageheader">
				<h1 class="pagetitle">零工管理</h1>
				<span class="pagedesc">在这里修改零工信息</span>

				<ul class="hornav">
					<li class="current"><a href="#basicform">修改零工</a></li>
				</ul>
			</div>
			<!--pageheader-->


			<form action="workdoedit" method="post" name="myform" enctype="multipart/form-data">
				<div id="contentwrapper" class="contentwrapper">

					<div id="basicform" class="subcontent">

						<div class="contenttitle2">
							<h3>零工基本信息填写</h3>
						</div>
						<!--contenttitle-->

						<p>
							<label>零工标题</label> <span class="field"><input type="text"
								name="name" value="${requestScope.work.name }" class="smallinput" /></span> <small class="desc">必填</small>
						</p>

						<p>
							<label>零工佣金</label> <span class="field"><input type="text"
								name="price" value="${requestScope.work.price }" class="mediuminput" /></span>
						</p>
						
						<p>
							<label>发布者的id</label> <span class="field"><input type="text"
								name="bossId" value="${requestScope.work.bossId }" class="mediuminput" /></span>
						</p>

						<p>
							<label>联系电话</label> <span class="field"><input type="text"
								name="phone" value="${requestScope.work.phone }" class="mediuminput" /></span>
						</p>

						<p>
							<label>招募人数</label> <span class="field"><input type="text"
								name="pe_num" value="${requestScope.work.pe_num }" class="mediuminput" /></span>
						</p>

						<p>
							<label>零工地址</label> <span class="field"><input type="text"
								name="address" value="${requestScope.work.address }" class="longinput" /></span>
						</p>

						<p>
							<label>零工类型</label> <span class="field">
								<select name="ty_id" class="select1">
    
    								<c:forEach var="wtype" items="${requestScope.wtlist }">
    
    									<c:choose>
   											<c:when test="${wtype.id==requestScope.work.ty_id }">  
   												<option value="${wtype.id }" selected="selected">${wtype.name }</option>   
   											</c:when>
   												<c:otherwise> 
   													<option value="${wtype.id }">${wtype.name }</option>
   												</c:otherwise>
										</c:choose>
    
    								</c:forEach>
    
    
    							</select>
							</span>
						</p>

						<p>
							<label>注意事项</label> <span class="field"> 
							<textarea cols="80" rows="5" class="longinput" name="content">
							${requestScope.work.content }
							</textarea>
							</span>
						</p>

						<p>
							<label>上传图片</label> <span class="field">
								<img src="${requestScope.work.img }" alt="" width="60px" height="60px" />
     							<input name="imgs" value="${requestScope.work.img }" type="hidden"/>
     							<input name="upimgs" type="file" />
							</span>
						</p>

						<br clear="all" /> <br />

						<p class="stdformbutton">
							<button class="submit radius2">提交</button>
							<input type="reset" class="reset radius2" value="重置" />
						</p>




						<br /> <br />

					</div>
					<!--subcontent-->



				</div>
				<!--contentwrapper-->
			</form>


</body>
</html>
