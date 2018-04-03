<%@ page language="java" import="java.util.*,com.oddjob.entity.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
//获取查询出来的类目
WorkType wtype = (WorkType)request.getAttribute("worktype");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>按钮图标</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="js/custom/general.js"></script>
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

<body>

<div class="centercontent tables">
	<form action="worktypedoedit" method="post" name="myfrom">
		<div class="contenttitle2">
			<h3>零工类目列表</h3>
		</div>

		<ul>
			<li style="list-style-type:none;"><label>类目名称<b>*</b></label>
				<input name="tname" type="text" class="dfinput" value="<%=wtype.getName() %>" style="width: 181px; "/>
				<i>必填，不能为空</i>
				<input type="hidden" name="tid" value="<%=wtype.getId() %>" />
			</li>
		</ul>
		
		<ul class="buttonlist" style="margin-top:10px;">
			<li><button class="stdbtn btn_blue" type="submit">确认</button></li>
		</ul>
	</form>
</div>

</body>
</html>
