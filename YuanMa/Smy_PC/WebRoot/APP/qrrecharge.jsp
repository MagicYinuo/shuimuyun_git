<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String kuaikeid = request.getParameter("kuaikeId");
String shopprices = request.getParameter("shopprices");
String type = request.getParameter("type");
String deposit = request.getParameter("deposit");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>扫码支付</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="UTF-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
	<link rel="stylesheet" href="<%=basePath %>APP/css/smyMobile.css" />
	</head>
	<style>
	.qrcode{
		display: block;
		width: 1.5rem;
		height: auto;
		overflow: hidden;
		background: white;
		margin: 0 auto;
		margin-top: 1rem;
	}
	</style>
	<body>
		<!--【头部】-->
		<header class="commHeader">
			<a class="commHeader_l" onClick="javascript :history.back(-1);">
				<img title="" alt="" src="<%=basePath%>APP/images/icon/arow_left.png" />
			</a>
			<p>微信扫码支付</p>
		</header>
		<!--【头部】end-->
		
		<img class="qrcode" src="<%=basePath%>payment/qrcode?kuaikeid=<%=kuaikeid%>&shouprices=<%=shopprices%>&type=<%=type%>" />
		
		<input type="hidden" id="kuaikeid" value="<%=kuaikeid%>">
		<script type="text/javascript" src="<%=basePath %>APP/js/jquery-1.11.0.js" ></script>
		<script type="text/javascript" src="<%=basePath %>APP/js/smyMobile.js" ></script>
		
		<script type="text/javascript">
		setTimeout(Start, 5000); //延迟5秒开始周期回调
		var kuaikeid = $("#kuaikeid").val();
		function fun() {
			$.ajax({
				url : "<%=path%>/payment/query",
				type : "POST",
				dataType : "text",
				data : {
					'kuaikeid' : kuaikeid
				},
				success : function(data) {
					if (data == "2") { //订单状态为1表示支付成功
						window.location.href = "<%=basePath%>RequestMappingUtil/requestData/APP/paysuccess?shouprices="+<%=shopprices%>; //页面跳转
					}
				},
				error : function() {
					
				}
			});
		}
		function Start() {
			setInterval("fun()", "1000"); //单位为毫秒
		}
		
		</script>
	</body>
</html>
