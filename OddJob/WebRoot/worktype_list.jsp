<%@ page language="java" import="java.util.*,com.oddjob.entity.WorkType"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	//显示查询关键字
	String keyword = request.getParameter("keyword");

	//判断关键字是否为空
	if (keyword == null) {
		keyword = "";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>零工类目列表</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
<script src="layer-v2.4/layer/layer.js"></script>
<!-- <script type="text/javascript" src="js/custom/tables.js"></script> -->
<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});
</script>

<script type="text/javascript">
	//打开页面
	function openEditView(id) {
		//iframe层-父子操作
		layer.open({
			type : 2,
			area : [ '40%', '40%' ],
			title : '修改商品类目',
			fix : false, //不固定
			maxmin : true,
			content : 'worktypetoedit?id=' + id,
			end : function(index) {
				//关闭或取消回调
				//刷新	    	
				window.location.reload();

			}
		});

	}

	// 删除
	function deleteByIds(id) {

		//询问框
		layer.confirm('您确定要删除？一旦删除，将不能恢复！', {
			btn : [ '确定', '取消' ]
		//按钮
		}, function() {

			//链接至删除servlet

			window.location.href = "worktypedel?id=" + id;

		});

	}
</script>
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
				<li><a href="#JOB_KINDS" class="editor">表单提交</a> <span
					class="arrow"></span>
					<ul id="JOB_KINDS">
						<li><a href="worktype_list">零工类目管理</a></li>
						<li><a href="worktype_add.jsp">增加零工类目</a></li>
					</ul></li>
				<li><a href="#JOB" class="elements">零工管理</a> <span
					class="arrow"></span>
					<ul id="JOB">
						<li><a href="worktype_list">查询零工</a></li>
						<li><a href="wizard.html">增加零工</a></li>
					</ul></li>
				<li><a href="#USERS" class="support">用户管理</a> <span
					class="arrow"></span>
					<ul id="USERS">
						<li><a href="worktype_list">查询用户</a></li>
						<li><a href="wizard.html">增加用户</a></li>
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
			<a class="togglemenu"></a> <br /> <br />
		</div>
		<!--leftmenu-->

		<div class="centercontent tables">

			<div class="pageheader notab">
				<h1 class="pagetitle">Tables</h1>
				<span class="pagedesc">This is a sample description of a page</span>

			</div>
			<!--pageheader-->

			<div id="contentwrapper" class="contentwrapper">

				<br clear="all" />

				<div class="contenttitle2">
					<h3>零工类目列表</h3>
				</div>
				<!--contenttitle-->

				<form action="worktype_list" method="post">
					<ul class="seachform1">

						<li><label>类目名称</label> <input name="keyword" type="text"
							class="scinput1" value="<%=keyword%>" style="width: 200px; " />
							<input name="" type="submit" class="scbtn" value="查询" /></li>
					</ul>
				</form>

				<br />

				<table cellpadding="0" cellspacing="0" border="0" class="stdtable"
					id="dyntable">
					<colgroup>
						<col class="con0" />
						<col class="con1" />
						<col class="con0" />
						<col class="con1" />
						<col class="con0" />
					</colgroup>
					<thead>
						<tr>
							<th class="head0">类目编号</th>
							<th class="head1">类目名称</th>
							<th class="head0">操作</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th class="head0">类目编号</th>
							<th class="head1">类目名称</th>
							<th class="head0">操作</th>
						</tr>
					</tfoot>
					<tbody>

						<%
						
							//循环显示商品类目
        					//取出商品类目列表
        
        					int pageNo = Integer.valueOf(request.getAttribute("pageNo").toString());
        					int pageSize = Integer.valueOf(request.getAttribute("pageSize").toString());
        					int totalPages = Integer.valueOf(request.getAttribute("totalPages").toString());
        					int totalRecords = Integer.valueOf(request.getAttribute("totalRecords").toString());
							
						%>

						<!-- 使用foreach循环输出 -->
						<c:forEach var="wtype" items="${requestScope.worktypelist}">
							<tr class="gradeX">
								<td>${wtype.id }</td>
								<td>${wtype.name }</td>
								<td><a href="javascript:openEditView(${wtype.id });"
									class="tablelink"> 修改</a> <a
									href="javascript:deleteByIds(${wtype.id });" class="tablelink">
										删除</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
					
	<div class="pagin">
    	<div class="message">共<i class="blue"><%=totalRecords %></i>条记录，当前显示第&nbsp;<i class="blue"><%=pageNo %>&nbsp;</i>页&nbsp;&nbsp; 共&nbsp;<i class="blue"><%=totalPages %>&nbsp;</i>页</div>
        <ul class="paginList">
        <!-- 设置分页导航 -->
        <%
        //没有数据，或者只有一页
        if(totalPages==0||(pageNo==1&&totalPages==1)){
        //没有数据，分页导航就不能点击
        %>
        
        <li class="paginItem"><a>首页</a></li>
        <li class="paginItem"><a><span class="pagepre"></span></a></li>        
        <li class="paginItem"><a><span class="pagenxt"></span></a></li>
        <li class="paginItem"><a>末页</a></li>
        
        <%
        
        }else if(pageNo==1){
        //第一页
        
        %>
        <li class="paginItem"><a>首页</a></li>
        <li class="paginItem"><a><span class="pagepre"></span></a></li>        
        <li class="paginItem"><a href="worktype_list?pageNo=<%=pageNo+1%>&keyword=<%=keyword%>"><span class="pagenxt"></span></a></li>
        <li class="paginItem"><a href="worktype_list?pageNo=<%=totalPages%>&keyword=<%=keyword%>">末页</a></li>
        
        <%
        
        }else if(pageNo==totalPages){
        //最后一页
        %>
        <li class="paginItem"><a href="worktype_list?pageNo=1&keyword=<%=keyword%>">首页</a></li>
        <li class="paginItem"><a href="worktype_list?pageNo=<%=pageNo-1%>&keyword=<%=keyword%>"><span class="pagepre"></span></a></li>        
        <li class="paginItem"><a><span class="pagenxt"></span></a></li>
        <li class="paginItem"><a>末页</a></li>
        
        
        <%
        }else{
        //其他页码
        
        %>
        <li class="paginItem"><a href="worktype_list?pageNo=1&keyword=<%=keyword%>">首页</a></li>
        <li class="paginItem"><a href="worktype_list?pageNo=<%=pageNo-1%>&keyword=<%=keyword%>"><span class="pagepre"></span></a></li>  
        <li class="paginItem"><a href="worktype_list?pageNo=<%=pageNo+1%>&keyword=<%=keyword%>"><span class="pagenxt"></span></a></li>
        <li class="paginItem"><a href="worktype_list?pageNo=<%=totalPages%>&keyword=<%=keyword%>">末页</a></li>
        
        <%
        
        }
        
         %>
        
        
        
        
        
        </ul>
    </div>
				
				<br /> <br />

			</div>
			<!--contentwrapper-->
		</div>
		<!-- centercontent -->
	</div>
	<!--bodywrapper-->



</body>
</html>

