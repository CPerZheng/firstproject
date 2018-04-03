<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>控制台页面</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.flot.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery.flot.resize.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.slimscroll.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script type="text/javascript" src="js/custom/dashboard.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/plugins/excanvas.min.js"></script><![endif]-->
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="js/plugins/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body class="withvernav">
	<div class="bodywrapper">
		<div class="topheader">
			<div class="left">
				<h1 class="logo">
					Ama.<span>Admin</span>
				</h1>
				<span class="slogan">后台管理系统</span>

				<div class="search">
					<form action="" method="post">
						<input type="text" name="keyword" id="keyword" value="请输入" />
						<button class="submitbutton"></button>
					</form>
				</div>
				<!--search-->

				<br clear="all" />

			</div>
			<!--left-->

			<div class="right">
				<!--<div class="notification">
                <a class="count" href="ajax/notifications.html"><span>9</span></a>
        	</div>-->
				<div class="userinfo">
					<img src="images/thumbs/avatar.png" alt="" /> <span>管理员</span>
				</div>
				<!--userinfo-->

				<div class="userinfodrop">
					<div class="avatar">
						<a href=""><img src="images/thumbs/avatarbig.png" alt="" /></a>
						<div class="changetheme">
							切换主题: <br /> <a class="default"></a> <a class="blueline"></a> <a
								class="greenline"></a> <a class="contrast"></a> <a
								class="custombg"></a>
						</div>
					</div>
					<!--avatar-->
					<div class="userdata">
						<h4>Juan</h4>
						<span class="email">youremail@yourdomain.com</span>
						<ul>
							<li><a href="editprofile.html">编辑资料</a></li>
							<li><a href="accountsettings.html">账号设置</a></li>
							<li><a href="help.html">帮助</a></li>
							<li><a href="index.html">退出</a></li>
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
						class="icon icon-flatscreen"></span>首页</a></li>
				<li><a href="manageblog.html"><span
						class="icon icon-pencil"></span>博客管理</a></li>
				<li><a href="messages.html"><span class="icon icon-message"></span>查看消息</a></li>
				<li><a href="reports.html"><span class="icon icon-chart"></span>统计报表</a></li>
			</ul>

			<div class="headerwidget">
				<div class="earnings">
					<div class="one_half">
						<h4>Today's Earnings</h4>
						<h2>$640.01</h2>
					</div>
					<!--one_half-->
					<div class="one_half last alignright">
						<h4>Current Rate</h4>
						<h2>53%</h2>
					</div>
					<!--one_half last-->
				</div>
				<!--earnings-->
			</div>
			<!--headerwidget-->

		</div>
		<!--header-->

		<div class="vernav2 iconmenu">
			<ul>
				<li><a href="#formsub" class="editor">表单提交</a> <span
					class="arrow"></span>
					<ul id="formsub">
						<li><a href="forms.html">基础表单</a></li>
						<li><a href="wizard.html">表单验证</a></li>
						<li><a href="editor.html">编辑器</a></li>
					</ul></li>
				<!--<li><a href="filemanager.html" class="gallery">文件管理</a></li>-->
				<li><a href="elements.html" class="elements">网页元素</a></li>
				<li><a href="widgets.html" class="widgets">网页插件</a></li>
				<li><a href="calendar.html" class="calendar">日历事件</a></li>
				<li><a href="support.html" class="support">客户支持</a></li>
				<li><a href="typography.html" class="typo">文字排版</a></li>
				<li><a href="tables.html" class="tables">数据表格</a></li>
				<li><a href="buttons.html" class="buttons">按钮 &amp; 图标</a></li>
				<li><a href="#error" class="error">错误页面</a> <span class="arrow"></span>
					<ul id="error">
						<li><a href="notfound.html">404错误页面</a></li>
						<li><a href="forbidden.html">403错误页面</a></li>
						<li><a href="internal.html">500错误页面</a></li>
						<li><a href="offline.html">503错误页面</a></li>
					</ul></li>
				<li><a href="#addons" class="addons">其他页面</a> <span
					class="arrow"></span>
					<ul id="addons">
						<li><a href="newsfeed.html">新闻订阅</a></li>
						<li><a href="profile.html">资料页面</a></li>
						<li><a href="productlist.html">产品列表</a></li>
						<li><a href="photo.html">图片视频分享</a></li>
						<li><a href="gallery.html">相册</a></li>
						<li><a href="invoice.html">购物车</a></li>
					</ul></li>
			</ul>
			<a class="togglemenu"></a> <br />
			<br />
		</div>
		<!--leftmenu-->

		<div class="centercontent">

			<div class="pageheader">
				<h1 class="pagetitle">控制台</h1>
				<span class="pagedesc">页面的描述内容</span>

				<ul class="hornav">
					<li class="current"><a href="#updates">最新更新</a></li>
					<li><a href="#activities">最近活动</a></li>
				</ul>
			</div>
			<!--pageheader-->

			<div id="contentwrapper" class="contentwrapper">

				<div id="updates" class="subcontent">
					<div class="notibar announcement">
						<a class="close"></a>
						<h3>通告</h3>
						<p>测试通告</p>
					</div>
					<!-- notification announcement -->

					<div class="two_third dashboard_left">

						<br clear="all" />

						<div class="contenttitle2 nomargintop">
							<h3>访问</h3>
						</div>
						<!--contenttitle-->

						<div class="overviewhead">
							<div class="overviewselect">
								<select id="overviewselect" name="select">
									<option value="">1小时前</option>
									<option value="">5小时前</option>
									<option value="">今天</option>
									<option value="">昨天</option>
									<option value="">本周</option>
									<option value="">本月</option>
								</select>
							</div>
							<!--floatright-->
							From: &nbsp;<input type="text" id="datepickfrom" /> &nbsp;
							&nbsp; To: &nbsp;<input type="text" id="datepickto" />
						</div>
						<!--overviewhead-->

						<br clear="all" />

						<table cellpadding="0" cellspacing="0" border="0"
							class="stdtable overviewtable">
							<colgroup>
								<col class="con0" width="20%" />
								<col class="con1" width="20%" />
								<col class="con0" width="20%" />
								<col class="con1" width="20%" />
								<col class="con0" width="20%" />
							</colgroup>
							<thead>
								<tr>
									<th class="head0">Metric</th>
									<th class="head1">平均价格</th>
									<th class="head0">用户数量</th>
									<th class="head1">管理员</th>
									<th class="head0">访问量</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<div class="progress progress150">
											<div class="bar">
												<div style="width: 60%;" class="value bluebar"></div>
											</div>
										</div>
									</td>
									<td>67.3%</td>
									<td>856, 220</td>
									<td class="center">32, 012</td>
									<td class="center">20.5</td>
								</tr>
							</tbody>
						</table>

						<br clear="all" />

						<div id="chartplace" style="height:300px;"></div>

						<br clear="all" />

						<table cellpadding="0" cellspacing="0" border="0"
							class="stdtable stdtablecb overviewtable2">
							<colgroup>
								<col class="con0" style="width: 4%" />
								<col class="con1" />
								<col class="con0" />
								<col class="con1" />
								<col class="con0" />
								<col class="con1" />
							</colgroup>
						</table>

						<br />
						<div class="copyrights">
							Collect from <a href="http://www.cssmoban.com/">手机网站模板</a>
						</div>

						<div class="widgetbox">
							<div class="title">
								<h3>最新消息/订单</h3>
							</div>
							<div class="widgetcontent">
								<div id="scroll1" class="mousescroll">
									<ul class="entrylist">
										<li>
											<div class="entry_wrap">
												<div class="entry_img">
													<img src="images/thumbs/image1.png" alt="" />
												</div>
												<div class="entry_content">
													<h4>
														<a href="">零工标题</a>
													</h4>
													<small>提交人: <a href=""><strong>XXX</strong></a>
														- 获取提交时间
													</small>
													<p>零工标题:</p>
													<p>零工类型:</p>
													<p>提交人电话:</p>
													<p>地址:</p>
													<p>佣金:</p>
													<p>
														<button class="stdbtn btn_lime">批准发布</button>
														<button class="stdbtn">阻止发布</button>
													</p>
												</div>
											</div>
										</li>
									</ul>
								</div>
								<!--#scroll1-->
							</div>
							<!--widgetcontent-->
						</div>
						<!-- widgetbox -->


					</div>
					<!--two_third dashboard_left -->

					<div class="one_third last dashboard_right">

						<div class="contenttitle2 nomargintop">
							<h3>Top Rated Sites</h3>
						</div>
						<!--contenttitle-->


						<ul class="toplist">
							<li>
								<div>
									<span class="three_fourth"> <span class="left"> <span
											class="title"><a href="">loremipsum.com</a></span> <span
											class="desc">Social Network</span>
									</span>
									<!--left-->
									</span>
									<!--three_fourth-->
									<span class="one_fourth last"> <span class="right">
											<span class="h3">8.1</span>
									</span>
									<!--right-->
									</span>
									<!--one_fourth-->
									<br clear="all" />
								</div>
							</li>
							<li>
								<div>
									<span class="three_fourth"> <span class="left"> <span
											class="title"><a href="">dolorsitamet.net</a></span> <span
											class="desc">Social Network</span>
									</span>
									<!--left-->
									</span>
									<!--three_fourth-->
									<span class="one_fourth last"> <span class="right">
											<span class="h3">7.8</span>
									</span>
									<!--right-->
									</span>
									<!--one_fourth-->
									<br clear="all" />
								</div>
							</li>
							<li>
								<div>
									<span class="three_fourth"> <span class="left"> <span
											class="title"><a href="">consectetur.org</a></span> <span
											class="desc">Social Network</span>
									</span>
									<!--left-->
									</span>
									<!--three_fourth-->
									<span class="one_fourth last"> <span class="right">
											<span class="h3">7.5</span>
									</span>
									<!--right-->
									</span>
									<!--one_fourth-->
									<br clear="all" />
								</div>
							</li>
						</ul>

						<div class="widgetbox">
							<div class="title">
								<h3>Newly Registered User</h3>
							</div>
							<div class="widgetoptions">
								<div class="right">
									<a href="">View All Users</a>
								</div>
								<a href="">Add User</a>
							</div>
							<div class="widgetcontent userlistwidget nopadding">
								<ul>
									<li>
										<div class="avatar">
											<img alt="" src="images/thumbs/avatar1.png" />
										</div>
										<div class="info">
											<a href="">Squint</a> <br /> Front-End Engineer <br /> 18
											minutes ago
										</div>
										<!--info-->
									</li>
									<li>
										<div class="avatar">
											<img alt="" src="images/thumbs/avatar2.png" />
										</div>
										<div class="info">
											<a href="">Eunice</a> <br /> Architectural Designer <br />
											18 minutes ago
										</div>
										<!--info-->
									</li>
									<li>
										<div class="avatar">
											<img alt="" src="images/thumbs/avatar1.png" />
										</div>
										<div class="info">
											<a href="">Captain Gutt</a> <br /> Software Engineer <br />
											18 minutes ago
										</div>
										<!--info-->
									</li>
									<li>
										<div class="avatar">
											<img alt="" src="images/thumbs/avatar2.png" />
										</div>
										<div class="info">
											<a href="">Flynn</a> <br /> Accounting Manager <br /> 18
											minutes ago
										</div>
										<!--info-->
									</li>
								</ul>
								<a class="more" href="">View More Users</a>
							</div>
							<!--widgetcontent-->
						</div>

						
						<!--widgetbox-->

					</div>
					<!--one_third last-->


				</div>
				<!-- #updates -->

				<div id="activities" class="subcontent" style="display: none;">
					&nbsp;</div>
				<!-- #activities -->

			</div>
			<!--contentwrapper-->

			<br clear="all" />

		</div>
		<!-- centercontent -->


	</div>
	<!--bodywrapper-->

</body>
</html>
