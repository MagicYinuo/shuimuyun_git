<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>输入取货码</title>
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>APP/css/mui.min.css" />
	<link rel="stylesheet" href="<%=basePath%>APP/css/layer.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>APP/css/smyMobile.css"/>
	</head>
	<body class="body_bg loginBody_bg">
		<div class="contMian">
			<header class="header headerLogin">
				<a class="header_l" href="javascript:self.location=document.referrer;">
					<img title="" alt="" src="<%=basePath%>APP/images/icon/arow_left.png" />
				</a>
				<h1 class="header_title">输入取货码</h1>
			</header>
			
			<div class="loginCont">
				<form class="loginCont_form">
					<div class="loginCont_form_item mui-input-row">
						<img title="" alt="" src="<%=basePath%>APP/images/icon/phone.png" />
						<input class="loginCont_form_itemAll mui-input-clear right" id="userPhone" type="text" placeholder="请输入手机号码" />
					</div>
					<a class="code_a" href="RequestMappingUtil/requestNUll/APP/endOfTransaction"><button type="button" class="codeBtn" id="codeBtn">确定</button></a>
				</form>
			</div>
		</div>
		<script type="text/javascript" src="<%=basePath%>APP/js/jquery-1.11.0.js" ></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/mui.min.js" ></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile.js" ></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/layer.js" ></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile_yz.js" ></script>
	</body>
</html>
