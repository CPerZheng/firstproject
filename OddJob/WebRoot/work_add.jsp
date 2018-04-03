<%@ page language="java" import="java.util.*,com.oddjob.entity.WorkType"
	pageEncoding="utf-8"%>
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
<title>添加零工</title>
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

<body class="withvernav">

	<div class="bodywrapper">
		<div class="topheader">
			<div class="left">
				<h1 class="logo">
					Aman.<span>da</span>
				</h1>
				<span class="slogan">admin template</span>

				<div class="search">
					<form action="" method="post">
						<input type="text" name="keyword" id="keyword"
							value="Enter keyword(s)" />
						<button class="submitbutton"></button>
					</form>
				</div>
				<!--search-->

				<br clear="all" />

			</div>
			<!--left-->

			<div class="right">

				<div class="userinfo">
					<img src="images/thumbs/avatar.png" alt="" /> <span>Juan
						Dela Cruz</span>
				</div>
				<!--userinfo-->

				<div class="userinfodrop">
					<div class="avatar">
						<a href=""><img src="images/thumbs/avatarbig.png" alt="" /></a>
						<div class="changetheme">
							Change theme: <br /> <a class="default"></a> <a class="blueline"></a>
							<a class="greenline"></a> <a class="contrast"></a> <a
								class="custombg"></a>
						</div>
					</div>
					<!--avatar-->
					<div class="userdata">
						<h4>Juan Dela Cruz</h4>
						<span class="email">youremail@yourdomain.com</span>
						<ul>
							<li><a href="editprofile.html">Edit Profile</a></li>
							<li><a href="accountsettings.html">Account Settings</a></li>
							<li><a href="help.html">Help</a></li>
							<li><a href="index.html">Sign Out</a></li>
						</ul>
					</div>
					<!--userdata-->
				</div>
				<!--userinfodrop-->
			</div>
			<!--right-->
		</div>
		<!--topheader-->


		<div class="header">
			<ul class="headermenu">
				<li class="current"><a href="dashboard.html"><span
						class="icon icon-flatscreen"></span>Dashboard</a></li>
				<li><a href="manageblog.html"><span
						class="icon icon-pencil"></span>Manage Blog</a></li>
				<li><a href="messages.html"><span class="icon icon-message"></span>Messages</a></li>
				<li><a href="reports.html"><span class="icon icon-chart"></span>Reports</a></li>
			</ul>

			<div class="headerwidget"></div>
			<!--headerwidget-->

		</div>
		<!--header-->

		<div class="vernav2 iconmenu">
			<ul>
				<li class="current"><a href="#formsub" class="editor">Forms</a>
					<span class="arrow"></span>
					<ul id="formsub">
						<li class="current"><a href="forms.html">Basic Form</a></li>
						<li><a href="wizard.html">Wizard</a></li>
						<li><a href="editor.html">WYSIWYG</a></li>
					</ul></li>
				<li><a href="filemanager.html" class="gallery">File Manager</a></li>
				<li><a href="elements.html" class="elements">Elements</a></li>
				<li><a href="widgets.html" class="widgets">Widgets</a></li>
				<li><a href="calendar.html" class="calendar">Calendar</a></li>
				<li><a href="support.html" class="support">Customer Support</a></li>
				<li><a href="typography.html" class="typo">Typography</a></li>
				<li><a href="tables.html" class="tables">Tables</a></li>
				<li><a href="buttons.html" class="buttons">Buttons
						&amp;Icons</a></li>

			</ul>
			<a class="togglemenu"></a> <br /> <br />
		</div>
		<!--leftmenu-->

		<div class="centercontent">

			<div class="pageheader">
				<h1 class="pagetitle">零工管理</h1>
				<span class="pagedesc">在这里添加零工信息</span>

				<ul class="hornav">
					<li class="current"><a href="#basicform">增加零工</a></li>
				</ul>
			</div>
			<!--pageheader-->


			<form action="workdoadd" method="post" name="myform" enctype="multipart/form-data">
				<div id="contentwrapper" class="contentwrapper">

					<div id="basicform" class="subcontent">

						<div class="contenttitle2">
							<h3>零工基本信息填写</h3>
						</div>
						<!--contenttitle-->

						<p>
							<label>零工标题</label> <span class="field"><input type="text"
								name="name" class="smallinput" /></span> <small class="desc">必填</small>
						</p>

						<p>
							<label>零工佣金</label> <span class="field"><input type="text"
								name="price" class="mediuminput" /></span>
						</p>
						
						<p>
							<label>发布者的id</label> <span class="field"><input type="text"
								name="bossId" class="mediuminput" /></span>
						</p>

						<p>
							<label>联系电话</label> <span class="field"><input type="text"
								name="phone" class="mediuminput" /></span>
						</p>

						<p>
							<label>招募人数</label> <span class="field"><input type="text"
								name="pe_num" class="mediuminput" /></span>
						</p>

						<p>
							<label>零工地址</label> <span class="field"><input type="text"
								name="address" class="longinput" /></span>
						</p>

						<p>
							<label>零工类型</label> <span class="field"> <select
								name="ty_id" class="select1">

									<c:forEach var="wtype" items="${requestScope.wtlist }">
										<option value="${wtype.id }">${wtype.name }</option>
									</c:forEach>


							</select>
							</span>
						</p>

						<p>
							<label>注意事项</label> <span class="field"> <textarea
									cols="80" rows="5" class="longinput" name="content"></textarea></span>
						</p>

						<p>
							<label>上传图片</label> <span class="field"> <input
								type="file" name="img" />
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

		</div>
		<!-- centercontent -->


	</div>
	<!--bodywrapper-->

</body>
</html>
