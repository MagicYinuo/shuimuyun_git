<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改绑定邮箱</title>
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="<%=basePath%>APP/css/mui.min.css" />
		<link rel="stylesheet" href="<%=basePath%>APP/css/layer.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>APP/css/smyMobile.css" />
	</head>
	<body>
		<!--【头部】-->
		<header class="commHeader">
			<a class="commHeader_l" href="javascript:self.location=document.referrer;">
				<img title="" alt="" src="<%=basePath%>APP/images/icon/arow_left.png" />
			</a>
			<h6>修改绑定邮箱</h6>
		</header>
		<form>
		<!--【头部】end-->
		<div class="courier_firsttit">
			当前绑定邮箱为：<span>582251698@qq.com</span>
		</div>
		<div class="appeal_firstdiv">
			<div>
				<label>新邮箱地址</label><input type="text" id="modemail" placeholder="请输入现用手机号" />
			</div>
			<div>
				<label>验 证 码</label><input class="las" id="modYzm" type="text" placeholder="请输入验证码" /><button id="modYzmBtn">获取验证码</button>
			</div>
		</div>
		<a href="javascript:void(0);"><button class="order_btn" id="modemailbtn">提交</button></a>
		</form>
		<script type="text/javascript" src="<%=basePath%>APP/js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/mui.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/layer.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile_yz.js" ></script>
	</body>
</html>