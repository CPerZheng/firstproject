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
<title>数据表格页面</title>
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
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>

<script type="text/javascript">

//打开页面
function openEditView(id) {
	//iframe层-父子操作
	layer.open({
		type:2,
		area:['40%', '40%'],
		title: '修改商品类目',
    	fix: false, //不固定
    	maxmin: true,
    	content: 'worktypetoedit?id='+id,
    	end: function(index){ 
        //关闭或取消回调
    	//刷新	    	
    	window.location.reload();
    		    
       }
	});


}

//删除
function delById(id) {
	//询问框
	layer.confim('您确定删除?本操作不可逆,请谨慎操作',{
		//按钮
		btn:['确定','取消']
	},function() {
		//链接至删除servlet(测试)
		window.location.href = "success.jsp";
	}
	);
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
						<li><a href="wizard.html">修改零工类目</a></li>
						<li><a href="editor.html">编辑器</a></li>
					</ul></li>
				<li><a href="#JOB" class="elements">零工管理</a> <span
					class="arrow"></span>
					<ul id="JOB">
						<li><a href="worktype_list">查询零工</a></li>
						<li><a href="wizard.html">修改零工</a></li>
						<li><a href="editor.html">编辑器</a></li>
					</ul></li>
				<li><a href="#USERS" class="support">用户管理</a> <span
					class="arrow"></span>
					<ul id="USERS">
						<li><a href="worktype_list">查询用户</a></li>
						<li><a href="wizard.html">修改用户</a></li>
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
			<a class="togglemenu"></a> <br /> <br />
		</div>
		<!--leftmenu-->

		<div class="centercontent">
    
        <div class="pageheader notab">
            <h1 class="pagetitle">增加零工类目</h1>
            <span class="pagedesc">请在本页面增加零工类目</span>
            
        </div><!--pageheader-->
        
        <div class="contentwrapper">
        	<div class="two_third">
                 <form action="worktypeadd" method="post">
                    <input type="text" name="tname"  placeholder="请输入类目名称" />
                    
                    <br /><br />
                    
                    <!-- Gets replaced with TinyMCE, remember HTML in a textarea should be encoded
                    <div>
                        <textarea id="elm1" name="elm1" rows="15" cols="80" style="width: 80%" class="tinymce">
                            &lt;p&gt;
                                This is some example text that you can edit inside the &lt;strong&gt;TinyMCE editor&lt;/strong&gt;.
                            &lt;/p&gt;
                        </textarea>
                    </div>
            		 -->
            
                    <br /><br />
                    <input type="submit" name="save" value="提交" />
                    <input type="reset" name="reset" value="重置" />
                 </form>
             </div><!--two_third-->
        </div><!--contentwrapper-->
    
    </div><!--centercontent-->
	</div>
	<!--bodywrapper-->

	

</body>
</html>