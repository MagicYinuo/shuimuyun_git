<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>下单详细信息</title>
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
			<h6>快递员</h6>
		</header>
		<!--【头部】end-->
		<div class="courier_firsttit">
			待取货
		</div>
		<!--正在派送(隐藏)-->
		<div style="display: none;" class="courier_firsttit">
			正在派送
		</div>
		<!--完成交易(隐藏)-->
		<div style="display: none;" class="courier_firsttit">
			完成交易
		</div>
		<div class="courier_firsttit_con">
			<div class="cour_div_1"><img src="<%=basePath%>APP/images/user.jpg"/></div>
			<div class="cour_div_2">小单</div>
			<div class="cour_div_3">
				<span><img src="<%=basePath%>APP/images/icon/courphone.png" width="12"/></span>
				<span>12345678911</span>
			</div>
			<div class="cour_div_4">快递员当前位置：</div>
			<div class="cour_div_5">
				<span><img src="<%=basePath%>APP/images/icon/adds_oreng.png" width="15"/></span>
				<span>贵州省贵阳市南明区花果园E区6栋1单元3001</span>
			</div>
		</div>
		<div class="courier_last">
			商品信息
		</div>
		<div class="courier_last_con">
			<div class="courier_last_con_list">
				<div>
					<span>类型</span>
					<span>数量</span>
					<span>大小</span>
					<span>总重</span>
					<span>建议交通工具</span>
				</div>
				<div>
					<span>易碎</span>
					<span>1</span>
					<span>小</span>
					<span>2kg</span>
					<span>无</span>
				</div>
			</div>
			<div class="courier_last_con_last">
				<div class="courier_last_con_last_img">
					<img src="<%=basePath%>APP/images/banner1.jpg" width="100%" height="100%"/>
					<div>
						该商品暂未上传图片
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="<%=basePath%>APP/js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/mui.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/layer.js"></script>
		<script type="text/javascript" src="<%=basePath%>APP/js/smyMobile_yz.js" ></script>
	</body>
</html>
