<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人资料</title>
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>APP/css/smyMobile.css" />
	</head>
	<body>
		<header class="commHeader">
			<h6>个人资料</h6>
		</header>
		<div class="myInfo_top">
			<img class="myInfo_user" title="" alt="" src="<%=basePath%>APP/images/myUser.png" width="100%" />
			<div class="myInfo_lreg">
				<!--未登录状态显示-->
				<a href="#">小单</a>
				<!--未登录状态显示 end-->
				<!--已登录状态显示 end-->
				<!--<span>小单</span>-->
			</div>
			</div>	
			<div class="personal_div">
				<a href="RequestMappingUtil/requestNUll/APP/modifyCellPhoneNumber" >
					<img src="<%=basePath%>APP/images/icon/per_phone.png"width="15" />
					<span>手机号码</span>
					<span>12345678912</span>
					<img src="<%=basePath%>APP/images/icon/consignee_right.png" width="15" />
				</a>
				<a>
					<img src="<%=basePath%>APP/images/icon/person_ren.png"width="18" />
					<span>我的姓名</span>
					<span>张宇</span>
				</a>
				<a href="RequestMappingUtil/requestNUll/APP/editAddress">
					<img src="<%=basePath%>APP/images/icon/adds_yellow.png"width="18" />
					<span>我的地址</span>
					<span>贵州省贵阳市南明区花果园</span>
					<img src="<%=basePath%>APP/images/icon/consignee_right.png" width="15" />
				</a>
				<a href="RequestMappingUtil/requestNUll/APP/modifyMailbox">
					<img src="<%=basePath%>APP/images/icon/email_red.png"width="18" />
					<span>我的邮箱</span>
					<span>1234567891@qq.com</span>
					<img src="<%=basePath%>APP/images/icon/consignee_right.png" width="15" />
				</a>
				<a href="RequestMappingUtil/requestNUll/APP/modifyPassword">
					<img src="<%=basePath%>APP/images/icon/suo_green.png"width="18" />
					<span>修改密码</span>
					<span></span>
					<img src="<%=basePath%>APP/images/icon/consignee_right.png" width="15" />
				</a>
				<a href="RequestMappingUtil/requestNUll/APP/modifyPaymentPassword">
					<img src="<%=basePath%>APP/images/icon/suo_green.png"width="18" />
					<span>修改支付密码</span>
					<span></span>
					<img src="<%=basePath%>APP/images/icon/consignee_right.png" width="15" />
				</a>
			</div>
		<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile.js" ></script>
	</body>
</html>
